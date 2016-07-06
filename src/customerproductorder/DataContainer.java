/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerproductorder;
import java.util.*;
import customerproductorder.Classes.*;
/**
 *
 * @author AS
 */
public class DataContainer {
    public ArrayList<Customer> customers;
    public ArrayList<Product> products;
    public ArrayList<Order> orders;
    public DataContainer(){
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        products = new ArrayList<Product>();
    }
    public List<Order> searchBySecondName(String keyword){
        List<Order> temp = new ArrayList<Order>();
        for(Order order:orders){
            if(order.getCustomer().getSecondName().contains(keyword)){
                temp.add(order);
            }
        }
        return temp;
    }
}
