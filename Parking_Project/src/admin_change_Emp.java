/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import com.mongodb.*;
import com.mongodb.BasicDBObject;
import javax.swing.JOptionPane;
public class admin_change_Emp extends javax.swing.JFrame {

    /**
     * Creates new form admin_change_Emp
     */
    //long mobno;
    //admin_update_Emp admin_change = new admin_update_Emp();
    String userid, userid_db;  
    
    public admin_change_Emp() {
        initComponents();
        
       // mobno = Integer.parseInt(mobni_field.getText());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userid_field = new javax.swing.JTextField();
        delete_button = new javax.swing.JButton();
        update_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("User ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 110, 24));

        userid_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        userid_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userid_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(userid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 158, 30));

        delete_button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delete_button.setText("DELETE");
        delete_button.setBorder(null);
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(delete_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 130, 32));

        update_button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        update_button.setText("UPDATE");
        update_button.setBorder(null);
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(update_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 130, 32));

        cancel_button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancel_button.setText("Cancel");
        cancel_button.setBorder(null);
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(cancel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 110, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\DBMS Project\\Parking_Project\\Images\\oak-wood.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Parking Management System");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        // TODO add your handling code here:
        
        try
        {
            userid = userid_field.getText();
            int flag = 0;
            MongoClient mc = new MongoClient("localhost",27017);
            DB db = mc.getDB("parking_system");
            DBCollection collection = db.getCollection("employee_info");
        
            BasicDBObject query = new BasicDBObject();
            BasicDBObject field = new BasicDBObject();
            field.put("_id",userid);
            
            DBCursor cursor = collection.find(query,field);
            while(cursor.hasNext())
            {
                DBObject obj = (DBObject)cursor.next();
                userid_db = obj.get("_id").toString();
                
                if(userid.equals(userid_db))
                {
                    
                    flag = 1;
                    setVisible(false);
                    new admin_update_Emp(userid).setVisible(true);
                    break;
                }
            }
            if(flag == 0)
            {
                JOptionPane.showMessageDialog(null,"UserID invalid");
            }
            
        }
        catch(Exception e)
        {
        
        }
        
    }//GEN-LAST:event_update_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:
 
        try
        {
            userid = userid_field.getText();
            int flag = 0;
            
            MongoClient mc = new MongoClient("localhost",27017);
            DB db = mc.getDB("parking_system");
            DBCollection collection = db.getCollection("employee_info");
          
            
            BasicDBObject query = new BasicDBObject();
            BasicDBObject field = new BasicDBObject();
            field.put("_id",userid);
            
            DBCursor cursor = collection.find(query,field);
            while(cursor.hasNext())
            {
                DBObject obj = (DBObject)cursor.next();
                userid_db = obj.get("_id").toString();
                
                if(userid.equals(userid_db))
                {
                    
                    flag = 1;
                    
                    BasicDBObject deleteObject = new BasicDBObject();
                    deleteObject.put("_id",userid);
                    DBCursor findQuery = collection.find(deleteObject);
                    collection.remove(deleteObject);
             
                    JOptionPane.showMessageDialog(null,"Employee Entry Deleted !!!");
                
                    setVisible(false);
                    new Admin_rights().setVisible(true);
                    break;
                }
            }
            if(flag == 0)
            {
                JOptionPane.showMessageDialog(null,"UserID invalid");
            }
        }
        catch(Exception e)
        {
        
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Admin_rights().setVisible(true);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void userid_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userid_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userid_fieldActionPerformed

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
            java.util.logging.Logger.getLogger(admin_change_Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_change_Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_change_Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_change_Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_change_Emp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton update_button;
    private javax.swing.JTextField userid_field;
    // End of variables declaration//GEN-END:variables
}
