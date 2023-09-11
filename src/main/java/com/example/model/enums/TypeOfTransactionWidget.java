package com.example.model.enums;

public class TypeOfTransactionWidget {
    private String name;
    private TypeOfTransaction typeOfTransaction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfTransaction getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(TypeOfTransaction typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    @Override
    public String toString() {
        return "TypeOfTransactionWidget [name=" + name + ", typeOfTransaction=" + typeOfTransaction + "]";
    }
}
