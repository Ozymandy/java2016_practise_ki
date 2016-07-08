
package customerproductorder.models;

public class Product implements NameGetable{
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
    public int getProductCost(){
        return this.productCost;
    }
    @Override
    public String getName() {
        return productName;
    }
}
