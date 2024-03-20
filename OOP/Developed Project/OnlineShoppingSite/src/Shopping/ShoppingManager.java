package Shopping;

import java.io.IOException;

public interface ShoppingManager {

    public void addProduct();
    public void deleteProduct();

    public void printProduct();

    public void save() throws IOException;
}
