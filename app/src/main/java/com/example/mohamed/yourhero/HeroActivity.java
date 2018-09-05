package com.example.mohamed.yourhero;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class HeroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hero);

        TextView heroName = findViewById(R.id.heroName);
        TextView heroAlias = findViewById(R.id.heroAlias);
        TextView heroTeam = findViewById(R.id.heroTeam);

        setFont(heroName, "SHOWG.TTF");
        setFont(heroAlias, "SHOWG.TTF");
        setFont(heroTeam, "SHOWG.TTF");

    }

    public void setFont(TextView textView, String fontName) {
        if (fontName != null) {
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }

        }
    }
}
