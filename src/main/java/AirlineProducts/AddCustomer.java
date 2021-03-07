package AirlineProducts;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class AddCustomer extends javax.swing.JInternalFrame {

    /**
     * Creates new form addCustomer
     */
    public AddCustomer() {
        initComponents();
        generateID();
    }
    
    String path=null;
    byte[] userimage=null;
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_one = new javax.swing.JPanel();
        l_first_name = new javax.swing.JLabel();
        j_last_name = new javax.swing.JLabel();
        l_nic = new javax.swing.JLabel();
        l_passport = new javax.swing.JLabel();
        j_address = new javax.swing.JLabel();
        tf_last_name = new javax.swing.JTextField();
        tf_first_name = new javax.swing.JTextField();
        tf_nic = new javax.swing.JTextField();
        tf_passport = new javax.swing.JTextField();
        sp_address = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        l_customer_id = new javax.swing.JLabel();
        l_customer_id_value = new javax.swing.JLabel();
        p_two = new javax.swing.JPanel();
        l_dob = new javax.swing.JLabel();
        l_gender = new javax.swing.JLabel();
        l_contact = new javax.swing.JLabel();
        rb_male = new javax.swing.JRadioButton();
        rb_female = new javax.swing.JRadioButton();
        tf_contact = new javax.swing.JTextField();
        dc_dob = new com.toedter.calendar.JDateChooser();
        j_photo = new javax.swing.JLabel();
        b_browse = new javax.swing.JButton();
        b_add = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();

        p_one.setBackground(new java.awt.Color(51, 0, 255));

        l_first_name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l_first_name.setForeground(new java.awt.Color(255, 255, 255));
        l_first_name.setText("FirstName");

        j_last_name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        j_last_name.setForeground(new java.awt.Color(255, 255, 255));
        j_last_name.setText("LastName");

        l_nic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l_nic.setForeground(new java.awt.Color(255, 255, 255));
        l_nic.setText("Nic No");

        l_passport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l_passport.setForeground(new java.awt.Color(255, 255, 255));
        l_passport.setText("Passport ID");

        j_address.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        j_address.setForeground(new java.awt.Color(255, 255, 255));
        j_address.setText("Address");

        txtaddress.setColumns(20);
        txtaddress.setRows(5);
        sp_address.setViewportView(txtaddress);

        javax.swing.GroupLayout p_oneLayout = new javax.swing.GroupLayout(p_one);
        p_one.setLayout(p_oneLayout);
        p_oneLayout.setHorizontalGroup(
            p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_oneLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p_oneLayout.createSequentialGroup()
                        .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(p_oneLayout.createSequentialGroup()
                                .addComponent(l_first_name)
                                .addGap(47, 47, 47)
                                .addComponent(tf_first_name))
                            .addGroup(p_oneLayout.createSequentialGroup()
                                .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(j_address)
                                    .addComponent(l_passport)
                                    .addComponent(l_nic))
                                .addGap(38, 38, 38)
                                .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sp_address)
                                    .addComponent(tf_passport)
                                    .addComponent(tf_nic))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(p_oneLayout.createSequentialGroup()
                        .addComponent(j_last_name)
                        .addGap(48, 48, 48)
                        .addComponent(tf_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        p_oneLayout.setVerticalGroup(
            p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_oneLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_first_name)
                    .addComponent(tf_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j_last_name)
                    .addComponent(tf_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nic)
                    .addComponent(tf_nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_passport)
                    .addComponent(tf_passport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j_address)
                    .addComponent(sp_address, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        l_customer_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_customer_id.setText("Customer ID");

        l_customer_id_value.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        l_customer_id_value.setForeground(new java.awt.Color(255, 0, 0));
        l_customer_id_value.setText("jLabel7");

        p_two.setBackground(new java.awt.Color(51, 0, 255));

        l_dob.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l_dob.setForeground(new java.awt.Color(255, 255, 255));
        l_dob.setText("Date of Birth");

        l_gender.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l_gender.setForeground(new java.awt.Color(255, 255, 255));
        l_gender.setText("Gender");

        l_contact.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l_contact.setForeground(new java.awt.Color(255, 255, 255));
        l_contact.setText("Contact");

        rb_male.setText("Male");

        rb_female.setText("Female");

        javax.swing.GroupLayout p_twoLayout = new javax.swing.GroupLayout(p_two);
        p_two.setLayout(p_twoLayout);
        p_twoLayout.setHorizontalGroup(
            p_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_twoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(p_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_twoLayout.createSequentialGroup()
                        .addComponent(l_dob)
                        .addGap(44, 44, 44)
                        .addComponent(dc_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_twoLayout.createSequentialGroup()
                        .addGroup(p_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_gender)
                            .addComponent(l_contact))
                        .addGap(43, 43, 43)
                        .addGroup(p_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(p_twoLayout.createSequentialGroup()
                                .addComponent(rb_male)
                                .addGap(18, 18, 18)
                                .addComponent(rb_female))
                            .addComponent(tf_contact))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        p_twoLayout.setVerticalGroup(
            p_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_twoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(p_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_dob)
                    .addComponent(dc_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_gender)
                    .addComponent(rb_male)
                    .addComponent(rb_female))
                .addGap(18, 18, 18)
                .addGroup(p_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_contact)
                    .addComponent(tf_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        j_photo.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        b_browse.setText("Browse");
        b_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_browseActionPerformed(evt);
            }
        });

        b_add.setText("Add");
        b_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addActionPerformed(evt);
            }
        });

        b_cancel.setText("Cancel");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(l_customer_id)
                        .addGap(50, 50, 50)
                        .addComponent(l_customer_id_value))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(p_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(p_two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(j_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(355, 355, 355)
                                .addComponent(b_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_customer_id)
                    .addComponent(l_customer_id_value))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(j_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(b_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void generateID() {
        try {
            Connection connection = DbUtils.getDbConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select MAX(id) from user;");
            result.next();
            l_customer_id_value.setText(generateID(result.getString("MAX(id)")));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to connect to database");
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred "
                + "interacting with the database");
        }
    }
    
    String generateID(String maxID) {
        if (maxID == null) {
            return "CS001";
        } else {
            long id = Long.parseLong(maxID.substring(2, maxID.length()));
            return "CS" + String.format("%03d", ++id);
        } 
    }
    
    private void b_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_browseActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser picchooser = new JFileChooser();
            picchooser.showOpenDialog(null);
            File pic = picchooser.getSelectedFile();       
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","png","jpg");
            picchooser.addChoosableFileFilter(filter);     
            path= pic.getAbsolutePath();
            BufferedImage img;                    
            img = ImageIO.read(picchooser.getSelectedFile());
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
            j_photo.setIcon(imageIcon); 

            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos= new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            for(int readNum; (readNum=fis.read(buff)) !=-1 ; ) {
                baos.write(buff,0,readNum);
            }
            userimage=baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to connect to database");
        } 
    }//GEN-LAST:event_b_browseActionPerformed

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed
        String id = l_customer_id_value.getText();
        String firstname = tf_first_name.getText();
        String lastname = tf_last_name.getText();
        String nic = tf_nic.getText(); 
        String passport = tf_passport.getText();
        String address = txtaddress.getText();
        
        DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        String date = da.format(dc_dob.getDate());
        String Gender;
        
        if(rb_male.isSelected())
        {
            Gender = "Male";
        }
        else
        {
            Gender = "FeMale";
        }
        
         String contact = tf_contact.getText();
         
        try {
            Connection connection = DbUtils.getDbConnection();
            PreparedStatement statement = connection.prepareStatement("insert "
                    + "into customer(id,firstname,lastname,nic,passport,address,"
                    + "dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");
            
            statement.setString(1, id);
            statement.setString(2, firstname);
            statement.setString(3, lastname);
            statement.setString(4, nic);
            statement.setString(5, passport);
            statement.setString(6, address);
            statement.setString(7, date);
            statement.setString(8, Gender);
            statement.setString(9, contact);
            statement.setBytes(10, userimage);
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Registation Createdd.........");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to connect to database");
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred "
                    + "interacting with the database");
        }
    }//GEN-LAST:event_b_addActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_b_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_add;
    private javax.swing.JButton b_browse;
    private javax.swing.JButton b_cancel;
    private com.toedter.calendar.JDateChooser dc_dob;
    private javax.swing.JLabel j_address;
    private javax.swing.JLabel j_last_name;
    private javax.swing.JLabel j_photo;
    private javax.swing.JLabel l_contact;
    private javax.swing.JLabel l_customer_id;
    private javax.swing.JLabel l_customer_id_value;
    private javax.swing.JLabel l_dob;
    private javax.swing.JLabel l_first_name;
    private javax.swing.JLabel l_gender;
    private javax.swing.JLabel l_nic;
    private javax.swing.JLabel l_passport;
    private javax.swing.JPanel p_one;
    private javax.swing.JPanel p_two;
    private javax.swing.JRadioButton rb_female;
    private javax.swing.JRadioButton rb_male;
    private javax.swing.JScrollPane sp_address;
    private javax.swing.JTextField tf_contact;
    private javax.swing.JTextField tf_first_name;
    private javax.swing.JTextField tf_last_name;
    private javax.swing.JTextField tf_nic;
    private javax.swing.JTextField tf_passport;
    private javax.swing.JTextArea txtaddress;
    // End of variables declaration//GEN-END:variables
}
