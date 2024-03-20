package Shopping;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String productType;
    private String productID;
    private String productName;
    private int numberOfItems;
    private double price;
    private static int count;


    public Product(String productType, String productID, String productName, int numberOfItems, double price){
        this.productType=productType;
        this.productID=productID;
        this.productName=productName;
        this.numberOfItems=numberOfItems;
        this.price=price;
        count++;
        if (count==50){
            System.out.println("Have reached 50 products");
        }

    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void print(){

    }




    @Override
    public String toString() {
        return "Shopping.Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", numberOfItems=" + numberOfItems +
                ", price=" + price +
                '}';
    }

}
