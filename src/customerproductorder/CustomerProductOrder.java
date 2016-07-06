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
public class CustomerProductOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataContainer container = new DataContainer();
        container.customers.add(new Customer("Constantine", "Ihnatsenka", "Krinichnaya st. 8-10","0001"));
        container.customers.add(new Customer("Eugene", "Sergeev", "Pushkina st. 1-10","0002"));
        container.customers.add(new Customer("Leonid", "Slutsky", "Lenina st.","0003"));
        container.customers.add(new Customer("Marco", "Reus", "Pervomayskaya st.","0004"));
        container.products.add(new Product("Ball",15,1));
        container.products.add(new Product("Coke",12,3));
        container.products.add(new Product("Hamburger",100,5));
        container.orders.add(new Order(container.customers.get(2),container.products));
        for(Customer customer:container.customers){
            System.out.println(customer);
        }
        for(Order order:container.searchBySecondName("Slutsky")){
            System.out.println(order);
        }
    }
    
}
