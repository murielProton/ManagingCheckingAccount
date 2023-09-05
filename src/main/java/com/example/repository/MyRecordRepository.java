package com.example.repository;

//import java.util.Date;
//import java.util.List;

//import org.springframework.data.repository.CrudRepository; 
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.entities.MyRecord;
//import com.example.model.enums.Author;
//import com.example.model.enums.ThemeGeneral;
//import com.example.model.enums.ThemeSub;
//import com.example.model.enums.TypeOfTransaction;
 
public interface MyRecordRepository extends JpaRepository<MyRecord, Long>{
    
}
