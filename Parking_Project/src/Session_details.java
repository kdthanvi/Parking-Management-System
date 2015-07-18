
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Session_details extends javax.swing.JFrame {

    /**
     * Creates new form Session_details
     */String time_str;
    public Session_details() {
        initComponents();
        
        try
        {
            
            String str = "stats", str2;
            MongoClient mc = new MongoClient("localhost",27017);
            DB db = mc.getDB("parking_system");
            DBCollection collection = db.getCollection("statistics");
            
            BasicDBObject query = new BasicDBObject();
            BasicDBObject field = new BasicDBObject();
            field.put("_id", str);
            
            DBCursor cursor = collection.find(field);
            
            while(cursor.hasNext())
            {
                DBObject obj = (DBObject)cursor.next();
                str2 = obj.get("_id").toString();
                                
                if(str2.equals(str))
                {
                    wheeler2_cnt_field.setText(obj.get("2wheeler_count").toString());
                    wheeler2_income_field.setText(obj.get("2wheeler_income").toString());
                    wheeler4_cnt_field.setText(obj.get("4wheeler_count").toString());
                    wheeler4_income_field.setText(obj.get("4wheeler_income").toString());
                    other_cnt_field.setText(obj.get("other_count").toString());
                    other_income_field.setText(obj.get("other_income").toString());
                    time_field.setText(obj.get("time").toString());
                    
                    break;
                    
                }
                
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    
    }

    public void updateSession(String s1)//, String s2)
    {
        try
        {
            
            int count;
            MongoClient mc = new MongoClient("localhost",27017);
            DB db = mc.getDB("parking_system");
            DBCollection collection2 = db.getCollection("statistics");
            
            BasicDBObject query = new BasicDBObject();
            BasicDBObject field = new BasicDBObject();
            field.put(s1, 1);
    
            DBCursor cursor = collection2.find(query, field);

            BasicDBObject obj = (BasicDBObject) cursor.next();
            count = obj.getInt(s1);
            System.out.println(count);

            
            BasicDBObject searchUpdate = new BasicDBObject();
            searchUpdate.append(s1, count);

            BasicDBObject UpdateObject = new BasicDBObject();
            UpdateObject.append("$set", new BasicDBObject(s1, 0));

            collection2.update(searchUpdate, UpdateObject);
        
        }
        catch(Exception e)
        {
        
        }
    }
    /**
     * This method is called from twithin the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        wheeler2_cnt_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        wheeler2_income_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        wheeler4_cnt_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        wheeler4_income_field = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        other_cnt_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        other_income_field = new javax.swing.JTextField();
        done_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        time_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("2 Wheelers Parked : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 36));

        wheeler2_cnt_field.setText("3");
        getContentPane().add(wheeler2_cnt_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 67, 36));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("2 Wheelers Income :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 140, 36));

        wheeler2_income_field.setText("60");
        getContentPane().add(wheeler2_income_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 91, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("4 Wheelers Parked :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 36));

        wheeler4_cnt_field.setText("4");
        getContentPane().add(wheeler4_cnt_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 67, 36));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("4 Wheeler Income :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 140, 40));

        wheeler4_income_field.setText("160");
        getContentPane().add(wheeler4_income_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 91, 36));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Others Parked :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, 36));

        other_cnt_field.setText("1");
        getContentPane().add(other_cnt_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 70, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Others Income :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 120, 40));

        other_income_field.setText("120");
        getContentPane().add(other_income_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 91, 36));

        done_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        done_button.setText("Done");
        done_button.setBorder(null);
        done_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(done_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 126, 37));

        clear_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clear_button.setText("Clear");
        clear_button.setBorder(null);
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(clear_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 108, 37));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Last Session Time :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 130, 41));

        time_field.setText("Wed Sep 24 19:34:15 IST 2014");
        getContentPane().add(time_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 176, 41));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\DBMS Project\\Parking_Project\\Images\\oak-wood.jpg")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        // TODO add your handling code here:
        
        
        updateSession("2wheeler_count" );//, "2wheeler_count" );
        
        updateSession("2wheeler_income");// , "2wheeler_income");
        
        updateSession("4wheeler_count");// , "4wheeler_count");
        
        updateSession("4wheeler_income");// , "4wheeler_income");
        
        updateSession("other_count" );//, "other_count");
        
        updateSession("other_income" );//, "other_income");
        
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
        time_str=cal.getTime().toString();
            
        
        try
        {
            String s; 
            
            MongoClient mc = new MongoClient("localhost",27017);
            DB db = mc.getDB("parking_system");
            DBCollection collection2 = db.getCollection("statistics");
            
            
            BasicDBObject query = new BasicDBObject();
            BasicDBObject field = new BasicDBObject();
            field.put("time", 1);
    
            DBCursor cursor = collection2.find(query, field);

            BasicDBObject obj = (BasicDBObject) cursor.next();
            s = obj.getString("time");
            System.out.println(s);

            
            BasicDBObject searchUpdate = new BasicDBObject();
            searchUpdate.append("time", s);

            BasicDBObject UpdateObject = new BasicDBObject();
            UpdateObject.append("$set", new BasicDBObject("time", time_str));

            collection2.update(searchUpdate, UpdateObject);
        
        }
        catch(Exception e)
        {
        
        }
        JOptionPane.showMessageDialog(null,"Session Details Cleared!");
        
        setVisible(false);
        new Admin_rights().setVisible(true);
        
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void done_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done_buttonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Admin_rights().setVisible(true);
    }//GEN-LAST:event_done_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Session_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Session_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Session_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Session_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Session_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_button;
    private javax.swing.JButton done_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField other_cnt_field;
    private javax.swing.JTextField other_income_field;
    private javax.swing.JTextField time_field;
    private javax.swing.JTextField wheeler2_cnt_field;
    private javax.swing.JTextField wheeler2_income_field;
    private javax.swing.JTextField wheeler4_cnt_field;
    private javax.swing.JTextField wheeler4_income_field;
    // End of variables declaration//GEN-END:variables
}
