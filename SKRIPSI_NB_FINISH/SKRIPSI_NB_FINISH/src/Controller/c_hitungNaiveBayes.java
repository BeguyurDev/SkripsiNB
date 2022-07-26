package Controller;

import Model.m_hitungNaiveBayes;
import java.util.List;

public class c_hitungNaiveBayes {
    m_hitungNaiveBayes NaiveBayes;


    public c_hitungNaiveBayes() {
        this.NaiveBayes = new m_hitungNaiveBayes();
    }
    
//    public c_hitungNaiveBayes(c_hitungNaiveBayes nb0,c_hitungNaiveBayes nb1,c_hitungNaiveBayes nb2,c_hitungNaiveBayes nb3,c_hitungNaiveBayes nb4,HashMap<String, Double> probAtributGlobal) {
//        this.NaiveBayes = new m_hitungNaiveBayes(nb0,nb1,nb2,nb3,nb4,probAtributGlobal);
//    }
    
//    public void hitungJumKriteriaAtributTiapKelas(List<List<String>> TrainingList, String label, m_prosesData stadium, m_prosesData countAtr) {
//        NaiveBayes.hitungJumKriteriaAtributTiapKelas(TrainingList, label, stadium, countAtr);
//    }
    
//    public void hitungJumKriteriaAtributTiapKelas(List<List<String>> TrainingList, String label, m_prosesData stadium) {
//        ata.hitungJumKriteriaAtributTiapKelas(TrainingList, label, stadium);
//    }
    public void hitungJumKriteriaAtributTiapKelasDataLatih(List<List<String>> TrainingList, String label) {
        NaiveBayes.hitungJumKriteriaAtributKelas(TrainingList, label);
    }
    
    public void hitungProbabilitasAtribut() {
        NaiveBayes.hitungProbabilitasAtributTiapKelas();
    }
    
    public void hitungProbabilitasAtribut(String label) {
        NaiveBayes.hitungProbabilitasAtributKelas(label);
    }

//    public int tabelConfusionMatrix(String aktual, String prediksi, String[][] kesimpulanPrediksi) {
//        return NaiveBayes.tabelConfusionMatrix(aktual, prediksi, kesimpulanPrediksi);
//    }
    
    public void hitungNaiveBayes(double hasil[][],List<List<String>> TestingList, int kolom) {        
        NaiveBayes.hitungNaiveBayes(hasil, TestingList, kolom);
    }
    
    public int getCountStadium() {
        return NaiveBayes.getCountStadium();
    }

    public void setCountStadium(int countStadium) {
        NaiveBayes.setCountStadium(countStadium);
    }

    public int getCountBayi() {
        return NaiveBayes.getCountBayi();
    }

    public void setCountBayi(int countBayi) {
        NaiveBayes.setCountBayi(countBayi);
    }

    public int getCountAnak2() {
        return NaiveBayes.getCountAnak2();
    }

    public void setCountAnak2(int countAnak2) {
        NaiveBayes.setCountAnak2(countAnak2);
    }

    public int getCountRemaja() {
        return NaiveBayes.getCountRemaja();
    }

    public void setCountRemaja(int countRemaja) {
        NaiveBayes.setCountRemaja(countRemaja);
    }
    
    public int getCountDewasa() {
        return NaiveBayes.getCountDewasa();
    }

    public void setCountDewasa(int countDewasa) {
        NaiveBayes.setCountDewasa(countDewasa);
    }
    
    public int getCountLansia() {
        return NaiveBayes.getCountLansia();
    }

    public void setCountLansia(int countLansia) {
        NaiveBayes.setCountLansia(countLansia);
    }

    public int getCountWanita() {
        return NaiveBayes.getCountWanita();
    }

    public void setCountWanita(int countWanita) {
        NaiveBayes.setCountWanita(countWanita);
    }

    public int getCountPria() {
        return NaiveBayes.getCountPria();
    }

