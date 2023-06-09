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
    public float getDTB(){
        return (diem_ltdd + diem_tin + diem_toan) / 3;
    }
}
