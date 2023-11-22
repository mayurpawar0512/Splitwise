package com.example.Splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SPLITWISE_USEREXPENSE")
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;

    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;

}
/*
    User to UserExpense relationship :
        one UserExpense will have only one user
        but one user can have many UserExpense
        User  UserExpense
        1       M
        1       1

        UserExpense : User -> M:1

    Expense to UserExpense relationship :
        1:m - since one expense can have multiple UserExpenses

 */