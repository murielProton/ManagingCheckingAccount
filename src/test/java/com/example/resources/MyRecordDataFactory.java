package com.example.resources;

import java.util.Date;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.TypeOfTransaction;

public  class MyRecordDataFactory {
    public static MyRecord createOneMyRecordForTesting(){

        MyRecord myDummy = new MyRecord();

        myDummy.setAuthor(Author.BOTH);
        myDummy.setName("Dummy name");
        myDummy.setDateOfTransaction(new Date());
        myDummy.setAmount(0f);
        myDummy.setTypeTransaction(TypeOfTransaction.WITHDRAWAL);
        myDummy.setThemeGeneral(ThemeGeneral.FOOD);
        return myDummy;
    }
}
