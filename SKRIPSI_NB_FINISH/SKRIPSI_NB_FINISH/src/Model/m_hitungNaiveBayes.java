package Model;

import java.util.HashMap;
import java.util.List;

public class m_hitungNaiveBayes {

    HashMap<String, Double> probAtribut;
    HashMap<String, Integer> jumlahKriteriaAtribut;

    int countStadium;
    int countBayi, countAnak2, countRemaja, countDewasa, countLansia;
    int countWanita, countPria;
    int countTypical, countAtypical, countNonAngina, countAsymptomatic;
    int countTDRendah, countTDNormal, countTDTinggi;
    int countKolesterolNormal, countKolesterolSedikitTinggi, countKolesterolTinggi;
    int countKGTidak, countKGYa;
    int countEKGNormal, countEKGAbnormal, countEKGHypertrofi;
    int countDJRendah, countDJSedang, countDJTinggi;
    int countLIATidak, countLIAYa;
    int countOldpeakNormal, countOldpeakBeresiko, countOldpeakBuruk;
    int countUpsloping, countFlat, countDownsloping;
    int countFloNormal, countFloKoroner, countFloAneurisma, countFloPerifer;
    int countThalNormal, countThalFixed, countThalReversable;
    int panjangDataLatih;

    double probStadium;
    double probMuda, probParubaya, probTua;
    double probWanita, probPria;
    double probTypical, probAtypical, probNonAngina, probAsymptomatic;
    double probTDRendah, probTDNormal, probTDTinggi;
    double probKolesterolRendah, probKolesterolSedang, probKolesterolTinggi;
    double probKGTidak, probKGYa;
    double probEKGNormal, probEKGAbnormal, probEKGHypertrofi;
    double probDJRendah, probDJSedang, probDJTinggi;
    double probLIATidak, probLIAYa;
    double probOldpeakNormal, probOldpeakBeresiko, probOldpeakBuruk;
    double probUpsloping, probFlat, probDownsloping;
    double probFloNormal, probFloKoroner, probFloAneurisma, probFloPerifer;
    double probThalNormal, probThalFixed, probThalReversable;

//    
    public m_hitungNaiveBayes() {

        probAtribut = new HashMap<>();
    }

//    public void hitungJumKriteriaAtributTiapKelas(List<List<String>> TrainingList, String label) {
//        for (int i = 0; i < TrainingList.size(); i++) {
//            if (TrainingList.get(i).get(13).equals(label)) {
////                System.out.println(++this.countStadium);
////                System.out.println(this.countStadium++);
//                this.countStadium++;
////                jumlahKriteriaAtribut.put(label, this.countStadium);
//                //atribut umur
//                if (TrainingList.get(i).get(0) == "Bayi") {
//                    jumlahKriteriaAtribut.put("0" + TrainingList.get(i).get(0) + label, this.countBayi++);
//                } else if (TrainingList.get(i).get(0) == "Anak-anak") {
//                    jumlahKriteriaAtribut.put("0" + TrainingList.get(i).get(0) + label, this.countAnak2++);
//                } else if (TrainingList.get(i).get(0) == "Remaja") {
//                    jumlahKriteriaAtribut.put("0" + TrainingList.get(i).get(0) + label, this.countRemaja++);
//                } else if (TrainingList.get(i).get(0) == "Dewasa") {
//                    jumlahKriteriaAtribut.put("0" + TrainingList.get(i).get(0) + label, this.countDewasa++);
//                } else {
//                    int lansia = this.countLansia++;
//                    jumlahKriteriaAtribut.put("0" + TrainingList.get(i).get(0) + label, lansia);
//                }
//                //atribut jenis kelamin
//                if (TrainingList.get(i).get(1) == "Pria") {
//                    jumlahKriteriaAtribut.put("1" + TrainingList.get(i).get(1) + label, this.countPria++);
//                } else {
//                    jumlahKriteriaAtribut.put("1" + TrainingList.get(i).get(1) + label, this.countWanita++);
//                }
//                //atribut jenis nyeri dada
//                if (TrainingList.get(i).get(2) == "Typical Angina") {
//                    jumlahKriteriaAtribut.put("2" + TrainingList.get(i).get(2) + label, this.countTypical++);
//                } else if (TrainingList.get(i).get(2) == "Atypical Angina") {
//                    jumlahKriteriaAtribut.put("2" + TrainingList.get(i).get(2) + label, this.countAtypical++);
//                } else if (TrainingList.get(i).get(2) == "Non-Angina Pain") {
//                    jumlahKriteriaAtribut.put("2" + TrainingList.get(i).get(2) + label, this.countNonAngina++);
//                } else {
//                    jumlahKriteriaAtribut.put("2" + TrainingList.get(i).get(2) + label, this.countAsymptomatic++);
//                }
//                //atribut tekanan darah
//                if (TrainingList.get(i).get(3) == "Normal") {
//                    jumlahKriteriaAtribut.put("3" + TrainingList.get(i).get(3) + label, this.countTDNormal++);
//                } else if (TrainingList.get(i).get(3) == "Rendah") {
//                    jumlahKriteriaAtribut.put("3" + TrainingList.get(i).get(3) + label, this.countTDRendah++);
//                } else {
//                    jumlahKriteriaAtribut.put("3" + TrainingList.get(i).get(3) + label, this.countTDTinggi++);
//                }
//                //atribut kolesterol
//                if (TrainingList.get(i).get(4) == "Normal") {
//                    jumlahKriteriaAtribut.put("4" + TrainingList.get(i).get(4) + label, this.countKolesterolNormal++);
//                } else if (TrainingList.get(i).get(4) == "Sedikit Tinggi") {
//                    jumlahKriteriaAtribut.put("4" + TrainingList.get(i).get(4) + label, this.countKolesterolSedikitTinggi++);
//                } else {
//                    jumlahKriteriaAtribut.put("4" + TrainingList.get(i).get(4) + label, this.countKolesterolTinggi++);
//                }
//                //atribut kadar gula darah > 120 mg/dl
//                if (TrainingList.get(i).get(5) == "Tidak") {
//                    jumlahKriteriaAtribut.put("5" + TrainingList.get(i).get(5) + label, this.countKGTidak++);
//                } else {
//                    jumlahKriteriaAtribut.put("5" + TrainingList.get(i).get(5) + label, this.countKGYa++);
//                }
//                //atribut elektrokardiografi
//                if (TrainingList.get(i).get(6) == "Normal") {
//                    jumlahKriteriaAtribut.put("6" + TrainingList.get(i).get(6) + label, this.countEKGNormal++);
//                } else if (TrainingList.get(i).get(6) == "Hypertrophy") {
//                    jumlahKriteriaAtribut.put("6" + TrainingList.get(i).get(6) + label, this.countEKGHypertrofi++);
//                } else {
//                    jumlahKriteriaAtribut.put("6" + TrainingList.get(i).get(6) + label, this.countEKGAbnormal++);
//                }
//                //atribut detak jantung 1 menit
//                if (TrainingList.get(i).get(7) == "Rendah") {
//                    jumlahKriteriaAtribut.put("7" + TrainingList.get(i).get(7) + label, this.countDJRendah++);
//                } else if (TrainingList.get(i).get(7) == "Sedang") {
//                    jumlahKriteriaAtribut.put("7" + TrainingList.get(i).get(7) + label, this.countDJSedang++);
//                } else {
//                    jumlahKriteriaAtribut.put("7" + TrainingList.get(i).get(7) + label, this.countDJTinggi++);
//                }
//                //atribut latihan induksi angina
//                if (TrainingList.get(i).get(8) == "Tidak") {
//                    jumlahKriteriaAtribut.put("8" + TrainingList.get(i).get(8) + label, this.countLIATidak++);
//                } else {
//                    jumlahKriteriaAtribut.put("8" + TrainingList.get(i).get(8) + label, this.countLIAYa++);
//                }
//                //atribut oldpeak
//                if (TrainingList.get(i).get(9) == "Normal") {
//                    jumlahKriteriaAtribut.put("9" + TrainingList.get(i).get(9) + label, this.countOldpeakNormal++);
//                } else if (TrainingList.get(i).get(9) == "Beresiko") {
//                    jumlahKriteriaAtribut.put("9" + TrainingList.get(i).get(9) + label, this.countOldpeakBeresiko++);
//                } else {
//                    jumlahKriteriaAtribut.put("9" + TrainingList.get(i).get(9) + label, this.countOldpeakBuruk++);
//                }
//                //atribut segmen ST
//                if (TrainingList.get(i).get(10) == "Upsloping") {
//                    jumlahKriteriaAtribut.put("10" + TrainingList.get(i).get(10) + label, this.countUpsloping++);
//                } else if (TrainingList.get(i).get(10) == "Flat") {
//                    jumlahKriteriaAtribut.put("10" + TrainingList.get(i).get(10) + label, this.countFlat++);
//                } else {
//                    jumlahKriteriaAtribut.put("10" + TrainingList.get(i).get(10) + label, this.countDownsloping++);
//                }
//                //atribut flourosofi
//                if (TrainingList.get(i).get(11) == "Normal") {
//                    jumlahKriteriaAtribut.put("11" + TrainingList.get(i).get(11) + label, this.countFloNormal++);
//                } else if (TrainingList.get(i).get(11) == "Arteri Koroner") {
//                    jumlahKriteriaAtribut.put("11" + TrainingList.get(i).get(11) + label, this.countFloKoroner++);
//                } else if (TrainingList.get(i).get(11) == "Aneurisma") {
//                    jumlahKriteriaAtribut.put("11" + TrainingList.get(i).get(11) + label, this.countFloAneurisma++);
//                } else {
//                    jumlahKriteriaAtribut.put("11" + TrainingList.get(i).get(11) + label, this.countFloPerifer++);
//                }
//                //atribut Thalium
//                if (TrainingList.get(i).get(12) == "Normal") {
//                    jumlahKriteriaAtribut.put("12" + TrainingList.get(i).get(12) + label, this.countThalNormal++);
//                } else if (TrainingList.get(i).get(12) == "Fixed Defect") {
//                    jumlahKriteriaAtribut.put("12" + TrainingList.get(i).get(12) + label, this.countThalFixed++);
//                } else {
//                    jumlahKriteriaAtribut.put("12" + TrainingList.get(i).get(12) + label, this.countThalReversable++);
//                }
//            }
//        }
////        this.probAtribut.put(label, (double) this.countStadium / TrainingList.size());
//        panjangDataLatih = TrainingList.size();
////        jumlahKriteriaAtribut.put(label, panjangDataLatih);
//    }
    public void hitungJumKriteriaAtributKelas(List<List<String>> TrainingList, String label) {
        for (int i = 0; i < TrainingList.size(); i++) {//untuk baris
            if (TrainingList.get(i).get(13).equals(label)) {//jika berlabel "tertentu"
                this.countStadium++;
//                jumAtributStadium0.put(label,);
                //countAtr.countStadium++;

                //atribut umur
                if (TrainingList.get(i).get(0) == "Bayi") {
                    this.countBayi++;
                    //  countAtr.countBayi++;
                } else if (TrainingList.get(i).get(0) == "Anak-anak") {
                    this.countAnak2++;
                    //countAtr.countAnak2++;
                } else if (TrainingList.get(i).get(0) == "Remaja") {
                    this.countRemaja++;
                    //countAtr.countRemaja++;
                } else if (TrainingList.get(i).get(0) == "Dewasa") {
                    this.countDewasa++;
                    //countAtr.countDewasa++;
                } else {
                    this.countLansia++;
                    //countAtr.countLansia++;
                }
                //atribut jenis kelamin
                if (TrainingList.get(i).get(1) == "Pria") {
                    this.countPria++;
//                    countAtr.countPria++;
                } else {
                    this.countWanita++;
//                    countAtr.countWanita++;
                }
                //atribut jenis nyeri dada
                if (TrainingList.get(i).get(2) == "Typical Angina") {
                    this.countTypical++;
//                    countAtr.countTypical++;
                } else if (TrainingList.get(i).get(2) == "Atypical Angina") {
                    this.countAtypical++;
//                    countAtr.countAtypical++;
                } else if (TrainingList.get(i).get(2) == "Non-Angina Pain") {
                    this.countNonAngina++;
//                    countAtr.countNonAngina++;
                } else {
                    this.countAsymptomatic++;
//                    countAtr.countAsymptomatic++;
                }
                //atribut tekanan darah
                if (TrainingList.get(i).get(3) == "Normal") {
                    this.countTDNormal++;
//                    countAtr.countTDNormal++;
                } else if (TrainingList.get(i).get(3) == "Rendah") {
                    this.countTDRendah++;
//                    countAtr.countTDRendah++;
                } else {
                    this.countTDTinggi++;
//                    countAtr.countTDTinggi++;
                }
                //atribut kolesterol
                if (TrainingList.get(i).get(4) == "Normal") {
                    this.countKolesterolNormal++;
//                    countAtr.countKolesterolNormal++;
                } else if (TrainingList.get(i).get(4) == "Sedikit Tinggi") {
                    this.countKolesterolSedikitTinggi++;
//                    countAtr.countKolesterolSedikitTinggi++;
                } else {
                    this.countKolesterolTinggi++;
//                    countAtr.countKolesterolTinggi++;
                }
                //atribut kadar gula darah > 120 mg/dl
                if (TrainingList.get(i).get(5) == "Tidak") {
                    this.countKGTidak++;
//                    countAtr.countKGTidak++;
                } else {
                    this.countKGYa++;
//                    countAtr.countKGYa++;
                }
                //atribut elektrokardiografi
                if (TrainingList.get(i).get(6) == "Normal") {
                    this.countEKGNormal++;
//                    countAtr.countEKGNormal++;
                } else if (TrainingList.get(i).get(6) == "Hypertrophy") {
                    this.countEKGHypertrofi++;
//                    countAtr.countEKGHypertrofi++;
                } else {
                    this.countEKGAbnormal++;
//                    countAtr.countEKGAbnormal++;
                }
                //atribut detak jantung 1 menit
                if (TrainingList.get(i).get(7) == "Rendah") {
                    this.countDJRendah++;
//                    countAtr.countDJRendah++;
                } else if (TrainingList.get(i).get(7) == "Sedang") {
                    this.countDJSedang++;
//                    countAtr.countDJSedang++;
                } else {
                    this.countDJTinggi++;
//                    countAtr.countDJTinggi++;
                }
                //atribut latihan induksi angina
                if (TrainingList.get(i).get(8) == "Tidak") {
                    this.countLIATidak++;
//                    countAtr.countLIATidak++;
                } else {
                    this.countLIAYa++;
//                    countAtr.countLIAYa++;
                }
                //atribut oldpeak
                if (TrainingList.get(i).get(9) == "Normal") {
                    this.countOldpeakNormal++;
//                    countAtr.countOldpeakNormal++;
                } else if (TrainingList.get(i).get(9) == "Beresiko") {
                    this.countOldpeakBeresiko++;
//                    countAtr.countOldpeakBeresiko++;
                } else {
                    this.countOldpeakBuruk++;
//                    countAtr.countOldpeakBuruk++;
                }
                //atribut segmen ST
                if (TrainingList.get(i).get(10) == "Upsloping") {
                    this.countUpsloping++;
//                    countAtr.countUpsloping++;
                } else if (TrainingList.get(i).get(10) == "Flat") {
                    this.countFlat++;
//                    countAtr.countFlat++;
                } else {
                    this.countDownsloping++;
//                    countAtr.countDownsloping++;
                }
                //atribut flourosofi
                if (TrainingList.get(i).get(11) == "Normal") {
                    this.countFloNormal++;
//                    countAtr.countFloNormal++;
                } else if (TrainingList.get(i).get(11) == "Arteri Koroner") {
                    this.countFloKoroner++;
//                    countAtr.countFloKoroner++;
                } else if (TrainingList.get(i).get(11) == "Aneurisma") {
                    this.countFloAneurisma++;
//                    countAtr.countFloAneurisma++;
                } else {
                    this.countFloPerifer++;
//                    countAtr.countFloPerifer++;
                }
                //atribut Thalium
                if (TrainingList.get(i).get(12) == "Normal") {
                    this.countThalNormal++;
//                    countAtr.countThalNormal++;
                } else if (TrainingList.get(i).get(12) == "Fixed Defect") {
                    this.countThalFixed++;
//                    countAtr.countThalFixed++;
                } else {
                    this.countThalReversable++;
//                    countAtr.countThalReversable++;
                }
            }
        }
        panjangDataLatih = TrainingList.size();
        this.probAtribut.put(label, (double) this.countStadium / panjangDataLatih);
    }

