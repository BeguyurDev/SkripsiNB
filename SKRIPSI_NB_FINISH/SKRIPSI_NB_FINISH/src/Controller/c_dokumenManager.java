package Controller;

import Model.m_dokumenManager;
import Model.m_prosesData;
import java.util.List;

public class c_dokumenManager {

    m_dokumenManager dokumen;
    m_prosesData prosesData;

    public c_dokumenManager() {
        dokumen = new m_dokumenManager();
        prosesData = new m_prosesData();
    }

    public boolean readData(List<List<String>> listData, String pathData) {
        return dokumen.readData(listData, pathData);
    }

    public void parseToDouble(List<List<String>> ListData, double data[][]) {
        prosesData.parseToDouble(ListData, data);
    }

//    public void printData(List<List<String>> ListData) {
//        prosesData.printData(ListData);
//    }
    public void transformData(List<List<String>> ListData, double[][] data) {
        prosesData.transformData(ListData, data);
    }

//    public void kesimpulan(String kesimpulanPrediksi[][], double perhitunganNaiveBayes[][], List<List<String>> TestingList) {
//        kesimpulan.kesimpulan(kesimpulanPrediksi, perhitunganNaiveBayes, TestingList);
//    }
}
