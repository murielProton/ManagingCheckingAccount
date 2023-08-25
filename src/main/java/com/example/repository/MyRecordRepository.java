package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.entity.MyRecord;

public interface MyRecordRepository extends CrudRepository<MyRecord, Long>{
    List<MyRecord> findByDateOfTransaction(Date dateOfTransaction);    
}