    //untuk data training
//    public static void hitungJumKriteriaAtributTiapKelas(List<List<String>> TrainingList, String label, m_prosesData stadium, m_prosesData countAtr) {
//        for (int i = 0; i < TrainingList.size(); i++) {
//            if (TrainingList.get(i).get(13) == label) {
//                stadium.countStadium++;
//                countAtr.countStadium++;
//                //atribut umur
//                if (TrainingList.get(i).get(0) == "Muda") {
//                    stadium.countMuda++;
//                    countAtr.countMuda++;
//                } else if (TrainingList.get(i).get(0) == "Parubaya") {
//                    stadium.countParubaya++;
//                    countAtr.countParubaya++;
//                } else {
//                    stadium.countTua++;
//                    countAtr.countTua++;
//                }
//                //atribut jenis kelamin
//                if (TrainingList.get(i).get(1) == "Pria") {
//                    stadium.countPria++;
//                    countAtr.countPria++;
//                } else {
//                    stadium.countWanita++;
//                    countAtr.countWanita++;
//                }
//                //atribut jenis nyeri dada
//                if (TrainingList.get(i).get(2) == "Typical Angina") {
//                    stadium.countTypical++;
//                    countAtr.countTypical++;
//                } else if (TrainingList.get(i).get(2) == "Atypical Angina") {
//                    stadium.countAtypical++;
//                    countAtr.countAtypical++;
//                } else if (TrainingList.get(i).get(2) == "Non-Angina Pain") {
//                    stadium.countNonAngina++;
//                    countAtr.countNonAngina++;
//                } else {
//                    stadium.countAsymptomatic++;
//                    countAtr.countAsymptomatic++;
//                }
//                //atribut tekanan darah
//                if (TrainingList.get(i).get(3) == "Normal") {
//                    stadium.countTDNormal++;
//                    countAtr.countTDNormal++;
//                } else if (TrainingList.get(i).get(3) == "Rendah") {
//                    stadium.countTDRendah++;
//                    countAtr.countTDRendah++;
//                } else {
//                    stadium.countTDTinggi++;
//                    countAtr.countTDTinggi++;
//                }
//                //atribut kolesterol
//                if (TrainingList.get(i).get(4) == "Rendah") {
//                    stadium.countKolesterolNormal++;
//                    countAtr.countKolesterolNormal++;
//                } else if (TrainingList.get(i).get(4) == "Sedang") {
//                    stadium.countKolesterolSedikitTinggi++;
//                    countAtr.countKolesterolSedikitTinggi++;
//                } else {
//                    stadium.countKolesterolTinggi++;
//                    countAtr.countKolesterolTinggi++;
//                }
//                //atribut kadar gula darah > 120 mg/dl
//                if (TrainingList.get(i).get(5) == "Tidak") {
//                    stadium.countKGTidak++;
//                    countAtr.countKGTidak++;
//                } else {
//                    stadium.countKGYa++;
//                    countAtr.countKGYa++;
//                }
//                //atribut elektrokardiografi
//                if (TrainingList.get(i).get(6) == "Normal") {
//                    stadium.countEKGNormal++;
//                    countAtr.countEKGNormal++;
//                } else if (TrainingList.get(i).get(6) == "Hypertrophy") {
//                    stadium.countEKGHypertrofi++;
//                    countAtr.countEKGHypertrofi++;
//                } else {
//                    stadium.countEKGAbnormal++;
//                    countAtr.countEKGAbnormal++;
//                }
//                //atribut detak jantung 1 menit
//                if (TrainingList.get(i).get(7) == "Rendah") {
//                    stadium.countDJRendah++;
//                    countAtr.countDJRendah++;
//                } else if (TrainingList.get(i).get(7) == "Sedang") {
//                    stadium.countDJSedang++;
//                    countAtr.countDJSedang++;
//                } else {
//                    stadium.countDJTinggi++;
//                    countAtr.countDJTinggi++;
//                }
//                //atribut latihan induksi angina
//                if (TrainingList.get(i).get(8) == "Tidak") {
//                    stadium.countLIATidak++;
//                    countAtr.countLIATidak++;
//                } else {
//                    stadium.countLIAYa++;
//                    countAtr.countLIAYa++;
//                }
//                //atribut oldpeak
//                if (TrainingList.get(i).get(9) == "Normal") {
//                    stadium.countOldpeakNormal++;
//                    countAtr.countOldpeakNormal++;
//                } else if (TrainingList.get(i).get(9) == "Beresiko") {
//                    stadium.countOldpeakBeresiko++;
//                    countAtr.countOldpeakBeresiko++;
//                } else {
//                    stadium.countOldpeakBuruk++;
//                    countAtr.countOldpeakBuruk++;
//                }
//                //atribut segmen ST
//                if (TrainingList.get(i).get(10) == "Upsloping") {
//                    stadium.countUpsloping++;
//                    countAtr.countUpsloping++;
//                } else if (TrainingList.get(i).get(10) == "Flat") {
//                    stadium.countFlat++;
//                    countAtr.countFlat++;
//                } else {
//                    stadium.countDownsloping++;
//                    countAtr.countDownsloping++;
//                }
//                //atribut flourosofi
//                if (TrainingList.get(i).get(11) == "Normal") {
//                    stadium.countFloNormal++;
//                    countAtr.countFloNormal++;
//                } else if (TrainingList.get(i).get(11) == "Arteri Koroner") {
//                    stadium.countFloKoroner++;
//                    countAtr.countFloKoroner++;
//                } else if (TrainingList.get(i).get(11) == "Aneurisma") {
//                    stadium.countFloAneurisma++;
//                    countAtr.countFloAneurisma++;
//                } else {
//                    stadium.countFloPerifer++;
//                    countAtr.countFloPerifer++;
//                }
//                //atribut Thalium
//                if (TrainingList.get(i).get(12) == "Normal") {
//                    stadium.countThalNormal++;
//                    countAtr.countThalNormal++;
//                } else if (TrainingList.get(i).get(12) == "Fixed Defect") {
//                    stadium.countThalFixed++;
//                    countAtr.countThalFixed++;
//                } else {
//                    stadium.countThalReversable++;
//                    countAtr.countThalReversable++;
//                }
//            }
//        }
//    }
    public void hitungProbabilitasAtributKelas(String label) {
//        probAtribut.put("0Bayi"+label, (double) jumAtributStadium0.get("0Bayi"+label) / jumAtributStadium0.get("label"));
//System.out.println("Lansia "+label+": "+this.countLansia);
//        System.out.println("Jumlah "+label+": "+this.countStadium);
//        System.out.println(jumlahKriteriaAtribut.get("0Lansia") + label);
        probAtribut.put("0Bayi" + label, (double) this.countBayi / this.countStadium);
        probAtribut.put("0Anak-anak" + label, (double) this.countAnak2 / this.countStadium);
        probAtribut.put("0Remaja" + label, (double) this.countRemaja / this.countStadium);
        probAtribut.put("0Dewasa" + label, (double) this.countDewasa / this.countStadium);
        probAtribut.put("0Lansia" + label, (double) this.countLansia / this.countStadium);
//        System.out.println("Probabilitas Lansia "+label+": "+probAtribut.get("0Lansia"+label));
        probAtribut.put("1Pria" + label, (double) this.countPria / this.countStadium);
        probAtribut.put("1Wanita" + label, (double) this.countWanita / this.countStadium);
        probAtribut.put("2Typical Angina" + label, (double) this.countTypical / this.countStadium);
        probAtribut.put("2Atypical Angina" + label, (double) this.countAtypical / this.countStadium);
        probAtribut.put("2Non-Angina Pain" + label, (double) this.countNonAngina / this.countStadium);
        probAtribut.put("2Asymptomatic" + label, (double) this.countAsymptomatic / this.countStadium);
        probAtribut.put("3Rendah" + label, (double) this.countTDRendah / this.countStadium);
        probAtribut.put("3Normal" + label, (double) this.countTDNormal / this.countStadium);
        probAtribut.put("3Tinggi" + label, (double) this.countTDTinggi / this.countStadium);
        probAtribut.put("4Normal" + label, (double) this.countKolesterolNormal / this.countStadium);
        probAtribut.put("4Sedikit Tinggi" + label, (double) this.countKolesterolSedikitTinggi / this.countStadium);
        probAtribut.put("4Tinggi" + label, (double) this.countKolesterolTinggi / this.countStadium);
        probAtribut.put("5Tidak" + label, (double) this.countKGTidak / this.countStadium);
        probAtribut.put("5Ya" + label, (double) this.countKGYa / this.countStadium);
        probAtribut.put("6Normal" + label, (double) this.countEKGNormal / this.countStadium);
        probAtribut.put("6ST-T Abnormal" + label, (double) this.countEKGAbnormal / this.countStadium);
        probAtribut.put("6Hypertrophy" + label, (double) this.countEKGHypertrofi / this.countStadium);
        probAtribut.put("7Rendah" + label, (double) this.countDJRendah / this.countStadium);
        probAtribut.put("7Sedang" + label, (double) this.countDJSedang / this.countStadium);
        probAtribut.put("7Tinggi" + label, (double) this.countDJTinggi / this.countStadium);
        probAtribut.put("8Tidak" + label, (double) this.countLIATidak / this.countStadium);
        probAtribut.put("8Ya" + label, (double) this.countLIAYa / this.countStadium);
        probAtribut.put("9Normal" + label, (double) this.countOldpeakNormal / this.countStadium);
        probAtribut.put("9Beresiko" + label, (double) this.countOldpeakBeresiko / this.countStadium);
        probAtribut.put("9Buruk" + label, (double) this.countOldpeakBuruk / this.countStadium);
        probAtribut.put("10Upsloping" + label, (double) this.countUpsloping / this.countStadium);
        probAtribut.put("10Flat" + label, (double) this.countFlat / this.countStadium);
        probAtribut.put("10Downsloping" + label, (double) this.countDownsloping / this.countStadium);
        probAtribut.put("11Normal" + label, (double) this.countFloNormal / this.countStadium);
        probAtribut.put("11Arteri Koroner" + label, (double) this.countFloKoroner / this.countStadium);
        probAtribut.put("11Aneurisma" + label, (double) this.countFloAneurisma / this.countStadium);
        probAtribut.put("11Arteri Perifer" + label, (double) this.countFloPerifer / this.countStadium);
        probAtribut.put("12Normal" + label, (double) this.countThalNormal / this.countStadium);
        probAtribut.put("12Fixed Defect" + label, (double) this.countThalFixed / this.countStadium);
        probAtribut.put("12Reversable Defect" + label, (double) this.countThalReversable / this.countStadium);
        probAtribut.put(label, (double) this.countStadium / this.panjangDataLatih);
//        System.out.println("panjang data: " + panjangDataLatih);
//        System.out.println("Probabilitas " + label + ": " + probAtribut.get(label));
        reset();
    }

