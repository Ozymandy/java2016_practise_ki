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
public class Product implements Comparable{
    private String productName;
    private int productCost;
    private int productID;
    public Product(String productName, int productCost, int productID){
        this.productName = productName;
        this.productCost = productCost;
        this.productID = productID;
    }
    @Override
    public String toString(){
        return super.toString();
    }
    public String getProductName(){
        return this.productName;
    }
    public int getProductCost(){
        return this.productCost;
    }
    @Override
    public int compareTo(Object t) {
       if(this.getProductCost()>((Product)t).getProductCost()){
           return 1;
       }
       if(this.getProductCost()<((Product)t).getProductCost()){
           return -1;
       }
       else{
           return 0;
       }
    }
}
