package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.model.entities.MyRecord;

import io.restassured.RestAssured;
import io.restassured.response.Response;


/*IMPORTANT you need to run the app to launch theese tests successfully ! */
public class MyRecordHTMLCrudTest {
  private static final String API_ROOT
    = "http://localhost:8081/api/myRecords";

  private MyRecord createRandomRecord() {
      MyRecord myDummy = new MyRecord();
      myDummy.setAuthor("Dummy author");
      myDummy.setName("Dummy name");
      myDummy.setDateOfTransaction(new Date());
      myDummy.setAmount(0f);
      return myDummy;
  }

  private String createMyRecordAsUri(MyRecord myRecord) {
      final Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(myRecord)
        .post(API_ROOT);
      return API_ROOT + "/" + response.jsonPath().get("id");
  }

  //Test Create Methodes
  @Test
  public void whenCreateNewMyRecord_thenCreated() {
    MyRecord myRecord = createRandomRecord();
    Response response = RestAssured.given()
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(myRecord)
      .post(API_ROOT);
    
    assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
  }

  @Test
  public void whenInvalidMyRecord_thenError() {
      MyRecord myRecord = createRandomRecord();
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
  public void whenGetRecordsByTitle_thenOK() {
      MyRecord myRecord = createRandomRecord();
      createMyRecordAsUri(myRecord);
      Response response = RestAssured.get(
        API_ROOT + "/name/" + myRecord.getName());
      
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
      assertTrue(response.as(List.class)
        .size() > 0);
  }
  @Test
  public void whenGetCreatedMyRecordById_thenOK() {
      MyRecord myRecord = createRandomRecord();
      String location = createMyRecordAsUri(myRecord);
      Response response = RestAssured.get(location);
      
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
      assertEquals(myRecord.getName(), response.jsonPath()
        .get("name"));
  }

  @Test
  public void whenGetNotExistRecordById_thenNotFound() {
      Response response = RestAssured.get(API_ROOT + "/12");
      
      assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
  }

    //Test Update Methodes
  @Test
  public void whenUpdateCreatedMyRecord_thenUpdated() {
    MyRecord myRecord = createRandomRecord();
    String location = createMyRecordAsUri(myRecord);
    myRecord.setId(Long.parseLong(location.split("api/myRecords/")[1]));
    myRecord.setAuthor("newAuthor");
    Response response = RestAssured.given()
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(myRecord)
      .put(location);
    
    assertEquals(HttpStatus.OK.value(), response.getStatusCode());

    response = RestAssured.get(location);
    
    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    assertEquals("newAuthor", response.jsonPath()
      .get("author"));
}
    //Test Delete Methode
    @Test
    public void whenDeleteCreatedMyRecord_thenOk() {
        MyRecord myRecord = createRandomRecord();
        String location = createMyRecordAsUri(myRecord);
        Response response = RestAssured.delete(location);
        
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    
        response = RestAssured.get(location);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
  
}
