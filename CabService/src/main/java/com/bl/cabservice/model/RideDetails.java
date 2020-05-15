package com.bl.cabservice.model;

public class RideDetails {
    public double distance;
    public int time;
    public String type;

    public RideDetails(String type, double distance, int time) {
        this.distance=distance;
        this.time=time;
        this.type=type;
    }
}
