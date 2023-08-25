package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.entity.MyRecord;

public interface MyRecordRepository extends CrudRepository<MyRecord, Long>{
    MyRecord findById(long id);

    List<MyRecord> findByDateOfTransaction(Date dateOfTransaction);

    List<MyRecord> findByTypeTransaction(String typeTransaction);

    List<MyRecord> findByName(String name);

    List<MyRecord> findByAmount(Float amount);
    
    List<MyRecord> findByTheme(String theme);
    
    List<MyRecord> findByAuthor(String author);
}
