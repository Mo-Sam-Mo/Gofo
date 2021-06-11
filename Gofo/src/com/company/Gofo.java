package com.company;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class is used to control Gofo system
 *
 * @version 2.1
 * @author Hanan , Mohamed, Fatima
 */

public class Gofo {

    protected  ArrayList<Playground> Playgrounds = new ArrayList<>() ;
    protected  ArrayList<User> users = new ArrayList<>() ;
    static int playgroundID = 1;
    static int playerID = 1;
    Scanner input = new Scanner(System.in) ;

    /**
     * default constructor
     * it is the start of the program
     */
    public Gofo() {
        System.out.println("Welcome to GoFo");
        while(true) {
            System.out.println("1- Sign Up");
            System.out.println("2- Exit");
            int c = input.nextInt();
            if (c == 1)
                signUp();
            else if(c == 2){
                System.out.println("shut down");
                input.close();
                System.exit(0);
            }
            else{
                System.out.println("invalid Task please choose one of those Tasks\n");
            }
        }
    }

    /**
     * it adds a playground to the Gofo system
     * @param id the owner id
     */
    protected void addPlayground(int id) {
        users.get(id-1).setType("Playground Owner");
        Playground newPlayground = new Playground() ;
        System.out.println("Enter Location:");
        input.nextLine() ;
        String tmp = input.nextLine();
        newPlayground.setLocation(tmp);

        String name;
        do {
            System.out.println("Enter the Playground name:");
            name = input.nextLine();
        } while(validPlayground(name));

        newPlayground.setPlaygroundName(name);
        System.out.println("Enter price:");
        newPlayground.setPrice(input.nextDouble());
        newPlayground.setPlaygroundID(playgroundID);
        playgroundID++;
        newPlayground.setPlaygroundOwnerID(id);
        Playgrounds.add(newPlayground);
        users.get(id-1).getMyPlaygrounds().add(newPlayground);
        System.out.println("Added!");
    }

    /**
     * check if the name is valid and not used
     *
     * @return true if he found the name in the system data
     * @param name it's the name that is going to be checked
     */
    boolean validPlayground(String name){
        if(users.size()!=0) {
            for (int i = 0; i < Playgrounds.size(); i++) {
                if (name.equals(Playgrounds.get(i).getPlaygroundName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * it adds a user to the system
     *
     * @param user the user that it going to add it
     */
    public void addUser(User user){
        user.setUserID(playerID);
        playerID++ ;
        users.add(user);
    }

    /**
     * it checks if the mail is used
     *
     * @param email the email that the fun is going to look for it
     * @return true if it found the email
     */
    boolean validMail(String email){
        if(users.size()!=0) {
            for (int i = 0; i < Playgrounds.size(); i++) {
                if (email.equals(Playgrounds.get(i).getPlaygroundName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * it register a user and add it to the system than it opens the menu for him
     *
     */
    public void signUp(){
        String tmp ;
        User newUser = new User();
        newUser.setType("Player");
        input.nextLine();

        System.out.println("Enter your name:");
        tmp = input.nextLine() ;
        newUser.setName(tmp);

        do {
            System.out.println("Enter your E-mail:");
            tmp = input.nextLine();
        } while(validMail(tmp));

        System.out.println("Enter your Password:");
        tmp = input.nextLine() ;
        newUser.setPassword(tmp);

        System.out.println("Enter your Location:");
        tmp = input.nextLine() ;
        newUser.setLocation(tmp);

        System.out.println("Choose your Gander:");
        System.out.println("1- Male");
        System.out.println("2- Female");
        int c = input.nextInt() ;
        if (c==1) {
            newUser.setGander("Male");
        }else if (c==2)
            newUser.setGander("Female");

        System.out.println("enter the amount of money you have:");
        double money = input.nextDouble();
        newUser.myMoney.balance = money;

        addUser(newUser);

        System.out.println("Email Created");
        playerMenu();
    }

    /**
     * the player menu that have the tasks that he can do
     *
     */
    public void playerMenu(){
        System.out.println("Welcome Player");
        while(true) {
            System.out.println("1-add playground (become an owner)");
            System.out.println("2-book a playground");
            System.out.println("3-exit");
            int Task = input.nextInt();
            if (Task == 1)
                addPlayground(playerID - 1);
            else if(Task ==2)
            {
                Book(playerID - 1);
            }
            else if(Task == 3){
                System.out.println("goodbye !");
                input.close();
                System.exit(0);
            }
            else{
                System.out.println("invalid Task please choose one of those Tasks\n");
            }
        }
    }

    /**
     * this fun is used to book a playground
     *
     * @param id the booker id
     */
    public void Book(int id){
        int count=1;
        ArrayList<Integer> firstList =new ArrayList<>();

        if(Playgrounds.size()!=0){
            System.out.println("Please choose a playgrounds: (enter it's number");
            for(int i = 0 ; i < Playgrounds.size() ; i++){
                if (users.get(id-1).getLocation().equalsIgnoreCase(Playgrounds.get(i).getLocation())){
                    System.out.println(count+"-"+Playgrounds.get(i));
                    firstList.add(i);
                    count++;
                }
            }
         for(int i = 0 ; i < Playgrounds.size() ; i++){
                if (!(users.get(id-1).getLocation().equalsIgnoreCase(Playgrounds.get(i).getLocation()))){

                    System.out.println(count+"-"+Playgrounds.get(i));
                    firstList.add(i);
                    count++;
                }
            }

            int in = input.nextInt();
            if(users.get(id-1).myMoney.withdraw(Playgrounds.get(firstList.get(count-2)).getPrice())){
                for(User obj:users){
                    for(Playground obj2: obj.getMyPlaygrounds()){
                        if(obj2.getPlaygroundID()==Playgrounds.get(firstList.get(count-2)).getPlaygroundID()){
                            obj.myMoney.deposit(Playgrounds.get(firstList.get(count-2)).getPrice());
                        }
                    }
                }
                if(in < count){
                    System.out.println("Please choose the right time for you:");
                    Playgrounds.get(firstList.get(count-2)).displayAvaHour();
                    in= input.nextInt();

                    Bookings book = new Bookings();
                    book.setName(Playgrounds.get(firstList.get(count-2)).getPlaygroundName());
                    book.setLocation(Playgrounds.get(firstList.get(count-2)).getLocation());
                    book.setPrice(Playgrounds.get(firstList.get(count-2)).getPrice());
                    book.setTime(Playgrounds.get(firstList.get((count-2))).getAvaHour().get(in-1));
                    book.setCancellationPeriod(24);
                    users.get(id-1).getMyBookings().add(book);
                    System.out.println("booked");
                    Playgrounds.get(firstList.get((count-2))).getAvaHour().remove(in-1);
                }
            }
        }else {
            System.out.println("There are no playgrounds to reserve");
        }

    }
}

