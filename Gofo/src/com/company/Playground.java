package com.company;
import java.util.ArrayList;

/**
 * this class holds the playground data and it's functions
 *
 * @version 2.1
 * @author Hanan , Mohamed, Fatima
 */

public class Playground {
    protected int playgroundID ;
    protected String location ;
    protected int playgroundOwnerID ;
    protected String playgroundName;
    private double price;
    private ArrayList<Integer> avaHour=new ArrayList<>();


    Playground(){
        avaHour.add(0,12);
        for(int i=1;i<12;i++){
            avaHour.add(i,i);
        }
    }

    /**
     * set the playground price
     *
     * @param price new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * set the playground location
     *
     * @param location new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * set the playground ID
     *
     * @param playgroundID new playground ID
     */
    public void setPlaygroundID(int playgroundID) {
        this.playgroundID = playgroundID;
    }

    /**
     * set the playground Name
     *
     * @param playgroundName new playground Name
     */
    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    /**
     * set the playground owner ID
     *
     * @param playgroundOwnerID the owner id that own the playground
     */
    public void setPlaygroundOwnerID(int playgroundOwnerID) {
        this.playgroundOwnerID = playgroundOwnerID;
    }

    /**
     * get list of available hour
     *
     * @return list of available hour
     */
    public ArrayList<Integer> getAvaHour() {
        return avaHour;
    }

    /**
     * get the playground Name
     *
     * @return current playground Name
     */
    public String getPlaygroundName() {
        return playgroundName;
    }

    /**
     * get playground ID
     *
     * @return current playground ID
     */
    public int getPlaygroundID() {
        return playgroundID;
    }

    /**
     * get playground location
     *
     * @return current playground location
     */
    public String getLocation() {
        return location;
    }

    /**
     * get playground price
     *
     * @return current playground price per hour
     */
    public double getPrice() {
        return price;
    }

    /**
     * display all available hour
     */
    public void displayAvaHour(){
        int count=1;
        for(int ava:avaHour){
            System.out.println(count+"- From "+ava+" Pm ");
            count++;
        }
    }

    /**
     * get all info about playground
     *
     * @return all playground info
     */
    @Override
    public String toString() {
        return
                "Playground Name = " + playgroundName + '\n'+
                        "  Location = " + location + '\n'+
                        "  Price = " + price +" LE"+ '\n';
    }
}

