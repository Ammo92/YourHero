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
import com.example.mohamed.yourhero.SQLite.SQLite;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        TextView appTitle = findViewById(R.id.apptitle);
        Button buttonPlay = findViewById(R.id.buttonPlay);
        Button buttonHistoric = findViewById(R.id.buttonHistoric);
        Button buttonExit = findViewById(R.id.buttonExit);


        setFont(appTitle,"SHOWG.TTF");
        setFontButton(buttonPlay,"SHOWG.TTF");
        setFontButton(buttonHistoric,"SHOWG.TTF");
        setFontButton(buttonExit,"SHOWG.TTF");

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* context = getApplicationContext();
                Requete requete = new Requete(context);
                Questions questions = new Questions("Question 15");
                requete.open();
                requete.insertQuestion(questions); */

            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);


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
