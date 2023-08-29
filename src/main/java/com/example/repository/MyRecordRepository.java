package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;

public interface MyRecordRepository extends CrudRepository<MyRecord, Long>{
    MyRecord findById(long id);

    List<MyRecord> findByDateOfTransaction(Date dateOfTransaction);

    List<MyRecord> findByTypeTransaction(TypeOfTransaction typeTransaction);

    List<MyRecord> findByName(String name);

    List<MyRecord> findByAmount(Float amount);
    
    List<MyRecord> findByAuthor(Author author);

    List<MyRecord> findByCheckNumber(String checkNumber);

    List<MyRecord> findByThemeGeneral(ThemeGeneral themeGeneral);

    List<MyRecord> findByBeneficiary(String beneficiary);

    List<MyRecord> findByThemeSub(ThemeSub themeSub);

    List<MyRecord> findByTenant(String tenant);
}
