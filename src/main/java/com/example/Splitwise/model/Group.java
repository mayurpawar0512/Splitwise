package com.example.Splitwise.model;

import jakarta.persistence.Entity;
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
    @OneToMany                      //no need to put mapped by as we don't need mapping from Expense to Group
    private List<Expense> expenses;
    @ManyToMany
    private List<User> users;
}
