package com.example.android.callingclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Bonjour");
        textView.setTextSize(50);

        textView.setTextColor(this.getResources().getColor(R.color.orange));
        setContentView(textView);
    }
}
