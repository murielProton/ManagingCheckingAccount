package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import com.example.model.entities.MyRecord;
import com.example.repository.MyRecordRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMyRecordReopsitory
@Sql({"/database/schema.sql", "/import_my_records.sql"})
public class SchemaSQLTest {
    @Autowired
    private MyRecordRepository myRecordRepository;

    @Test
    public void testLoadDataForTestClass() {
        Collection<MyRecord> myCollectionOfRecords;
        myCollectionOfRecords = (Collection<MyRecord>) myRecordRepository.findAll();
        assertEquals(1, myCollectionOfRecords.size());
    }
}
