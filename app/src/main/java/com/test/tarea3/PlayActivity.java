package com.test.tarea3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class PlayActivity extends AppCompatActivity {
    private Context mContext;

    private ImageView cover;

    private TextView nombre;
    private TextView description;
    private TextView prize;
    private Button comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initViews();
        addEvents();
        modifyContent();
        receiveData();
    }

    private void initViews() {
        cover = findViewById(R.id.cover);
        nombre = findViewById(R.id.nombre);
        description = findViewById(R.id.description);
        prize = findViewById(R.id.precio);
        comprar = findViewById(R.id.comprar);
    }

    private void addEvents() {
        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Has Comprado " + nombre + ", felicidades! Vuelva pronto", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void modifyContent() {
        description.setText("Naughty Dog");
        nombre.setText("Crash");
        cover.setImageResource(R.drawable.crash);
        prize.setText("29.99");
    }

    private void receiveData() {
        Intent intent = getIntent();
        String json = intent.getStringExtra(Constants.KEY_JUEGO);
        Juego game = new Gson().fromJson(json, Juego.class);
        description.setText(game.getDescription());
        nombre.setText(game.getGameName());
        cover.setImageResource(game.getCoverImage());
        prize.setText(game.getPrize()+".99");
    }
}
