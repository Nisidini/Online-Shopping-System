package Shopping;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> productList;

    public ShoppingCart(){
        this.productList = new ArrayList<>();
    }
    public void addToCart(Product product){
        productList.add(product);
    }


    public void removeFromCart(Product product) {
        productList.remove(product);
    }


}
