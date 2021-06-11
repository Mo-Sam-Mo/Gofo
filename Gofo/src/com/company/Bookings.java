package com.company;

/**
 * this class holds the bookings info and it's function
 *
 * @version 2.1
 * @author Hanan , Mohamed, Fatima
 */

public class Bookings {
    protected String name;
    protected String location;
    protected double price;
    protected int time;
    protected long cancellationPeriod;

    /**
     * it sets the cancellation period
     *
     * @param cancellationPeriod the period that the booker can cancel the book before it
     */
    public void setCancellationPeriod(long cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    /**
     * set the booker name
     *
     * @param name the booker name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set booking location
     *
     * @param location the playground location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * set booking price
     *
     * @param price the price that the booker has paid it
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * set booking time
     *
     * @param time the time that the player has choose
     */
    public void setTime(int time) {
        this.time = time;
    }
}

