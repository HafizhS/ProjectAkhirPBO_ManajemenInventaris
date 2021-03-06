package ManajemenInventaris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.scripts.JO;

public class Manajemen_PeminjamanBarangPanel extends javax.swing.JPanel {

    private Manajemen_Main parent;
    public boolean isAlreadyInit = false;
    private PeminjamanBarang_AfterPinjamButtonPanel darkPanel = null;
    public int idMurid;
    int id_detail_peminjaman;
    int id_peminjaman;
    Connection koneksi;

    public Manajemen_PeminjamanBarangPanel(Manajemen_Main parent, int id_murid) throws IOException {
        this.parent = parent;
        this.idMurid = id_murid;
        initComponents();
        initGambar();
        random_code.setVisible(false);
        random_code1.setVisible(false);
        try {
            ResultSet rs = getDataFromDB(idMurid);
            if (rs.next()) {
                label_namaPeminjam.setText(rs.getString("nama"));
                label_kelasPeminjam.setText(rs.getString("nama_kelas"));
                label_nis.setText(rs.getInt("nis") + "");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        koneksi = DBconnection.getKoneksi();
        random_detail_peminjaman();
        random();
    }

    Manajemen_PeminjamanBarangPanel(Manajemen_Main aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initGambar() throws IOException {
        BufferedImage harapScan = ImageIO.read(new File("image\\scanning_onboarding.png"));
        BufferedImage pinjamBtn = ImageIO.read(new File("image\\button\\pinjam_btn.png"));

        label_gambarHarapScan.setIcon(new ImageIcon(harapScan.getScaledInstance(harapScan.getWidth(), harapScan.getHeight(), Image.SCALE_SMOOTH)));
        label_gambarHarapScan.setText("");
        button_pinjam.setIcon(new ImageIcon(pinjamBtn.getScaledInstance(pinjamBtn.getWidth(), pinjamBtn.getHeight(), Image.SCALE_SMOOTH)));
        button_pinjam.setText("");
    }

    private ResultSet getDataFromDB(int primarykey) throws SQLException {
        String query = "SELECT * FROM tbl_murid JOIN tbl_kelas ON tbl_kelas.id_kelas = tbl_murid.id_kelas WHERE id_murid = '" + primarykey + "'";
        return DBconnection.getKoneksi().createStatement().executeQuery(query);
    }

    public void random() {

        Random random = new Random();
        for (int i = 1; i <= 1; i++) {
            id_peminjaman = 1 + random.nextInt(100000);
        }
        random_code.setText(id_peminjaman + "");
    }

    public void random_detail_peminjaman() {

        Random random = new Random();
        for (int i = 1; i <= 1; i++) {
            id_detail_peminjaman = 1 + random.nextInt(1000);
        }
        random_code1.setText(id_detail_peminjaman + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_gambarHarapScan = new javax.swing.JLabel();
        label_titleDataPeminjam = new javax.swing.JLabel();
        label_dataNamaPeminjam = new javax.swing.JLabel();
        label_dataKelasPeminjam = new javax.swing.JLabel();
        label_namaPeminjam = new javax.swing.JLabel();
        label_kelasPeminjam = new javax.swing.JLabel();
        label_titleBarangDipinjam = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_barangDipinjam = new javax.swing.JTable();
        button_home = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_title = new javax.swing.JLabel();
        button_pinjam = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        code = new javax.swing.JTextField();
        random_code = new javax.swing.JLabel();
        random_code1 = new javax.swing.JLabel();
        label_dataKelasPeminjam1 = new javax.swing.JLabel();
        label_nis = new javax.swing.JLabel();
        btnDelete = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(255, 255, 255));

        label_gambarHarapScan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_gambarHarapScan.setText("gambar_harapScan");
        label_gambarHarapScan.setToolTipText("");
        label_gambarHarapScan.setMaximumSize(new java.awt.Dimension(413, 450));
        label_gambarHarapScan.setMinimumSize(new java.awt.Dimension(413, 450));
        label_gambarHarapScan.setPreferredSize(new java.awt.Dimension(413, 450));

        label_titleDataPeminjam.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleDataPeminjam.setForeground(new java.awt.Color(51, 102, 255));
        label_titleDataPeminjam.setText("Data Peminjam : ");

        label_dataNamaPeminjam.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_dataNamaPeminjam.setForeground(new java.awt.Color(102, 153, 255));
        label_dataNamaPeminjam.setText("Atas Nama :");

        label_dataKelasPeminjam.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_dataKelasPeminjam.setForeground(new java.awt.Color(102, 153, 255));
        label_dataKelasPeminjam.setText("Kelas           :");

        label_namaPeminjam.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_namaPeminjam.setForeground(new java.awt.Color(102, 153, 255));
        label_namaPeminjam.setText("{nama}");

        label_kelasPeminjam.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_kelasPeminjam.setForeground(new java.awt.Color(102, 153, 255));
        label_kelasPeminjam.setText("{kelas}");

        label_titleBarangDipinjam.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titleBarangDipinjam.setForeground(new java.awt.Color(51, 102, 255));
        label_titleBarangDipinjam.setText("Barang Yang Dipinjam :");

        table_barangDipinjam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        table_barangDipinjam.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        table_barangDipinjam.setForeground(new java.awt.Color(51, 153, 255));
        table_barangDipinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Barang", "Barcode ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_barangDipinjam.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        table_barangDipinjam.setFillsViewportHeight(true);
        table_barangDipinjam.setGridColor(new java.awt.Color(51, 153, 255));
        table_barangDipinjam.setRowHeight(40);
        table_barangDipinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_barangDipinjamMouseClicked(evt);
            }
        });
        table_barangDipinjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_barangDipinjamKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(table_barangDipinjam);
        if (table_barangDipinjam.getColumnModel().getColumnCount() > 0) {
            table_barangDipinjam.getColumnModel().getColumn(0).setHeaderValue("Nama Barang");
            table_barangDipinjam.getColumnModel().getColumn(1).setHeaderValue("Barcode ID");
        }

        button_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_home.setText("button_home");
        button_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_homeMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(102, 153, 255));

