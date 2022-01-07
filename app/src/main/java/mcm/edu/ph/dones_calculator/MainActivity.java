package mcm.edu.ph.dones_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button plus, minus, mul, div, res;
EditText var1, var2;
TextView ther, ansbox;
String result, TAG;
float int1, int2, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operations();
        repeat();
    }

    public void operations(){

        plus = (Button) findViewById(R.id.button);
        minus = (Button) findViewById(R.id.button3);
        mul = (Button) findViewById(R.id.button4);
        div = (Button) findViewById(R.id.button5);

        res = (Button) findViewById(R.id.res);

        var1 = (EditText) findViewById(R.id.entry1);
        var2 = (EditText) findViewById(R.id.entry2);

        ther = (TextView) findViewById(R.id.textView5);
        ansbox = (TextView) findViewById(R.id.textView4);

        TAG = "calculator";

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int1 = Float.parseFloat(var1.getText().toString());
                int2 = Float.parseFloat(var2.getText().toString());
                Log.d(TAG,"addition");
                answer = int1 + int2;
                result = String.valueOf(answer);
                ther.setVisibility(View.VISIBLE);
                ansbox.setVisibility(View.VISIBLE);
                ansbox.setText(result);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int1 = Float.parseFloat(var1.getText().toString());
                int2 = Float.parseFloat(var2.getText().toString());
                answer = int1 - int2;
                result = String.valueOf(answer);
                ther.setVisibility(View.VISIBLE);
                ansbox.setVisibility(View.VISIBLE);
                ansbox.setText(result);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int1 = Float.parseFloat(var1.getText().toString());
                int2 = Float.parseFloat(var2.getText().toString());
                answer = int1 * int2;
                result = String.valueOf(answer);
                ther.setVisibility(View.VISIBLE);
                ansbox.setVisibility(View.VISIBLE);
                ansbox.setText(result);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int1 = Float.parseFloat(var1.getText().toString());
                int2 = Float.parseFloat(var2.getText().toString());
                answer = int1 / int2;
                result = String.valueOf(answer);
                ther.setVisibility(View.VISIBLE);
                ansbox.setVisibility(View.VISIBLE);
                ansbox.setText(result);
            }
        });
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
