/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerproductorder.Classes;

/**
 *
 * @author AS
 */
public class Customer implements Comparable {
    private String firstName;
    private String secondName;
    private String address;
    private String cardNumber;
    //private final int customerID; //have to be readonly
    public Customer(String firstName, String secondName, String address, 
            String cardNumber){
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.cardNumber = cardNumber;
    }
    @Override
    public String toString(){
        return "It's "+this.firstName + " " + this.secondName + 
                " with cardNumber "+ this.cardNumber + " living by address " 
                + this.address;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getSecondName(){
        return this.secondName;
    }
    public String getAddress(){
        return this.address;
    }
    public String getcardNumber(){
        return this.cardNumber;
    }
    @Override
    public int compareTo(Object t) {
        return this.getSecondName().compareTo(((Customer)t).getSecondName());
    }
}
