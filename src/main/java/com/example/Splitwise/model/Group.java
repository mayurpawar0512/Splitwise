package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_GROUP")
public class Group extends BaseModel {
    private String name;
    private String description;
    private String totalAmountSpent;
    private Currency defaultCurrency;
    @OneToMany
    @JoinColumn(name = "splitwise_group_id")
    private List<Expense> expenses;
    @ManyToMany
    private List<User> users;
}

/*
    Relationship between expense and group
    expense is doesn't have group but group have expenses
    so this is uni-directional oneToMany mapping -> we will use JoinColumn

    without this JPA created additional table names "splitwise_group_expense"
 */
