package cashierproject;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

class Item {
    public int id;
    public String name;
    public String category;
    public int price;
    public int stock;
    public String image_url;
    
    public Item (int id, String name, String category, int price, int stock, String image_url) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.image_url = image_url;
    }
}

public class MainFrame extends javax.swing.JFrame {
    
    static ArrayList<String> categoryList = new ArrayList<>();
    static ArrayList<Item> itemList = new ArrayList<>();
    static ArrayList<Item> shoppingList = new ArrayList<>();
    int totalPurchases = 0;

    public MainFrame() {
        initComponents();
        getDataFromDatabase();
        displayCategory();
        displayItem("Semua Kategori");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        topPanel = new javax.swing.JPanel();
        transactionHistoryButton = new javax.swing.JButton();
        applicationNameLabel = new javax.swing.JLabel();
        addItemButton = new javax.swing.JButton();
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        shoppingListPanel = new javax.swing.JPanel();
        cancelShoppingButton = new javax.swing.JButton();
        confirmShoppingButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        membershipField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        middlePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Kasir");

        topPanel.setBackground(new java.awt.Color(204, 204, 255));
        topPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        topPanel.setPreferredSize(new java.awt.Dimension(1280, 80));

        transactionHistoryButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        transactionHistoryButton.setText("Riwayat Transaksi");
        transactionHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionHistoryButtonActionPerformed(evt);
            }
        });

        applicationNameLabel.setFont(new java.awt.Font("Book Antiqua", 1, 20)); // NOI18N
        applicationNameLabel.setText("APLIKASI KASIR");

        addItemButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addItemButton.setText("Daftarkan Barang");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                .addComponent(applicationNameLabel)
                .addGap(353, 353, 353)
                .addComponent(transactionHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applicationNameLabel)
                    .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        leftPanel.setBackground(new java.awt.Color(204, 204, 255));
        leftPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        leftPanel.setPreferredSize(new java.awt.Dimension(200, 634));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rightPanel.setBackground(new java.awt.Color(204, 204, 255));
        rightPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rightPanel.setPreferredSize(new java.awt.Dimension(300, 634));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Belanja");
        jLabel1.setToolTipText("");

        shoppingListPanel.setBackground(new java.awt.Color(255, 255, 255));
        shoppingListPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        shoppingListPanel.setPreferredSize(new java.awt.Dimension(247, 250));

        javax.swing.GroupLayout shoppingListPanelLayout = new javax.swing.GroupLayout(shoppingListPanel);
        shoppingListPanel.setLayout(shoppingListPanelLayout);
        shoppingListPanelLayout.setHorizontalGroup(
            shoppingListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        shoppingListPanelLayout.setVerticalGroup(
            shoppingListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );

        cancelShoppingButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelShoppingButton.setText("Batal");
        cancelShoppingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelShoppingButtonActionPerformed(evt);
            }
        });

        confirmShoppingButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        confirmShoppingButton.setText("Bayar");
        confirmShoppingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmShoppingButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Metode Pembayaran");

        radioGroup.add(jRadioButton1);
        jRadioButton1.setText("Tunai");

        radioGroup.add(jRadioButton2);
        jRadioButton2.setText("Non-Tunai");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nomor Keanggotaan");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addComponent(cancelShoppingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmShoppingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(shoppingListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addComponent(membershipField, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(shoppingListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(membershipField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelShoppingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmShoppingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(768, 634));

        middlePanel.setBackground(new java.awt.Color(204, 204, 255));
        middlePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        middlePanel.setPreferredSize(new java.awt.Dimension(768, 634));

        javax.swing.GroupLayout middlePanelLayout = new javax.swing.GroupLayout(middlePanel);
        middlePanel.setLayout(middlePanelLayout);
        middlePanelLayout.setHorizontalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
        );
        middlePanelLayout.setVerticalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(middlePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transactionHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionHistoryButtonActionPerformed
        JFrame frame = new HistoryTransactionFrame();
        frame.setLocationRelativeTo(null);
        frame.setTitle("Riwayat Penjualan");
        frame.setVisible(true);
    }//GEN-LAST:event_transactionHistoryButtonActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        JFrame frame = new AddItemFrame();
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pendaftaran Barang");
        frame.setVisible(true);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                totalPurchases = 0;
                categoryList.clear();
                itemList.clear();
                shoppingList.clear();
                getDataFromDatabase();
                leftPanel.removeAll();
                displayCategory();
                middlePanel.removeAll();
                displayItem("Semua Kategori");
            }
        });
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void confirmShoppingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmShoppingButtonActionPerformed
        if (totalPurchases > 0) {
            String membershipSave = membershipField.getText();
            if (membershipSave.isEmpty()) {
                membershipSave = "-";
            }

            String itemSave = "";
            for (Item item : shoppingList) {
                itemSave += item.name + " (" + Integer.toString(item.stock) + "x" + Integer.toString(item.price) + "), ";
            }
            itemSave = itemSave.substring(0, itemSave.length()-2);

            saveDataToDatabase(membershipSave, itemSave, totalPurchases);
        }
    }//GEN-LAST:event_confirmShoppingButtonActionPerformed

    private void cancelShoppingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelShoppingButtonActionPerformed
        totalPurchases = 0;
        shoppingList.clear();
        shoppingListPanel.removeAll();
        shoppingListPanel.revalidate();
        shoppingListPanel.repaint();
        membershipField.setText("");
        radioGroup.clearSelection();
        middlePanel.removeAll();
        displayItem("Semua Kategori");
    }//GEN-LAST:event_cancelShoppingButtonActionPerformed

    public static void getDataFromDatabase() {       
        String url = "jdbc:mysql://localhost/cashier_project";
        String username = "root"; 
        String password = ""; 
        
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            
            String queryCategory = "SELECT category FROM category_data";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryCategory);

            while (rs.next()) {
                categoryList.add(rs.getString("category"));
            }
            
            String queryItem = "SELECT id, name, category, price, stock, image_url FROM item_data";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryItem);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                String image_url = rs.getString("image_url");
                itemList.add(new Item(id, name, category, price, stock, image_url));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void saveDataToDatabase(String membership, String item, int total) {
        String url = "jdbc:mysql://localhost/cashier_project";
        String username = "root"; 
        String password = ""; 
        
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO transaction_data (datetime, membership, item, total) VALUES (NOW(), ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, membership);
            ps.setString(2, item);
            ps.setInt(3, total);
            
            ps.executeUpdate();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Daftar belanja telah diproses dan disimpan!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            totalPurchases = 0;
            shoppingList.clear();
            shoppingListPanel.removeAll();
            shoppingListPanel.revalidate();
            shoppingListPanel.repaint();
            membershipField.setText("");
            radioGroup.clearSelection();
            middlePanel.removeAll();
            displayItem("Semua Kategori");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Daftar belanja gagal diproses!", "Gagal!", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void displayCategory() {       
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        if (!categoryList.isEmpty()) {
            JLabel label = new JLabel("Daftar Kategori");
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            leftPanel.add(Box.createVerticalStrut(30)); 
            leftPanel.add(label);
            leftPanel.add(Box.createVerticalStrut(30));     
        }

        for (String category : categoryList) {
            JButton button = new JButton(category);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(140, 35));
            button.setFont(new Font("Arial", Font.PLAIN, 13));
            leftPanel.add(button);
            leftPanel.add(Box.createVerticalStrut(15)); 
            
            button.addActionListener((ActionEvent e) -> {
                middlePanel.removeAll();
                displayItem(category);
            });
        }
                
        leftPanel.revalidate();
        leftPanel.repaint();
    }
    
    private void displayItem(String category) {
        middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        int middlePanelWidth = 768;
        int middlePanelHeight = 640;
        middlePanel.setMinimumSize(new Dimension(middlePanelWidth, middlePanelHeight));
        middlePanel.setPreferredSize(new Dimension(middlePanelWidth, middlePanelHeight));
        middlePanel.setMaximumSize(new Dimension(middlePanelWidth, middlePanelHeight));
        
        for (Item item : itemList) {
            if (category.equals(item.category) || category.equals("Semua Kategori")) {
                JPanel panel = new JPanel();
                int panelWidth = 170;
                int panelHeight = 190;
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setPreferredSize(new Dimension(panelWidth, panelHeight));
                panel.setMinimumSize(new Dimension(panelWidth, panelHeight));
                panel.setMaximumSize(new Dimension(panelWidth, panelHeight));
                panel.setBackground(new Color(220, 220, 255));
                Border emptyBorder = new EmptyBorder(10, 10, 10, 10);
                Border bevelBorder = new BevelBorder(BevelBorder.RAISED);
                panel.setBorder(new CompoundBorder(bevelBorder, emptyBorder));

                JLabel itemName = new JLabel(item.name);
                itemName.setFont(new Font("Arial", Font.BOLD, 14));
                itemName.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(itemName);

                panel.add(Box.createVerticalStrut(10)); 
                ImageIcon imageIcon = new ImageIcon(item.image_url);
                Image newImage = imageIcon.getImage().getScaledInstance(100, 75, Image.SCALE_SMOOTH);
                imageIcon.setImage(newImage);
                JLabel itemImage = new JLabel(imageIcon);
                itemImage.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(itemImage);

                panel.add(Box.createVerticalStrut(10)); 
                JLabel itemPrice = new JLabel("  Rp" + Integer.toString(item.price));
                itemName.setFont(new Font("Arial", Font.BOLD, 16));
                JLabel itemStock = new JLabel(Integer.toString(item.stock) + " pcs  ");
                itemName.setFont(new Font("Arial", Font.BOLD, 16));
                JPanel row = new JPanel();
                row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
                row.setBackground(new Color(220, 220, 255));
                row.add(itemPrice);
                row.add(Box.createHorizontalGlue());
                row.add(itemStock);
                panel.add(row);

                panel.add(Box.createVerticalStrut(10)); 
                JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, item.stock, 1));
                JButton button = new JButton("Tambahkan");
                button.setMaximumSize(new Dimension(100, 80));
                button.setFont(new Font("Arial", Font.PLAIN, 12));
                button.addActionListener((ActionEvent e) -> {
                    shoppingListPanel.removeAll();
                    displayPurchases(item.name, item.price, spinner.getValue());
                });
                                
                JPanel row2 = new JPanel();
                row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
                row2.setBackground(new Color(220, 220, 255));
                row2.add(spinner);
                row2.add(Box.createHorizontalGlue());
                row2.add(button);
                panel.add(row2);

                middlePanel.add(panel);
            }
        } 
        
        middlePanel.revalidate();
        middlePanel.repaint();
    }
    
    private void displayPurchases(String itemName, int itemPrice, Object itemAmount) {
        shoppingListPanel.setLayout(new BoxLayout(shoppingListPanel, BoxLayout.Y_AXIS));
        shoppingListPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        int shoppingPanelWidth = 247;
        int shoppingPanelHeight = 250;
        shoppingListPanel.setPreferredSize(new Dimension(shoppingPanelWidth, shoppingPanelHeight));
        shoppingListPanel.setMinimumSize(new Dimension(shoppingPanelWidth, shoppingPanelHeight));
        shoppingListPanel.setMaximumSize(new Dimension(shoppingPanelWidth, shoppingPanelHeight));
        
        for (Item item : shoppingList) {
            if (itemName.equals(item.name)) {
                shoppingList.remove(item);
                break;
            }
        }
        
        if ((int)itemAmount > 0) {
            shoppingList.add(new Item(0, itemName, null, itemPrice, (int)itemAmount, null));
        }
        
        totalPurchases = 0;
        for (Item item : shoppingList) {
            JLabel name = new JLabel(item.name);
            JLabel total = new JLabel("Rp" + Integer.toString(item.price * item.stock));
            JPanel rowItem = new JPanel();
            rowItem.setLayout(new BoxLayout(rowItem, BoxLayout.X_AXIS));
            rowItem.setBackground(Color.WHITE);
            rowItem.add(name);
            rowItem.add(Box.createHorizontalGlue());
            rowItem.add(total);
            shoppingListPanel.add(rowItem);
            shoppingListPanel.add(Box.createVerticalStrut(5));
            totalPurchases += item.price * item.stock;
        }
        
        if (totalPurchases > 0) {
            shoppingListPanel.add(Box.createVerticalGlue());
            JLabel name = new JLabel("Total");
            name.setFont(new Font("Arial", Font.BOLD, 12));
            JLabel total = new JLabel("Rp" + Integer.toString(totalPurchases));
            total.setFont(new Font("Arial", Font.BOLD, 12));
            JPanel rowItem = new JPanel();
            rowItem.setLayout(new BoxLayout(rowItem, BoxLayout.X_AXIS));
            rowItem.setBackground(Color.WHITE);
            rowItem.add(name);
            rowItem.add(Box.createHorizontalGlue());
            rowItem.add(total);
            shoppingListPanel.add(rowItem);
        }
        
        shoppingListPanel.revalidate();
        shoppingListPanel.repaint();
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JLabel applicationNameLabel;
    private javax.swing.JButton cancelShoppingButton;
    private javax.swing.JButton confirmShoppingButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JTextField membershipField;
    private javax.swing.JPanel middlePanel;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel shoppingListPanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton transactionHistoryButton;
    // End of variables declaration//GEN-END:variables
}
