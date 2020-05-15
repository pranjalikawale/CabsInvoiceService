package com.bl.cabservice.controller;

import com.bl.cabservice.model.RideData;
import com.bl.cabservice.model.RideDetails;
import com.bl.cabservice.service.InvoiceSummary;
import com.bl.cabservice.service.RideFactory;
import com.bl.cabservice.service.RideRepository;

public class InvoiceService {

    public int costPerTime;
    public double minimumCostPerKilometer ;
    public double minimumFare;
    private final RideRepository rideRepository;

    public InvoiceService(){
        this.rideRepository=new RideRepository();
    }

    public void setValue(String typeOfRides) {
        RideData rideVal=new RideFactory().getRide(typeOfRides);
        this.costPerTime=rideVal.CostperTime;
        this.minimumCostPerKilometer=rideVal.MinCostperkm;
        this.minimumFare=rideVal.MinCost;
    }

    public  double getCalculateFare(String typeOfRides,double distance,int time){
        //Get the values as per Type
        setValue(typeOfRides);
        return calculateFare(distance,time);
    }
    
    public double calculateFare(double distance, int time) {
        double totalFare=distance*minimumCostPerKilometer+time*costPerTime;
        return Math.max(totalFare,minimumFare);
    }

    public InvoiceSummary calculateFare(RideDetails[] rideDetails) {
        double totalFare=0;
        for (RideDetails rideDetail : rideDetails){
            totalFare+=this.getCalculateFare(rideDetail.type, rideDetail.distance, rideDetail.time);
        }
        return new InvoiceSummary(rideDetails.length,totalFare);
    }

    public void addRides(String userId, RideDetails[] rideDetails){
        rideRepository.addRides(userId, rideDetails);
    }

    public InvoiceSummary getInvoiceSummary(String userId){
        return this.calculateFare(rideRepository.getRides(userId));
    }

}
