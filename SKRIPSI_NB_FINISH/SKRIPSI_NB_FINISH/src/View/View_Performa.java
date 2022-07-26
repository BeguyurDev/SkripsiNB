package View;

import Controller.c_dokumenManager;
import Controller.c_hitungConfusionMatrix;
import Controller.c_hitungNaiveBayes;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class View_Performa extends javax.swing.JFrame {

    c_hitungNaiveBayes nb;
    c_dokumenManager DokumenDataManager;
    c_hitungConfusionMatrix CMStadium0;
    c_hitungConfusionMatrix CMStadium1;
    c_hitungConfusionMatrix CMStadium2;
    c_hitungConfusionMatrix CMStadium3;
    c_hitungConfusionMatrix CMStadium4;

    public View_Performa() {

        DokumenDataManager = new c_dokumenManager();

        initComponents();
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(this.getSize()));
        this.setTitle("Multiclass Classicication Stadium Penyakit Jantung");

    }

    private boolean inputValidation(List<List<String>> DataTrainingList, List<List<String>> DataTestingList) {

        String TrainingPath = TFTrainingPath.getText();
        String TestingPath = TFTestingpath.getText();

        if (TFTestingpath.getText().equalsIgnoreCase("") || TFTrainingPath.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Isi Alamat Data Training dan Data Testing !", "WARNING!!", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (DokumenDataManager.readData(DataTrainingList, TrainingPath) == false) {
            JOptionPane.showMessageDialog(this, "Data Training tidak ditemukan !", "WARNING!!", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (DokumenDataManager.readData(DataTestingList, TestingPath) == false) {
            JOptionPane.showMessageDialog(this, "Data Testing tidak ditemukan !", "WARNING!!", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    

    DefaultTableModel setTableModel(double perhitungan[][], String kesimpulan[][]) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
            //kolom yang akan ditampilkan
            "No", "Stadium 0", "Stadium 1", "Stadium 2", "Stadium 3", "Stadium 4", "Kelas Asli", "Prediksi", "Keterangan"});
        //dimulai dari no.1
//        int no=1;
        for (int i = 0; i < perhitungan.length; i++) {
            tableModel.addRow(new Object[]{
                (i + 1),
                perhitungan[i][0],
                perhitungan[i][1],
                perhitungan[i][2],
                perhitungan[i][3],
                perhitungan[i][4],
                kesimpulan[i][0],
                kesimpulan[i][1],
                kesimpulan[i][2],});
        }

        return tableModel;
    }

    private void showTableNB(double perhitungan[][], String kesimpulan[][]) {
        jTable1.setModel(setTableModel(perhitungan, kesimpulan));
        TableColumn col0 = jTable1.getColumnModel().getColumn(0);
        col0.setPreferredWidth(10);
        TableColumn col6 = jTable1.getColumnModel().getColumn(6);
        col6.setPreferredWidth(46);
        TableColumn col7 = jTable1.getColumnModel().getColumn(7);
        col7.setPreferredWidth(46);
    }

    private int tabelConfusionMatrix(String aktual, String prediksi, String[][] kesimpulanPrediksi) {
        int count = 0;
        for (int i = 0; i < kesimpulanPrediksi.length; i++) {
            if (kesimpulanPrediksi[i][0].equals(aktual) && kesimpulanPrediksi[i][1].equals(prediksi)) {
                count++;
            }
        }
        return count;
    }

    private void showTableCM(int AktualPrediksiCM[][]) {
        jTextField00.setText(String.valueOf(AktualPrediksiCM[0][0]));
        jTextField01.setText(String.valueOf(AktualPrediksiCM[0][1]));
        jTextField02.setText(String.valueOf(AktualPrediksiCM[0][2]));
        jTextField03.setText(String.valueOf(AktualPrediksiCM[0][3]));
        jTextField04.setText(String.valueOf(AktualPrediksiCM[0][4]));
        jTextField10.setText(String.valueOf(AktualPrediksiCM[1][0]));
        jTextField11.setText(String.valueOf(AktualPrediksiCM[1][1]));
        jTextField12.setText(String.valueOf(AktualPrediksiCM[1][2]));
        jTextField13.setText(String.valueOf(AktualPrediksiCM[1][3]));
        jTextField14.setText(String.valueOf(AktualPrediksiCM[1][4]));
        jTextField20.setText(String.valueOf(AktualPrediksiCM[2][0]));
        jTextField21.setText(String.valueOf(AktualPrediksiCM[2][1]));
        jTextField22.setText(String.valueOf(AktualPrediksiCM[2][2]));
        jTextField23.setText(String.valueOf(AktualPrediksiCM[2][3]));
        jTextField24.setText(String.valueOf(AktualPrediksiCM[2][4]));
        jTextField30.setText(String.valueOf(AktualPrediksiCM[3][0]));
        jTextField31.setText(String.valueOf(AktualPrediksiCM[3][1]));
        jTextField32.setText(String.valueOf(AktualPrediksiCM[3][2]));
        jTextField33.setText(String.valueOf(AktualPrediksiCM[3][3]));
        jTextField34.setText(String.valueOf(AktualPrediksiCM[3][4]));
        jTextField40.setText(String.valueOf(AktualPrediksiCM[4][0]));
        jTextField41.setText(String.valueOf(AktualPrediksiCM[4][1]));
        jTextField42.setText(String.valueOf(AktualPrediksiCM[4][2]));
        jTextField43.setText(String.valueOf(AktualPrediksiCM[4][3]));
        jTextField44.setText(String.valueOf(AktualPrediksiCM[4][4]));
        jTextFieldJumS0.setText(String.valueOf(AktualPrediksiCM[0][0]+AktualPrediksiCM[0][1]+AktualPrediksiCM[0][2]+AktualPrediksiCM[0][3]+AktualPrediksiCM[0][4]));
        jTextFieldJumS1.setText(String.valueOf(AktualPrediksiCM[1][0]+AktualPrediksiCM[1][1]+AktualPrediksiCM[1][2]+AktualPrediksiCM[1][3]+AktualPrediksiCM[1][4]));
        jTextFieldJumS2.setText(String.valueOf(AktualPrediksiCM[2][0]+AktualPrediksiCM[2][1]+AktualPrediksiCM[2][2]+AktualPrediksiCM[2][3]+AktualPrediksiCM[2][4]));
        jTextFieldJumS3.setText(String.valueOf(AktualPrediksiCM[3][0]+AktualPrediksiCM[3][1]+AktualPrediksiCM[3][2]+AktualPrediksiCM[3][3]+AktualPrediksiCM[3][4]));
        jTextFieldJumS4.setText(String.valueOf(AktualPrediksiCM[4][0]+AktualPrediksiCM[4][1]+AktualPrediksiCM[4][2]+AktualPrediksiCM[4][3]+AktualPrediksiCM[4][4]));
        jTextFieldPredS0.setText(String.valueOf(AktualPrediksiCM[0][0]+AktualPrediksiCM[1][0]+AktualPrediksiCM[2][0]+AktualPrediksiCM[3][0]+AktualPrediksiCM[4][0]));
        jTextFieldPredS1.setText(String.valueOf(AktualPrediksiCM[0][1]+AktualPrediksiCM[1][1]+AktualPrediksiCM[2][1]+AktualPrediksiCM[3][1]+AktualPrediksiCM[4][1]));
        jTextFieldPredS2.setText(String.valueOf(AktualPrediksiCM[0][2]+AktualPrediksiCM[1][2]+AktualPrediksiCM[2][2]+AktualPrediksiCM[3][2]+AktualPrediksiCM[4][2]));
        jTextFieldPredS3.setText(String.valueOf(AktualPrediksiCM[0][3]+AktualPrediksiCM[1][3]+AktualPrediksiCM[2][3]+AktualPrediksiCM[3][3]+AktualPrediksiCM[4][3]));
        jTextFieldPredS4.setText(String.valueOf(AktualPrediksiCM[0][4]+AktualPrediksiCM[1][4]+AktualPrediksiCM[2][4]+AktualPrediksiCM[3][4]+AktualPrediksiCM[4][4]));
        int dataS0 = Integer.valueOf(jTextFieldJumS0.getText());
        int dataS1 = Integer.valueOf(jTextFieldJumS1.getText());
        int dataS2 = Integer.valueOf(jTextFieldJumS2.getText());
        int dataS3 = Integer.valueOf(jTextFieldJumS3.getText());
        int dataS4 = Integer.valueOf(jTextFieldJumS4.getText());
        int total = dataS0+dataS1+dataS2+dataS3+dataS4;
        jTextFieldTotal.setText(String.valueOf(total));
    }

    private void showPerformanceCM(int total) {

        jTextFieldPresisi0.setText(String.format(Locale.US, "%.4f", CMStadium0.getPresisi() * 100));
        jTextFieldRecall0.setText(String.format(Locale.US, "%.4f", CMStadium0.getRecall() * 100));

        jTextFieldPresisi1.setText(String.format(Locale.US, "%.4f", CMStadium1.getPresisi() * 100));
        jTextFieldRecall1.setText(String.format(Locale.US, "%.4f", CMStadium1.getRecall() * 100));

        jTextFieldPresisi2.setText(String.format(Locale.US, "%.4f", CMStadium2.getPresisi() * 100));
        jTextFieldRecall2.setText(String.format(Locale.US, "%.4f", CMStadium2.getRecall() * 100));

        jTextFieldPresisi3.setText(String.format(Locale.US, "%.4f", CMStadium3.getPresisi() * 100));
        jTextFieldRecall3.setText(String.format(Locale.US, "%.4f", CMStadium3.getRecall() * 100));

        jTextFieldPresisi4.setText(String.format(Locale.US, "%.4f", CMStadium4.getPresisi() * 100));
        jTextFieldRecall4.setText(String.format(Locale.US, "%.4f", CMStadium4.getRecall() * 100));

        double presisiRata2 = (double) (CMStadium0.getPresisi() + CMStadium1.getPresisi() + CMStadium2.getPresisi() + CMStadium3.getPresisi() + CMStadium4.getPresisi()) / (5) * 100;
        double recallRata2 = (double) (CMStadium0.getRecall() + CMStadium1.getRecall() + CMStadium2.getRecall() + CMStadium3.getRecall() + CMStadium4.getRecall()) / (5) * 100;

        jTextFieldPresisiRata2.setText(String.format(Locale.US, "%.4f", presisiRata2));
        jTextFieldRecallRata2.setText(String.format(Locale.US, "%.4f", recallRata2));

        double akurasi = (double) (CMStadium0.getTruePositive() + CMStadium1.getTruePositive() + CMStadium2.getTruePositive() + CMStadium3.getTruePositive() + CMStadium4.getTruePositive()) / (total) * 100;
        jTextFieldAkurasi.setText(String.format(Locale.US, "%.4f", akurasi));
    }

    private void kesimpulan(String kesimpulanPrediksi[][], double perhitunganNaiveBayes[][], List<List<String>> TestingList) {
        for (int i = 0; i < perhitunganNaiveBayes.length; i++) {
            //cek apakah hasil perhitungan untuk stadium 0 lebih besar
            if (perhitunganNaiveBayes[i][0] > perhitunganNaiveBayes[i][1] && perhitunganNaiveBayes[i][0] > perhitunganNaiveBayes[i][2] && perhitunganNaiveBayes[i][0] > perhitunganNaiveBayes[i][3] && perhitunganNaiveBayes[i][0] > perhitunganNaiveBayes[i][4]) {
                //indeks 0 menyimpan label aktual
                kesimpulanPrediksi[i][0] = TestingList.get(i).get(13);
                //indeks 1 menyimpan prediksi sistem
                kesimpulanPrediksi[i][1] = "Stadium 0";

                //Cek apakah hasil prediksi sistem sama dengan label aktual
                if (kesimpulanPrediksi[i][0].equalsIgnoreCase(kesimpulanPrediksi[i][1])) {
                    //indeks 2 menyimpan keterangn sama atau tidak
                    kesimpulanPrediksi[i][2] = "Sama";
                } else {
                    kesimpulanPrediksi[i][2] = "Tidak Sama";
                }
                //cek apakah hasil perhitungan untuk stadium 1 lebih besar
            } else if (perhitunganNaiveBayes[i][1] > perhitunganNaiveBayes[i][0] && perhitunganNaiveBayes[i][1] > perhitunganNaiveBayes[i][2] && perhitunganNaiveBayes[i][1] > perhitunganNaiveBayes[i][3] && perhitunganNaiveBayes[i][1] > perhitunganNaiveBayes[i][4]) {
                kesimpulanPrediksi[i][0] = TestingList.get(i).get(13);
                kesimpulanPrediksi[i][1] = "Stadium 1";
                if (kesimpulanPrediksi[i][0].equalsIgnoreCase(kesimpulanPrediksi[i][1])) {
                    kesimpulanPrediksi[i][2] = "Sama";
                } else {
                    kesimpulanPrediksi[i][2] = "Tidak Sama";
                }
                //cek apakah hasil perhitungan untuk stadium 2 lebih besar
            } else if (perhitunganNaiveBayes[i][2] > perhitunganNaiveBayes[i][0] && perhitunganNaiveBayes[i][2] > perhitunganNaiveBayes[i][1] && perhitunganNaiveBayes[i][2] > perhitunganNaiveBayes[i][3] && perhitunganNaiveBayes[i][2] > perhitunganNaiveBayes[i][4]) {
                kesimpulanPrediksi[i][0] = TestingList.get(i).get(13);
                kesimpulanPrediksi[i][1] = "Stadium 2";
                if (kesimpulanPrediksi[i][0].equalsIgnoreCase(kesimpulanPrediksi[i][1])) {
                    kesimpulanPrediksi[i][2] = "Sama";
                } else {
                    kesimpulanPrediksi[i][2] = "Tidak Sama";
                }
                //cek apakah hasil perhitungan untuk stadium 3 lebih besar
            } else if (perhitunganNaiveBayes[i][3] > perhitunganNaiveBayes[i][0] && perhitunganNaiveBayes[i][3] > perhitunganNaiveBayes[i][1] && perhitunganNaiveBayes[i][3] > perhitunganNaiveBayes[i][2] && perhitunganNaiveBayes[i][3] > perhitunganNaiveBayes[i][4]) {
                kesimpulanPrediksi[i][0] = TestingList.get(i).get(13);
                kesimpulanPrediksi[i][1] = "Stadium 3";
                if (kesimpulanPrediksi[i][0].equalsIgnoreCase(kesimpulanPrediksi[i][1])) {
                    kesimpulanPrediksi[i][2] = "Sama";
                } else {
                    kesimpulanPrediksi[i][2] = "Tidak Sama";
                }
                //cek apakah hasil perhitungan untuk stadium 4 lebih besar
            } else {
                kesimpulanPrediksi[i][0] = TestingList.get(i).get(13);
                kesimpulanPrediksi[i][1] = "Stadium 4";
                if (kesimpulanPrediksi[i][0].equalsIgnoreCase(kesimpulanPrediksi[i][1])) {
                    kesimpulanPrediksi[i][2] = "Sama";
                } else {
                    kesimpulanPrediksi[i][2] = "Tidak Sama";
                }
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TFTrainingPath = new javax.swing.JTextField();
        btnBrowseTraining = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TFTestingpath = new javax.swing.JTextField();
        btnUji = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnBrowseTesting = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField00 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField01 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField02 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField03 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField04 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextFieldPredS0 = new javax.swing.JTextField();
        jTextFieldPredS1 = new javax.swing.JTextField();
        jTextFieldPredS2 = new javax.swing.JTextField();
        jTextFieldPredS3 = new javax.swing.JTextField();
        jTextFieldPredS4 = new javax.swing.JTextField();
        jTextFieldJumS0 = new javax.swing.JTextField();
        jTextFieldJumS1 = new javax.swing.JTextField();
        jTextFieldJumS2 = new javax.swing.JTextField();
        jTextFieldJumS3 = new javax.swing.JTextField();
        jTextFieldJumS4 = new javax.swing.JTextField();
        jTextFieldTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextFieldPresisi0 = new javax.swing.JTextField();
        jTextFieldPresisi1 = new javax.swing.JTextField();
        jTextFieldPresisi2 = new javax.swing.JTextField();
        jTextFieldPresisi3 = new javax.swing.JTextField();
        jTextFieldPresisi4 = new javax.swing.JTextField();
        jTextFieldRecall1 = new javax.swing.JTextField();
        jTextFieldRecall2 = new javax.swing.JTextField();
        jTextFieldRecall0 = new javax.swing.JTextField();
        jTextFieldRecall4 = new javax.swing.JTextField();
        jTextFieldRecall3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldPresisiRata2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldRecallRata2 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jTextFieldAkurasi = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel1.setText("Multiclass Classification Stadium Penyakit Jantung");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel2.setText("Menggunakan Metode Naive Bayes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Data Training");

        TFTrainingPath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBrowseTraining.setText("Browse");
        btnBrowseTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseTrainingActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Data Testing");

        TFTestingpath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnUji.setText("Uji Performa");
        btnUji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUjiActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBrowseTesting.setText("Browse");
        btnBrowseTesting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseTestingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnUji)
                        .addGap(47, 47, 47)
                        .addComponent(btnReset)
                        .addGap(0, 558, Short.MAX_VALUE))
                    .addComponent(TFTrainingPath)
                    .addComponent(TFTestingpath))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnBrowseTraining))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowseTesting)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFTrainingPath, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFTestingpath, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseTesting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUji, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("P R E D I K S I    S I S T E M");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Stadium 0");

        jTextField00.setEditable(false);
        jTextField00.setBackground(new java.awt.Color(255, 255, 255));
        jTextField00.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField00.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField00.setPreferredSize(new java.awt.Dimension(8, 25));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Stadium 1");

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(255, 255, 255));
        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setPreferredSize(new java.awt.Dimension(8, 25));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Stadium 3");

        jTextField30.setEditable(false);
        jTextField30.setBackground(new java.awt.Color(255, 255, 255));
        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Stadium 4");

        jTextField40.setEditable(false);
        jTextField40.setBackground(new java.awt.Color(255, 255, 255));
        jTextField40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField40.setPreferredSize(new java.awt.Dimension(8, 25));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Stadium 0");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Stadium 1");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Stadium 2");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Stadium 3");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Stadium 4");

        jTextField01.setEditable(false);
        jTextField01.setBackground(new java.awt.Color(255, 255, 255));
        jTextField01.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField01.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField01.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(255, 255, 255));
        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField21.setEditable(false);
        jTextField21.setBackground(new java.awt.Color(255, 255, 255));
        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jTextField31.setEditable(false);
        jTextField31.setBackground(new java.awt.Color(255, 255, 255));
        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });

        jTextField41.setEditable(false);
        jTextField41.setBackground(new java.awt.Color(255, 255, 255));
        jTextField41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField41.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(255, 255, 255));
        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField22.setEditable(false);
        jTextField22.setBackground(new java.awt.Color(255, 255, 255));
        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });

        jTextField02.setEditable(false);
        jTextField02.setBackground(new java.awt.Color(255, 255, 255));
        jTextField02.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField02.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField02.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField42.setEditable(false);
        jTextField42.setBackground(new java.awt.Color(255, 255, 255));
        jTextField42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField42.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField32.setEditable(false);
        jTextField32.setBackground(new java.awt.Color(255, 255, 255));
        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(255, 255, 255));
        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField03.setEditable(false);
        jTextField03.setBackground(new java.awt.Color(255, 255, 255));
        jTextField03.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField03.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField03.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField33.setEditable(false);
        jTextField33.setBackground(new java.awt.Color(255, 255, 255));
        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField33ActionPerformed(evt);
            }
        });

        jTextField43.setEditable(false);
        jTextField43.setBackground(new java.awt.Color(255, 255, 255));
        jTextField43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField43.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField23.setEditable(false);
        jTextField23.setBackground(new java.awt.Color(255, 255, 255));
        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(255, 255, 255));
        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField04.setEditable(false);
        jTextField04.setBackground(new java.awt.Color(255, 255, 255));
        jTextField04.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField04.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField04.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField34.setEditable(false);
        jTextField34.setBackground(new java.awt.Color(255, 255, 255));
        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });

        jTextField44.setEditable(false);
        jTextField44.setBackground(new java.awt.Color(255, 255, 255));
        jTextField44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField44.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextField24.setEditable(false);
        jTextField24.setBackground(new java.awt.Color(255, 255, 255));
        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(255, 255, 255));
        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Stadium 2");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("D");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("A");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("T");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("A");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("S");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("E");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("T");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Jumlah");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Jumlah");

        jTextFieldPredS0.setEditable(false);
        jTextFieldPredS0.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPredS0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPredS0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPredS0.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldPredS1.setEditable(false);
        jTextFieldPredS1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPredS1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPredS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPredS1.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldPredS2.setEditable(false);
        jTextFieldPredS2.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPredS2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPredS2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPredS2.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldPredS3.setEditable(false);
        jTextFieldPredS3.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPredS3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPredS3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPredS3.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldPredS4.setEditable(false);
        jTextFieldPredS4.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPredS4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPredS4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPredS4.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldJumS0.setEditable(false);
        jTextFieldJumS0.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldJumS0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldJumS0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJumS0.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldJumS1.setEditable(false);
        jTextFieldJumS1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldJumS1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldJumS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJumS1.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldJumS2.setEditable(false);
        jTextFieldJumS2.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldJumS2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldJumS2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJumS2.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextFieldJumS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJumS2ActionPerformed(evt);
            }
        });

        jTextFieldJumS3.setEditable(false);
        jTextFieldJumS3.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldJumS3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldJumS3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJumS3.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextFieldJumS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJumS3ActionPerformed(evt);
            }
        });

        jTextFieldJumS4.setEditable(false);
        jTextFieldJumS4.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldJumS4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldJumS4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJumS4.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotal.setPreferredSize(new java.awt.Dimension(8, 25));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField00, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField01, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldPredS1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField02, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldPredS2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField03, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldPredS3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField04, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldPredS4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel29)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldPredS0, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel47))
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jTextFieldJumS2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldJumS3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldJumS4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldJumS1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldJumS0, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jTextField00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jTextField01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jTextField03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jTextField02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jTextField04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldPredS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldPredS0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldPredS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldPredS3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldJumS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTextFieldJumS0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldJumS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldJumS3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldJumS4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPredS4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Stadium 0", "Stadium 1", "Stadium 2", "Stadium 3", "Stadium 4", "Kelas Asli", "Prediksi", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("No");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Stadium 0");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Stadium 1");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Stadium 2");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Stadium 3");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Stadium 4");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("Kelas Asli");
            jTable1.getColumnModel().getColumn(7).setHeaderValue("Prediksi");
            jTable1.getColumnModel().getColumn(8).setHeaderValue("Keterangan");
        }

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Stadium 1");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Stadium 3");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Stadium 4");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Stadium 0");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Presisi");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Recall");

        jTextFieldPresisi0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPresisi0.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldPresisi0.setPreferredSize(new java.awt.Dimension(10, 25));

        jTextFieldPresisi1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPresisi1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldPresisi1.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldPresisi2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPresisi2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldPresisi2.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextFieldPresisi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPresisi2ActionPerformed(evt);
            }
        });

        jTextFieldPresisi3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPresisi3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldPresisi3.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextFieldPresisi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPresisi3ActionPerformed(evt);
            }
        });

        jTextFieldPresisi4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPresisi4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldPresisi4.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldRecall1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRecall1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldRecall1.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldRecall2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRecall2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldRecall2.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextFieldRecall2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRecall2ActionPerformed(evt);
            }
        });

        jTextFieldRecall0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRecall0.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldRecall0.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldRecall4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRecall4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldRecall4.setPreferredSize(new java.awt.Dimension(8, 25));

        jTextFieldRecall3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRecall3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldRecall3.setPreferredSize(new java.awt.Dimension(8, 25));
        jTextFieldRecall3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRecall3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Rata-rata");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("%");

        jTextFieldPresisiRata2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPresisiRata2.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel17.setText("%");

        jTextFieldRecallRata2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRecallRata2.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel48.setText("%");

        jLabel50.setText("%");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Stadium 2");

        jLabel53.setText("%");

        jLabel56.setText("%");

        jLabel57.setText("%");

        jLabel63.setText("%");

        jLabel66.setText("%");

        jLabel67.setText("%");

        jLabel22.setText("%");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("%");

        jPanel12.setPreferredSize(new java.awt.Dimension(224, 57));

        jTextFieldAkurasi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAkurasi.setPreferredSize(new java.awt.Dimension(6, 28));

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel91.setText("Akurasi");

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel92.setText("%");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAkurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel92)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextFieldAkurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel92))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPresisi4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel67))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldPresisi3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldPresisi2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel57)
                                            .addComponent(jLabel63)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldPresisi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel44)
                                            .addComponent(jTextFieldPresisi0, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel48)
                                            .addComponent(jLabel22)))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(23, 23, 23)
                                .addComponent(jTextFieldPresisiRata2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextFieldRecall4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel66))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldRecall3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldRecall2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldRecall1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldRecall0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel17)))
                            .addComponent(jLabel45)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextFieldRecallRata2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPresisi0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jTextFieldRecall0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPresisi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel40)
                    .addComponent(jTextFieldRecall1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPresisi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel51)
                    .addComponent(jLabel56)
                    .addComponent(jTextFieldRecall2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPresisi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel41)
                    .addComponent(jTextFieldRecall3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextFieldPresisi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addComponent(jTextFieldRecall4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRecallRata2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPresisiRata2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Hasil Perhitungan Naive Bayes");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tabel Confusion Matrix");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel38.setBackground(new java.awt.Color(153, 153, 153));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Performa Klasifikasi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 175, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void jTextField33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField33ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void btnBrowseTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseTrainingActionPerformed
        // TODO add your handling code here:
        try {
            FileFilter ff = new FileNameExtensionFilter("Csv File", "csv", ".csv");
            JFileChooser jfc = new JFileChooser();
//            jfc.addChoosableFileFilter(ff);
            jfc.setFileFilter(ff);
            int returnVal = jfc.showOpenDialog(this);
//            System.out.println(returnVal);
            if (returnVal == jfc.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                String dir = file.getAbsolutePath();
                TFTrainingPath.setText(dir);
            }
        } catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_btnBrowseTrainingActionPerformed

    private void btnBrowseTestingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseTestingActionPerformed
        // TODO add your handling code here:
        try {
            FileFilter ff = new FileNameExtensionFilter("Csv File", "csv", ".csv");
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(ff);
            int returnVal = jfc.showOpenDialog(this);
            if (returnVal == jfc.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                String dir = file.getAbsolutePath();
                TFTestingpath.setText(dir);
            }

        } catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_btnBrowseTestingActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        TFTrainingPath.setText("");
        TFTestingpath.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUjiActionPerformed
        // TODO add your handling code here:

        //Buat variabel List 2 Dimensi penampung data training dan data testing
        List<List<String>> DataTrainingList = new ArrayList<>();
        List<List<String>> DataTestingList = new ArrayList<>();
        //program cek apakah inputan direktori file sudah terisi
        if (inputValidation(DataTrainingList, DataTestingList) == true) {
            //parsing ke double
            //buat var array 2D untuk menampung hasil parsing
            double ParsedDataTraining[][] = new double[DataTrainingList.size()][14];
            double ParsedDataTesting[][] = new double[DataTestingList.size()][14];
            DokumenDataManager.parseToDouble(DataTrainingList, ParsedDataTraining);
            DokumenDataManager.parseToDouble(DataTestingList, ParsedDataTesting);

            //normalisasi atribut umur, tekanan darah, kolesterol, denyut jantung, dan oldpeak
            DokumenDataManager.transformData(DataTrainingList, ParsedDataTraining);
            DokumenDataManager.transformData(DataTestingList, ParsedDataTesting);
//            
//            for (int i = 0; i < DataTrainingList.size(); i++) {
//                for (int j = 0; j < DataTrainingList.get(i).size(); j++) {
//                    System.out.print(DataTrainingList.get(i).get(j)+"\t");
//                }
//                System.out.println("");
//            }
            //buat objek bertipe c_prosesData untuk menampung jumlah value masing-masing atribut
            nb = new c_hitungNaiveBayes();

            //Hitung jumlah kriteria atribut data latih tiap stadium
            nb.hitungJumKriteriaAtributTiapKelasDataLatih(DataTrainingList, "Stadium 0");
            nb.hitungProbabilitasAtribut("Stadium 0");
            nb.hitungJumKriteriaAtributTiapKelasDataLatih(DataTrainingList, "Stadium 1");
            nb.hitungProbabilitasAtribut("Stadium 1");           
            nb.hitungJumKriteriaAtributTiapKelasDataLatih(DataTrainingList, "Stadium 2");
            nb.hitungProbabilitasAtribut("Stadium 2");           
            nb.hitungJumKriteriaAtributTiapKelasDataLatih(DataTrainingList, "Stadium 3");
            nb.hitungProbabilitasAtribut("Stadium 3");            
            nb.hitungJumKriteriaAtributTiapKelasDataLatih(DataTrainingList, "Stadium 4");
            nb.hitungProbabilitasAtribut("Stadium 4");
            
            //buat var hasil array 2D untuk menampung hasil perhitungan Naive Bayes
            //col 1=menyimpan hasil perhitungan untuk stadium 0, col 2=menyimpan hasil perhitungan untuk stadium 1
            //col 3=menyimpan hasil perhitungan untuk stadium 2, col 4=menyimpan hasil perhitungan untuk stadium 3
            //col 4=menyimpan hasil perhitungan untuk stadium 4
            double[][] hasilPerhitunganNB = new double[DataTestingList.size()][5];
            
            //hitung dengan metode Naive Bayes
            //perhitungan untuk masing-masing class
            nb.hitungNaiveBayes(hasilPerhitunganNB, DataTestingList, 0);
            nb.hitungNaiveBayes(hasilPerhitunganNB, DataTestingList, 1);
            nb.hitungNaiveBayes(hasilPerhitunganNB, DataTestingList, 2);
            nb.hitungNaiveBayes(hasilPerhitunganNB, DataTestingList, 3);
            nb.hitungNaiveBayes(hasilPerhitunganNB, DataTestingList, 4);
            
            //buat var kesimpulanPrediksi array 2D untuk menampung kesimpulan prediksi
            //col 1= class aktual, col 2= class prediksi, col 3=keterangan sama/tidak sama
            String[][] kesimpulanPrediksi = new String[DataTestingList.size()][3];
            //isi var tersebut
            kesimpulan(kesimpulanPrediksi, hasilPerhitunganNB, DataTestingList);

            //show table
            showTableNB(hasilPerhitunganNB, kesimpulanPrediksi);

            //Buat tabel Confusion Matrix
            //buat hashMap sebagai pembantu untuk mencari tabel Confusion Matrix
            HashMap<String, String> stadium = new HashMap<>();
            stadium.put("Stadium 0", "Stadium 0");
            stadium.put("Stadium 1", "Stadium 1");
            stadium.put("Stadium 2", "Stadium 2");
            stadium.put("Stadium 3", "Stadium 3");
            stadium.put("Stadium 4", "Stadium 4");

            //buat var AktualPrediksi array 2D untuk menampung tabel Confusion Matrix
            int tabelConfusionMatrix[][] = new int[5][5];
            //isi var tersebut
            for (int classAktual = 0; classAktual < tabelConfusionMatrix.length; classAktual++) {
                for (int classPrediksi = 0; classPrediksi < tabelConfusionMatrix[0].length; classPrediksi++) {
                    tabelConfusionMatrix[classAktual][classPrediksi] = tabelConfusionMatrix(stadium.get("Stadium " + classAktual), stadium.get("Stadium " + classPrediksi), kesimpulanPrediksi);
                }
            }

            //Tampilkan tabel confusion matrix di layar
            showTableCM(tabelConfusionMatrix);

            //Hitung TP,FP,TN,FN serta Akurasi, Presisi, Recall setiap stadium
            //buat objek bertipe m_hitungConfusionMatrix sebagai penampung hasil
            CMStadium0 = new c_hitungConfusionMatrix(tabelConfusionMatrix, 0);
            CMStadium1 = new c_hitungConfusionMatrix(tabelConfusionMatrix, 1);
            CMStadium2 = new c_hitungConfusionMatrix(tabelConfusionMatrix, 2);
            CMStadium3 = new c_hitungConfusionMatrix(tabelConfusionMatrix, 3);
            CMStadium4 = new c_hitungConfusionMatrix(tabelConfusionMatrix, 4);

            //Tampilkan hasil performance ke layar
            showPerformanceCM(DataTestingList.size());
//            }

        }
    }//GEN-LAST:event_btnUjiActionPerformed

    private void jTextFieldPresisi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPresisi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPresisi2ActionPerformed

    private void jTextFieldPresisi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPresisi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPresisi3ActionPerformed

    private void jTextFieldRecall2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRecall2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRecall2ActionPerformed

    private void jTextFieldRecall3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRecall3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRecall3ActionPerformed

    private void jTextFieldJumS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJumS2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJumS2ActionPerformed

    private void jTextFieldJumS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJumS3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJumS3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new View_Performa().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFTestingpath;
    private javax.swing.JTextField TFTrainingPath;
    private javax.swing.JButton btnBrowseTesting;
    private javax.swing.JButton btnBrowseTraining;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField00;
    private javax.swing.JTextField jTextField01;
    private javax.swing.JTextField jTextField02;
    private javax.swing.JTextField jTextField03;
    private javax.swing.JTextField jTextField04;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextFieldAkurasi;
    private javax.swing.JTextField jTextFieldJumS0;
    private javax.swing.JTextField jTextFieldJumS1;
    private javax.swing.JTextField jTextFieldJumS2;
    private javax.swing.JTextField jTextFieldJumS3;
    private javax.swing.JTextField jTextFieldJumS4;
    private javax.swing.JTextField jTextFieldPredS0;
    private javax.swing.JTextField jTextFieldPredS1;
    private javax.swing.JTextField jTextFieldPredS2;
    private javax.swing.JTextField jTextFieldPredS3;
    private javax.swing.JTextField jTextFieldPredS4;
    private javax.swing.JTextField jTextFieldPresisi0;
    private javax.swing.JTextField jTextFieldPresisi1;
    private javax.swing.JTextField jTextFieldPresisi2;
    private javax.swing.JTextField jTextFieldPresisi3;
    private javax.swing.JTextField jTextFieldPresisi4;
    private javax.swing.JTextField jTextFieldPresisiRata2;
    private javax.swing.JTextField jTextFieldRecall0;
    private javax.swing.JTextField jTextFieldRecall1;
    private javax.swing.JTextField jTextFieldRecall2;
    private javax.swing.JTextField jTextFieldRecall3;
    private javax.swing.JTextField jTextFieldRecall4;
    private javax.swing.JTextField jTextFieldRecallRata2;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