    public void setCountPria(int countPria) {
        NaiveBayes.setCountPria(countPria);
    }

    public int getCountTypical() {
        return NaiveBayes.getCountTypical();
    }

    public void setCountTypical(int countTypical) {
        NaiveBayes.setCountTypical(countTypical);
    }

    public int getCountAtypical() {
        return NaiveBayes.getCountAtypical();
    }

    public void setCountAtypical(int countAtypical) {
        NaiveBayes.setCountAtypical(countAtypical);
    }

    public int getCountNonAngina() {
        return NaiveBayes.getCountNonAngina();
    }

    public void setCountNonAngina(int countNonAngina) {
        NaiveBayes.setCountNonAngina(countNonAngina);
    }

    public int getCountAsymptomatic() {
        return NaiveBayes.getCountAsymptomatic();
    }

    public void setCountAsymptomatic(int countAsymptomatic) {
        NaiveBayes.setCountAsymptomatic(countAsymptomatic);
    }

    public int getCountTDRendah() {
        return NaiveBayes.getCountTDRendah();
    }

    public void setCountTDRendah(int countTDRendah) {
        NaiveBayes.setCountTDRendah(countTDRendah);
    }

    public int getCountTDNormal() {
        return NaiveBayes.getCountTDNormal();
    }

    public void setCountTDNormal(int countTDNormal) {
        NaiveBayes.setCountTDNormal(countTDNormal);
    }

    public int getCountTDTinggi() {
        return NaiveBayes.getCountTDTinggi();
    }

    public void setCountTDTinggi(int countTDTinggi) {
        NaiveBayes.setCountTDTinggi(countTDTinggi);
    }

    public int getCountKolesterolRendah() {
        return NaiveBayes.getCountKolesterolRendah();
    }

    public void setCountKolesterolRendah(int countKolesterolRendah) {
        NaiveBayes.setCountKolesterolRendah(countKolesterolRendah);
    }

    public int getCountKolesterolSedang() {
        return NaiveBayes.getCountKolesterolSedang();
    }

    public void setCountKolesterolSedang(int countKolesterolSedang) {
        NaiveBayes.setCountKolesterolSedang(countKolesterolSedang);
    }

    public int getCountKolesterolTinggi() {
        return NaiveBayes.getCountKolesterolTinggi();
    }

    public void setCountKolesterolTinggi(int countKolesterolTinggi) {
        NaiveBayes.setCountKolesterolTinggi(countKolesterolTinggi);
    }

    public int getCountKGTidak() {
        return NaiveBayes.getCountKGTidak();
    }

    public void setCountKGTidak(int countKGTidak) {
        NaiveBayes.setCountKGTidak(countKGTidak);
    }

    public int getCountKGYa() {
        return NaiveBayes.getCountKGYa();
    }

    public void setCountKGYa(int countKGYa) {
        NaiveBayes.setCountKGYa(countKGYa);
    }

    public int getCountEKGNormal() {
        return NaiveBayes.getCountEKGNormal();
    }

    public void setCountEKGNormal(int countEKGNormal) {
        NaiveBayes.setCountEKGNormal(countEKGNormal);
    }

    public int getCountEKGAbnormal() {
        return NaiveBayes.getCountEKGAbnormal();
    }

    public void setCountEKGAbnormal(int countEKGAbnormal) {
        NaiveBayes.setCountEKGAbnormal(countEKGAbnormal);
    }

    public int getCountEKGHypertrofi() {
        return NaiveBayes.getCountEKGHypertrofi();
    }

    public void setCountEKGHypertrofi(int countEKGHypertrofi) {
        NaiveBayes.setCountEKGHypertrofi(countEKGHypertrofi);
    }

    public int getCountDJRendah() {
        return NaiveBayes.getCountDJRendah();
    }

    public void setCountDJRendah(int countDJRendah) {
        NaiveBayes.setCountDJRendah(countDJRendah);
    }

    public int getCountDJSedang() {
        return NaiveBayes.getCountDJSedang();
    }

