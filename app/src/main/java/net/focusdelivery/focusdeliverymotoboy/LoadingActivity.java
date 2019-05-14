package net.focusdelivery.focusdeliverymotoboy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Intent intent;
        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Carregando");
        progress.setMessage("...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        SharedPreferences prefs = getSharedPreferences("BD", Context.MODE_PRIVATE);
        String topic = prefs.getString("topicSelected", "val");
        Log.d("TOPICLOADIN", topic);
        if (topic.equals("val")) {
            intent = new Intent(LoadingActivity.this, SelectActivity.class);
        } else {
            intent = new Intent(LoadingActivity.this,
                    MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
