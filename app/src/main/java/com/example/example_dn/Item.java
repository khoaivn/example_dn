package com.example.example_dn;

public class Item {
    String full_name;
    int diem_tin;
    int diem_toan;
    int diem_ltdd;
    Item(String full_name_0, int diem_toan_0, int diem_tin_0, int diem_ltdd_0){
        full_name = full_name_0;
        diem_ltdd = diem_ltdd_0;
        diem_tin = diem_tin_0;
        diem_toan = diem_toan_0;
    }

    public String getFull_name() {
        return full_name;
    }

    public int getDiem_ltdd() {
        return diem_ltdd;
    }

    public int getDiem_tin() {
        return diem_tin;
    }

    public int getDiem_toan() {
        return diem_toan;
    }

    public void setDiem_tin(int diem_tin) {
        this.diem_tin = diem_tin;
    }

    public void setDiem_ltdd(int diem_ltdd) {
        this.diem_ltdd = diem_ltdd;
    }

    public void setDiem_toan(int diem_toan) {
        this.diem_toan = diem_toan;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public float getDTB(){
        return (diem_ltdd + diem_tin + diem_toan) / 3;
    }
}
