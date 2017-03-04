/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import com.mysql.jdbc.Statement;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import src.koneksi;

public class form_barang extends javax.swing.JFrame {

    private Statement statement;
    private ResultSet resultset;
    private koneksi koneksi;
    private String id_delete;
    private ResultSet resultSet;
    
    /**
     * Creates new form form_barang
     */
    public form_barang() {
        initComponents();
        koneksi = new koneksi();
        Select();
        PanggilKategoriToComboBox();
    }

    
    private void Select() {
        try {
            String header[] = {"ID BARANG", "KATEGORI", "NAMA_BARANG", "STOK", "HARGA JUAL"};
            DefaultTableModel defaultTableModel = new DefaultTableModel(null, header);
            Tabel_Barang.setModel(defaultTableModel);


            int baris = Tabel_Barang.getSelectedRow();

            for (int i = 0; i < baris; i++) {
                defaultTableModel.removeRow(i);
            }

            String sql = "select * from barang";
            statement = (Statement) koneksi.connection.createStatement();
            resultset = statement.executeQuery(sql);

            while (resultset.next()) {

                String id_barang = resultset.getString(1);
                String ComboBoxK = resultset.getString(2);
                String Nma_Barang = resultset.getString(3);
                String Stok = resultset.getString(4);
                String hrg = resultset.getString(5);
              
                Object isi[] = {id_barang, ComboBoxK, Nma_Barang, Stok, hrg};
                defaultTableModel.addRow(isi);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

     private void insert(){
        try {

            String sql="insert into barang values('"+id_barang.getText()+"','"+kategori.getSelectedItem()+"','" +Nma_Barang.getText()+"','"+Stok.getText()+"','" + harga.getText() + "' )";
            statement.executeUpdate(sql);

        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void delete() {
        try {
            String query = "delete from barang where id_barang='" + id_barang.getText() + "'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data telah terpakai");
        }
    }


    private void clear() {
        id_barang.setText("");
        Nma_Barang.setText("");
        Stok.setText("");
    }

    public void update_barang(){

         //panggil method koneksi
        java.sql.Connection conn = new koneksi().connection;


        String sql="update barang set KATEGORI=?, NAMA_BARANG=?, STOK=?, HARGA_JUAL=? where ID_BARANG='"+id_barang.getText()+"'";
        java.sql.PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
        } catch (Exception ex) {
        }

        try{
            stmt.setString(4,harga.getText());
            stmt.setString(3,Stok.getText());
            stmt.setString(2,Nma_Barang.getText());
            stmt.setString(1,kategori.getSelectedItem().toString());



            stmt.executeUpdate();


        }catch(Exception se){
            JOptionPane.showMessageDialog(null, (se.getMessage()));
        }
    }

    private void PanggilKategoriToComboBox() {
        try {
            kategori.removeAllItems();
            String sql = "select KATEGORI from kategori";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                kategori.addItem(resultSet.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id_barang = new javax.swing.JTextField();
        Nma_Barang = new javax.swing.JTextField();
        Stok = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_Barang = new javax.swing.JTable();
        kategori = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        harga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("FORM DAFTAR BARANG BARU");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(187, 20, 322, 21);

        jLabel2.setText("ID BARANG");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 55, 55, 14);

        jLabel3.setText("KATEGORI");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 94, 51, 14);

        jLabel4.setText("NAMA BARANG");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 134, 73, 14);

        jLabel5.setText("STOK");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 172, 26, 14);

        id_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_barangKeyPressed(evt);
            }
        });
        getContentPane().add(id_barang);
        id_barang.setBounds(136, 52, 203, 20);
        getContentPane().add(Nma_Barang);
        Nma_Barang.setBounds(136, 131, 203, 20);
        getContentPane().add(Stok);
        Stok.setBounds(136, 169, 203, 20);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 358, 65, 23);

        jButton2.setText("Insert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(507, 358, 61, 23);

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(574, 358, 51, 23);

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(631, 358, 63, 23);

        Tabel_Barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabel_Barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_BarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel_Barang);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(73, 250, 544, 102);

        kategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(kategori);
        kategori.setBounds(136, 91, 203, 20);

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(349, 90, 41, 23);
        getContentPane().add(harga);
        harga.setBounds(136, 207, 203, 20);

        jLabel6.setText("HARGA");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 210, 35, 14);

        setBounds(0, 0, 736, 431);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (id_barang.getText().equalsIgnoreCase("") || Nma_Barang.getText().equalsIgnoreCase("") || Stok.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Lengkapi Inputan Anda");
        } else {
            insert();
            Select();
            clear();
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Select();
        update_barang();
        Select();
        clear(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         if (id_barang.getText().equals("") ||Nma_Barang.getText().equals("")||Stok.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di Hapus");
        } else {

        delete();
        Select();
        clear();
    }  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Tabel_BarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_BarangMouseClicked
        // TODO add your handling code here:
      id_barang.setText(Tabel_Barang.getValueAt(Tabel_Barang.getSelectedRow(),0).toString());
      Stok.setText(Tabel_Barang.getValueAt(Tabel_Barang.getSelectedRow(),3).toString());
       Nma_Barang.setText(Tabel_Barang.getValueAt(Tabel_Barang.getSelectedRow(),2).toString());
       kategori.setSelectedItem(Tabel_Barang.getValueAt(Tabel_Barang.getSelectedRow(),1).toString());
    }//GEN-LAST:event_Tabel_BarangMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        form_kategori cat;
        cat = new form_kategori();
        cat.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void id_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_barangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (id_barang.getText().equalsIgnoreCase("") || Nma_Barang.getText().equalsIgnoreCase("") || Stok.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Silahkan Lengkapi Inputan Anda");
            } else {
                insert();
                Select();
                clear();
            }
        }
    }//GEN-LAST:event_id_barangKeyPressed

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
            java.util.logging.Logger.getLogger(form_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nma_Barang;
    private javax.swing.JTextField Stok;
    private javax.swing.JTable Tabel_Barang;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField id_barang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox kategori;
    // End of variables declaration//GEN-END:variables
}