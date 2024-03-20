package Shopping;

import java.util.Collections;



public class Clothing extends Product{
    private int size;
    private String colour;


    public Clothing(String productType, String productID, String productName, int numberOfItems, double price, int size, String colour){
        super(productType,productID,productName,numberOfItems,price);
        this.size=size;
        this.colour=colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


    public void print() {

        System.out.println("Clothing -" + "  " + "ProductID-" + " " + getProductID() + "  " + "Product Name - "  +" " + getProductName() + "  " + "number of items - "+ " " +getNumberOfItems()+ " " +
                " " + "Price -" + " "+ getPrice() + " " + " "+ "Size - " + " " + getSize() + "  " + "Color - " + "  " + getColour());
    }

    @Override
    public String toString() {
        return "Shopping.Clothing{" +
                "size=" + size +
                ", colour='" + colour + '\'' +
                '}';
    }
}
