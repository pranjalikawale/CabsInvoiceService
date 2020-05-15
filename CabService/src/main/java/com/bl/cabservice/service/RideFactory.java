package com.bl.cabservice.service;

import com.bl.cabservice.model.NormalRide;
import com.bl.cabservice.model.PremiumRide;
import com.bl.cabservice.model.RideData;

public class RideFactory {

    public RideData getRide(String typeOfRides){
        RideData rideData =new RideData();
        if(typeOfRides.equals("Normal Ride")){
            NormalRide nride=new NormalRide();
            rideData.CostperTime=nride.getCostPerTime();
            rideData.MinCost=nride.getMinimumFare();
            rideData.MinCostperkm=nride.getMinimumCostPerKilometer();
        }
        else if(typeOfRides.equals("Premium Ride")){
            PremiumRide pride=new PremiumRide();
            rideData.CostperTime=pride.getCostPerTime();
            rideData.MinCost=pride.getMinimumFare();
            rideData.MinCostperkm=pride.getMinimumCostPerKilometer();
        }
        return rideData;
    }

}
