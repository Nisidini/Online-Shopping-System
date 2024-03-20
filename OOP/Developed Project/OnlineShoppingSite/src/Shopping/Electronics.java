package Shopping;

import java.util.Collections;



public class Electronics extends Product {
    private String brand;
    private int warrantlyPeriod;


    public Electronics(String productType, String productID, String productName, int numberOfItems, double price, String brand, int warrantlyPeriod){
        super(productType,productID,productName,numberOfItems,price);
        this.brand=brand;
        this.warrantlyPeriod=warrantlyPeriod;


    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantlyPeriod() {
        return warrantlyPeriod;
    }

    public void setWarrantlyPeriod(int warrantlyPeriod) {
        this.warrantlyPeriod = warrantlyPeriod;
    }

    @Override
    public String toString() {
        return "Shopping.Electronics{" +
                "brand='" + brand + '\'' +
                ", warrantlyPeriod=" + warrantlyPeriod +
                '}';
    }

    public void print() {

        System.out.println("Electronics -" + "  " + "ProductID-" + "  " + getProductID() + "  " + "Product Name - " +  "  " + getProductName() + "  " + "number of items - "+ " " +getNumberOfItems()+  "  "+
                "Price" + "  "+ getPrice() +"  " + "Brand - "+" "   + getBrand() +" "+ "Warrantly Period - " +" "  + " " +getWarrantlyPeriod());
    }


}
