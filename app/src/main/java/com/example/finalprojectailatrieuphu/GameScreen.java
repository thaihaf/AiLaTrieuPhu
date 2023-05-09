package com.example.finalprojectailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalprojectailatrieuphu.Adapter.TienThuongAdapter;
import com.example.finalprojectailatrieuphu.Dialog.DialogKhanGiaTraLoi;
import com.example.finalprojectailatrieuphu.object.CauHoi;
import com.example.finalprojectailatrieuphu.object.FaceData;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends AppCompatActivity {

    ListView lsvTienThuong;
    TienThuongAdapter tienThuongAdapter;
    ArrayList<String> arrTienThuong;
    CauHoi cauHoi;
    Button btnMenu, btnReplay;

    int viTriCauHoi = 1;
    View.OnClickListener listener;
    TextView txvCauHoi, txvCauTL1, txvCauTL2, txvCauTL3, txvCauTL4, txvThuaGame;
    ArrayList<TextView> arrTxvCauTraLoi;
    String cauTraoLoi;
    FaceData faceData;
    ImageView img1, img2, img3, img4;

    boolean troGiup5050 = true;
    boolean troGiupKhanGia = true;
    boolean troGiupDoiCauHoi = true;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // delete title
        getSupportActionBar().hide();
        //create money and question list
        init();
        //set up textview
        anhXa();
        //set up game
        setUp();
        setClick();
        img1 = findViewById(R.id.imgHelp1);
        img2 = findViewById(R.id.imgHelp2);
        img3 = findViewById(R.id.imgHelp3);
        img4 = findViewById(R.id.imgHelp4);

    }

    /**
     * set up question list and money list
     */
    public void init() {
        arrTienThuong = new ArrayList<>();
        arrTienThuong.add("150.000.000");//15
        arrTienThuong.add("85.000.000");//14
        arrTienThuong.add("60.000.000");//13
        arrTienThuong.add("40.000.000");//12
        arrTienThuong.add("30.000.000");//11
        arrTienThuong.add("22.000.000");//10
        arrTienThuong.add("14.000.000");//9
        arrTienThuong.add("10.000.000");//8
        arrTienThuong.add("6.000.000");//7
        arrTienThuong.add("3.000.000");//6
        arrTienThuong.add("2.000.000");//5
        arrTienThuong.add("1.000.000");//4
        arrTienThuong.add("600.000");//3
        arrTienThuong.add("400.000");//2
        arrTienThuong.add("200.000");//1

        tienThuongAdapter = new TienThuongAdapter(this, 0, arrTienThuong);

        cauHoi = new CauHoi();

        arrTxvCauTraLoi = new ArrayList<>();

        faceData = new FaceData();

        faceData = new FaceData(this);
    }

    /**
     * get view from layout
     */
    public void anhXa() {
        lsvTienThuong = findViewById(R.id.lsvTienThuong);
        txvCauHoi = findViewById(R.id.txvCauHoi);
        txvCauTL1 = findViewById(R.id.txvCauTL1);
        txvCauTL2 = findViewById(R.id.txvCauTL2);
        txvCauTL3 = findViewById(R.id.txvCauTL3);
        txvCauTL4 = findViewById(R.id.txvCauTL4);
        txvThuaGame = findViewById(R.id.txvThuaGame);
        btnReplay = findViewById(R.id.btnRepaly);
        btnMenu = findViewById(R.id.btnMenu);
        arrTxvCauTraLoi.add(txvCauTL1);
        arrTxvCauTraLoi.add(txvCauTL2);
        arrTxvCauTraLoi.add(txvCauTL3);
        arrTxvCauTraLoi.add(txvCauTL4);
    }

    /**
     * set up adapter and question
     */
    public void setUp() {
        txvThuaGame.setVisibility(View.GONE);
        lsvTienThuong.setAdapter(tienThuongAdapter);
        hienCauHoi();
    }

    /**
     * event on click a answer
     */
    public void setClick() {
        //set up click listener
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCauTraLoi(((TextView) view));
                //
                for (TextView t : arrTxvCauTraLoi) {
                    if (t.getId() != view.getId()) {
                        t.setOnClickListener(null);
                    }
                }
            }
        };
        //set up click for answer textview
        for (TextView t : arrTxvCauTraLoi) {
            t.setOnClickListener(listener);
        }
    }

    /**
     * check answer
     * @param txv
     */
    public void checkCauTraLoi(final TextView txv) {
        cauTraoLoi = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_cau_chon);
        //time delay
        new CountDownTimer(2000, 100) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                for (TextView t : arrTxvCauTraLoi) {
                    String s = t.getText().toString();
                    if (s.equals(cauHoi.getDapAnDung())) {
                        t.setBackgroundResource(R.drawable.bg_cau_dung);

                        break;
                    }
                }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        if (cauTraoLoi.equals(cauHoi.getDapAnDung())) {
                            viTriCauHoi++;
                            if (viTriCauHoi > 15) {
                                viTriCauHoi = 15;
                                txvThuaGame.setVisibility(View.VISIBLE);
                                txvThuaGame.setText("Chuc mung ban da duoc \n" + arrTienThuong.get(0) + " vnd");
                                btnReplay.setVisibility(View.VISIBLE);
                                btnMenu.setVisibility(View.VISIBLE);
                                return;
                            }
                            //show next question
                            hienCauHoi();
                        } else if ((cauTraoLoi != cauHoi.getDapAnDung()) && viTriCauHoi == 1) {
                            txvThuaGame.setVisibility(View.VISIBLE);
                            txvThuaGame.setText("Ban sẽ ra về với tiền thương là \n 0 vnd");
                            btnReplay.setVisibility(View.VISIBLE);
                            btnMenu.setVisibility(View.VISIBLE);
                        } else {
                            txvThuaGame.setVisibility(View.VISIBLE);
                            if (viTriCauHoi <= 5) {
                                txvThuaGame.setText("Ban sẽ ra về với tiền thương là \n" + arrTienThuong.get(14) + " vnd");
                                btnReplay.setVisibility(View.VISIBLE);
                                btnMenu.setVisibility(View.VISIBLE);
                            } else {
                                int vitriTienThuong = ((viTriCauHoi - 1) / 5) * 5 - 1;
                                txvThuaGame.setText("Ban sẽ ra về với tiền thương là \n" + arrTienThuong.get(14 - vitriTienThuong) + " vnd");
                                btnReplay.setVisibility(View.VISIBLE);
                                btnMenu.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }.start();
            }
        }.start();
    }

    /**
     * set up question
     */
    public void setCauHoi() {
        cauHoi = faceData.getRandomQuestionWithLevel(viTriCauHoi/5+1);
        faceData.removeQuestion(cauHoi);
    }

    /**
     * show question
     */
    public void hienCauHoi() {
        //lay cau hoi trong list
        setCauHoi();
        txvCauHoi.setText(cauHoi.getNoiDung());
        ArrayList<String> arrCauTraLoi = new ArrayList<>(cauHoi.getArrDapAnSai());
        arrCauTraLoi.add(cauHoi.getDapAnDung());

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int vt1 = r.nextInt(arrCauTraLoi.size());//
            int vt2 = r.nextInt(arrCauTraLoi.size());//
            String a = arrCauTraLoi.get(vt1);//
            arrCauTraLoi.set(vt1, arrCauTraLoi.get(vt2));
            arrCauTraLoi.set(vt2, a);
        }

        for (int i = 0; i < arrTxvCauTraLoi.size(); i++) {
            arrTxvCauTraLoi.get(i).setOnClickListener(listener);
            arrTxvCauTraLoi.get(i).setVisibility(View.VISIBLE);
            arrTxvCauTraLoi.get(i).setBackgroundResource(R.drawable.bg_btn);
            arrTxvCauTraLoi.get(i).setText(arrCauTraLoi.get(i));
        }
        tienThuongAdapter.setViTriCauHoi(viTriCauHoi);
    }

    /**
     * help from audience
     * @param view
     */
    int[] dapAnAn=new int[2];
    int vttrogiup=0;
    public void trogiup5050(View view) {
        if(troGiup5050 == false){
            return;
        }
        Random r= new Random();
        int sodanAnAnDi =2;
        int index=0;
        do{
            int vitriDanAnAn = r.nextInt(4);// 1
            TextView t = arrTxvCauTraLoi.get(vitriDanAnAn);
            if(t.getVisibility() == View.VISIBLE && t.getText().toString().equals(cauHoi.getDapAnDung())==false){
                dapAnAn[index]=vitriDanAnAn;
                t.setVisibility(View.INVISIBLE);
                t.setOnClickListener(null);
                sodanAnAnDi --;
                index++;
                vttrogiup=viTriCauHoi;
            }
        }while (sodanAnAnDi>0);
        troGiup5050 = false;

        img1.setVisibility(View.INVISIBLE);
    }

    public void troGiupKhanGia(View view) {

        if (troGiupKhanGia == false){
            return;
        }
        if(viTriCauHoi!=vttrogiup)
        {
            troGiup5050=true;
        }
        for (int i=0;i<arrTxvCauTraLoi.size();i++){
            TextView t = arrTxvCauTraLoi.get(i);
            if(t.getText().toString().equals(cauHoi.getDapAnDung())){
                new DialogKhanGiaTraLoi(this,i+1,troGiup5050,dapAnAn).show();
                break;
            }
        }
        troGiupKhanGia =false;
        img2.setVisibility(View.INVISIBLE);
    }

    /**
     * change question
     * @param view
     */
    public void trogiupDoiCauHoi(View view) {
        if (troGiupDoiCauHoi == false) {
            return;
        }
        hienCauHoi();
        troGiupDoiCauHoi = false;
        img3.setVisibility(View.INVISIBLE);
    }

    /**
     * give up
     * @param view
     */
    public void dungCuocChoi(View view) {
        if (viTriCauHoi == 1) {
            txvThuaGame.setVisibility(View.VISIBLE);
            txvThuaGame.setText("Ban dừng cuộc chơi ra về với tiền thưởng là 0 vnd\n");
            btnReplay.setVisibility(View.VISIBLE);
            btnMenu.setVisibility(View.VISIBLE);
        } else {
            txvThuaGame.setVisibility(View.VISIBLE);
            int vitriTienThuong = viTriCauHoi - 2;
            txvThuaGame.setText("Ban dừng cuộc chơi ra về với tiền thương là \n" + arrTienThuong.get(14 - vitriTienThuong) + " vnd");
            btnReplay.setVisibility(View.VISIBLE);
            btnMenu.setVisibility(View.VISIBLE);
        }
    }

    /**
     * back to menu
     * @param view
     */
    public void backToMenu(View view) {
        Intent i1 = new Intent(this, MainScreen.class);
        startActivity(i1);
    }

    /**
     * replay game
     * @param view
     */
    public void replayGame(View view) {
        setUp();
        btnReplay.setVisibility(View.GONE);
        btnMenu.setVisibility(View.GONE);
        viTriCauHoi = 1;
        tienThuongAdapter.setViTriCauHoi(viTriCauHoi);
        troGiupKhanGia = true;
        troGiupDoiCauHoi = true;
        troGiup5050 = true;
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.VISIBLE);
        img3.setVisibility(View.VISIBLE);
    }
}
