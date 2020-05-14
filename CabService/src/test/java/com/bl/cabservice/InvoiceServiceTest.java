package com.bl.cabservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService =null;

    @Before
    public void initialize(){
        invoiceService =new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance=2.0;
        int time=5;
        double fare= invoiceService.getCalculateFare("Premium Ride",distance,time);
        Assert.assertEquals(40.0,fare,0.0);
    }


    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare(){
        double distance=0.1;
        int time=1;
        double fare= invoiceService.getCalculateFare("Normal Ride",distance,time);
        Assert.assertEquals(5,fare,0.0);
    }
    @Test
    public void givenMultipleRide_ShouldReturnTotalFare(){
        String userId="pranjali@123.com";
        Ride[] rides={new Ride("Normal Ride",2.0,5),
                      new Ride("Normal Ride",0.1,1)};
        InvoiceSummary summary= invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary(){
        String userId="pranjali@123.com";
        Ride[] rides={new Ride("Normal Ride",2.0,5),
                      new Ride("Normal Ride",0.1,1)};
        invoiceService.addRides(userId,rides);
        Ride[] rides1={new Ride("Premium Ride",2.0,5),
                       new Ride("Premium Ride",0.1,1)};
        invoiceService.addRides(userId,rides1);
        InvoiceSummary summary= invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenTypeOfRideDistanceAndTime_ShouldReturnTotalFare(){
        double distance=2.0;
        int time=5;
        String type="Normal Ride";
        double fare= invoiceService.getCalculateFare(type,distance,time);
        Assert.assertEquals(25,fare,0.0);
    }





}
