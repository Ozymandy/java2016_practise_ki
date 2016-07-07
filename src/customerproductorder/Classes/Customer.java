
package customerproductorder.Classes;


public class Customer implements Comparable {
    private String firstName;
    private String lastName;
    private String address;
    private String cardNumber;

    public Customer(String firstName, String lastName, String address, 
            String cardNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cardNumber = cardNumber;
    }
    @Override
    public String toString(){
        return "It's "+this.firstName + " " + this.lastName + 
                " with cardNumber "+ this.cardNumber + " living by address " 
                + this.address;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAddress(){
        return this.address;
    }
    public String getcardNumber(){
        return this.cardNumber;
    }
    @Override
    public int compareTo(Object t) {
        return this.getLastName().compareTo(((Customer)t).getLastName());
    }
}
