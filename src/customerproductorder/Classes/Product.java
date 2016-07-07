
package customerproductorder.Classes;

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
