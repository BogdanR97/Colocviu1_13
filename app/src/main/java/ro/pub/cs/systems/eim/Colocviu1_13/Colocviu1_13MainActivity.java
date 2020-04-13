package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Colocviu1_13MainActivity extends AppCompatActivity {

    Integer pressedNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            pressedNo = savedInstanceState.getInt("PRESSED_NO");

        Log.println(0, "DEBUG", "This is" + pressedNo.toString());

        final Button north = findViewById(R.id.northBtn);
        Button south = findViewById(R.id.southBtn);
        Button east = findViewById(R.id.eastBtn);
        Button west = findViewById(R.id.westBtn);
        final EditText cardinal = findViewById(R.id.cardinalText);

        north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardinal.append(getText(R.string.north));
                pressedNo++;
            }
        });

        east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardinal.append(getText(R.string.east));
                pressedNo++;
            }
        });

        west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardinal.append(getText(R.string.west));
                pressedNo++;
            }
        });

        south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardinal.append(getText(R.string.south));
                pressedNo++;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("PRESSED_NO", pressedNo);
    }
}
