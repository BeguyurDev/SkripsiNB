package Model;

import java.util.ArrayList;
import java.util.List;

public class m_prosesData {

//    int countStadium = 0;
//    //atribut umur
//    int countMuda = 0, countParubaya = 0, countTua = 0;
//    //atribut jenis kelamin
//    int countWanita = 0, countPria = 0;
//    //atribut nyeri dada
//    int countTypical = 0, countAtypical = 0, countNonAngina = 0, countAsymptomatic = 0;
//    //atribut tekanan darah
//    int countTDRendah = 0, countTDNormal = 0, countTDTinggi = 0;
//    //atribut kolesterol
//    int countKolesterolRendah = 0, countKolesterolSedang = 0, countKolesterolTinggi = 0;
//    //atribut kadar gula > 120 mg/dl
//    int countKGTidak = 0, countKGYa = 0;
//    //atribut ekg
//    int countEKGNormal = 0, countEKGAbnormal = 0, countEKGHypertrofi = 0;
//    //atribut detak jantung 1 menit
//    int countDJRendah = 0, countDJSedang = 0, countDJTinggi = 0;
//    //atribut latihan induksi angina (terdapat nyeri saat olahraga)
//    int countLIATidak = 0, countLIAYa = 0;
//    //atribut oldpeak
//    int countOldpeakNormal = 0, countOldpeakBeresiko = 0, countOldpeakBuruk = 0;
//    //atribut segmen ST
//    int countUpsloping = 0, countFlat = 0, countDownsloping = 0;
//    //atribut florosofi
//    int countFloNormal = 0, countFloKoroner = 0, countFloAneurisma = 0, countFloPerifer = 0;
//    //atribut thalium
//    int countThalNormal = 0, countThalFixed = 0, countThalReversable = 0;
    
//    public List<m_dataKesimpulanPerhitungan> showTable(double[][] hasilPerhitungan, String[][] kesimpulan) {
//        List<m_dataKesimpulanPerhitungan> Listhasil = new ArrayList<>();
//        for (int i = 0; i < hasilPerhitungan.length; i++) {
//            Listhasil.add(new m_dataKesimpulanPerhitungan((i + 1), hasilPerhitungan[i][0], hasilPerhitungan[i][1], hasilPerhitungan[i][2], hasilPerhitungan[i][3], hasilPerhitungan[i][4], kesimpulan[i][0], kesimpulan[i][1], kesimpulan[i][2]));
//        }
//        return Listhasil;
//    }

    public static void parseToDouble(List<List<String>> ListData, double data[][]) {
        //Memindahkan Data Testing dari TestingList bertipe string ke array 2D DataTesting[][] bertipe double
        for (int i = 0; i < ListData.size(); i++) {
            for (int j = 0; j < ListData.get(0).size(); j++) {
                data[i][j] = Double.parseDouble(ListData.get(i).get(j));
            }
        }
    }

//    public static void printData(List<List<String>> ListData) {
//        for (int i = 0; i < ListData.size(); i++) {
//            System.out.print((i + 1) + ". ");
//            for (int j = 0; j < ListData.get(i).size(); j++) {
//                System.out.print(ListData.get(i).get(j) + "\t");
//            }
//            System.out.println("");
//        }
//    }

