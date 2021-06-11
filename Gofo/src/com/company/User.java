package com.company;
import java.util.ArrayList;

/**
 * this class is used to hold all the user data and his functions
 *
 * @version 2.1
 * @author Hanan , Mohamed, Fatima
 */

public class User {

    protected String name ;
    protected String email  ;
    protected String password ;
    protected String location  ;
    protected String type ;
    protected String gander ;
    protected int userID ;
    protected EWallet myMoney = new EWallet();
    protected ArrayList<Playground> myPlaygrounds = new ArrayList<>();
    protected ArrayList<Bookings> myBookings = new ArrayList<>();

    /**
     * default constructor
     */
    public User() {}

    /**
     * it returns the user's playground
     *
     * @return  the user playground
     */
    public ArrayList<Playground> getMyPlaygrounds() {
        return myPlaygrounds;
    }

    /**
     * it returns the user's bookings
     *
     * @return  the user bookings
     */
    public ArrayList<Bookings> getMyBookings() {
        return myBookings;
    }

    /**
     * set userID
     *
     * @param userID the user id
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * set the user name
     *
     * @param name user's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set password
     *
     * @param password the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get the user's location
     *
     * @return user location
     */
    public String getLocation() {
        return location;
    }

    /**
     * set the user's location
     *
     * @param location the user's location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * set the type of the user
     *
     * @param type user's type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * set gander
     *
     * @param gander the user's gander
     */
    public void setGander(String gander) {
        this.gander = gander;
    }

    /**
     * it displays all user info
     *
     * @return all user info as string
     */
    @Override
    public String toString() {
        return
                "Name='" + name + '\n' +
                ", Email='" + email + '\n' +
                ", Location='" + location + '\n' +
                ", Type='" + type + '\n' +
                ", Gander='" + gander + '\n';
    }
}
