package io.geuns.csvmicroservice.csv.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import io.geuns.csvmicroservice.csv.helper.AmountCsvConverter;

import java.time.LocalDate;

public class CsvStatement {

    @CsvDate(value = "yyyy-MM-dd") @CsvBindByName(column = "Date")
    private LocalDate statementDate;

    @CsvCustomBindByName(converter = AmountCsvConverter.class, column = "Amount")
    private double amount;

    @CsvBindByName(column = "Account")
    private String account;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Description")
    private String description;


    public CsvStatement() {
    }

    public CsvStatement(LocalDate statementDate, Double amount, String account, String name, String description) {
        this.statementDate = statementDate;
        this.amount = amount;
        this.account = account;
        this.name = name;
        this.description = description;
    }

    public LocalDate getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(LocalDate statementDate) {
        this.statementDate = statementDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
