package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static Random random = new Random();
    private Button btnDiceRoll;
    private ImageView iv1, iv2;
    private TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDiceRoll = findViewById(R.id.btnDiceRoll);
        iv1 = findViewById(R.id.ivDice1);
        iv2 = findViewById(R.id.ivDice2);
        tv1= findViewById(R.id.tvDice1);
        tv2 = findViewById(R.id.tvDice2);
        tv3 = findViewById(R.id.tvSum);


        iv1.setImageResource(getResources().getIdentifier("dice_1","drawable", "com.example.diceroller"));
        iv2.setImageResource(getResources().getIdentifier("dice_2","drawable", "com.example.diceroller"));

        tv1.setText("1");
        tv2.setText("2");
        tv3.setText("3");

        btnDiceRoll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int num1 = rollDice();
                int num2 = rollDice();

                int result1 = getResources().getIdentifier("dice_" + num1,"drawable","com.example.diceroller");
                int result2 = getResources().getIdentifier("dice_" + num2,"drawable","com.example.diceroller");

                iv1.setImageResource(result1);
                iv2.setImageResource(result2);

                tv1.setText(String.valueOf(num1));
                tv2.setText(String.valueOf(num2));
                tv3.setText(String.valueOf(num1+num2));

            }
        });
    }

    //code for random number generator
    public static int rollDice(){
        return random.nextInt(6) + 1;
    }

}