        label_title.setBackground(new java.awt.Color(204, 204, 204));
        label_title.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        label_title.setForeground(new java.awt.Color(102, 153, 255));
        label_title.setText("Peminjaman Barang");

        button_pinjam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_pinjam.setText("button_pinjam");
        button_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_pinjamMouseClicked(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jButton1.setText("Scan");

        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeKeyPressed(evt);
            }
        });

        random_code.setText("jLabel1");

        random_code1.setText("jLabel1");

        label_dataKelasPeminjam1.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_dataKelasPeminjam1.setForeground(new java.awt.Color(102, 153, 255));
        label_dataKelasPeminjam1.setText("NIS           :");

        label_nis.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        label_nis.setForeground(new java.awt.Color(102, 153, 255));
        label_nis.setText("{NIS}");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label_title)
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(random_code, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(random_code1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_titleDataPeminjam)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label_dataNamaPeminjam)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(label_namaPeminjam))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label_dataKelasPeminjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(label_kelasPeminjam))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(label_dataKelasPeminjam1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(label_nis)))
                                            .addComponent(label_titleBarangDipinjam))))
                                .addGap(154, 186, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_gambarHarapScan, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(random_code1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(random_code, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_title)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_titleDataPeminjam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_dataNamaPeminjam)
                            .addComponent(label_namaPeminjam))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_dataKelasPeminjam)
                            .addComponent(label_kelasPeminjam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_dataKelasPeminjam1)
                            .addComponent(label_nis, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(2, 2, 2)
                        .addComponent(label_titleBarangDipinjam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 463, Short.MAX_VALUE))
                    .addComponent(label_gambarHarapScan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_homeMouseClicked
        this.parent.backToHome(this);
//        this.parent.remove(darkPanel);
    }//GEN-LAST:event_button_homeMouseClicked

    private void button_pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_pinjamMouseClicked
        if (table_barangDipinjam.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Anda tidak meminjam apapun");
        } else {
            if (!this.isAlreadyInit) {
                this.setVisible(false);
                int row = table_barangDipinjam.getRowCount();
                darkPanel = new PeminjamanBarang_AfterPinjamButtonPanel(parent, label_nis.getText(), row, id_peminjaman);
                this.parent.add(darkPanel, BorderLayout.CENTER);
                darkPanel.setBackground(new Color(0, 0, 0, 50));
                darkPanel.setVisible(true);
                isAlreadyInit = true;
            }

        }

    }//GEN-LAST:event_button_pinjamMouseClicked

    private void codeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String sql = "SELECT * FROM tbl_barang WHERE id_barcode = '" + code.getText() + "' AND "
                        + "kondisi_barang = 'baik' OR kondisi_barang = 'normal' ";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    for (int x = 0; x < table_barangDipinjam.getRowCount(); x++) {
                        if (code.getText().equals(table_barangDipinjam.getValueAt(x, 1))) {
                            JOptionPane.showMessageDialog(null, "Tidak boleh scan barang lebih dari 1x dengan barcode yang sama");
                        } else {
                            System.out.println(sql);
                            insertData();
                            loadTable();
                        }
                    }
                }
                code.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_codeKeyPressed

    private void table_barangDipinjamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_barangDipinjamKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_table_barangDipinjamKeyPressed
    int baris;
    private void table_barangDipinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barangDipinjamMouseClicked
        baris = table_barangDipinjam.getSelectedRow();
    }//GEN-LAST:event_table_barangDipinjamMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String idWhoWantToBeDelete = table_barangDipinjam.getValueAt(baris, 1).toString();

        try {
            Statement stmt = koneksi.createStatement();
            String query = "DELETE FROM tbl_detail_peminjaman WHERE id_barang = '" + idWhoWantToBeDelete + "';";
            System.out.println(query);
            stmt.executeUpdate(query);
            loadTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    DefaultTableModel dtm;

    public void loadTable() {
        String[] kolom = {"Nama Barang", "ID Barcode"};
        dtm = new DefaultTableModel(null, kolom);

        try {
            String sql = "SELECT * FROM tbl_detail_peminjaman "
                    + "INNER JOIN tbl_barang ON (tbl_detail_peminjaman.id_barang = tbl_barang.id_barcode) "
                    + "WHERE tbl_detail_peminjaman.id_peminjaman = '" + id_peminjaman + "'";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                dtm.addRow(new String[]{
                    rs.getString("nama_barang"), rs.getString("id_barcode")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        table_barangDipinjam.setModel(dtm);
    }

    public void insertData() {
        try {
            String sql = "INSERT INTO tbl_detail_peminjaman VALUES('" + id_detail_peminjaman + "', '" + id_peminjaman + "','" + code.getText() + "', '1')";
            Statement stmt = koneksi.createStatement();
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDelete;
    private javax.swing.JLabel button_home;
    private javax.swing.JLabel button_pinjam;
    private javax.swing.JTextField code;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_dataKelasPeminjam;
    private javax.swing.JLabel label_dataKelasPeminjam1;
    private javax.swing.JLabel label_dataNamaPeminjam;
    private javax.swing.JLabel label_gambarHarapScan;
    private javax.swing.JLabel label_kelasPeminjam;
    private javax.swing.JLabel label_namaPeminjam;
    private javax.swing.JLabel label_nis;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_titleBarangDipinjam;
    private javax.swing.JLabel label_titleDataPeminjam;
    private javax.swing.JLabel random_code;
    private javax.swing.JLabel random_code1;
    private javax.swing.JTable table_barangDipinjam;
    // End of variables declaration//GEN-END:variables
}
