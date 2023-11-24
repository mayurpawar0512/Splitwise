package com.example.Splitwise.service.strategy;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(){       //<--- pass an enum and based on that select the strategy
        return  new HeapBasedStrategy();
    }
}
