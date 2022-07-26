package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class m_dokumenManager {

    public boolean readData(List<List<String>> listData, String pathData) {
        String line = "";
        boolean ada = false;
        try {
            //buat bufferedreader untuk memanggil file, file reader untuk memanggil file dengan parameter path
            //cek ketersediaan file
            BufferedReader brData = new BufferedReader(new FileReader(pathData));
            ada = true;

            while ((line = brData.readLine()) != null) {
                //membuat var values untuk menampung isi data perbaris
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    System.out.print(values[i]+"\t");
                }
                System.out.println("");
                //menambahkan value ke List data Training
                listData.add(Arrays.asList(values));
            }
            brData.close();
            
            
        } catch (FileNotFoundException ex) {
            //JOptionPane.showMessageDialog(null, "Data tidak ditemukan !", "WARNING!!", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            
        }
        return ada;
    }
    
    
}
