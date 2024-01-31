package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.entities.MyRecord;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.TypeOfTransaction;

public interface MyRecordRepository extends CrudRepository<MyRecord, Long>{
    MyRecord findById(long id);

    List<MyRecord> findAll();

    @Query("SELECT mr FROM MyRecord mr WHERE " +
        "MONTH(mr.dateOfTransaction) = MONTH(:givenDate) AND " +
        "YEAR(mr.dateOfTransaction) = YEAR(:givenDate) AND " +
        " (mr.typeTransaction NOT IN :excludedTypes or :excludedTypes is null)")
    List<MyRecord> findDebitByMonth(@Param("givenDate") LocalDate givenDate, @Param("excludedTypes") List<TypeOfTransaction> excludedTypes);
    @Query("SELECT mr FROM MyRecord mr WHERE " +
    "YEAR(mr.dateOfTransaction) = YEAR(:givenDate) AND " +
    " (mr.typeTransaction NOT IN :excludedTypes or :excludedTypes is null)")
    List<MyRecord> findDebitByYear(@Param("givenDate") LocalDate givenDate, @Param("excludedTypes") List<TypeOfTransaction> excludedTypes);
    @Query("SELECT mr FROM MyRecord mr WHERE " +
        "MONTH(mr.dateOfTransaction) = MONTH(:givenDate) AND " +
        "YEAR(mr.dateOfTransaction) = YEAR(:givenDate) AND " +
        "mr.typeTransaction = 'BALANCE' ")
    MyRecord findBalanceByMonth(@Param("givenDate") LocalDate givenDate);
    @Query("SELECT DISTINCT mr.themeGeneral FROM MyRecord mr")
    List<ThemeGeneral> findAllDistinctThemeGenerals();
    @Query("SELECT DISTINCT mr.themeSub FROM MyRecord mr")
    List<ThemeGeneral> findAllDistinctThemeSubs();

}
