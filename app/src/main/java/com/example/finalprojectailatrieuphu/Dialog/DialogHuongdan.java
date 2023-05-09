package com.example.finalprojectailatrieuphu.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.finalprojectailatrieuphu.GameScreen;
import com.example.finalprojectailatrieuphu.R;

public class DialogHuongdan extends Dialog {

    private Button btnStart2;
    public DialogHuongdan(@NonNull final Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dilog_huongdan);
        btnStart2 = findViewById(R.id.btnStart2);
        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), GameScreen.class);
                context.startActivity(i);
            }
        });
    }
}
