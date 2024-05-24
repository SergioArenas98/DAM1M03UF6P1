package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Shop;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;

import model.Product;

public class InventoryView extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable inventoryTable;
    private DefaultTableModel tableModel;

    public InventoryView(Shop shop) {
    	setSize(470, 350);
        setLayout(null);

        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Producto", "Precio", "Stock", "Disponibilidad"}
        );

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 49, 430, 240);
        add(scrollPane);

        inventoryTable = new JTable(tableModel);
        inventoryTable.getColumnModel().getColumn(0).setPreferredWidth(133);
        inventoryTable.getColumnModel().getColumn(1).setPreferredWidth(116);
        inventoryTable.getColumnModel().getColumn(2).setPreferredWidth(106);
        inventoryTable.getColumnModel().getColumn(3).setPreferredWidth(104);
        scrollPane.setViewportView(inventoryTable);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 430, 27);
        add(panel);

        JLabel lblNewLabel = new JLabel("INVENTARIO DE LA TIENDA");
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel.add(lblNewLabel);

        // Add inventory products to the table
        for (Product product : shop.getInventory()) {
            if (product != null) {
                Object[] rowData = {
                        product.getName(),
                        product.getPublicPrice(),
                        product.getStock(),
                        product.isAvailable()
                };
                // Add row to the table
                tableModel.addRow(rowData);
            }
        }
    }
}