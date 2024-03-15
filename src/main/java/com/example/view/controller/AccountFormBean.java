package com.example.view.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.BankAccount;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;
import com.example.repository.MyRecordRepository;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Component
@Named
@ViewScoped
@Slf4j
public class AccountFormBean extends UtilsBean implements Serializable {

    private LocalDate dateDefaultValue = LocalDate.now();
    @Autowired
    private MyRecordRepository repository;

    private MyRecord currentRecord;

    private String display = "none";

    @PostConstruct
    public void init(){
        initRecord();
        log.info("init 1 currentRecord -> {} ", currentRecord);
    }

    private void initRecord() {
        currentRecord = new MyRecord();
        currentRecord.setTypeTransaction(TypeOfTransaction.SALARY);
    }
    
    public void onTypeOfTransactionChange(){
        log.info("onTypeOfTransactionChange", currentRecord.getTypeTransaction());
        currentRecord.setThemeGeneral(null);
        currentRecord.setThemeSub(null);
        currentRecord.setBeneficiary(null);
        currentRecord.setTenant(null);
        
    }
    public void onThemeGeneralChange() {
      currentRecord.setThemeSub(null);
      currentRecord.setBeneficiary(null);
      currentRecord.setTenant(null);
    }
    public void onThemeSubChange() {
        currentRecord.setBeneficiary(null);
        currentRecord.setTenant(null);
      }
    public void save(){
        repository.save(currentRecord);
        initRecord();
    }
    public List<TypeOfTransaction> getAllTypeOfTransaction(){
        return Arrays.asList(TypeOfTransaction.values());
    }
    public List<ThemeGeneral> getAllThemeGeneral(){
        return Arrays.asList(ThemeGeneral.values());
    }
    public List<ThemeSub> getAllThemeSub(){
        return Arrays.asList(ThemeSub.values());
    }
    public List<ThemeGeneral> getMatchThemeGeneral(TypeOfTransaction typeOfTransaction){
        log.info("Récupération du thème général pour {}", typeOfTransaction);
        return Arrays.asList(ThemeGeneral.values()).stream()
            .filter(themeGeneral -> typeOfTransaction.getListGenerals().contains(themeGeneral))
            .collect(Collectors.toList());
    }
    public List<ThemeSub> getMatchThemeSub(ThemeGeneral general){
        log.info("Récupération du sous thème pour {}", general);
        return Arrays.asList(ThemeSub.values()).stream()
            .filter(sub -> sub.getListGenerals().contains(general))
            .collect(Collectors.toList());
    }

    public List<BankAccount> getAllBankAccounts(){
        return Arrays.asList(BankAccount.values());
    }
    public boolean showFieldBankAccount(){
        if(currentRecord.getTypeTransaction()==null){
            return true;
        }
        return !currentRecord.getTypeTransaction().isIncome();
    }
    public boolean showFieldBeneficiary(){
        log.info(" in showFieldBeneficiary with {}, {}", currentRecord.getTypeTransaction(), currentRecord.getThemeGeneral());
        return 
            (currentRecord.getTypeTransaction()!=null && currentRecord.getTypeTransaction().isIncome())
            || (currentRecord.getThemeGeneral()!=null && currentRecord.getThemeGeneral().isBeneficiaryRendered())
        ;
    }
    public boolean showFieldCheckNumber(){
        /** The field 'checkNumber' appears if TypeOfTransaction value is in CHECK.
         * **/
        log.info("showFieldCheckNumber()", currentRecord.getTypeTransaction());
        if(currentRecord.getTypeTransaction()==null){
            return false;
        }
        return currentRecord.getTypeTransaction().isCheckNumberRendered();
    }
    public boolean showFieldThemeGeneral(){
        log.info("showFieldCheckNumber()", currentRecord.getTypeTransaction());
        if(currentRecord.getTypeTransaction()==null){
            return false;
        }
        return currentRecord.getTypeTransaction().isThemeGeneralRendered();
    }
    public boolean showFieldThemeSub(){
        log.info("showFieldCheckNumber()", currentRecord.getTypeTransaction());
        if(currentRecord.getTypeTransaction()==null){
            return false;
        }
        return currentRecord.getTypeTransaction().isThemeGeneralRendered();
    }
    public boolean showFieldTenant(){
        /** The field 'tenant' appears if ThemeSub value is value is in RENT.
         * **/
        log.info("showFieldCheckNumber()", currentRecord.getThemeSub());
        if(currentRecord.getThemeSub()==null){
            return false;
        }
        return currentRecord.getThemeSub().isTenantRendered();
    }




}
