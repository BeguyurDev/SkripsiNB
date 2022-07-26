package Controller;

import Model.m_hitungConfusionMatrix;

public class c_hitungConfusionMatrix {
    m_hitungConfusionMatrix cf;

    public c_hitungConfusionMatrix() {
        this.cf = new m_hitungConfusionMatrix();
    }

    public c_hitungConfusionMatrix(int data[][],int stadium) {
        this.cf = new m_hitungConfusionMatrix(data, stadium);
    }
    
    public c_hitungConfusionMatrix(String data[][]) {
        this.cf = new m_hitungConfusionMatrix(data);
    }

//    public c_hitungConfusionMatrix(m_hitungConfusionMatrix s0,m_hitungConfusionMatrix s1,m_hitungConfusionMatrix s2,m_hitungConfusionMatrix s3,m_hitungConfusionMatrix s4) {
//        this.cf = new m_hitungConfusionMatrix(s0,s1, s2, s3, s4);
//    }
    
//    public double getRata2akurasi() {
//        return cf.getRata2akurasi();
//    }
//
//    public void setRata2akurasi(double rata2akurasi) {
//        cf.setRata2akurasi(rata2akurasi);
//    }
//    
//
//    public double getRata2presisi() {
//        return cf.getRata2presisi();
//    }
//
//    public void setRata2presisi(double rata2presisi) {
//        cf.setRata2presisi(rata2presisi);
//    }
//
//    public double getRata2recall() {
//        return cf.getRata2recall();
//    }
//
//    public void setRata2recall(double rata2recall) {
//        cf.setRata2recall(rata2recall);
//    }
//    
//    public double getRata2specificity() {
//        return cf.getRata2specificity();
//    }
//
//    public void setRata2specificity(double rata2specificity) {
//        cf.setRata2specificity(rata2specificity);
//    }

    public int getTruePositive() {
        return cf.getTruePositive();
    }

    public void setTruePositive(int truePositive) {
        cf.setTruePositive(truePositive);
    }

    public int getTrueNegative() {
        return cf.getTrueNegative();
    }

    public void setTrueNegative(int trueNegative) {
        cf.setTrueNegative(trueNegative);
    }

    public int getFalsePositive() {
        return cf.getFalsePositive();
    }

    public void setFalsePositive(int falsePositive) {
        cf.setFalsePositive(falsePositive);
    }

    public int getFalseNegative() {
        return cf.getFalseNegative();
    }

    public void setFalseNegative(int falseNegative) {
        cf.setFalseNegative(falseNegative);
    }

    public double getAkurasi() {
        return cf.getAkurasi();
    }

    public void setAkurasi(double akurasi) {
        cf.getAkurasi();
    }

    public double getPresisi() {
        return cf.getPresisi();
    }

    public void setPresisi(double presisi) {
        cf.setPresisi(presisi);
    }    

    public double getRecall() {
        return cf.getRecall();
    }

    public void setRecall(double recall) {
        cf.setRecall(recall);
    }

    public double getSpecificity() {
        return cf.getSpecificity();
    }

    public void setSpecificity(double specificity) {
        cf.setSpecificity(specificity);
    }
}
