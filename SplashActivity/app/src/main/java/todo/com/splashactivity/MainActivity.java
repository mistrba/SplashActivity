package todo.com.splashactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        final  boolean useDarkTheme = preferences.getBoolean(PREF_DARK_THEME, false);


        setContentView(R.layout.activity_main);

        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        lottieAnimationView.setImageAssetsFolder("images");
        lottieAnimationView.setAnimation("data.json");

        lottieAnimationView.useExperimentalHardwareAcceleration(true);
        lottieAnimationView.enableMergePathsForKitKatAndAbove(true);

        Thread background = new Thread() {
            public void run() {

                try {
                    sleep(3000);
                    Bundle bundle=new Bundle();
                    Intent intent =new Intent(getApplicationContext(),SecondActivity.class);
                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("Catch block", Log.getStackTraceString(e));                }
            }};
        background.start();



    }}