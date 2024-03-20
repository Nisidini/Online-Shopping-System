package Shopping;

import GUI.Gui;

import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {
    public static int Max_products = 50;
    public static ArrayList<Product> productList = new ArrayList<>();
    private int systemCart;



    final static Scanner user_input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WestminsterShoppingManager manager = new WestminsterShoppingManager();
        manager.displayMenu();
    }

    public void displayMenu() throws IOException, ClassNotFoundException {
        load_file();
        while (true) {
            System.out.println("Enter 1 to Add a new product");
            System.out.println("Enter 2 to Delete a product");
            System.out.println("Enter 3 to print the list of products");
            System.out.println("Enter 4 to save in a file");
            System.out.println("Enter 5 to Open the GUI");
            System.out.println("Enter 6 to Exist the system");
            System.out.println();
            int choice;
            while (true) {
                try {
                    System.out.println("Please enter the option");
                    choice = user_input.nextInt();
                    System.out.println();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input");
                    user_input.next();

                }

            }
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    printProduct();
                    break;
                case 4:
                    save();
                    break;

                case 5:
                    Gui gui = new Gui(this);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have selected an invalid option. Please re-enter");
            }


        }
    }

    @Override
    public void addProduct() {
        Product product = null;

        System.out.println("Enter the type of product(electronics/clothing): ");
        String productType = user_input.next();

        System.out.println("Enter the product ID:");
        String productID = user_input.next();

        System.out.println("Enter the product name:");
        String productName = user_input.next();

        int availableItems;
        while (true) {
            try {
                System.out.println("Enter the number of availabe items:");
                availableItems = user_input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid! Please re-enter");
                user_input.next();
            }
        }


        double price;
        while (true) {
            try {
                System.out.println("Enter the price:");
                price = user_input.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Price! Please re-enter");
                user_input.next();
            }
        }


        switch (productType.toLowerCase()) {
            case "electronics":
                System.out.println("Enter the brand of the product:");
                String brand = user_input.next();

                System.out.println("Enter the warranty period(enter the no.of years):");
                int warrantyPeriod = user_input.nextInt();

                product = new Electronics(productType, productID, productName, availableItems, price, brand, warrantyPeriod);
                break;

            case "clothing":
                int size;
                while (true) {
                    try {
                        System.out.println("Enter the size:");
                        size = user_input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid! Please re-enter");
                        user_input.next();
                    }
                }

                System.out.println("Enter the color:");
                String color = user_input.next();
                product = new Clothing(productType, productID, productName, availableItems, price, size, color);
                break;

            default:
                System.out.println("Invalid product type");

        }
        if (product != null)

            //what if the product is already in the cart.
            if (productList.contains(product)) {
                System.out.println("The product is already in the cart");
            } else if (systemCart >= Max_products) {
                System.out.println("The cart is full");

            } else {
                //add the product
                productList.add(product);
                systemCart += 1;
                Max_products -= 1;
                System.out.println("Remaining products to add" + " " + Max_products);
            }

    }

    @Override
    public void deleteProduct() {

        System.out.println("Enter the product ID:");
        String productID = user_input.next();


        if (productList.isEmpty()) {
            System.out.println("No products added yet");
        } else {
            boolean found = false;
            for (Product product : productList) {
                if (product.getProductID().equals(productID)) {

                    if (product.getProductType().equalsIgnoreCase("electronics")) {
                        System.out.println("Electronics is removed");
                    } else {
                        System.out.println("Clothing is removed");
                    }
                    productList.remove(product);
                    systemCart -= 1;
                    Max_products += 1;
                    System.out.println("Total number of products remaining in the system" + " " + systemCart);
                    found = true;
                    break;
//
                }

            }
            if (!found)
                System.out.println("Invalid product ID");
        }

    }

    @Override
    public void printProduct() {
        if (productList.isEmpty()) {
            System.out.println("No products in the system yet");
        } else {
            for (int i = 0; i < productList.size() - 1; i++) {
                for (int j = 0; j < productList.size() - 1 - i; j++) {
                    if (productList.get(j).getProductID().compareTo(productList.get(j + 1).getProductID()) > 0) {
                        // Swap if the product ID is greater than the next one
                        Collections.swap(productList, j, j + 1);
                    }
                }
            }
            System.out.println("List of products in the system:");
            for (Product product : productList) {
                product.print();
                System.out.println();

            }
        }

    }

    @Override
    public void save() throws IOException {
        File file = new File("products.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Product product : productList) {
            oos.writeObject(product);
        }

        fos.flush();
        fos.close();
        oos.close();
    }

    public void load_file() throws IOException, ClassNotFoundException {
        File file = new File("products.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        while (true) {
            try {
                Product product = (Product) ois.readObject();
                productList.add(product);
            } catch (EOFException e) {
                break;
            }
        }
    }
}
