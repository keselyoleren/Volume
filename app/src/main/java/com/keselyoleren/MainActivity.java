package com.keselyoleren;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPanjang, edtLebar, edtTinggi;
    private Button btnHitung;
    private TextView tvHasil;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLebar = findViewById(R.id.edt_lebar);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtTinggi = findViewById(R.id.edt_tinggi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_result);

        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null){
            String result =  savedInstanceState.getString(STATE_RESULT);
            tvHasil.setText(result);
        }
    }

    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung){
            String inputPanjang = edtPanjang.getText().toString().trim();
            String inputLebar = edtLebar.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();

            // Validator

            boolean isEmptyFiled = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputPanjang)){
                isEmptyFiled = true;
                edtPanjang.setError("This filed is required");
            }
            if (TextUtils.isEmpty(inputLebar)){
                isEmptyFiled = true;
                edtLebar.setError("This filed is required");
            }
            if (TextUtils.isEmpty(inputTinggi)){
                isEmptyFiled = true;
                edtTinggi.setError("This filed is required");
            }

            if(!isEmptyFiled) {
                double volume = Double.valueOf(inputPanjang) * Double.valueOf(inputLebar) * Double.valueOf(inputTinggi);
                tvHasil.setText(String.valueOf(volume));
            }

        }
    }


}