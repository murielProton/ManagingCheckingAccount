package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.resources.MyRecordDataFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;


/*IMPORTANT you need to run the app to launch theese tests successfully ! */
public class MyRecordHTMLCrudTest {
 private static final String API_ROOT
    = "http://localhost:8081/api/myRecords";

  public static MyRecord myRecord; 
  public static String location;

  private  static MyRecord createMyRecordAsUri(MyRecord myRecord) {
      final Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(myRecord)
        .post(API_ROOT);
       return response.getBody().as(MyRecord.class);
  }

  @BeforeAll
  public static void setup(){
    // clear database 
    RestAssured.delete(API_ROOT+"/purgeDatabase");
    // Create a dummy record
    myRecord = MyRecordDataFactory.createOneMyRecordForTesting();
    myRecord = createMyRecordAsUri(myRecord);
    location = API_ROOT + "/" + myRecord.getId();
  }



  //Test Create Methodes
  @Test
  public void whenCreateNewMyRecord_thenCreated() {
    Response response = RestAssured.given()
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(myRecord)
      .post(API_ROOT);
    
    assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
  }

  @Test
  public void whenInvalidMyRecord_thenError() {
      myRecord.setAmount(null);
      Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(myRecord)
        .post(API_ROOT);
      
      assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
  }

  //Test Read Methodes
  @Test
  public void whenGetAllRecords_thenOK() {
      Response response = RestAssured.get(API_ROOT);
  
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
  }

  @Test
  public void whenGetRecordsByName_thenOK() {
      Response response = RestAssured.get(API_ROOT + "/name/" + myRecord.getName());
      List<MyRecord> resultList = Arrays.asList(response.getBody().as(MyRecord[].class));
      assertFalse(resultList.isEmpty());
      for (MyRecord currentReccord : resultList) {
        assertEquals("Dummy name", currentReccord.getName());
      }
      
  }
        
  @Test
  public void whenGetCreatedMyRecordById_thenOK() {
      Response response = RestAssured.get(location);
      
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
      assertEquals(myRecord.getName(), response.jsonPath()
        .get("name"));
  }
/*It's not A TU change the ID.*/
  @Test
  public void whenGetNotExistRecordById_thenNotFound() {
      Response response = RestAssured.get(API_ROOT + "/3454575");
      assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
  }

    //Test Update Methodes
  @Test
  public void whenUpdateCreatedMyRecord_thenUpdated() {
    myRecord.setAuthor(Author.PATRICK);
    Response response = RestAssured.given()
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(myRecord)
      .put(location);
    
    assertEquals(HttpStatus.OK.value(), response.getStatusCode());

    response = RestAssured.get(location);
    
    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    assertEquals("PATRICK", response.jsonPath()
      .get("author"));
}
    //Test Delete Methode
    @Test
    public void whenDeleteCreatedMyRecord_thenOk() {
        Response response = RestAssured.delete(location);
        
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    
        response = RestAssured.get(location);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

}
