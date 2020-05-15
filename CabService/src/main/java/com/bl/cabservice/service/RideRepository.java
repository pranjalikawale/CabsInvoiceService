package com.bl.cabservice.service;

import com.bl.cabservice.model.RideDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<RideDetails>> userRides=null;

    public RideRepository() {
        this.userRides=new HashMap<>();
    }

    public void addRides(String userId, RideDetails[] rideDetails) {
        ArrayList<RideDetails> rideDetailsArrayList =this.userRides.get(userId);
        if(rideDetailsArrayList ==null) {
            this.userRides.put(userId,new ArrayList<>(Arrays.asList(rideDetails)));
        }
    }

    public RideDetails[] getRides(String userId){
        return this.userRides.get(userId).toArray(new RideDetails[0]);
    }
}
