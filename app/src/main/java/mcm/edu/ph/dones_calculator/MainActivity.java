package mcm.edu.ph.dones_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Button plus, minus, mul, div, mod, res;
    EditText var1, var2;
    TextView ther, ansbox;
    String result;
    double no1, no2, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //hide the action bar
        setContentView(R.layout.activity_main);

        //initializing
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

    }

    // getting user input ----------------------------------------------------------------------------
    public void getUserInput() {
        no1 = Double.parseDouble(var1.getText().toString());
        no2 = Double.parseDouble(var2.getText().toString());
    }

    // onClick ------------------------------------------------------------------------------------------

    // +
    public void add(View v) {
        getUserInput();
        answer = no1 + no2;
        result();
    }

    // -
    public void subtract(View v) {
        getUserInput();
        answer = no1 - no2;
        result();
    }

    // x
    public void multiply(View v) {
        getUserInput();
        answer = no1 * no2;
        result();
    }

    // ÷
    public void divide(View v) {
        getUserInput();
        answer = no1 / no2;
        result();
    }

    // %
    public void mod(View v) {
        getUserInput();
        answer = no1 % no2;
        result();
    }

    // showing result -----------------------------------------------------------------------------------
    public void result(){
        double roundOff = (double) Math.round(answer * 1000000)/1000000;
        result = String.valueOf(roundOff);
        ther.setVisibility(View.VISIBLE);
        ansbox.setVisibility(View.VISIBLE);
        ansbox.setText(result);
    }

    // restarts the variables ------------------------------------------------------------------------
    public void restart(View v){
        ther.setVisibility(View.INVISIBLE);
        ansbox.setVisibility(View.INVISIBLE);
        var1.setText("");
        var2.setText("");
    }

}