    public void hitungProbabilitasAtributTiapKelas() {
//        probAtribut.put("0Bayi"+label, (double) jumAtributStadium0.get("0Bayi"+label) / this.countStadium);
        probAtribut.put("0Bayi", (double) this.countBayi / this.countStadium);
        probAtribut.put("0Anak-anak", (double) this.countAnak2 / this.countStadium);
        probAtribut.put("0Remaja", (double) this.countRemaja / this.countStadium);
        probAtribut.put("0Dewasa", (double) this.countDewasa / this.countStadium);
        probAtribut.put("0Lansia", (double) this.countLansia / this.countStadium);
        probAtribut.put("1Pria", (double) this.countPria / this.countStadium);
        probAtribut.put("1Wanita", (double) this.countWanita / this.countStadium);
        probAtribut.put("2Typical Angina", (double) this.countTypical / this.countStadium);
        probAtribut.put("2Atypical Angina", (double) this.countAtypical / this.countStadium);
        probAtribut.put("2Non-Angina Pain", (double) this.countNonAngina / this.countStadium);
        probAtribut.put("2Asymptomatic", (double) this.countAsymptomatic / this.countStadium);
        probAtribut.put("3Rendah", (double) this.countTDRendah / this.countStadium);
        probAtribut.put("3Normal", (double) this.countTDNormal / this.countStadium);
        probAtribut.put("3Tinggi", (double) this.countTDTinggi / this.countStadium);
        probAtribut.put("4Normal", (double) this.countKolesterolNormal / this.countStadium);
        probAtribut.put("4Sedikit Tinggi", (double) this.countKolesterolSedikitTinggi / this.countStadium);
        probAtribut.put("4Tinggi", (double) this.countKolesterolTinggi / this.countStadium);
        probAtribut.put("5Tidak", (double) this.countKGTidak / this.countStadium);
        probAtribut.put("5Ya", (double) this.countKGYa / this.countStadium);
        probAtribut.put("6Normal", (double) this.countEKGNormal / this.countStadium);
        probAtribut.put("6ST-T Abnormal", (double) this.countEKGAbnormal / this.countStadium);
        probAtribut.put("6Hypertrophy", (double) this.countEKGHypertrofi / this.countStadium);
        probAtribut.put("7Rendah", (double) this.countDJRendah / this.countStadium);
        probAtribut.put("7Sedang", (double) this.countDJSedang / this.countStadium);
        probAtribut.put("7Tinggi", (double) this.countDJTinggi / this.countStadium);
        probAtribut.put("8Tidak", (double) this.countLIATidak / this.countStadium);
        probAtribut.put("8Ya", (double) this.countLIAYa / this.countStadium);
        probAtribut.put("9Normal", (double) this.countOldpeakNormal / this.countStadium);
        probAtribut.put("9Beresiko", (double) this.countOldpeakBeresiko / this.countStadium);
        probAtribut.put("9Buruk", (double) this.countOldpeakBuruk / this.countStadium);
        probAtribut.put("10Upsloping", (double) this.countUpsloping / this.countStadium);
        probAtribut.put("10Flat", (double) this.countFlat / this.countStadium);
        probAtribut.put("10Downsloping", (double) this.countDownsloping / this.countStadium);
        probAtribut.put("11Normal", (double) this.countFloNormal / this.countStadium);
        probAtribut.put("11Arteri Koroner", (double) this.countFloKoroner / this.countStadium);
        probAtribut.put("11Aneurisma", (double) this.countFloAneurisma / this.countStadium);
        probAtribut.put("11Arteri Perifer", (double) this.countFloPerifer / this.countStadium);
        probAtribut.put("12Normal", (double) this.countThalNormal / this.countStadium);
        probAtribut.put("12Fixed Defect", (double) this.countThalFixed / this.countStadium);
        probAtribut.put("12Reversable Defect", (double) this.countThalReversable / this.countStadium);

    }

