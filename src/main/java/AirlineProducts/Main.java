package AirlineProducts;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Main extends javax.swing.JFrame {

    public AddCustomer addCustomer;
    public SearchCustomer searchCustomer;
    public AddFlight addFlight;
    public ticket ticket;
    public ticketreport ticketReport;
    public UserCreation userCreation;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_add_customer = new javax.swing.JMenuItem();
        mi_search_customer = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mi_book_ticket = new javax.swing.JMenuItem();
        mi_ticket_report = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mi_add_flight = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mi_user_creation = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenu1.setText("Customer");

        mi_add_customer.setText("Add Customer");
        mi_add_customer.setName("addCustomerComp"); // NOI18N
        mi_add_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_add_customerActionPerformed(evt);
            }
        });
        jMenu1.add(mi_add_customer);

        mi_search_customer.setText("Search Customer");
        mi_search_customer.setName("searchCustomerMI"); // NOI18N
        mi_search_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_search_customerActionPerformed(evt);
            }
        });
        jMenu1.add(mi_search_customer);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tickets");

        mi_book_ticket.setText("Book Ticket");
        mi_book_ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_book_ticketActionPerformed(evt);
            }
        });
        jMenu2.add(mi_book_ticket);

        mi_ticket_report.setText("Ticket Report");
        mi_ticket_report.setName(""); // NOI18N
        mi_ticket_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ticket_reportActionPerformed(evt);
            }
        });
        jMenu2.add(mi_ticket_report);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Flight");

        mi_add_flight.setText("Add Flight");
        mi_add_flight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_add_flightActionPerformed(evt);
            }
        });
        jMenu3.add(mi_add_flight);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("User");

        mi_user_creation.setText("UserCreation");
        mi_user_creation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_user_creationActionPerformed(evt);
            }
        });
        jMenu4.add(mi_user_creation);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mi_add_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_add_customerActionPerformed
        // TODO add your handling code here:
//        AddCustomer cus = new AddCustomer();
        if (addCustomer == null) {
            addCustomer = new AddCustomer();
        }
        jDesktopPane1.removeAll();
        jDesktopPane1.add(addCustomer);
        addCustomer.setVisible(true);

    }//GEN-LAST:event_mi_add_customerActionPerformed

    private void mi_search_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_search_customerActionPerformed
        // TODO add your handling code here:

        if (searchCustomer == null) {
            searchCustomer = new SearchCustomer();
        }
        jDesktopPane1.removeAll();
        jDesktopPane1.add(searchCustomer);
        searchCustomer.setVisible(true);

    }//GEN-LAST:event_mi_search_customerActionPerformed

    private void mi_add_flightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_add_flightActionPerformed
        // TODO add your handling code here:
        if (addFlight == null) {
            addFlight = new AddFlight();
        }
        jDesktopPane1.removeAll();
        jDesktopPane1.add(addFlight);
        addFlight.setVisible(true);

    }//GEN-LAST:event_mi_add_flightActionPerformed

    private void mi_book_ticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_book_ticketActionPerformed
        // TODO add your handling code here:
        if (ticket == null) {
            ticket = new ticket();
        }
        jDesktopPane1.removeAll();
        jDesktopPane1.add(ticket);
        ticket.setVisible(true);

    }//GEN-LAST:event_mi_book_ticketActionPerformed

    private void mi_ticket_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ticket_reportActionPerformed
        // TODO add your handling code here:

        if (ticketReport == null) {
            ticketReport = new ticketreport();
        }
        jDesktopPane1.removeAll();
        jDesktopPane1.add(ticketReport);
        ticketReport.setVisible(true);

    }//GEN-LAST:event_mi_ticket_reportActionPerformed

    private void mi_user_creationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_user_creationActionPerformed
        // TODO add your handling code here:

        if (userCreation == null) {
            userCreation = new UserCreation();
        }
        jDesktopPane1.removeAll();
        jDesktopPane1.add(userCreation);
        userCreation.setVisible(true);

    }//GEN-LAST:event_mi_user_creationActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem mi_add_customer;
    public javax.swing.JMenuItem mi_add_flight;
    public javax.swing.JMenuItem mi_book_ticket;
    public javax.swing.JMenuItem mi_search_customer;
    public javax.swing.JMenuItem mi_ticket_report;
    public javax.swing.JMenuItem mi_user_creation;
    // End of variables declaration//GEN-END:variables
}
