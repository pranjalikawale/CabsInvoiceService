package com.bl.cabservice.model;

import com.bl.cabservice.model.RidesCategory;

public class NormalRide implements RidesCategory {
    public int COST_PER_TIME = 1;
    public double MINIMUM_COST_PER_KILOMETER = 10;
    public double MINIMUM_FARE=5;

    public int getCostPerTime(){
        return COST_PER_TIME;
    }

    public double getMinimumCostPerKilometer(){
        return MINIMUM_COST_PER_KILOMETER;
    }

    public double getMinimumFare(){
        return MINIMUM_FARE;
    }
}
