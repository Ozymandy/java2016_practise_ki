/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerproductorder.Classes;
import java.util.*;
/**
 *
 * @author AS
 */
public class Order {
    private Customer customer;
    private ArrayList<Product> products;
    public Order(Customer customer, ArrayList<Product> products){
        //this.product = product;
        this.products = products;
        this.customer = customer;
    }
    @Override
    public String toString(){
        return "Customer " + customer.getFirstName() + " "+ customer.
                getSecondName() + " ordered " + products.size() + " items";
    }
}
