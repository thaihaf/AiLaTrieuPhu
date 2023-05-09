package com.example.finalprojectailatrieuphu.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.finalprojectailatrieuphu.R;

import java.util.Random;

public class DialogKhanGiaTraLoi extends Dialog {
    private TextView txvChonA,txvChonB,txvChonC,txvChonD;
    public DialogKhanGiaTraLoi(Context context, int vtD,boolean is5050,int dapAnAn[]) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dilog_tro_giup_khan_gia);
        txvChonA = findViewById(R.id.txvChonA);
        txvChonB = findViewById(R.id.txvChonB);
        txvChonC = findViewById(R.id.txvChonC);
        txvChonD = findViewById(R.id.txvChonD);
        if (is5050 == true) {
            // 3
            int arrdrom[] = new int[]{0, 0, 0, 0};
            int can = 25;
            for (int i = 0; i < arrdrom.length; i++) {
                arrdrom[i] = arrdrom[i] + can;// 25 50 100 125
                if (i == vtD - 1) {
                    arrdrom[i] = arrdrom[i] + 25; // 25 50 100
                    can = can + 25;//100
                }
                can = can + 25;//can 125
            }

            int tong = 125;
            int arrPhanTranTl[] = new int[]{0, 0, 0, 0}; // a  b  c d
            int soKhanGia = 200;
            Random r = new Random();
            for (int i = 0; i < soKhanGia; i++) {
                int chon = r.nextInt(tong);// 0 25 75 100 125
                if (chon >= 0 && chon < arrdrom[0]) {
                    arrPhanTranTl[0]++;
                } else if (chon >= arrdrom[0] && chon < arrdrom[1]) {
                    arrPhanTranTl[1]++;
                } else if (chon >= arrdrom[1] && chon < arrdrom[2]) {
                    arrPhanTranTl[2]++;
                } else {
                    arrPhanTranTl[3]++;
                }
            }
            txvChonA.setText("A : " + (int) (arrPhanTranTl[0] * 100.0f / soKhanGia) + " %");
            txvChonB.setText("B : " + (int) (arrPhanTranTl[1] * 100.0f / soKhanGia) + " %");
            txvChonC.setText("C : " + (int) (arrPhanTranTl[2] * 100.0f / soKhanGia) + " %");
            txvChonD.setText("D : " + (int) (arrPhanTranTl[3] * 100.0f / soKhanGia) + " %");

        }

        else{

            for(int i=0;i<dapAnAn.length;i++) {
                if(dapAnAn[i]==0){
                    txvChonA.setVisibility(View.INVISIBLE);
                }
                if(dapAnAn[i]==1){
                    txvChonB.setVisibility(View.INVISIBLE);
                }
                if(dapAnAn[i]==2){
                    txvChonC.setVisibility(View.INVISIBLE);
                }
                if(dapAnAn[i]==3){
                    txvChonD.setVisibility(View.INVISIBLE);
                }

            }
            Random r = new Random();
            int ptsai = r.nextInt(49);
            int ptdung= 100-ptsai;
            if(vtD==1) {
                txvChonA.setText("A : " + (int) (ptdung) + " %");
                txvChonB.setText("B : " + (int) (ptsai) + " %");
                txvChonC.setText("C : " + (int) (ptsai) + " %");
                txvChonD.setText("D : " + (int) (ptsai) + " %");
            }
            if(vtD==2) {
                txvChonA.setText("A : " + (int) (ptsai) + " %");
                txvChonB.setText("B : " + (int) (ptdung) + " %");
                txvChonC.setText("C : " + (int) (ptsai) + " %");
                txvChonD.setText("D : " + (int) (ptsai) + " %");
            }
            if(vtD==3) {
                txvChonA.setText("A : " + (int) (ptsai) + " %");
                txvChonB.setText("B : " + (int) (ptsai) + " %");
                txvChonC.setText("C : " + (int) (ptdung) + " %");
                txvChonD.setText("D : " + (int) (ptsai) + " %");
            }
            if(vtD==4) {
                txvChonA.setText("A : " + (int) (ptsai) + " %");
                txvChonB.setText("B : " + (int) (ptsai) + " %");
                txvChonC.setText("C : " + (int) (ptsai) + " %");
                txvChonD.setText("D : " + (int) (ptdung) + " %");
            }
        }
    }
}
