package com.bl.cabservice;

public class Ride {
    public double distance;
    public int time;
    public String type;

    public Ride(String type,double distance, int time) {
        this.distance=distance;
        this.time=time;
        this.type=type;
    }
}
