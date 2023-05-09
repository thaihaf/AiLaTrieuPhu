package com.example.finalprojectailatrieuphu.sql.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class QuestionEntity {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    public int id;
    @ColumnInfo
    public String noiDung;
    @ColumnInfo
    public String dapAnDung;
    @ColumnInfo
    public String dapAnSai1;
    @ColumnInfo
    public String dapAnSai2;
    @ColumnInfo
    public String dapAnSai3;
    @ColumnInfo
    public int capdo;

    public int getCapdo() {
        return capdo;
    }

    public void setCapdo(int capdo) {
        this.capdo = capdo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDapAnSai1() {
        return dapAnSai1;
    }

    public void setDapAnSai1(String dapAnSai1) {
        this.dapAnSai1 = dapAnSai1;
    }

    public String getDapAnSai2() {
        return dapAnSai2;
    }

    public void setDapAnSai2(String dapAnSai2) {
        this.dapAnSai2 = dapAnSai2;
    }

    public String getDapAnSai3() {
        return dapAnSai3;
    }

    public void setDapAnSai3(String dapAnSai3) {
        this.dapAnSai3 = dapAnSai3;
    }
}
