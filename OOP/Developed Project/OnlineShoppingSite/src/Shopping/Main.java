//package Shopping;
//
//import java.util.Scanner;
//
//public class Main {
//    static ShoppingManager manager = new WestminsterShoppingManager();
//    final static Scanner user_input = new Scanner(System.in);
//           public static void main(String[] args) {
//
//            while (true){
//                displayMenu();
//                //TODO: have to validate choice
//                int choice = user_input.nextInt();
//                switch (choice){
//                    case 1:
//                        addProduct();
//                        break;
//                    case 2:
//                        deleteProduct();
//                        break;
//                    case 3:
//                        manager.printProduct();
//                        break;
//                    case 4:
//                        manager.save();
//                        break;
//                    default:
//                        System.out.println("You have selected an invalid option");
//                }
//
//
//            }
//    }
//    public static void displayMenu(){
//        System.out.println("Enter 1 to Add a new product");
//        System.out.println("Enter 2 to Delete a product");
//        System.out.println("Enter 3 to print the list of products");
//        System.out.println("Enter 4 to save in a file");
//        System.out.println("Enter 5 to Open the GUI");
//        System.out.println();
//    }
//    private static void addProduct(){
//               Product product = null;
//
//        System.out.println("Enter the type of product(electronics/clothing): ");
//        String choice = user_input.next();
//
//        System.out.println("Enter the product ID:");
//        String productID = user_input.next();
//
//        System.out.println("Enter the product name:");
//        String productName = user_input.next();
//
//        System.out.println("Enter the number of availabe items:");
//        int availableItems = user_input.nextInt();
//
//        System.out.println("Enter the price:");
//        double price = user_input.nextDouble();
//
//
//               switch (choice.toLowerCase()){
//                   case "electronics":
//                       System.out.println("Enter the brand of the product:");
//                       String brand = user_input.next();
//
//                       System.out.println("Enter the warranty period:");
//                       int warrantyPeriod = user_input.nextInt();
//
//                       product = new Electronics(productID, productName, availableItems, price, brand, warrantyPeriod);
//                       break;
//
//                   case "clothing":
//                       System.out.println("Enter the size:");
//                       int size = user_input.nextInt();
//
//                       System.out.println("Enter the color:");
//                       String color = user_input.next(); //TODO: Use a color picker
//                       product = new Clothing(productID, productName, availableItems,price,size,color);
//                       break;
//
//                   default:
//                       System.out.println("Invalid product type");
//
//               }
//               if (product!=null)
//               manager.addProduct(product);
//
//    }
//    private static void deleteProduct(){
//        System.out.println("Enter the product ID:");
//        String productID = user_input.next();
//        //TODO : to validate a string we can use RegEx
//        manager.deleteProduct(productID);
//    }
//
//
//
//
//}