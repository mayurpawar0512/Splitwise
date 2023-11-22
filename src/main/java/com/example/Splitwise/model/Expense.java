package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_EXPENSE")
public class Expense extends BaseModel{
    private double amount;
    private String description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany
    private List<UserExpense> userExpenses;

}
/*
    Expense to currency relationship :
        1:1 - one expense cannot have more than one currency

    Expense to UserExpense relationship :
        1:m - since one expense can have multiple UserExpenses

 */