package com.hfad.week2_daily1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class IME extends Activity {

    SeekBar tenure;
    SeekBar loan;
    SeekBar interest;

    TextView txt_loan;
    TextView txt_tenure;
    TextView txt_interest;
    TextView totalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ime);

        bindingView();

        // perform seek bar change listener event used for getting the progress value
        tenure.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                txt_tenure.setText("" + progressChangedValue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                txt_tenure.setText("" + progressChangedValue);

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                leCalc(txt_tenure.toString(), txt_interest.toString(), txt_loan.toString());
            }

        });

        loan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                txt_loan.setText("" + progressChangedValue);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                leCalc(txt_tenure.toString(), txt_interest.toString(), txt_loan.toString());

            }

        });

        interest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                txt_interest.setText("" + progressChangedValue);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                leCalc(txt_tenure.toString(), txt_interest.toString(), txt_loan.toString());
            }

        });
    }

    private void bindingView() {
        // initiate  views
        tenure = findViewById(R.id.sk_tenure);
        loan = findViewById(R.id.sk_loan);
        interest = findViewById(R.id.sk_interest);

        txt_interest = findViewById(R.id.txt_interest);
        txt_loan = findViewById(R.id.txt_Loan);
        txt_tenure = findViewById(R.id.txt_tenure);

        totalAmount = findViewById(R.id.vw_amount);
    }

    private void leCalc(String strLoan, String strTenure, String strInterest) {
        Double p = Double.parseDouble(strLoan);
        Double r = Double.parseDouble(strTenure);
        Double r_100 = r / (100 * 12);
        Double n = Double.parseDouble(strInterest);

        Double res = (r_100 * p * Math.pow((1 + r_100), n)) / (Math.pow((1 + r_100), n) - 1);
        totalAmount.setText("" + res);
    }
}