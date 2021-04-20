package AirlineProducts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class UserCreation extends javax.swing.JInternalFrame {

    /**
     * Creates new form userCreation
     */
    public UserCreation() {
        initComponents();
        generateID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_user_id = new javax.swing.JLabel();
        l_first_name = new javax.swing.JLabel();
        l_last_name = new javax.swing.JLabel();
        l_username = new javax.swing.JLabel();
        l_password = new javax.swing.JLabel();
        l_user_id_value = new javax.swing.JLabel();
        tf_first_name = new javax.swing.JTextField();
        tf_last_name = new javax.swing.JTextField();
        tf_username = new javax.swing.JTextField();
        b_add = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();
        pwf_password = new javax.swing.JPasswordField();

        setName("user_creation"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("User Creation"));

        l_user_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l_user_id.setText("User ID");

        l_first_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l_first_name.setText("First name");

        l_last_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l_last_name.setText("Last name");

        l_username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l_username.setText("Username");

        l_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l_password.setText("Password");

        l_user_id_value.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_user_id_value.setForeground(new java.awt.Color(255, 0, 0));
        l_user_id_value.setText("jLabel6");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_user_id)
                    .addComponent(l_first_name)
                    .addComponent(l_last_name)
                    .addComponent(l_username)
                    .addComponent(l_password))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_user_id_value)
                    .addComponent(tf_first_name)
                    .addComponent(tf_last_name)
                    .addComponent(tf_username)
                    .addComponent(pwf_password, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(l_user_id)
                                    .addComponent(l_user_id_value))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(l_first_name)
                                    .addComponent(tf_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addComponent(l_last_name))
                            .addComponent(tf_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(l_username))
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_password)
                    .addComponent(pwf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed
        String id = l_user_id_value.getText();
        String firstname = tf_first_name.getText();
        String lastname = tf_last_name.getText();
        String username = tf_username.getText();
        String password = String.copyValueOf(pwf_password.getPassword());

        if (hasValidInputs(id, firstname, lastname, username, password)) {
            try {
                Connection connection = DbUtils.getDbConnection();
                PreparedStatement statement = connection.prepareStatement("insert "
                        + "into user(id,firstname,lastname,username,password)values(?,?,?,?,?)");

                statement.setString(1, id);
                statement.setString(2, firstname);
                statement.setString(3, lastname);
                statement.setString(4, username);
                statement.setString(5, password);

                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "User Created");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Unable to connect to database");
            } catch (SQLException ex) {
                Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "An error occurred "
                        + "interacting with the database");
            }
        }
    }//GEN-LAST:event_b_addActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void generateID() {
        try {
            Connection connection = DbUtils.getDbConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select MAX(id) from user;");
            result.next();
            l_user_id_value.setText(generateID(result.getString("MAX(id)")));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to connect to database");
        } catch (SQLException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred "
                    + "interacting with the database");
        }
    }

    public String generateID(String maxID) {
        if (maxID == null) {
            return "UO001";
        } else {
            long id = Long.parseLong(maxID.substring(2, maxID.length()));
            return "UO" + String.format("%03d", ++id);
        }
    }

    public boolean isValidName(String name) {
        if (name.length() < 2 || name.length() > 15) {
            JOptionPane.showMessageDialog(this, "Names must be between 2 and 15 characters");
            return false;
        }
        if (!name.chars().allMatch(Character::isLetter)) {
            JOptionPane.showMessageDialog(this, "Names may only contains letters");
            return false;
        }
        return true;
    }

    public boolean isValidUsername(String username) {
        if (username.length() < 2 || username.length() > 15) {
            JOptionPane.showMessageDialog(this, "Username must be between 2 and 15 characters");
            return false;
        }
        if (!username.chars().allMatch(Character::isLetterOrDigit)) {
            JOptionPane.showMessageDialog(this, "Username may only contains letters and digits");
            return false;
        }
        try {
            Connection connection = DbUtils.getDbConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user "
                    + "WHERE username = ?;");
            statement.setString(1, username);
            System.out.println("valid username query: " + statement.toString());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                JOptionPane.showMessageDialog(this, "Username is not available");
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to connect to database");
        } catch (SQLException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred "
                    + "interacting with the database");
        }
        return true;
    }

    public boolean isValidPassword(String password) {
        if (password.length() < 6 || password.length() > 15) {
            JOptionPane.showMessageDialog(this, "Password must be between 6 and 15 characters");
            return false;
        }
        if (password.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Password may not contain spaces");
            return false;
        }
        if (password.chars().allMatch(Character::isLetterOrDigit)) {
            JOptionPane.showMessageDialog(this, "Password must contain at least one special character");
            return false;
        }
        return true;
    }

    public boolean hasValidID(String id) {
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "There is no valid ID");
            return false;
        }
        return true;
    }

    private boolean hasValidInputs(String id, String firstName, String lastName,
            String username, String password) {
        return hasValidID(id) && isValidName(firstName) && isValidName(lastName)
                && isValidUsername(username) && isValidPassword(password);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_add;
    private javax.swing.JButton b_cancel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_first_name;
    private javax.swing.JLabel l_last_name;
    private javax.swing.JLabel l_password;
    private javax.swing.JLabel l_user_id;
    private javax.swing.JLabel l_user_id_value;
    private javax.swing.JLabel l_username;
    private javax.swing.JPasswordField pwf_password;
    private javax.swing.JTextField tf_first_name;
    private javax.swing.JTextField tf_last_name;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
