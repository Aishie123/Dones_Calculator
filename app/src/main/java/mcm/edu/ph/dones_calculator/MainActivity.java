package mcm.edu.ph.dones_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button plus, minus, mul, div, mod, res;
    EditText var1, var2;
    TextView ther, ansbox;
    String result, TAG;
    double no1, no2, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operations();
        repeat();
    }

    public void operations(){

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        mul = (Button) findViewById(R.id.times);
        div = (Button) findViewById(R.id.divide);
        mod = (Button) findViewById(R.id.mod);

        res = (Button) findViewById(R.id.res);

        var1 = (EditText) findViewById(R.id.var1entry);
        var2 = (EditText) findViewById(R.id.var2entry);

        ther = (TextView) findViewById(R.id.result);
        ansbox = (TextView) findViewById(R.id.answer);

        TAG = "calculator";

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"addition");
                no1 = Double.parseDouble(var1.getText().toString());
                no2 = Double.parseDouble(var2.getText().toString());
                answer = no1 + no2;
                result();
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"subtraction");
                no1 = Double.parseDouble(var1.getText().toString());
                no2 = Double.parseDouble(var2.getText().toString());
                answer = no1 - no2;
                result();
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"multiplication");
                no1 = Double.parseDouble(var1.getText().toString());
                no2 = Double.parseDouble(var2.getText().toString());
                answer = no1 * no2;
                result();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"division");
                no1 = Double.parseDouble(var1.getText().toString());
                no2 = Double.parseDouble(var2.getText().toString());
                answer = no1 / no2;
                result();
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"get remainder");
                no1 = Double.parseDouble(var1.getText().toString());
                no2 = Double.parseDouble(var2.getText().toString());
                answer = no1 % no2;
                result();
            }
        });
    }

    public void result(){
        double roundOff = (double) Math.round(answer * 1000000)/1000000;
        result = String.valueOf(roundOff);
        ther.setVisibility(View.VISIBLE);
        ansbox.setVisibility(View.VISIBLE);
        ansbox.setText(result);
    }

    public void repeat(){
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations();
                ther.setVisibility(View.INVISIBLE);
                ansbox.setVisibility(View.INVISIBLE);
                var1.setText("0.0");
                var2.setText("0.0");
            }
        });
    }
}