package com.bl.cabservice;

public class InvoiceGenerator {
    private static final int COST_PR_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE=5;

    public double calculateFare(double distance, int time) {
        double totalFare=distance*MINIMUM_COST_PER_KILOMETER+time*COST_PR_TIME;
        if(totalFare<MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;

    }
}
