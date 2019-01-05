package com.slobodsky.nick.diceshake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRoll;

    ImageView image1, image2;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnRoll = findViewById(R.id.btnRoll);

        image1 = findViewById(R.id.image1);

        image2 = findViewById(R.id.image2);

        r = new Random();

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.shake);

                final Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.shake);

                final Animation.AnimationListener animationListener = new
                        Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {


                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        int rand = r.nextInt(6) + 1;

                        int res = getResources().getIdentifier("dice_" + rand,
                                "drawable", "com.slobodsky.nick.diceshake");

                        if (animation == anim1)
                        {
                            image1.setImageResource(res);
                        }
                        else if (animation == anim2)
                        {
                            image2.setImageResource(res);
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };

                anim1.setAnimationListener(animationListener);

                anim2.setAnimationListener(animationListener);

                image1.startAnimation(anim1);

                image2.startAnimation(anim2);
            }
        });
    }
}
