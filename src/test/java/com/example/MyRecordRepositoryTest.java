package com.example;
 
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.TypeOfTransaction;
import com.example.repository.MyRecordRepository;
import com.example.resources.MyRecordDataFactory;

import io.restassured.RestAssured;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import com.example.MyRecordHTMLCrudTest;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyRecordRepositoryTest {

    private static MyRecord myRecordForTest;

    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private MyRecordRepository repo;

    @BeforeAll
    public void setup(){
        // clear persistence with entityManager // Maybe not necessary 
        repo.deleteAll();
        // Create a dummy record
        myRecordForTest = repo.save(MyRecordDataFactory.createOneMyRecordForTesting());
    }

    @Test
    public void testCreateMyRecord() {
        
        MyRecord existsMyRecord = entityManager.find(MyRecord.class, myRecordForTest.getId());
        
        assertThat(myRecordForTest.getAuthor()).isEqualTo(existsMyRecord.getAuthor());        
    }
}
