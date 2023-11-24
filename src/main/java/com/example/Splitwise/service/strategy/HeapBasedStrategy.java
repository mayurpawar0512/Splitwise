package com.example.Splitwise.service.strategy;

import com.example.Splitwise.dto.TransactionDTO;
import com.example.Splitwise.model.Expense;
import com.example.Splitwise.model.User;
import com.example.Splitwise.model.UserExpense;
import com.example.Splitwise.model.UserExpenseType;

import java.util.*;

public class HeapBasedStrategy implements SettleUpStrategy{
    @Override
    public List<TransactionDTO> settleUp(List<Expense> expenses) {
        HashMap<User, Double> outStandingAmountMap = new HashMap<>();
        List<TransactionDTO> transactions = new ArrayList<>();

        for(Expense expense : expenses){
            for(UserExpense userExpense : expense.getUserExpenses()){
                User user = userExpense.getUser();
                double currentOutStandingAmount = outStandingAmountMap.getOrDefault(user,0.0);
                outStandingAmountMap.put(user, getUpdatedOutStandingAmount(currentOutStandingAmount, userExpense));

            }
        }

        //Users with positive balance
        PriorityQueue<Map.Entry<User,Double>> maxHeap = new PriorityQueue<>(
                (a,b) -> Double.compare(b.getValue(),a.getValue())
        );

        //Users with negative balance
        PriorityQueue<Map.Entry<User,Double>> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(Map.Entry::getValue)
        );

        //Populate from the map
        for(Map.Entry<User, Double> entry : outStandingAmountMap.entrySet()){
            if(entry.getValue() < 0){
                minHeap.add(entry);
            } else if (entry.getValue() > 0) {
                maxHeap.add(entry);
            }else {
                System.out.println(entry.getKey().getName() + "'s is already settledup");
            }
        }

        //Calculate transactions till one of them becomes zero




        return transactions;
    }

    private Double getUpdatedOutStandingAmount(double currentOutStandingAmount, UserExpense userExpense) {
        if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID)){
            currentOutStandingAmount += userExpense.getAmount();
        }else{
            currentOutStandingAmount -= userExpense.getAmount();
        }
        return currentOutStandingAmount;
    }
}
