package com.example.repository;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MyRecordRepositoryTest {
    //variable to set for all tests and mocks
    private final LocalDate dateOfTransaction = LocalDate.now().withDayOfMonth(1);


    //to be used in all this class
    @Autowired
    private MyRecordRepository myRecordRepository;

    private final List<MyRecord> mockRecords = new ArrayList<>();

    @Before
    public void setUpTestMyRecordRepository() {

        // Create mock records
        MyRecord mockRecord1 = new MyRecord();
        MyRecord mockRecord2 = new MyRecord();
        MyRecord mockRecord3 = new MyRecord();
        MyRecord mockRecord4 = new MyRecord();
        MyRecord mockRecord5 = new MyRecord();
        MyRecord mockRecord6 = new MyRecord();
        MyRecord mockRecord7 = new MyRecord();
        MyRecord mockRecord8 = new MyRecord();
        MyRecord mockRecord9 = new MyRecord();
        MyRecord mockRecord10 = new MyRecord();


        mockRecord1.setAmount(23f);
        mockRecord1.setAuthor(Author.MURIEL);
        mockRecord1.setBeneficiary("Muriel");
        mockRecord1.setCheckNumber(null);
        mockRecord1.setDateOfTransaction(dateOfTransaction.minusMonths(1));
        mockRecord1.setName("test1");
        mockRecord1.setTenant(null);
        mockRecord1.setThemeGeneral(ThemeGeneral.HEALTH);
        mockRecord1.setThemeSub(null);
        mockRecord1.setTypeTransaction(TypeOfTransaction.CREDIT_CARD);

        mockRecord2.setAmount(800f);
        mockRecord2.setAuthor(null);
        mockRecord2.setBeneficiary("Muriel");
        mockRecord2.setCheckNumber(null);
        mockRecord2.setDateOfTransaction(dateOfTransaction);
        mockRecord2.setName("test2");
        mockRecord2.setTenant("test tenant");
        mockRecord2.setThemeGeneral(ThemeGeneral.CALUIRE_ET_CUIRE);
        mockRecord2.setThemeSub(ThemeSub.RENT);
        mockRecord2.setTypeTransaction(TypeOfTransaction.PAYMENT);

        mockRecord3.setAmount(23f);
        mockRecord3.setAuthor(Author.MURIEL);
        mockRecord3.setBeneficiary("Muriel");
        mockRecord3.setCheckNumber(null);
        mockRecord3.setDateOfTransaction(dateOfTransaction);
        mockRecord3.setName("test3");
        mockRecord3.setTenant(null);
        mockRecord3.setThemeGeneral(ThemeGeneral.HEALTH);
        mockRecord3.setThemeSub(null);
        mockRecord3.setTypeTransaction(TypeOfTransaction.CASH);

        mockRecord4.setAmount(100f);
        mockRecord4.setAuthor(Author.MURIEL);
        mockRecord4.setBeneficiary("Muriel");
        mockRecord4.setCheckNumber(null);
        mockRecord4.setDateOfTransaction(dateOfTransaction);
        mockRecord4.setName("test4");
        mockRecord4.setTenant(null);
        mockRecord4.setThemeGeneral(null);
        mockRecord4.setThemeSub(null);
        mockRecord4.setTypeTransaction(TypeOfTransaction.BALANCE);

        mockRecord5.setAmount(800f);
        mockRecord5.setAuthor(null);
        mockRecord5.setBeneficiary("Muriel");
        mockRecord5.setCheckNumber(null);
        mockRecord5.setDateOfTransaction(dateOfTransaction.plusMonths(1));
        mockRecord5.setName("test5");
        mockRecord5.setTenant("test tenant");
        mockRecord5.setThemeGeneral(ThemeGeneral.CALUIRE_ET_CUIRE);
        mockRecord5.setThemeSub(ThemeSub.RENT);
        mockRecord5.setTypeTransaction(TypeOfTransaction.CHECK_CASHING);

        mockRecord6.setAmount(800f);
        mockRecord6.setAuthor(null);
        mockRecord6.setBeneficiary("Muriel");
        mockRecord6.setCheckNumber(null);
        mockRecord6.setDateOfTransaction(dateOfTransaction.plusYears(1));
        mockRecord6.setName("test6");
        mockRecord6.setTenant("test tenant");
        mockRecord6.setThemeGeneral(ThemeGeneral.CALUIRE_ET_CUIRE);
        mockRecord6.setThemeSub(ThemeSub.RENT);
        mockRecord6.setTypeTransaction(TypeOfTransaction.CHECK_CASHING);

        mockRecord7.setAmount(800f);
        mockRecord7.setAuthor(null);
        mockRecord7.setBeneficiary("Muriel");
        mockRecord7.setCheckNumber(null);
        mockRecord7.setDateOfTransaction(dateOfTransaction);
        mockRecord7.setName("test7");
        mockRecord7.setTenant("");
        mockRecord7.setThemeGeneral(ThemeGeneral.CALUIRE_ET_CUIRE);
        mockRecord7.setThemeSub(ThemeSub.COSTS);
        mockRecord7.setTypeTransaction(TypeOfTransaction.AUTOMATIC_DRAWDOWN);

        mockRecord8.setAmount(130f);
        mockRecord8.setAuthor(null);
        mockRecord8.setBeneficiary(null);
        mockRecord8.setCheckNumber("123456789");
        mockRecord8.setDateOfTransaction(dateOfTransaction);
        mockRecord8.setName("test8");
        mockRecord8.setTenant("");
        mockRecord8.setThemeGeneral(ThemeGeneral.MEZIEU);
        mockRecord8.setThemeSub(ThemeSub.GASS);
        mockRecord8.setTypeTransaction(TypeOfTransaction.CHECK);

        mockRecord9.setAmount(23f);
        mockRecord9.setAuthor(Author.MURIEL);
        mockRecord9.setBeneficiary("Muriel");
        mockRecord9.setCheckNumber(null);
        mockRecord9.setDateOfTransaction(dateOfTransaction);
        mockRecord9.setName("test3");
        mockRecord9.setTenant(null);
        mockRecord9.setThemeGeneral(ThemeGeneral.HEALTH);
        mockRecord9.setThemeSub(null);
        mockRecord9.setTypeTransaction(TypeOfTransaction.CREDIT_CARD);

        mockRecord10.setAmount(720f);
        mockRecord10.setAuthor(null);
        mockRecord10.setBeneficiary("Muriel");
        mockRecord10.setCheckNumber(null);
        mockRecord10.setDateOfTransaction(dateOfTransaction);
        mockRecord10.setName("test7");
        mockRecord10.setTenant("");
        mockRecord10.setThemeGeneral(ThemeGeneral.CALUIRE_ET_CUIRE);
        mockRecord10.setThemeSub(ThemeSub.ELECTRICITY);
        mockRecord10.setTypeTransaction(TypeOfTransaction.AUTOMATIC_DRAWDOWN);

        //add mockRecords to list
        mockRecords.add(mockRecord1);
        mockRecords.add(mockRecord2);
        mockRecords.add(mockRecord3);
        mockRecords.add(mockRecord4);
        mockRecords.add(mockRecord5);
        mockRecords.add(mockRecord6);
        mockRecords.add(mockRecord7);
        mockRecords.add(mockRecord8);
        mockRecords.add(mockRecord9);
        mockRecords.add(mockRecord10);
        myRecordRepository.deleteAll();
        myRecordRepository.saveAll(mockRecords);
    }

    @Test
    public void testFindAll() throws Exception {
        List<MyRecord> listOfMyRecordsToTest = new ArrayList<>();
        listOfMyRecordsToTest = myRecordRepository.findAll();
        Assert.assertEquals(listOfMyRecordsToTest.size(), 10);
    }

    @Test
    public void testFindDebitByMonth() throws Exception {
        List<MyRecord> listOfMyRecordsToTest = new ArrayList<>();
        listOfMyRecordsToTest = myRecordRepository.findDebitByMonth(dateOfTransaction, Arrays.asList(TypeOfTransaction.CASH,
                TypeOfTransaction.BALANCE));
        Assert.assertEquals(listOfMyRecordsToTest.size(), 5);
    }

    @Test
    public void testFindMyRecordsByMonthAndAuthor() throws Exception{
        List<MyRecord> listOfMyRecordsToTest = new ArrayList<>();
        listOfMyRecordsToTest = myRecordRepository.findMyRecordsByMonthAndAuthor(dateOfTransaction,
                                                                                List.of(Author.MURIEL),
                                                                                Arrays.asList(TypeOfTransaction.CASH, 
                                                                                                TypeOfTransaction.BALANCE));
        Assert.assertEquals(listOfMyRecordsToTest.size(),1);
    }
    @Test
    public void testFindDebitByYear() throws Exception{
        List<MyRecord> listOfMyRecordsToTest = new ArrayList<>();
        listOfMyRecordsToTest = myRecordRepository.findDebitByYear(dateOfTransaction,
                                                                                Arrays.asList(TypeOfTransaction.CASH,
                                                                                            TypeOfTransaction.BALANCE));
    Assert.assertEquals(listOfMyRecordsToTest.size(),7);
    }
    @Test
    public void testFindYearlyReportsByThemeGeneral() throws Exception{
        List<MyRecord> listOfMyRecordsToTest = new ArrayList<>();
            listOfMyRecordsToTest = myRecordRepository.findYearlyReportsByThemeGeneral(dateOfTransaction,
                                                                                                    ThemeGeneral.CALUIRE_ET_CUIRE,
                                                                                                    Arrays.asList(TypeOfTransaction.CASH,
                                                                                                    TypeOfTransaction.BALANCE));
        Assert.assertEquals(listOfMyRecordsToTest.size(),4);
    }
    @Test
    public void testFindBalanceByMonth() throws Exception{
        MyRecord myRecordToTest = null;
        myRecordToTest = myRecordRepository.findBalanceByMonth(dateOfTransaction);
        Assert.assertEquals((float)myRecordToTest.getAmount(),(float) 100,00);
    }
    @Test
    public void testFindAllDistinctThemeGenerals() throws Exception{
        List<ThemeGeneral> listOfThemeGeneral = new ArrayList<>();
            listOfThemeGeneral = myRecordRepository.findAllDistinctThemeGenerals();
        Assert.assertEquals(listOfThemeGeneral.size(),4);
    }
    @Test
    public void testFindAllDistinctThemeSubs() throws Exception{
        List<ThemeSub> listOfThemeSubs = new ArrayList<>();
        listOfThemeSubs = myRecordRepository.findAllDistinctThemeSubs();
        Assert.assertEquals(listOfThemeSubs.size(),5);
    }
    @Test
    public void testFindDistinctThemeSubsFrom() throws Exception{
        List<ThemeSub> listOfThemeSubs = new ArrayList<>();
        listOfThemeSubs = myRecordRepository.findDistinctThemeSubsFrom(Arrays.asList(ThemeSub.COSTS,ThemeSub.GASS));
        Assert.assertEquals(listOfThemeSubs.size(),2);
    }
    @Test
    public void testFindRecordsByYearAndThemeAndExludingThemeSubs() throws Exception{
        List<MyRecord> listOfMyRecordsToTest = new ArrayList<>();
        listOfMyRecordsToTest = myRecordRepository.findRecordsByYearAndThemeAndExludingThemeSubs(dateOfTransaction,
                                                                                                    ThemeGeneral.CALUIRE_ET_CUIRE,
                                                                                                    Arrays.asList(ThemeSub.GASS,
                                                                                                                ThemeSub.COSTS));
        Assert.assertEquals(listOfMyRecordsToTest.size(),3);
    }


}
