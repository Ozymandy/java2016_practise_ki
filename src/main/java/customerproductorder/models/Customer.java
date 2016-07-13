package customerproductorder.models;

/**
 * It's Customer's model
 */
public class Customer implements NameGetable {

    /**
     * Field which contains first name.
     */
    private String firstName;
    /**
     * Field which contains last name.
     */
    private String lastName;
    /**
     * Field which contains adress.
     */
    private String address;
    /**
     * Field which card Number.
     */
    private int cardNumber;

    /**
     * Ctor
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param cardNumber
     */
    public Customer(String firstName, String lastName, String address,
            int cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cardNumber = cardNumber;
    }

    /**
     * Our implementation of toString().
     *
     * @return view of class
     */
    @Override
    public String toString() {
        return "It's " + this.firstName + " " + this.lastName
                + " with cardNumber " + this.cardNumber + " living by address "
                + this.address;
    }

    /**
     * Field which contains first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Access method for field address.
     *
     * @return adress
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Access method for cardNumber field.
     *
     * @return card Number
     */
    public int getCardNumber() {
        return this.cardNumber;
    }

    /**
     * Access method and implementation of NameGetable interface.
     *
     * @return lastName
     */
    @Override
    public String getName() {
        return lastName;
    }
    
}
