package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.model.entity.MyRecord;
import com.example.repository.MyRecordRepository;
import com.example.exception.MyRecordIdMismatchException;
import com.example.exception.MyRecordNotFoundException;

@RestController
@RequestMapping("/api/myRecords")
public class MyRecordController {
    @Value("${spring.application.name}")
    String appName;
    @Autowired
    private MyRecordRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MyRecord create(@RequestBody MyRecord myRecord) {
        return repository.save(myRecord);
    }

    @GetMapping("/createDummy")
    public MyRecord createDummy() {
        MyRecord myDummy = new MyRecord();
        myDummy.setAuthor("Dummy author");
        myDummy.setName("Dummy name");
        myDummy.setDateOfTransaction(new Date());
        myDummy.setAmount(0f);
        return repository.save(myDummy);
    }

    @GetMapping
    public Iterable<MyRecord> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public MyRecord findById(@PathVariable Long id) {
        return repository.findById(id)
          .orElseThrow(MyRecordNotFoundException::new);
    }

    @GetMapping("/date/{dateOfTransaction}")
    public List<MyRecord> findByTitle(@PathVariable Date dateOfTransaction) {
        return repository.findByDateOfTransaction(dateOfTransaction);
    }

    @GetMapping("/type/{typeTransaction}")
    public List<MyRecord> findByTypeTransaction(@PathVariable String typeTransaction) {
        return repository.findByTypeTransaction(typeTransaction);
    }

    @GetMapping("/name/{name}")
    public List<MyRecord> findByName(@PathVariable String name){
        return repository.findByName(name);
    }

    @GetMapping("/amount/{amount}")
    public List<MyRecord> findByName(@PathVariable Float amount){
        return repository.findByAmount(amount);
    }
    
    @GetMapping("/theme/{theme}")
    public List<MyRecord> findByTheme(@PathVariable String theme){
        return repository.findByTheme(theme);
    }
    
    @GetMapping("/author/{author}")
    public List<MyRecord> findByAuthor(@PathVariable String author){
        return repository.findByAuthor(author);
    }

    @PutMapping("/{id}")
    public MyRecord updateBook(@RequestBody MyRecord myRecord, @PathVariable Long id) {
        if (myRecord.getId() != id) {
          throw new MyRecordIdMismatchException();
        }
        repository.findById(id)
          .orElseThrow(MyRecordNotFoundException::new);
        return repository.save(myRecord);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id)
          .orElseThrow(MyRecordNotFoundException::new);
        repository.deleteById(id);
    }


}
