package com.bl.cabservice;

public class InvoiceService {

    public  int costPerTime ;
    public  double minimumCostPerKilometer ;
    public  double minimumFare;
    private final RideRepository rideRepository;

    public InvoiceService(){
        this.rideRepository=new RideRepository();
    }

    public  double getCalculateFare(String typeOfRides,double distance,int time){
        switch (typeOfRides){
            case "Normal Ride":
                costPerTime= 1;
                minimumCostPerKilometer = 10;
                minimumFare=5;
                break;
            case "Premium Ride":
                costPerTime= 2;
                minimumCostPerKilometer = 15;
                minimumFare=20;
                break;
        }
        return calculateFare(distance,time);
    }


    public double calculateFare(double distance, int time) {
        double totalFare=distance*minimumCostPerKilometer+time*costPerTime;
        return Math.max(totalFare,minimumFare);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare=0;
        for (Ride ride:rides){
            totalFare+=this.getCalculateFare(ride.type,ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userId,Ride[] rides){
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId){
        return this.calculateFare(rideRepository.getRides(userId));
    }

}