    public void setCountDJSedang(int countDJSedang) {
        NaiveBayes.setCountDJSedang(countDJSedang);
    }

    public int getCountDJTinggi() {
        return NaiveBayes.getCountDJTinggi();
    }

    public void setCountDJTinggi(int countDJTinggi) {
        NaiveBayes.setCountDJTinggi(countDJTinggi);
    }

    public int getCountLIATidak() {
        return NaiveBayes.getCountLIATidak();
    }

    public void setCountLIATidak(int countLIATidak) {
        NaiveBayes.setCountLIATidak(countLIATidak);
    }

    public int getCountLIAYa() {
        return NaiveBayes.getCountLIAYa();
    }

    public void setCountLIAYa(int countLIAYa) {
        NaiveBayes.setCountLIAYa(countLIAYa);
    }

    public int getCountOldpeakNormal() {
        return NaiveBayes.getCountOldpeakNormal();
    }

    public void setCountOldpeakNormal(int countOldpeakNormal) {
        NaiveBayes.setCountOldpeakNormal(countOldpeakNormal);
    }

    public int getCountOldpeakBeresiko() {
        return NaiveBayes.getCountOldpeakBeresiko();
    }

    public void setCountOldpeakBeresiko(int countOldpeakBeresiko) {
        NaiveBayes.setCountOldpeakBeresiko(countOldpeakBeresiko);
    }

    public int getCountOldpeakBuruk() {
        return NaiveBayes.getCountOldpeakBuruk();
    }

    public void setCountOldpeakBuruk(int countOldpeakBuruk) {
        NaiveBayes.setCountOldpeakBuruk(countOldpeakBuruk);
    }

    public int getCountUpsloping() {
        return NaiveBayes.getCountUpsloping();
    }

    public void setCountUpsloping(int countUpsloping) {
        NaiveBayes.setCountUpsloping(countUpsloping);
    }

    public int getCountFlat() {
        return NaiveBayes.getCountFlat();
    }

    public void setCountFlat(int countFlat) {
        NaiveBayes.setCountFlat(countFlat);
    }

    public int getCountDownsloping() {
        return NaiveBayes.getCountDownsloping();
    }

    public void setCountDownsloping(int countDownsloping) {
        NaiveBayes.setCountDownsloping(countDownsloping);
    }

    public int getCountFloNormal() {
        return NaiveBayes.getCountFloNormal();
    }

    public void setCountFloNormal(int countFloNormal) {
        NaiveBayes.setCountFloNormal(countFloNormal);
    }

    public int getCountFloKoroner() {
        return NaiveBayes.getCountFloKoroner();
    }

    public void setCountFloKoroner(int countFloKoroner) {
        NaiveBayes.setCountFloKoroner(countFloKoroner);
    }

    public int getCountFloAneurisma() {
        return NaiveBayes.getCountFloAneurisma();
    }

    public void setCountFloAneurisma(int countFloAneurisma) {
        NaiveBayes.setCountFloAneurisma(countFloAneurisma);
    }

    public int getCountFloPerifer() {
        return NaiveBayes.getCountFloPerifer();
    }

    public void setCountFloPerifer(int countFloPerifer) {
        NaiveBayes.setCountFloPerifer(countFloPerifer);
    }

    public int getCountThalNormal() {
        return NaiveBayes.getCountThalNormal();
    }

    public void setCountThalNormal(int countThalNormal) {
        NaiveBayes.setCountThalNormal(countThalNormal);
    }

    public int getCountThalFixed() {
        return NaiveBayes.getCountThalFixed();
    }

    public void setCountThalFixed(int countThalFixed) {
        NaiveBayes.setCountThalFixed(countThalFixed);
    }

    public int getCountThalReversable() {
        return NaiveBayes.getCountThalReversable();
    }

    public void setCountThalReversable(int countThalReversable) {
        NaiveBayes.setCountThalReversable(countThalReversable);
    }
}