    public void hitungNaiveBayes(double hasil[][], List<List<String>> TestingList, int kolom) {

//        System.out.println(this.probAtribut.get("Stadium " + kolom));//print probabilitas label
        double probH = this.probAtribut.get("Stadium " + kolom);
        String label = "Stadium " + kolom;

//        System.out.println("Probabilitas Stadium " + kolom + " = " + probH);
        for (int i = 0; i < TestingList.size(); i++) {
            double likehood = 1;
            for (int j = 0; j < 13; j++) {//kolom
                String getAtribut = TestingList.get(i).get(j);
//                System.out.println(getAtribut);
//                System.out.println(j + getAtribut + label);
//                System.out.println(probAtribut.get(j + getAtribut + label));
                likehood = likehood * probAtribut.get(j + getAtribut + label);
//                penyebut = penyebut * probAtrGlobal.get(j + namaAtribut);
            }
            //double PH=PH.get(label)
//            hasil[i][kolom] = (pembilang / penyebut);
            hasil[i][kolom] = likehood * probH;
        }
    }

//    public void hitungNaiveBayes(double hasil[][], List<List<String>> TestingList) {
//
//        double probS0 = this.probAtributStadium0.get("Stadium 0");
//        double probS1 = this.probAtributStadium1.get("Stadium 1");
//        double probS2 = this.probAtributStadium2.get("Stadium 2");
//        double probS3 = this.probAtributStadium3.get("Stadium 3");
//        double probS4 = this.probAtributStadium4.get("Stadium 4");
//        for (int i = 0; i < TestingList.size(); i++) {
//            double likehoodS0 = 1;
//            double likehoodS1 = 1;
//            double likehoodS2 = 1;
//            double likehoodS3 = 1;
//            double likehoodS4 = 1;
//            for (int j = 0; j < 13; j++) {
//                String getAtribut = TestingList.get(i).get(j);
//                likehoodS0 = likehoodS0 * probAtributStadium0.get(j + getAtribut);
//                likehoodS1 = likehoodS1 * probAtributStadium1.get(j + getAtribut);
//                likehoodS2 = likehoodS2 * probAtributStadium2.get(j + getAtribut);
//                likehoodS3 = likehoodS3 * probAtributStadium3.get(j + getAtribut);
//                likehoodS4 = likehoodS4 * probAtributStadium4.get(j + getAtribut);
//            }
//            //double PH=PH.get(label)
////            hasil[i][kolom] = (pembilang / penyebut);
//            hasil[i][0] = likehoodS0 * probS0;
//            hasil[i][1] = likehoodS1 * probS1;
//            hasil[i][2] = likehoodS2 * probS2;
//            hasil[i][3] = likehoodS3 * probS3;
//            hasil[i][4] = likehoodS4 * probS4;
//        }
//    }
    public int getCountStadium() {
        return countStadium;
    }

