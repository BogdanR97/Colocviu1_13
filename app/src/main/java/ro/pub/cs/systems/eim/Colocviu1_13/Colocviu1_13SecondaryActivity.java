package ro.pub.cs.systems.eim.Colocviu1_13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_13SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_colocviu1_13_secondary);

        Intent intent = getIntent();
        String cardinalStr = intent.getStringExtra("CARDINAL");

        EditText cardinalView = findViewById(R.id.cardinalSecText);
        cardinalView.setKeyListener(null);
        
        if (cardinalStr != null)
            cardinalView.setText(cardinalStr);

        Button register = findViewById(R.id.registerBtn);
        Button cancel = findViewById(R.id.cancelBtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });

    }
}
