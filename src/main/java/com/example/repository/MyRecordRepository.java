package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository; 
import org.springframework.data.jpa.repository.Query;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;
 
public interface MyRecordRepository extends CrudRepository<MyRecord, Integer>{

    List<MyRecord> findByDateOfTransaction(Date dateOfTransaction);

    List<MyRecord> findByTypeOfTransaction(TypeOfTransaction typeOfTransaction);

    List<MyRecord> findByCheckNumber(String checkNumber);

    List<MyRecord> findByName(String name);

    List<MyRecord> findByAmount(Float amount);

    List<MyRecord> findByThemeGeneral(ThemeGeneral themeGeneral);

    List<MyRecord> findByBeneficiary(String beneficiary);

    List<MyRecord> findByThemeSub(ThemeSub themeSub);

    List<MyRecord> findByTenant(String tenant);

    List<MyRecord> findByAuthor(Author author);

    @Query(value = "SELECT * FROM account_records WHERE type_of_transaction = \"Salary\" OR \"Payment\" ORDER BY date_of_transaction",
           nativeQuery = true)
    List<MyRecord> findAllIncomes();
    
}
