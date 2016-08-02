package customerproductorder.models;

/**
 * This class is model of Product.
 */
public class Product implements NameGetable {

    /**
     * Field which contains product's name.
     */
    private String productName;
    /**
     * Field which contains product's cost.
     */
    private int productCost;
    /**
     * Field which contains product's id.
     */
    private int productID;

    /**
     * Ctor of this class.
     *
     * @param productName product Name
     * @param productCost product Cost
     * @param productID product Id
     */
    public Product(String productName, int productCost, int productID) {
        this.productName = productName;
        this.productCost = productCost;
        this.productID = productID;
    }

    /**
     * Overrided mthod toString() which contains our implementation.
     *
     * @return string view of this class
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Access method of field productCost.
     *
     * @return product cost
     */
    public int getProductCost() {
        return this.productCost;
    }

    /**
     * Access method of field productName.
     *
     * @return product Name
     */
    @Override
    public String getName() {
        return productName;
    }

    public int getProductId() {
        return productID;
    }
}
