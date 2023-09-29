package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.repository.MyRecordRepository;

import jakarta.servlet.http.HttpServletRequest;

import com.example.exception.MyRecordIdMismatchException;
import com.example.exception.MyRecordNotFoundException;
import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;

@RestController
@RequestMapping("/api/myRecords")
public class MyRecordController {

    private MyRecordRepository repository;

    @Autowired
    public MyRecordController(MyRecordRepository repository) {
        this.repository = repository;
    }

    // to ensure the binding between HTML date and Java Date type
    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/addANewRecord")
    @ResponseStatus(HttpStatus.CREATED)
    public String addRecord(@Validated MyRecord myRecord, BindingResult result, Model model) {
        System.out.println("add a new Record");
        if (result.hasErrors()){
            System.out.println("adding a new Record has failed");
            return "account-form "+ result;
        }
        repository.save(myRecord);
        System.out.println("Success !");

        return "account-form";
    }

    @GetMapping("/all-of-my-records")
    public Iterable<MyRecord> findAll() {
        return repository.findAll();
    }
    @GetMapping("/all-incomes")
    Object findAllIncomes() {
        return repository.findAllIncomes();
    }

    @GetMapping("/{id}")
    public MyRecord findById(@PathVariable Integer id) {
        return repository.findById(id)
          .orElseThrow(MyRecordNotFoundException::new);
    }

    @GetMapping("/date/{date-of-transaction}")
    public List<MyRecord> findByDateOfTransaction(@PathVariable Date dateOfTransaction) {
        return repository.findByDateOfTransaction(dateOfTransaction);
    }

    @GetMapping("/type/{type-of-transaction}")
    public List<MyRecord> findByTypeOfTransaction(@PathVariable TypeOfTransaction typeOfTransaction) {
        return repository.findByTypeOfTransaction(typeOfTransaction);
    }

    @GetMapping("/check-number/{check-number}")
    public List<MyRecord> findByCheckNumber(@PathVariable String checkNumber) {
        return repository.findByCheckNumber(checkNumber);
    }

    @GetMapping("/name/{name}")
    public List<MyRecord> findByName(@PathVariable String name){
        return repository.findByName(name);
    }

    @GetMapping("/amount/{amount}")
    public List<MyRecord> findByAmount(@PathVariable Float amount){
        return repository.findByAmount(amount);
    }
    
    @GetMapping("/theme-general/{theme-general}")
    public List<MyRecord> findByThemeGeneral(@PathVariable ThemeGeneral themeGeneral){
        return repository.findByThemeGeneral(themeGeneral);
    }
    @GetMapping("/beneficiary/{beneficiary}")
    public List<MyRecord> findByBeneficiary(@PathVariable String beneficiary){
        return repository.findByBeneficiary(beneficiary);
    }

    @GetMapping("/theme-sub/{theme-sub}")
    public List<MyRecord> findByThemeSub(@PathVariable ThemeSub themeSub){
        return repository.findByThemeSub(themeSub);
    }

    @GetMapping("/tenant/{tenant}")
    public List<MyRecord> findByTenant(@PathVariable String tenant){
        return repository.findByTenant(tenant);
    }
    
    @GetMapping("/author/{author}")
    public List<MyRecord> findByAuthor(@PathVariable Author author){
        return repository.findByAuthor(author);
    }

    @PutMapping("/{id}")
    public MyRecord updateMyRecord(@RequestBody MyRecord myRecord, @PathVariable Integer id) {
        if (!myRecord.getId().equals(id)) {
          throw new MyRecordIdMismatchException();
        }
        repository.findById(id)
          .orElseThrow(MyRecordNotFoundException::new);
        return repository.save(myRecord);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.findById(id)
          .orElseThrow(MyRecordNotFoundException::new);
        repository.deleteById(id);
    }

    @DeleteMapping("/purgeDatabase")
    public void purgeDatabase() {
        repository.deleteAll();
    }
}
