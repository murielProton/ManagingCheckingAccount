package com.example.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.entities.MyRecord;


@RunWith(SpringRunner.class)
@SpringBootTest
public interface MyRecordRepositoryTest extends CrudRepository<MyRecord, Long>{
    /*@Autowired
    private YourController yourController;

    @MockBean
    private MyRecord myRecord = new MyRecord();*/

    @Test
    public static void testFindDebitByMonth() {
        List<MyRecord> listOfMyRecordsToTest ;
    }


}
