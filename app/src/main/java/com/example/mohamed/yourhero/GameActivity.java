package com.example.mohamed.yourhero;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.mohamed.yourhero.SQLite.Questions;
import com.example.mohamed.yourhero.SQLite.Requete;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Questions test;
    int cpt = 0;
    int[] intArray = new int[] {0,0,0,0,0,0,0,0,0,0,0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        final TextView displayQuestion = findViewById(R.id.displayQuestions);
        Button buttonYes = findViewById(R.id.buttonYes);
        Button buttonNo = findViewById(R.id.buttonNO);
        final TextView numQuestions = findViewById(R.id.numQuestions);

        Context context = getApplicationContext();
        final Requete requete = new Requete(context);
        final Random randomID = new Random();
        int randomNumber = randomID.nextInt(15 - 1) + 1;

        setFont(displayQuestion,"SHOWG.TTF");
        setFontButton(buttonNo,"SHOWG.TTF");
        setFontButton(buttonYes,"SHOWG.TTF");
        setFont(numQuestions,"SHOWG.TTF");


        requete.open();


        test = requete.getInfoWithId(randomNumber);
        cpt++;
        intArray[0] = randomNumber;
        numQuestions.setText(cpt + "/10");
        displayQuestion.setText(test.getQuestions());


        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int randomNumber = randomID.nextInt(15 - 1) + 1;
                cpt++;
                for(int i = 0; i < intArray.length ; i++ ){
                    if(intArray[i] == randomNumber){
                        randomNumber = randomNumber + 1;
                        i = 0;
                    }
                }
                test = requete.getInfoWithId(randomNumber);
                numQuestions.setText(cpt + "/10");
                displayQuestion.setText(test.getQuestions());
                if(cpt == 10){
                    Intent intent = new Intent(GameActivity.this, HeroActivity.class);
                    startActivity(intent);
                }
            }
        });

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int randomNumber = randomID.nextInt(15 - 1) + 1;
                cpt++;
                for(int i = 0; i < intArray.length ; i++ ){
                    if(intArray[i] == randomNumber){
                        randomNumber = randomNumber + 1;
                        i = 0;
                    }
                }
                test = requete.getInfoWithId(randomNumber);
                numQuestions.setText(cpt + "/10");
                displayQuestion.setText(test.getQuestions());
                if(cpt == 10){
                    Intent intent = new Intent(GameActivity.this, HeroActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void setFont(TextView textView, String fontName) {
        if(fontName != null){
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }
        }
    }

    public void setFontButton(Button button, String fontName) {
        if(fontName != null){
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
                button.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }
        }
    }



}
