package android.example.com.miwokapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000; //time after the screen "splashes" to the home screen

    Animation topAnim, bottomAnim;
    ImageView miwokIcon, tentIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Views
        miwokIcon = findViewById(R.id.splashscreen_miwok_icon);
        tentIcon = findViewById(R.id.splashscreen_tent_icon);

        //Set the animation
        miwokIcon.setAnimation(topAnim);
        tentIcon.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashScreen.this, android.example.com.miwokapplication.HomeScreen.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