    public static void transformData(List<List<String>> ListData, double[][] data) {
        //Normalisasi data
        for (int i = 0; i < data.length; i++) {
            //normalisasi umur
            if (data[i][0] <=1) {
                ListData.get(i).set(0, "Bayi");
            } else if (data[i][0] <= 10) {
                ListData.get(i).set(0, "Anak-anak");
            } else if (data[i][0] <= 19) {
                ListData.get(i).set(0, "Remaja");
            } else if (data[i][0] <= 60) {
                ListData.get(i).set(0, "Dewasa");
            } else {
                ListData.get(i).set(0, "Lansia");
            }

            //normalisasi jenis kelamin
            if (data[i][1] == 0) {
                ListData.get(i).set(1, "Wanita");
            } else {
                ListData.get(i).set(1, "Pria");
            }

            //normalisasi nyeri dada
            if (data[i][2] == 1) {
                ListData.get(i).set(2, "Typical Angina");
            } else if (data[i][2] == 2) {
                ListData.get(i).set(2, "Atypical Angina");
            } else if (data[i][2] == 3) {
                ListData.get(i).set(2, "Non-Angina Pain");
            } else {
                ListData.get(i).set(2, "Asymptomatic");
            }

            //normalisasi tekanan darah
            if (data[i][3] < 120) {
                ListData.get(i).set(3, "Rendah");
            } else if (data[i][3] > 140) {
                ListData.get(i).set(3, "Tinggi");
            } else {
                ListData.get(i).set(3, "Normal");
            }

            //normalisasi kolesterol
            if (data[i][4] < 200) {
                ListData.get(i).set(4, "Normal");
            } else if (data[i][4] > 239) {
                ListData.get(i).set(4, "Tinggi");
            } else {
                ListData.get(i).set(4, "Sedikit Tinggi");
            }

            //normalisasi kadar gula >120mg/dl
            if (data[i][5] == 0) {
                ListData.get(i).set(5, "Tidak");
            } else {
                ListData.get(i).set(5, "Ya");
            }

            //normalisasi data ekg
            if (data[i][6] == 0) {
                ListData.get(i).set(6, "Normal");
            } else if (data[i][6] == 1) {
                ListData.get(i).set(6, "ST-T Abnormal");
            } else {
                ListData.get(i).set(6, "Hypertrophy");
            }

            //normalisasi range detak jantung 1 menit
            if (data[i][7] < 60) {
                ListData.get(i).set(7, "Rendah");
            } else if (data[i][7] > 142) {
                ListData.get(i).set(7, "Tinggi");
            } else {
                ListData.get(i).set(7, "Sedang");
            }

            //normalisasi induksi angina
            if (data[i][8] == 0) {
                ListData.get(i).set(8, "Tidak");
            } else {
                ListData.get(i).set(8, "Ya");
            }

            //normalisasi oldpeak
            if (data[i][9] < 1.5) {
                ListData.get(i).set(9, "Normal");
            } else if (data[i][9] > 2.55) {
                ListData.get(i).set(9, "Buruk");
            } else {
                ListData.get(i).set(9, "Beresiko");
            }

            //normalisasi segmen ST
            if (data[i][10] == 1) {
                ListData.get(i).set(10, "Upsloping");
            } else if (data[i][10] == 2) {
                ListData.get(i).set(10, "Flat");
            } else {
                ListData.get(i).set(10, "Downsloping");
            }

            //normalisasi pembuluh dara flourosophy
            if (data[i][11] == 0) {
                ListData.get(i).set(11, "Normal");
            } else if (data[i][11] == 1) {
                ListData.get(i).set(11, "Arteri Koroner");
            } else if (data[i][11] == 2) {
                ListData.get(i).set(11, "Aneurisma");
            } else {
                ListData.get(i).set(11, "Arteri Perifer");
            }

            //normalisasi thalium
            if (data[i][12] == 3) {
                ListData.get(i).set(12, "Normal");
            } else if (data[i][12] == 6) {
                ListData.get(i).set(12, "Fixed Defect");
            } else {
                ListData.get(i).set(12, "Reversable Defect");
            }

            //normalisasi label stadium
            if (data[i][13] == 0) {
                ListData.get(i).set(13, "Stadium 0");
            } else if (data[i][13] == 1) {
                ListData.get(i).set(13, "Stadium 1");
            } else if (data[i][13] == 2) {
                ListData.get(i).set(13, "Stadium 2");
            } else if (data[i][13] == 3) {
                ListData.get(i).set(13, "Stadium 3");
            } else {
                ListData.get(i).set(13, "Stadium 4");
            }
        }
    }

}
