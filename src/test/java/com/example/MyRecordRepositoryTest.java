package com.example;
 
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
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
import com.example.MyRecordHTMLCrudTest;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MyRecordRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private MyRecordRepository repo;

    @Test
    public void testCreateUser() {

        MyRecord myRecordForTest = repo.save(MyRecordDataFactory.createOneMyRecordForTesting());
        
        MyRecord existsMyRecord = entityManager.find(MyRecord.class, myRecordForTest.getId());
        
        assertThat(myRecordForTest.getAuthor()).isEqualTo(existsMyRecord.getAuthor());        
    }
}
