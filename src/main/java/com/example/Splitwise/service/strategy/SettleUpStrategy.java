package com.example.Splitwise.service.strategy;

import com.example.Splitwise.dto.TransactionDTO;
import com.example.Splitwise.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<TransactionDTO> settleUp(List<Expense> expenses);
}