    public void setCountStadium(int countStadium) {
        this.countStadium = countStadium;
    }

    public int getCountBayi() {
        return countBayi;
    }

    public void setCountBayi(int countBayi) {
        this.countBayi = countBayi;
    }

    public int getCountAnak2() {
        return countAnak2;
    }

    public void setCountAnak2(int countAnak2) {
        this.countAnak2 = countAnak2;
    }

    public int getCountRemaja() {
        return countRemaja;
    }

    public void setCountRemaja(int countRemaja) {
        this.countRemaja = countRemaja;
    }

    public int getCountDewasa() {
        return countDewasa;
    }

    public void setCountDewasa(int countDewasa) {
        this.countDewasa = countDewasa;
    }

    public int getCountLansia() {
        return countLansia;
    }

    public void setCountLansia(int countLansia) {
        this.countLansia = countLansia;
    }

    public int getCountWanita() {
        return countWanita;
    }

    public void setCountWanita(int countWanita) {
        this.countWanita = countWanita;
    }

    public int getCountPria() {
        return countPria;
    }

    public void setCountPria(int countPria) {
        this.countPria = countPria;
    }

    public int getCountTypical() {
        return countTypical;
    }

    public void setCountTypical(int countTypical) {
        this.countTypical = countTypical;
    }

