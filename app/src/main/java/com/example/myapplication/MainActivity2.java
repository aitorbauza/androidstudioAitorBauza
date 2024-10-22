package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String LOG_TAG = "MainActivity";

    private TextView gestureSquare; // Para el TextView que mostrará los gestos
    private GestureDetector gestureDetector; // Para detectar gestos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "In method onCreate");
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        Intent intent = getIntent();

        String mensaje = intent.getStringExtra("key1");

        TextView textView = findViewById(R.id.textView2);
        textView.setText(mensaje);

        textView.setTextColor(getResources().getColor(R.color.red));
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "In method onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "In method onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "In method onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "In method onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "In method onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "In method onStart");
    }

    public void returnReply() {
        Log.d(TAG, "In method returnReply");
        finish();
    }



}
