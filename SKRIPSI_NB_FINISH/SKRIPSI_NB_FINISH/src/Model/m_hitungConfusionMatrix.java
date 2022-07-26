package Model;

public class m_hitungConfusionMatrix {

    int truePositive;
    int falsePositive;
    int trueNegative;
    int falseNegative;
    double akurasi;
    double presisi;
    double recall;
    double specificity;

    public m_hitungConfusionMatrix() {
        this.truePositive = 0;
        this.falsePositive = 0;
        this.trueNegative = 0;
        this.falseNegative = 0;
        this.akurasi = 0;
        this.presisi = 0;
        this.recall = 0;
        this.specificity = 0;
    }

    public m_hitungConfusionMatrix(String[][] data) {
        this.truePositive = 0;
        this.falsePositive = 0;
        this.trueNegative = 0;
        this.falseNegative = 0;
        this.akurasi = 0;
        this.presisi = 0;
        this.recall = 0;
        this.specificity = 0;
    }

//    public m_hitungConfusionMatrix(m_hitungConfusionMatrix s0, m_hitungConfusionMatrix s1, m_hitungConfusionMatrix s2, m_hitungConfusionMatrix s3, m_hitungConfusionMatrix s4) {
//        setRata2Akurasi(s0, s1, s2, s3, s4);
//        setRata2Presisi(s0, s1, s2, s3, s4);
//        setRata2Recall(s0, s1, s2, s3, s4);
//        setRata2Specificity(s0, s1, s2, s3, s4);
//    }
    public m_hitungConfusionMatrix(int[][] data, int stadium) {
        
        setTP(data, stadium);
        setFP(data, stadium);
        setFN(data, stadium);
        setTN(data, stadium);
//        setAkurasi();
        setPresisi();
        setRecall();
        setSpecificity();
    }

    public int getTruePositive() {
        return truePositive;
    }

    public void setTruePositive(int truePositive) {
        this.truePositive = truePositive;
    }

    public int getTrueNegative() {
        return trueNegative;
    }

    public void setTrueNegative(int trueNegative) {
        this.trueNegative = trueNegative;
    }

    public int getFalsePositive() {
        return falsePositive;
    }

    public void setFalsePositive(int falsePositive) {
        this.falsePositive = falsePositive;
    }

    public int getFalseNegative() {
        return falseNegative;
    }

    public void setFalseNegative(int falseNegative) {
        this.falseNegative = falseNegative;
    }

    public double getAkurasi() {
        return akurasi;
    }

    public void setAkurasi(double akurasi) {
        this.akurasi = akurasi;
    }

    private void setAkurasi() {
        int penyebut = this.truePositive + this.trueNegative + this.falseNegative + this.falsePositive;
        if (penyebut > 0) {
            this.akurasi = (double) (this.truePositive + this.trueNegative) / penyebut;
        } else {
            this.akurasi = 0;
        }
    }

    public double getPresisi() {
        return presisi;
    }

    public void setPresisi(double presisi) {
        this.presisi = presisi;
    }

    private void setPresisi() {
        int penyebut = this.truePositive + this.falsePositive;
        if (penyebut > 0) {
            this.presisi = (double) (this.truePositive) / penyebut;
        } else {
            this.presisi = 0;
        }
    }

    public double getRecall() {
        return recall;
    }

    public void setRecall(double recall) {
        this.recall = recall;
    }

    private void setRecall() {
        int penyebut = this.truePositive + this.falseNegative;
        if (penyebut > 0) {
            this.recall = (double) this.truePositive / penyebut;
        } else {
            this.recall = 0;
        }

    }

    public double getSpecificity() {
        return specificity;
    }

    public void setSpecificity(double specificity) {
        this.specificity = specificity;
    }

    private void setSpecificity() {
        int penyebut = this.trueNegative + this.falsePositive;
        if (penyebut > 0) {
            this.specificity = (double) this.trueNegative / (penyebut);
        } else {
            this.specificity = 0;
        }

    }

    private void setTP(int[][] data, int stadium) {
        this.truePositive = data[stadium][stadium];
    }

    private void setFP(int[][] data, int stadium) {
        for (int i = 0; i < data[0].length; i++) {
            this.falsePositive = this.falsePositive + data[i][stadium];
        }
        this.falsePositive = this.falsePositive - data[stadium][stadium];
    }

    private void setFN(int[][] data, int stadium) {
        for (int i = 0; i < data[0].length; i++) {
            this.falseNegative = this.falseNegative + data[stadium][i];
        }
        this.falseNegative = this.falseNegative - data[stadium][stadium];
    }

    private void setTN(int[][] data, int stadium) {
        int jumlah = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                jumlah = jumlah + data[i][j];
            }
        }

        this.trueNegative = jumlah - (this.truePositive + this.falseNegative + this.falsePositive);
    }

//    public double getRata2akurasi() {
//        return rata2akurasi;
//    }
//
//    public void setRata2akurasi(double rata2akurasi) {
//        this.rata2akurasi = rata2akurasi;
//    }
//
//    private void setRata2Akurasi(m_hitungConfusionMatrix s0, m_hitungConfusionMatrix s1, m_hitungConfusionMatrix s2, m_hitungConfusionMatrix s3, m_hitungConfusionMatrix s4) {
//        this.rata2akurasi = (double) (s0.getAkurasi() + s1.getAkurasi() + s2.getAkurasi() + s3.getAkurasi() + s4.getAkurasi()) / 5;
//    }
//
//    public double getRata2presisi() {
//        return rata2presisi;
//    }
//
//    public void setRata2presisi(double rata2presisi) {
//        this.rata2presisi = rata2presisi;
//    }
//
//    private void setRata2Presisi(m_hitungConfusionMatrix s0, m_hitungConfusionMatrix s1, m_hitungConfusionMatrix s2, m_hitungConfusionMatrix s3, m_hitungConfusionMatrix s4) {
//        this.rata2presisi = (s0.getPresisi() + s1.getPresisi() + s2.getPresisi() + s3.getPresisi() + s4.getPresisi()) / 5;
//    }
//
//    public double getRata2recall() {
//        return rata2recall;
//    }
//
//    public void setRata2recall(double rata2recall) {
//        this.rata2recall = rata2recall;
//    }
//
//    private void setRata2Recall(m_hitungConfusionMatrix s0, m_hitungConfusionMatrix s1, m_hitungConfusionMatrix s2, m_hitungConfusionMatrix s3, m_hitungConfusionMatrix s4) {
//        this.rata2recall = (s0.getRecall() + s1.getRecall() + s2.getRecall() + s3.getRecall() + s4.getRecall()) / 5;
//    }
//
//    public double getRata2specificity() {
//        return rata2specificity;
//    }
//
//    public void setRata2specificity(double rata2specificity) {
//        this.rata2specificity = rata2specificity;
//    }
//
//    private void setRata2Specificity(m_hitungConfusionMatrix s0, m_hitungConfusionMatrix s1, m_hitungConfusionMatrix s2, m_hitungConfusionMatrix s3, m_hitungConfusionMatrix s4) {
//        this.rata2specificity = (s0.getSpecificity() + s1.getSpecificity() + s2.getSpecificity() + s3.getSpecificity() + s4.getSpecificity()) / 5;
//    }
}
