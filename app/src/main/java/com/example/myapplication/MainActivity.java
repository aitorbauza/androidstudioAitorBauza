package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String LOG_TAG = "MainActivity";

    private TextView gestureSquare; // Para el TextView que mostrará los gestos
    private GestureDetector gestureDetector; // Para detectar gestos
    private View draggableSquare; // Cuadrado que se puede arrastrar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializamos el TextView para mostrar los gestos
        gestureSquare = findViewById(R.id.gesture_square);
      //  draggableSquare = findViewById(R.id.draggable_square); // Obtener la vista del cuadrado arrastrable

        // Creamos el GestureDetector para manejar los gestos
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Toast.makeText(MainActivity.this, "Click Detectado", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Click Detectado");
                gestureSquare.setText("Click Detectado");
                return true;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Toast.makeText(MainActivity.this, "Doble Click Detectado", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Doble Click Detectado");
                gestureSquare.setText("Doble Click Detectado");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Toast.makeText(MainActivity.this, "Click Largo Detectado", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Click Largo Detectado");
                gestureSquare.setText("Click Largo Detectado");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                float diffX = e2.getX() - e1.getX(); // Coordenadas de X
                float diffY = e2.getY() - e1.getY(); // Coordenadas de Y

                if (Math.abs(diffX) > Math.abs(diffY)) { // Si esto ocurre significa que el swipe ha sido horizontal
                    if (diffX > 0) { // Si es mayor que 0, hacia la derecha
                        Toast.makeText(MainActivity.this, "Swipe Right Detectado", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Swipe Right Detectado");
                        gestureSquare.setText("Swipe Right Detectado");
                    } else { // Si es menor, a la izquierda
                        Toast.makeText(MainActivity.this, "Swipe Left Detectado", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Swipe Left Detectado");
                        gestureSquare.setText("Swipe Left Detectado");
                    }
                } else { // Si el swipe ha sido en vertical
                    if (diffY > 0) { // Si es positivo, hace un swipe down
                        Toast.makeText(MainActivity.this, "Swipe Down Detectado", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Swipe Down Detectado");
                        gestureSquare.setText("Swipe Down Detectado");
                    } else { // Y sino, hace swipe up
                        Toast.makeText(MainActivity.this, "Swipe Up Detectado", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Swipe Up Detectado");
                        gestureSquare.setText("Swipe Up Detectado");
                    }
                }
                return true;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                return true; // Necesario para que el GestureDetector funcione correctamente
            }
        });

        // Configuramos el Listener para el TextView
        gestureSquare.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event); // Pasamos los eventos de toque al GestureDetector
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Log.d(TAG, "In method onCreate");
            Log.d(LOG_TAG, "-------");
            Log.d(LOG_TAG, "onCreate");
            return insets;
        });
    }

    public void clickBoton(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key1", "Hola desde MainActivity");
        startActivity(intent);
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
}
