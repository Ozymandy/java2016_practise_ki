
package customerproductorder.models;


public class Customer implements NameGetable {
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
    public String getAddress(){
        return this.address;
    }
    public String getcardNumber(){
        return this.cardNumber;
    }

    @Override
    public String getName() {
        return lastName;
    }

}
