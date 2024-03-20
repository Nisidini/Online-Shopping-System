package GUI;

import Shopping.Product;
import Shopping.WestminsterShoppingManager;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import Shopping.Electronics;
import Shopping.Clothing;


import static Shopping.WestminsterShoppingManager.productList;

public class Gui {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> categoryComboBox;
    
    public JPanel select = new JPanel();

    public Gui (WestminsterShoppingManager shoppingManager){
        userInterface(shoppingManager);
    }


    private void userInterface(WestminsterShoppingManager shoppingManager){
        JFrame myframe = new JFrame("Shopping site");
        myframe.setVisible(true);

        myframe.setResizable(false);

        myframe.pack();

        Border border = BorderFactory.createEmptyBorder();



        //Panels

        //Main panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);

        JPanel header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        JPanel body = new JPanel();
        body.setBackground(Color.WHITE);


        JPanel productTable = new JPanel();
        productTable.setBackground(Color.WHITE);


        select.setBackground(Color.WHITE);
        select.setBorder(BorderFactory.createMatteBorder(1,1,0,1,Color.BLACK));

        JPanel footer = new JPanel();
        footer.setBackground(Color.WHITE);
        footer.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.BLACK));


        //Labels

        JLabel label1 = new JLabel();
        label1.setText("Westminster Shopping Centre");
        header.add(label1);

        JLabel label2 = new JLabel();
        label2.setText("Select Product Category");

        JPanel category = new JPanel();
        body.add(label2);

        JLabel label3 = new JLabel();
        label3.setText("Selected Product:Details");
        select.add(label3);



        //Combox
        String [] product = {"All","Electronics", "Clothing"};
        categoryComboBox = new JComboBox<>(product);
        body.add(categoryComboBox);

        categoryComboBox.addActionListener(e -> {
            String selectedCategory = (String) categoryComboBox.getSelectedItem();
            filter(productList, selectedCategory);
        });


        //button

        JButton button1 = new JButton();
        button1.setText("Shopping Cart");
        body.add(button1);

        JButton button2 = new JButton();
        button2.setText("Add to Shopping Cart");
        footer.add(button2);


        //Table
        String columnNames[] = {"Product1D", "Name", "Category", "Price($)", "Info"};


        JTable table = new JTable();

        model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);
        updateTable(productList);
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRowIndex = table.getSelectedRow();
            if (selectedRowIndex != -1) {


            }
        });
        table.getSelectionModel().addListSelectionListener(e ->  {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        displayDetails(selectedRow);
                    }

                }

        });

        table.setModel(model);



        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(450, 100));


        productTable.add(scrollPane);
        table.setGridColor(Color.BLACK);

        panel1.setLayout(new GridLayout(5,3));

        JButton sortButton = new JButton();
        productTable.add(sortButton);


//        //Adding to the panel

        panel1.add(header);
        panel1.add(body);
        panel1.add(productTable);
        panel1.add(select);
        panel1.add(footer);
        panel1.setBorder(border);


        //adding to the frame
        myframe.add(panel1);
        myframe.setSize(650,650);

    }

    public void updateTable(ArrayList<Product> productList){
        model.setRowCount(0);


        for (Product product : productList) {
            Object[] rowData = new Object[0];

            if (product instanceof Clothing) {
                Clothing clothing = (Clothing) product;
                
                rowData = new Object[]{
                        product.getProductID(),
                        product.getProductName(),
                        product.getProductType(),
                        product.getPrice(),
                        clothing.getSize() + "," +clothing.getColour()
                };
            } else if (product instanceof  Electronics){
                Electronics electronics = (Electronics) product;
                rowData = new Object[]{
                        product.getProductID(),
                        product.getProductName(),
                        product.getProductType(),
                        product.getPrice(),
                        electronics.getBrand()+ "," + electronics.getWarrantlyPeriod(),
                        
                        

                };
            }

            if (product.getNumberOfItems() < 3) {
                model.addRow(rowData);
            } else {
                model.addRow(rowData);
            }
        }
    }


    private void filter(ArrayList<Product> productList, String selectedCategory) {
        model.setRowCount(0);

        for (Product product : productList) {
            if (selectedCategory.equals("All") || product.getProductType().equalsIgnoreCase(selectedCategory)) {
                Object[] rowData = {product.getProductID(), product.getProductName(), product.getProductType(),
                        product.getPrice()};
                model.addRow(rowData);
            }
        }
    }

    private void displayDetails(int selectedRow) {
        // Clear previous details

        select.removeAll();
        Product product = productList.get(selectedRow);

        System.out.println(product);

        JLabel description = new JLabel("Selected product - details");
        JLabel ID = new JLabel("Product ID - " + product.getProductID() );
        JLabel category = new JLabel("Category- "+ product.getProductType() );
        JLabel name = new JLabel("Name- " + product.getProductName() );


        JLabel items = new JLabel("Items Available- " + product.getNumberOfItems() );

        select.add(description);
        select.add(ID);
        select.add(category);
        select.add(name);
        select.add(items);
        select.setLayout(new BoxLayout(select, BoxLayout.Y_AXIS));




        // Update the panel
        select.revalidate();
        select.repaint();
    }



}
