package com.example.Splitwise.repository;

import com.example.Splitwise.model.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository  extends JpaRepository<UserExpense, Integer> {
}
