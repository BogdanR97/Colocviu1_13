package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Colocviu1_13MainActivity extends AppCompatActivity {

    Integer pressedNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            pressedNo = savedInstanceState.getInt("PRESSED_NO");

        Log.d("PRINTNO", "This is" + pressedNo.toString());

        final Button north = findViewById(R.id.northBtn);
        Button south = findViewById(R.id.southBtn);
        Button east = findViewById(R.id.eastBtn);
        Button west = findViewById(R.id.westBtn);
        final EditText cardinal = findViewById(R.id.cardinalText);
        cardinal.setKeyListener(null);

        Button navigator = findViewById(R.id.navigateBtn);

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

        navigator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Colocviu1_13MainActivity.this, Colocviu1_13SecondaryActivity.class);
                intent.putExtra("CARDINAL", cardinal.getText().toString());

                cardinal.setText("");
                pressedNo = 0;

                startActivityForResult(intent, 0);
            }
        });

        // D.1
        Intent intent = new Intent(this, Colocviu1_13Service.class);
        intent.putExtra("CARDINAL_MSG", cardinal.getText().toString());
        startService(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("PRESSED_NO", pressedNo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 0)
            Toast.makeText(this, "REGISTER was pressed", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "CANCEL was pressed", Toast.LENGTH_LONG).show();

    }
}
