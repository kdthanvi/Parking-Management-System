/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */

import java.text.SimpleDateFormat;
import com.mongodb.BasicDBObject;
import com.mongodb.*;
import com.sun.jmx.snmp.BerDecoder;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.CatchNode;


public class Vehicle_exit extends javax.swing.JFrame {
   
   String vehno, vehno_copy;// int Token;
   String vehno_db;//int db_token;
   
   //int validator=0;
   int flag=0;
   int veh_count;
   long in_time_mills, exit_time_mills, time_diff = 0;
   //int charges;
   long charges;
   String exit_time_str;
    
    /*
    Date d1 = null;
    Date d2 = null;
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      */  
    /**
     * Creates new form Vehicle_exit
     */
    
    
    public Vehicle_exit(int count) {
        initComponents();
        veh_count = count;
        
        System.out.println(count+"and "+veh_count);
        
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat date=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        //System.out.println(cal.getTime());
        exit_time_str=cal.getTime().toString();
        exit_time_field.setText(exit_time_str);
        
        exit_time_mills = System.currentTimeMillis();
    
        fetch();
    }

    
    
    public void fetch()
    {
        try
        {
            MongoClient mc = new MongoClient("localhost",27017);
            DB db = mc.getDB("parking_system");
            DBCollection collectionx = db.getCollection("entry_info");
        
            
            if(veh_count == 2)
            {
             
                BasicDBObject queryx = new BasicDBObject();
                BasicDBObject fieldx = new BasicDBObject();
                fieldx.put("vehno",1);
                DBCursor cursorx = collectionx.find(queryx,fieldx);
       
                while(cursorx.hasNext())
                {
            
                    System.out.println("hmmmWOW---n");
                    BasicDBObject objx = (BasicDBObject)cursorx.next();
               
                    char [] temp;
                    temp = objx.getString("vehno").toCharArray();
                    char last;
                    last = temp[temp.length-1];
                
                    if(last=='2')
                    {
                
                        vehno_combo.addItem(objx.get("vehno").toString());
                        
                    }
                    System.out.println("hello");
            
                }
            }
            else if(veh_count == 4)
            {
             
                BasicDBObject queryx = new BasicDBObject();
                BasicDBObject fieldx = new BasicDBObject();
                fieldx.put("vehno",1);
                DBCursor cursorx = collectionx.find(queryx,fieldx);
       
                while(cursorx.hasNext())
                {
            
                    System.out.println("hmmmWOW---n");
                    BasicDBObject objx = (BasicDBObject)cursorx.next();
               
                    char [] temp;
                    temp = objx.getString("vehno").toCharArray();
                    char last;
                    last = temp[temp.length-1];
                
                    if(last=='4')
                    {
                
                        vehno_combo.addItem(objx.get("vehno").toString());
                        //vehno = vehno_combo.getSelectedItem().toString();
                    }
                    System.out.println("hello");
            
                }
            }
            
            else 
            {
             
                BasicDBObject queryx = new BasicDBObject();
                BasicDBObject fieldx = new BasicDBObject();
                fieldx.put("vehno",1);
                DBCursor cursorx = collectionx.find(queryx,fieldx);
       
                while(cursorx.hasNext())
                {
            
                    System.out.println("hmmmWOW---n");
                    BasicDBObject objx = (BasicDBObject)cursorx.next();
               
                    char [] temp;
                    temp = objx.getString("vehno").toCharArray();
                    char last;
                    last = temp[temp.length-1];
                
                    if(last=='6')
                    {
                
                        vehno_combo.addItem(objx.get("vehno").toString());
                        //vehno = vehno_combo.getSelectedItem().toString();
                    }
                    System.out.println("hello");
            
                }
            }
        }
        catch(Exception e)
        {
        }
    }
    
    
    public boolean validate2()
    {
        if(checkPassingCode())
        {
            if(checkVehno())
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Enter Valid Vehicle No");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter Valid Passing Number");
        }
        return false;
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
        jLabel4 = new javax.swing.JLabel();
        exit_time_field = new javax.swing.JTextField();
        Exit_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        vehno_combo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PARKING ENTRY MANAGEMENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 420, 69));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Out Time : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 31));

        exit_time_field.setEditable(false);
        exit_time_field.setAutoscrolls(false);
        exit_time_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        exit_time_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_time_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(exit_time_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 189, 35));

        Exit_button.setText("Exit");
        Exit_button.setBorder(null);
        Exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Exit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 100, 40));

        cancel_button.setText("Cancel");
        cancel_button.setBorder(null);
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(cancel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 90, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Vehicle No. : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 130, 30));

        vehno_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        vehno_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehno_comboActionPerformed(evt);
            }
        });
        getContentPane().add(vehno_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 190, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\DBMS Project\\Parking_Project\\Images\\oak-wood.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_buttonActionPerformed
        // TODO add your handling code here:
            
      try
      {
          vehno = vehno_combo.getSelectedItem().toString();
            vehno_copy = vehno;
            System.out.println("in button number niald"+vehno);
        
            MongoClient mc = new MongoClient("localhost",27017);
            DB db = mc.getDB("parking_system");
            DBCollection collection = db.getCollection("entry_info");
            
            BasicDBObject query_time = new BasicDBObject();
            BasicDBObject field_time = new BasicDBObject();
            field_time.put("intime",1);
            DBCursor cursor = collection.find(query_time,field_time);
        
            BasicDBObject query_token = new BasicDBObject();
            BasicDBObject field_token = new BasicDBObject();
            field_time.put("vehno",1);
            DBCursor cursor_token = collection.find(query_token,field_token);
        
            while(cursor.hasNext())
            {
                BasicDBObject obj_time = (BasicDBObject)cursor.next();
                in_time_mills = Long.parseLong(obj_time.getString("intime"));
            
                BasicDBObject obj_token = (BasicDBObject)cursor_token.next();
                //db_token = obj_token.getInt("_id");
                vehno_db = obj_token.getString("vehno");
                System.out.println(vehno_db);
                System.out.println("hello");
            
                System.out.println("hey ayu");
        
                DBCollection collection1 = db.getCollection("vehicle_count");
                DBCollection collection2 = db.getCollection("statistics");
                vehno = vehno_copy;
                if(veh_count == 2)
                {
                    //vehno = vehno + "W2";
                    
                    if(vehno.equals(vehno_db))
                    {
                        
                        flag = 1;
                        
                        BasicDBObject deleteObject = new BasicDBObject();
                        //deleteObject.put("_id",Token);
                        deleteObject.put("vehno",vehno);
                        DBCursor findQuery = collection.find(deleteObject);
                         collection.remove(deleteObject);
       
                    
                        int count_bike;
                        BasicDBObject query = new BasicDBObject();
                        BasicDBObject field = new BasicDBObject();
                        field.put("wheeler_2", 1);
                        DBCursor cursor1 = collection1.find(query, field);
                    
                        BasicDBObject obj = (BasicDBObject) cursor1.next();
                        count_bike = obj.getInt("wheeler_2");
                
                        System.out.println(count_bike);

                        BasicDBObject searchUpdate = new BasicDBObject();
                        searchUpdate.append("wheeler_2", count_bike);

                        BasicDBObject UpdateObject = new BasicDBObject();
                        UpdateObject.append("$set", new BasicDBObject("wheeler_2", count_bike - 1));

                        collection1.update(searchUpdate, UpdateObject);
                
                        System.out.println("Checking...");
                    
                        time_diff = exit_time_mills - in_time_mills;
                        time_diff = time_diff/1000;
                        time_diff = time_diff/60;
                        System.out.println("difftime"+time_diff);
                        if(time_diff > 60)
                            charges = 20 + (time_diff)/2;
                        else
                            charges = 20;
                    
                        
                    //updating session...
                    
                    int income_bike;
                    BasicDBObject query2 = new BasicDBObject();
                    BasicDBObject field2 = new BasicDBObject();
                    field2.put("2wheeler_income", 1);
                    DBCursor cursor2 = collection2.find(query2, field2);

                    BasicDBObject obj2 = (BasicDBObject) cursor2.next();
                    income_bike = obj2.getInt("2wheeler_income");
                    System.out.println(income_bike);

                    BasicDBObject searchUpdate2 = new BasicDBObject();
                    searchUpdate2.append("2wheeler_income", income_bike);

                    BasicDBObject UpdateObject2 = new BasicDBObject();
                    UpdateObject2.append("$set", new BasicDBObject("2wheeler_income", income_bike + charges));

                    collection2.update(searchUpdate2, UpdateObject2);
                        
                        JOptionPane.showMessageDialog(null, "Vehicle Out !\n" +
                            /*"In Time : " + in_time_mills + "\n" +*/
                            "Extra Parking Time : " + time_diff + "Min.\n" +
                            "Charges : " + charges  );
                
                        System.out.println("Checked...");
                    
                        setVisible(false);
                        new Entry_OR_Exit().setVisible(true);
                        break;
                    }
                }
  
                else if(veh_count == 4)
                {
                    
                    //vehno = vehno + "W4";
                    
                    if(vehno.equals(vehno_db))
                    {
                        
                        flag = 1;
                        
                        BasicDBObject deleteObject = new BasicDBObject();
                        //deleteObject.put("_id",Token);
                        deleteObject.put("vehno",vehno);
                        DBCursor findQuery = collection.find(deleteObject);
                         collection.remove(deleteObject);
       
                    int count_car;
                
                        BasicDBObject query = new BasicDBObject();
                        BasicDBObject field = new BasicDBObject();
                        field.put("wheeler_4",1);
                        DBCursor cursor1 = collection1.find(query,field);
        
                        BasicDBObject obj = (BasicDBObject)cursor1.next();
                        count_car = obj.getInt("wheeler_4");
                        System.out.println(count_car);
            
                        BasicDBObject searchUpdate = new BasicDBObject();
                        searchUpdate.append("wheeler_4", count_car);

                        BasicDBObject UpdateObject = new BasicDBObject();
                        UpdateObject.append("$set", new BasicDBObject("wheeler_4",count_car-1));

                        collection1.update(searchUpdate, UpdateObject);
     
                        System.out.println("Checking...2");
                        
                        time_diff = exit_time_mills - in_time_mills;
                        time_diff = time_diff/1000;
                        time_diff = time_diff/60;
                        System.out.println("difftime"+time_diff);
                        if(time_diff > 60)
                            charges = 40 + (time_diff)*3/2;
                        else
                            charges = 40;
                        
                        //Session update....
                        
                    int income_car;
                    BasicDBObject query2 = new BasicDBObject();
                    BasicDBObject field2 = new BasicDBObject();
                    field2.put("4wheeler_income", 1);
                    DBCursor cursor2 = collection2.find(query2, field2);

                    BasicDBObject obj2 = (BasicDBObject) cursor2.next();
                    income_car = obj2.getInt("4wheeler_income");
                    System.out.println(income_car);

                    BasicDBObject searchUpdate2 = new BasicDBObject();
                    searchUpdate2.append("4wheeler_income", income_car);

                    BasicDBObject UpdateObject2 = new BasicDBObject();
                    UpdateObject2.append("$set", new BasicDBObject("4wheeler_income", income_car + charges));

                    collection2.update(searchUpdate2, UpdateObject2);
                    
                    
                        
                        JOptionPane.showMessageDialog(null, "Vehicle Out !\n" +
                        /*"In Time : " + in_time_mills + "\n" +*/
                        "Extra Parking Time : " + time_diff + "Min.\n" +
                        "Charges : " + charges  );
                        
                        System.out.println("Checking...2");
                        
                        setVisible(false);
                        new Entry_OR_Exit().setVisible(true);
                        break;
                
                        }
                 }
                else
                {
                    
                    //vehno = vehno + "W6";
                    if(vehno.equals(vehno_db))
                    {
                        
                        flag = 1;
                        
                        BasicDBObject deleteObject = new BasicDBObject();
                        //deleteObject.put("_id",Token);
                        deleteObject.put("vehno",vehno);
                        DBCursor findQuery = collection.find(deleteObject);
                         collection.remove(deleteObject);
       
                    int count_other;

                    BasicDBObject query = new BasicDBObject();
                    BasicDBObject field = new BasicDBObject();
                    field.put("other", 1);
                    DBCursor cursor1 = collection1.find(query, field);

                    BasicDBObject obj = (BasicDBObject)cursor1.next();
                    count_other = obj.getInt("other");
                    
                    System.out.println(count_other);

                    BasicDBObject searchUpdate = new BasicDBObject();
                    searchUpdate.append("other", count_other);
                    
                    BasicDBObject UpdateObject = new BasicDBObject();
                    UpdateObject.append("$set", new BasicDBObject("other", count_other - 1));

                    collection1.update(searchUpdate, UpdateObject);
                
                    System.out.println("Checking...3");
                    
                    time_diff = exit_time_mills - in_time_mills;
                    time_diff = time_diff/1000;
                    time_diff = time_diff/60;
                    System.out.println("difftime"+time_diff);
                    if(time_diff > 60)
                        charges = 60 + (time_diff);
                    else
                        charges = 60;
                
                    //sessiuon update....
                    
                    int income_other;
                    BasicDBObject query2 = new BasicDBObject();
                    BasicDBObject field2 = new BasicDBObject();
                    field2.put("other_income", 1);
                    DBCursor cursor2 = collection2.find(query2, field2);

                    BasicDBObject obj2 = (BasicDBObject) cursor2.next();
                    income_other = obj2.getInt("other_income");
                    System.out.println(income_other);

                    BasicDBObject searchUpdate2 = new BasicDBObject();
                    searchUpdate2.append("other_income", income_other);

                    BasicDBObject UpdateObject2 = new BasicDBObject();
                    UpdateObject2.append("$set", new BasicDBObject("other_income", income_other + charges));

                    collection2.update(searchUpdate2, UpdateObject2);
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Vehicle Out !\n" +
                        /*"In Time : " + in_time_mills + "\n" +*/
                        "Extra Parking Time : " + time_diff + "Min.\n" +
                        "Charges : " + charges  );
                    
                    System.out.println("Checked...3");
                    setVisible(false);
                    new Entry_OR_Exit().setVisible(true);
                    break;
                
                    }
                }
            //}
        }
        if(flag == 0)
        {
            JOptionPane.showMessageDialog(null, "Invalid Vehicle Number or Type");
            setVisible(false);
            new Entry_OR_Exit().setVisible(true);
        }   
        /*
        BasicDBObject searchUpdate = new BasicDBObject();
        searchUpdate.append("wheeler_2", count_bike);

        BasicDBObject UpdateObject = new BasicDBObject();
        UpdateObject.append("$set", new BasicDBObject("wheeler_2", count_bike + 1));

        collection.update(searchUpdate, UpdateObject);

        */
        //}
     }
     catch(Exception e)
      {
      
      }
             
    }//GEN-LAST:event_Exit_buttonActionPerformed

    private void exit_time_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_time_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exit_time_fieldActionPerformed

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Entry_OR_Exit().setVisible(true);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void vehno_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehno_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehno_comboActionPerformed

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
            java.util.logging.Logger.getLogger(Vehicle_exit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vehicle_exit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vehicle_exit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vehicle_exit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vehicle_exit().setVisible(true);
                /*
                    DawNi Error....ASK
                */
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit_button;
    private javax.swing.JButton cancel_button;
    private javax.swing.JTextField exit_time_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox vehno_combo;
    // End of variables declaration//GEN-END:variables
}