    public int getCountAtypical() {
        return countAtypical;
    }

    public void setCountAtypical(int countAtypical) {
        this.countAtypical = countAtypical;
    }

    public int getCountNonAngina() {
        return countNonAngina;
    }

    public void setCountNonAngina(int countNonAngina) {
        this.countNonAngina = countNonAngina;
    }

    public int getCountAsymptomatic() {
        return countAsymptomatic;
    }

    public void setCountAsymptomatic(int countAsymptomatic) {
        this.countAsymptomatic = countAsymptomatic;
    }

    public int getCountTDRendah() {
        return countTDRendah;
    }

    public void setCountTDRendah(int countTDRendah) {
        this.countTDRendah = countTDRendah;
    }

    public int getCountTDNormal() {
        return countTDNormal;
    }

    public void setCountTDNormal(int countTDNormal) {
        this.countTDNormal = countTDNormal;
    }

    public int getCountTDTinggi() {
        return countTDTinggi;
    }

    public void setCountTDTinggi(int countTDTinggi) {
        this.countTDTinggi = countTDTinggi;
    }

    public int getCountKolesterolRendah() {
        return countKolesterolNormal;
    }

    public void setCountKolesterolRendah(int countKolesterolRendah) {
        this.countKolesterolNormal = countKolesterolRendah;
    }

    public int getCountKolesterolSedang() {
        return countKolesterolSedikitTinggi;
    }

    public void setCountKolesterolSedang(int countKolesterolSedang) {
        this.countKolesterolSedikitTinggi = countKolesterolSedang;
    }

    public int getCountKolesterolTinggi() {
        return countKolesterolTinggi;
    }

    public void setCountKolesterolTinggi(int countKolesterolTinggi) {
        this.countKolesterolTinggi = countKolesterolTinggi;
    }

    public int getCountKGTidak() {
        return countKGTidak;
    }

    public void setCountKGTidak(int countKGTidak) {
        this.countKGTidak = countKGTidak;
    }

    public int getCountKGYa() {
        return countKGYa;
    }

    public void setCountKGYa(int countKGYa) {
        this.countKGYa = countKGYa;
    }

    public int getCountEKGNormal() {
        return countEKGNormal;
    }

    public void setCountEKGNormal(int countEKGNormal) {
        this.countEKGNormal = countEKGNormal;
    }

    public int getCountEKGAbnormal() {
        return countEKGAbnormal;
    }

    public void setCountEKGAbnormal(int countEKGAbnormal) {
        this.countEKGAbnormal = countEKGAbnormal;
    }

    public int getCountEKGHypertrofi() {
        return countEKGHypertrofi;
    }

    public void setCountEKGHypertrofi(int countEKGHypertrofi) {
        this.countEKGHypertrofi = countEKGHypertrofi;
    }

    public int getCountDJRendah() {
        return countDJRendah;
    }

    public void setCountDJRendah(int countDJRendah) {
        this.countDJRendah = countDJRendah;
    }

    public int getCountDJSedang() {
        return countDJSedang;
    }

    public void setCountDJSedang(int countDJSedang) {
        this.countDJSedang = countDJSedang;
    }

    public int getCountDJTinggi() {
        return countDJTinggi;
    }

    public void setCountDJTinggi(int countDJTinggi) {
        this.countDJTinggi = countDJTinggi;
    }

    public int getCountLIATidak() {
        return countLIATidak;
    }

    public void setCountLIATidak(int countLIATidak) {
        this.countLIATidak = countLIATidak;
    }

    public int getCountLIAYa() {
        return countLIAYa;
    }

    public void setCountLIAYa(int countLIAYa) {
        this.countLIAYa = countLIAYa;
    }

    public int getCountOldpeakNormal() {
        return countOldpeakNormal;
    }

    public void setCountOldpeakNormal(int countOldpeakNormal) {
        this.countOldpeakNormal = countOldpeakNormal;
    }

    public int getCountOldpeakBeresiko() {
        return countOldpeakBeresiko;
    }

    public void setCountOldpeakBeresiko(int countOldpeakBeresiko) {
        this.countOldpeakBeresiko = countOldpeakBeresiko;
    }

    public int getCountOldpeakBuruk() {
        return countOldpeakBuruk;
    }

    public void setCountOldpeakBuruk(int countOldpeakBuruk) {
        this.countOldpeakBuruk = countOldpeakBuruk;
    }

    public int getCountUpsloping() {
        return countUpsloping;
    }

    public void setCountUpsloping(int countUpsloping) {
        this.countUpsloping = countUpsloping;
    }

    public int getCountFlat() {
        return countFlat;
    }

    public void setCountFlat(int countFlat) {
        this.countFlat = countFlat;
    }

    public int getCountDownsloping() {
        return countDownsloping;
    }

    public void setCountDownsloping(int countDownsloping) {
        this.countDownsloping = countDownsloping;
    }

    public int getCountFloNormal() {
        return countFloNormal;
    }

    public void setCountFloNormal(int countFloNormal) {
        this.countFloNormal = countFloNormal;
    }

    public int getCountFloKoroner() {
        return countFloKoroner;
    }

    public void setCountFloKoroner(int countFloKoroner) {
        this.countFloKoroner = countFloKoroner;
    }

