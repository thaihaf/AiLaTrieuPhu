package com.example.finalprojectailatrieuphu.object;

import java.util.ArrayList;

public class CauHoi {
    private String noiDung,dapAnDung;
    private ArrayList<String> arrDapAnSai;
    private int capdo;

    public int getCapdo() {
        return capdo;
    }

    public void setCapdo(int capdo) {
        this.capdo = capdo;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public ArrayList<String> getArrDapAnSai() {
        return arrDapAnSai;
    }

    public void setArrDapAnSai(ArrayList<String> arrDapAnSai) {
        this.arrDapAnSai = arrDapAnSai;
    }
    public void setArrDapAnSai(String dapAnSai) {//dapan1&dapan2&dâpn3
        String arrS[]=dapAnSai.split("&");
        this.arrDapAnSai = new ArrayList<>();
        for (String s : arrS){
            arrDapAnSai.add(s);
        }
    }
}
