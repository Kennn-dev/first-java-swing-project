
import java.awt.Image;
import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Drink extends javax.swing.JFrame {

    /**
     * Creates new form Drink
    
   */
    
    Connection con;
    PreparedStatement prStmt;
    Statement stmt;
    ResultSet rsSet;
    DefaultTableModel table;
    String finalPath ;
    public Drink() {
        initComponents();
        Connect();
        loadDataCombobox();
        loadDataToList();
        loadDataToTable();
    }
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/coffee_shop", "root", "");
        }catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ResultSet fetchDataTable(String table){
        try {
            String query = "SELECT * FROM "+table;
            prStmt = con.prepareStatement(query);
            
            rsSet = prStmt.executeQuery();
            
            } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsSet;
    }
    
    public ResultSet fetchSingleDrink(String idFetch){
        
        
        try {
            String query = "SELECT * FROM drink WHERE drinkID="+idFetch;
            prStmt = con.prepareStatement(query);
            rsSet = prStmt.executeQuery();
            
                    } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsSet;
    }
    
    public void loadDataToTable(){
       try {
            int cursor;
            rsSet = fetchDataTable("drink");
            ResultSetMetaData metaData = rsSet.getMetaData();
            cursor = metaData.getColumnCount();
            
            //create a Table model
            table = (DefaultTableModel)drinkTable.getModel();
            table.setRowCount(0);
            
            while(rsSet.next())
            {
                //Each result get values
//              id , name , price, category
                String id = rsSet.getInt("drinkID")+"";
                String price = rsSet.getDouble("price")+"";
                String name = rsSet.getString("drinkName");
               
                //add to Table model a new Row  with these values fetched^^
                table.addRow(new Object[]{id,name,price});
                
                drinkTable.setModel(table);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public void loadDataToList(){
        DefaultListModel list = new DefaultListModel(); //create a new list model
        rsSet = fetchDataTable("drinktype");
        try {
        while (rsSet.next()) //go through each row that your query returns
        {
            int id = rsSet.getInt("drinkTypeID");
            String itemCode = rsSet.getString("drinkTypeName"); //get the element in column "xxx"
            list.addElement(itemCode + " - "+id); //add each item to the model
           
        }
        jList1.setModel(list); //set model to jList1
         } catch (SQLException ex) {
                Logger.getLogger(Drink.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void loadDataCombobox() {
//        clear 
        categoryCbb.removeAllItems();
        //get Data
        ArrayList<String> cateArr = new ArrayList<String>();
        rsSet = fetchDataTable("drinkType");
        
        try {
            while(rsSet.next()){
                //add value get from DB to array
                cateArr.add(rsSet.getString("drinkTypeName")+" - "+rsSet.getInt("drinkTypeID"));
            }
//        then add to combobox
            for(String str : cateArr){
                categoryCbb.addItem(str);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drink.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
    }
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(190, 150, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        Create = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        priceInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        categoryCbb = new javax.swing.JComboBox<>();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        imageBtn = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        drinkTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        cateAddInput = new javax.swing.JButton();
        delCateInput = new javax.swing.JButton();
        cateNameInput = new javax.swing.JLabel();
        nameCateInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        backBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DRINKS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel1.setText("Name :");

        Create.setBackground(new java.awt.Color(204, 204, 204));
        Create.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel3.setText("Price :");

        jLabel7.setText("VND");

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel8.setText("Category :");

        editBtn.setBackground(new java.awt.Color(204, 204, 204));
        editBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        editBtn.setText("Edit");
        editBtn.setEnabled(false);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(204, 204, 204));
        deleteBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.setEnabled(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        imageBtn.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        imageBtn.setText("Insert Image");
        imageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Create, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameInput)
                            .addComponent(categoryCbb, 0, 200, Short.MAX_VALUE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(categoryCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Create, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LIST DRINKS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 24))); // NOI18N

        drinkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ));
        drinkTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drinkTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(drinkTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CATEGORIES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 24))); // NOI18N

        cateAddInput.setText("Add");
        cateAddInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cateAddInputActionPerformed(evt);
            }
        });

        delCateInput.setText("Delete");
        delCateInput.setEnabled(false);
        delCateInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCateInputActionPerformed(evt);
            }
        });

        cateNameInput.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        cateNameInput.setText("Name :");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel2.setText("Lorem ipsum subheader");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cateAddInput)
                        .addGap(2, 2, 2)
                        .addComponent(delCateInput))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cateNameInput)
                            .addComponent(jLabel2))
                        .addGap(120, 120, 120)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(nameCateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cateNameInput)
                .addGap(18, 18, 18)
                .addComponent(nameCateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cateAddInput)
                    .addComponent(delCateInput))
                .addGap(19, 19, 19))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LIST CATEGORIES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 24))); // NOI18N

        jList1.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Drink", jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 902, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel4);

        jMenu1.setText("Back");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.toBack();
        setVisible(false);
    }//GEN-LAST:event_backBtnActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        delCateInput.setEnabled(true);
        String name = jList1.getSelectedValue().split(" - ")[0].toString();
        nameCateInput.setText(name);
    }//GEN-LAST:event_jList1MouseClicked

    private void delCateInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delCateInputActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String id = jList1.getSelectedValue().split(" - ")[1].toString();
        String sql = "DELETE FROM drinktype WHERE drinktypeID = ?";
        try {
            prStmt = con.prepareStatement(sql);
            prStmt.setInt(1, Integer.parseInt(id));
            prStmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Delete Successfull :D");
            loadDataToList();
            loadDataCombobox();
            nameCateInput.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_delCateInputActionPerformed

    private void cateAddInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cateAddInputActionPerformed
        // TODO add your handling code here:
        String name = nameCateInput.getText();
        if("".equals(name)){
            JOptionPane.showMessageDialog(this, "Input required");
        }else{
            try {
                String sql = "INSERT INTO drinkType(drinkTypeName) VALUES (?)";
                prStmt = con.prepareStatement(sql);
                prStmt.setString(1, name);
                prStmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Created Successful :D");
                loadDataToList();
                loadDataCombobox();
                //clear input
                nameCateInput.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(Drink.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cateAddInputActionPerformed

    private void drinkTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drinkTableMouseClicked
        try {
            // TODO add your handling code here:
            //create a Table model
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);

            //
            int row = drinkTable.getSelectedRow();
            String id = drinkTable.getModel().getValueAt(row, 0).toString();
            String name = drinkTable.getModel().getValueAt(row, 1).toString();
            String price = drinkTable.getModel().getValueAt(row, 2).toString();
            String categoryName = fetchSingleDrinkIDToDrinkTypeName(Integer.parseInt(id));

            //get path
            String path = "";
            String sql = "SELECT * FROM drink WHERE drinkID=" + id;
            rsSet = prStmt.executeQuery(sql);
            while(rsSet.next()){
                finalPath = rsSet.getString("image");
                path = rsSet.getString("image");
            }

            //set values
            nameInput.setText(name);
            priceInput.setText(price+"");
            categoryCbb.setSelectedItem(categoryName);
            imageLabel.setIcon(ResizeImage(path));
        } catch (SQLException ex) {
            Logger.getLogger(Drink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_drinkTableMouseClicked

    private void imageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBtnActionPerformed
        // TODO add your handling code here:
        //file format
        JFileChooser file = new JFileChooser();
        String path = new File("").getAbsolutePath();
        file.setCurrentDirectory(new File(path));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","jpeg","png");
        file.addChoosableFileFilter(filter);

        //      show dialog to open file
        int result = file.showSaveDialog(null);

        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            finalPath = selectedFile.getAbsolutePath();
            imageLabel.setIcon(ResizeImage(finalPath));
        }else if(result == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(this, "No File selected !");
        }
    }//GEN-LAST:event_imageBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try {
            // TODO add your handling code here:
            String id = drinkTable.getModel().getValueAt(drinkTable.getSelectedRow(), 0).toString();
//            System.out.println(id);
            String sql = "delete from drink WHERE drinkID = "+id;
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Delete Successful :D");
            loadDataToTable();
            ResetForm();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Delete fail !");
            Logger.getLogger(Drink.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        //verify fields not blank
        if("".equals(nameInput.getText())){
            JOptionPane.showMessageDialog(this, "Name required !");
        }else if("".equals(priceInput.getText())){
            JOptionPane.showMessageDialog(this, "Price required !");
        }else if("".equals(finalPath)){
            JOptionPane.showMessageDialog(this, "Image required !");
        }else{
            try {
                //Create new drinks
                String id = drinkTable.getModel().getValueAt(drinkTable.getSelectedRow(), 0).toString();
                String name = nameInput.getText();
                String price = priceInput.getText();
                String path = finalPath;
                String categoryID = categoryCbb.getSelectedItem().toString().split(" - ")[1];
                //                System.out.print(path);

                String sql = "UPDATE drink SET drinkName = ?, drinkTypeID = ?, price = ?, image =? WHERE drinkID = ?";
                prStmt = con.prepareStatement(sql);
                // replace these with ? value in sql query :D
                prStmt.setString(1, name);
                prStmt.setInt(2,Integer.parseInt(categoryID));
                prStmt.setDouble(3, Double.parseDouble(price));
                prStmt.setString(4, path);
                prStmt.setString(5, id);
                prStmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Update Successful :D");
                loadDataToTable();
                ResetForm();

            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        // TODO add your handling code here:
        //verify fields not blank
        if("".equals(nameInput.getText())){
            JOptionPane.showMessageDialog(this, "Name required !");
        }else if("".equals(priceInput.getText())){
            JOptionPane.showMessageDialog(this, "Price required !");
        }else if("".equals(finalPath)){
            JOptionPane.showMessageDialog(this, "Image required !");
        }else{
            try {
                //Create new drinks

                String name = nameInput.getText();
                String price = priceInput.getText();
                String path = finalPath;
                String categoryID = categoryCbb.getSelectedItem().toString().split(" - ")[1];
                System.out.print(path);

                String sql = "INSERT INTO drink(drinkName, drinkTypeID, price, image) VALUES (?,?,?,?)";
                prStmt = con.prepareStatement(sql);
                // replace these with ? value in sql query :D
                prStmt.setString(1, name);
                prStmt.setInt(2,Integer.parseInt(categoryID));
                prStmt.setDouble(3, Double.parseDouble(price));
                prStmt.setString(4, path);
                prStmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Created Successful :D");
                loadDataToTable();
                ResetForm();

            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_CreateActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
//        new Main().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Drink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Drink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Drink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Drink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Drink().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cateAddInput;
    private javax.swing.JLabel cateNameInput;
    private javax.swing.JComboBox<String> categoryCbb;
    private javax.swing.JButton delCateInput;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable drinkTable;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton imageBtn;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nameCateInput;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField priceInput;
    // End of variables declaration//GEN-END:variables

    private void ResetForm() {
        nameInput.setText("");
        priceInput.setText("");
        categoryCbb.setSelectedIndex(0);
        imageLabel.setIcon(null);
         editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }

    private String fetchSingleDrinkIDToDrinkTypeName(int idDrink) {
       
        String name = null;
         try {
             //idDrink -> rs drinkType
            String drinkQuery = "SELECT * FROM drink WHERE drinkID="+idDrink;
            prStmt = con.prepareStatement(drinkQuery);
            rsSet = prStmt.executeQuery();
            while(rsSet.next()){
                    int idTypeDrink = rsSet.getInt("drinkTypeID");
                    String typeDrinkQuery = "SELECT * FROM drinktype WHERE drinkTypeID="+idTypeDrink;
                    prStmt = con.prepareStatement(typeDrinkQuery);
                    rsSet = prStmt.executeQuery();
                    while(rsSet.next()){
                        String typeName = rsSet.getString("drinkTypeName");
                        name =typeName +" - "+idTypeDrink;
                    }
            }
                    } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    
}


 