    public int getCountFloAneurisma() {
        return countFloAneurisma;
    }

    public void setCountFloAneurisma(int countFloAneurisma) {
        this.countFloAneurisma = countFloAneurisma;
    }

    public int getCountFloPerifer() {
        return countFloPerifer;
    }

    public void setCountFloPerifer(int countFloPerifer) {
        this.countFloPerifer = countFloPerifer;
    }

    public int getCountThalNormal() {
        return countThalNormal;
    }

    public void setCountThalNormal(int countThalNormal) {
        this.countThalNormal = countThalNormal;
    }

    public int getCountThalFixed() {
        return countThalFixed;
    }

    public void setCountThalFixed(int countThalFixed) {
        this.countThalFixed = countThalFixed;
    }

    public int getCountThalReversable() {
        return countThalReversable;
    }

    public void setCountThalReversable(int countThalReversable) {
        this.countThalReversable = countThalReversable;
    }

    private void reset() {
        this.countStadium = 0;
        this.countBayi = 0;
        this.countAnak2 = 0;
        this.countRemaja = 0;
        this.countDewasa = 0;
        this.countLansia = 0;
        this.countWanita = 0;
        this.countPria = 0;
        this.countTypical = 0;
        this.countAtypical = 0;
        this.countNonAngina = 0;
        this.countAsymptomatic = 0;
        this.countTDRendah = 0;
        this.countTDNormal = 0;
        this.countTDTinggi = 0;
        this.countKolesterolNormal = 0;
        this.countKolesterolSedikitTinggi = 0;
        this.countKolesterolTinggi = 0;
        this.countKGTidak = 0;
        this.countKGYa = 0;
        this.countEKGNormal = 0;
        this.countEKGAbnormal = 0;
        this.countEKGHypertrofi = 0;
        this.countDJRendah = 0;
        this.countDJSedang = 0;
        this.countDJTinggi = 0;
        this.countLIATidak = 0;
        this.countLIAYa = 0;
        this.countOldpeakNormal = 0;
        this.countOldpeakBeresiko = 0;
        this.countOldpeakBuruk = 0;
        this.countUpsloping = 0;
        this.countFlat = 0;
        this.countDownsloping = 0;
        this.countFloNormal = 0;
        this.countFloKoroner = 0;
        this.countFloAneurisma = 0;
        this.countFloPerifer = 0;
        this.countThalNormal = 0;
        this.countThalFixed = 0;
        this.countThalReversable = 0;
    }

//    public m_hitungNaiveBayes(c_hitungNaiveBayes nb0, c_hitungNaiveBayes nb1, c_hitungNaiveBayes nb2, c_hitungNaiveBayes nb3, c_hitungNaiveBayes nb4, HashMap<String, Double> probAtributGlobal) {
//
//        probAtribut = new HashMap<>();
//        this.countStadium = (nb0.getCountStadium() + nb1.getCountStadium() + nb2.getCountStadium() + nb3.getCountStadium() + nb4.getCountStadium());
//        this.countBayi = (nb0.getCountBayi() + nb1.getCountBayi() + nb2.getCountBayi() + nb3.getCountBayi() + nb4.getCountBayi());
//        this.countAnak2 = (nb0.getCountAnak2() + nb1.getCountAnak2() + nb2.getCountAnak2() + nb3.getCountAnak2() + nb4.getCountAnak2());
//        this.countRemaja = (nb0.getCountRemaja() + nb1.getCountRemaja() + nb2.getCountRemaja() + nb3.getCountRemaja() + nb4.getCountRemaja());
//        this.countWanita = (nb0.getCountWanita() + nb1.getCountWanita() + nb2.getCountWanita() + nb3.getCountWanita() + nb4.getCountWanita());
//        this.countPria = (nb0.getCountPria() + nb1.getCountPria() + nb2.getCountPria() + nb3.getCountPria() + nb4.getCountPria());
//        this.countTypical = (nb0.getCountTypical() + nb1.getCountTypical() + nb2.getCountTypical() + nb3.getCountTypical() + nb4.getCountTypical());
//        this.countAtypical = (nb0.getCountAtypical() + nb1.getCountAtypical() + nb2.getCountAtypical() + nb3.getCountAtypical() + nb4.getCountAtypical());
//        this.countNonAngina = (nb0.getCountNonAngina() + nb1.getCountNonAngina() + nb2.getCountNonAngina() + nb3.getCountNonAngina() + nb4.getCountNonAngina());
//        this.countAsymptomatic = (nb0.getCountAsymptomatic() + nb1.getCountAsymptomatic() + nb2.getCountAsymptomatic() + nb3.getCountAsymptomatic() + nb4.getCountAsymptomatic());
//        this.countTDRendah = (nb0.getCountTDRendah() + nb1.getCountTDRendah() + nb2.getCountTDRendah() + nb3.getCountTDRendah() + nb4.getCountTDRendah());
//        this.countTDNormal = (nb0.getCountTDNormal() + nb1.getCountTDNormal() + nb2.getCountTDNormal() + nb3.getCountTDNormal() + nb4.getCountTDNormal());
//        this.countTDTinggi = (nb0.getCountTDTinggi() + nb1.getCountTDTinggi() + nb2.getCountTDTinggi() + nb3.getCountTDTinggi() + nb4.getCountTDTinggi());
//        this.countKolesterolNormal = (nb0.getCountKolesterolRendah() + nb1.getCountKolesterolRendah() + nb2.getCountKolesterolRendah() + nb3.getCountKolesterolRendah() + nb4.getCountKolesterolRendah());
//        this.countKolesterolSedikitTinggi = (nb0.getCountKolesterolSedang() + nb1.getCountKolesterolSedang() + nb2.getCountKolesterolSedang() + nb3.getCountKolesterolSedang() + nb4.getCountKolesterolSedang());
//        this.countKolesterolTinggi = (nb0.getCountKolesterolTinggi() + nb1.getCountKolesterolTinggi() + nb2.getCountKolesterolTinggi() + nb3.getCountKolesterolTinggi() + nb4.getCountKolesterolTinggi());
//        this.countKGTidak = (nb0.getCountKGTidak() + nb1.getCountKGTidak() + nb2.getCountKGTidak() + nb3.getCountKGTidak() + nb4.getCountKGTidak());
//        this.countKGYa = (nb0.getCountKGYa() + nb1.getCountKGYa() + nb2.getCountKGYa() + nb3.getCountKGYa() + nb4.getCountKGYa());
//        this.countEKGNormal = (nb0.getCountEKGNormal() + nb1.getCountEKGNormal() + nb2.getCountEKGNormal() + nb3.getCountEKGNormal() + nb4.getCountEKGNormal());
//        this.countEKGAbnormal = (nb0.getCountEKGAbnormal() + nb1.getCountEKGAbnormal() + nb2.getCountEKGAbnormal() + nb3.getCountEKGAbnormal() + nb4.getCountEKGAbnormal());
//        this.countEKGHypertrofi = (nb0.getCountEKGHypertrofi() + nb1.getCountEKGHypertrofi() + nb2.getCountEKGHypertrofi() + nb3.getCountEKGHypertrofi() + nb4.getCountEKGHypertrofi());
//        this.countDJRendah = (nb0.getCountDJRendah() + nb1.getCountDJRendah() + nb2.getCountDJRendah() + nb3.getCountDJRendah() + nb4.getCountDJRendah());
//        this.countDJSedang = (nb0.getCountDJSedang() + nb1.getCountDJSedang() + nb2.getCountDJSedang() + nb3.getCountDJSedang() + nb4.getCountDJSedang());
//        this.countDJTinggi = (nb0.getCountDJTinggi() + nb1.getCountDJTinggi() + nb2.getCountDJTinggi() + nb3.getCountDJTinggi() + nb4.getCountDJTinggi());
//        this.countLIATidak = (nb0.getCountLIATidak() + nb1.getCountLIATidak() + nb2.getCountLIATidak() + nb3.getCountLIATidak() + nb4.getCountLIATidak());
//        this.countLIAYa = (nb0.getCountLIAYa() + nb1.getCountLIAYa() + nb2.getCountLIAYa() + nb3.getCountLIAYa() + nb4.getCountLIAYa());
//        this.countOldpeakNormal = (nb0.getCountOldpeakNormal() + nb1.getCountOldpeakNormal() + nb2.getCountOldpeakNormal() + nb3.getCountOldpeakNormal() + nb4.getCountOldpeakNormal());
//        this.countOldpeakBeresiko = (nb0.getCountOldpeakBeresiko() + nb1.getCountOldpeakBeresiko() + nb2.getCountOldpeakBeresiko() + nb3.getCountOldpeakBeresiko() + nb4.getCountOldpeakBeresiko());
//        this.countOldpeakBuruk = (nb0.getCountOldpeakBuruk() + nb1.getCountOldpeakBuruk() + nb2.getCountOldpeakBuruk() + nb3.getCountOldpeakBuruk() + nb4.getCountOldpeakBuruk());
//        this.countUpsloping = (nb0.getCountUpsloping() + nb1.getCountUpsloping() + nb2.getCountUpsloping() + nb3.getCountUpsloping() + nb4.getCountUpsloping());
//        this.countFlat = (nb0.getCountFlat() + nb1.getCountFlat() + nb2.getCountFlat() + nb3.getCountFlat() + nb4.getCountFlat());
//        this.countDownsloping = (nb0.getCountDownsloping() + nb1.getCountDownsloping() + nb2.getCountDownsloping() + nb3.getCountDownsloping() + nb4.getCountDownsloping());
//        this.countFloNormal = (nb0.getCountFloNormal() + nb1.getCountFloNormal() + nb2.getCountFloNormal() + nb3.getCountFloNormal() + nb4.getCountFloNormal());
//        this.countFloKoroner = (nb0.getCountFloKoroner() + nb1.getCountFloKoroner() + nb2.getCountFloKoroner() + nb3.getCountFloKoroner() + nb4.getCountFloKoroner());
//        this.countFloAneurisma = (nb0.getCountFloAneurisma() + nb1.getCountFloAneurisma() + nb2.getCountFloAneurisma() + nb3.getCountFloAneurisma() + nb4.getCountFloAneurisma());
//        this.countFloPerifer = (nb0.getCountFloPerifer() + nb1.getCountFloPerifer() + nb2.getCountFloPerifer() + nb3.getCountFloPerifer() + nb4.getCountFloPerifer());
//        this.countThalNormal = (nb0.getCountThalNormal() + nb1.getCountThalNormal() + nb2.getCountThalNormal() + nb3.getCountThalNormal() + nb4.getCountThalNormal());
//        this.countThalFixed = (nb0.getCountThalFixed() + nb1.getCountThalFixed() + nb2.getCountThalFixed() + nb3.getCountThalFixed() + nb4.getCountThalFixed());
//        this.countThalReversable = (nb0.getCountThalReversable() + nb1.getCountThalReversable() + nb2.getCountThalReversable() + nb3.getCountThalReversable() + nb4.getCountThalReversable());
////        hitungProbabilitasAtributTiapKelas();
//        probAtributGlobal.putAll(this.probAtribut);
//    }
//    public m_hitungNaiveBayes(List<List<String>> TrainData, List<List<String>> TestData, double[][] hasil) {
//        probAtribut = new HashMap<>();
////        probAtributS0 = new HashMap<>();
////        probAtributS1 = new HashMap<>();
////        probAtributS2 = new HashMap<>();
////        probAtributS3 = new HashMap<>();
////        probAtributS4 = new HashMap<>();
//        HashMap<String, Double> probAtributStadium0 = new HashMap<>();
//        HashMap<String, Double> probAtributStadium1 = new HashMap<>();
//        HashMap<String, Double> probAtributStadium2 = new HashMap<>();
//        HashMap<String, Double> probAtributStadium3 = new HashMap<>();
//        HashMap<String, Double> probAtributStadium4 = new HashMap<>();
////        HashMap<String, Double> jumAtributStadium0 = new HashMap<>();
////        HashMap<String, Double> jumbAtributStadium1 = new HashMap<>();
////        HashMap<String, Double> jumbAtributStadium2 = new HashMap<>();
////        HashMap<String, Double> jumbAtributStadium3 = new HashMap<>();
////        HashMap<String, Double> jumbAtributStadium4 = new HashMap<>();
//        hitungJumKriteriaAtributTiapKelas(TrainData, "Stadium 0");
//        hitungProbabilitasAtributTiapKelas(probAtributStadium0);
//        probAtributStadium0.putAll(probAtributS0);
//        reset();
//        hitungJumKriteriaAtributTiapKelas(TrainData, "Stadium 1");
//        hitungProbabilitasAtributTiapKelas(probAtributStadium1);
//        probAtributStadium1.putAll(probAtributS1);
//        reset();
//        hitungJumKriteriaAtributTiapKelas(TrainData, "Stadium 2");
//        hitungProbabilitasAtributTiapKelas(probAtributStadium2);
//        probAtributStadium2.putAll(probAtributS2);
//        reset();
//        hitungJumKriteriaAtributTiapKelas(TrainData, "Stadium 3");
//        hitungProbabilitasAtributTiapKelas(probAtributStadium3);
//        probAtributStadium3.putAll(probAtributS3);
//        reset();
//        hitungJumKriteriaAtributTiapKelas(TrainData, "Stadium 4");
//        hitungProbabilitasAtributTiapKelas(probAtributStadium4);
//        probAtributStadium4.putAll(probAtributS4);
//        reset();
//        hitungNaiveBayes(hasil, TestData);
//    }
}
