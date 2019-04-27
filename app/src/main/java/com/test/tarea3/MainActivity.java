package com.test.tarea3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    //private List<Juego> listaJuego = new ArrayList<>();
    private GameAdapter gameAdapter;
    private List<Juego> juegoArray = new ArrayList<>();
    private ListView juegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        juegoArray.add(new Juego(1, R.drawable.assassins_creed_3, "Assassin's Creed 3", "Ubisoft", 29));
        juegoArray.add(new Juego(2, R.drawable.crash, "Crash Team Racing Nitro Fueled", "Naughty Dog", 31));
        juegoArray.add(new Juego(3, R.drawable.fifa_19, "FIFA 19", "EA Sports", 39));
        juegoArray.add(new Juego(4 ,R.drawable.grand_theft_auto, "Grand Theft Auto IV", "RockStar", 15 ));
        juegoArray.add(new Juego(5, R.drawable.mortal_kombat, "Mortal Kombat 11",  "NetherRealm Studios", 39));
        juegoArray.add(new Juego(6, R.drawable.overwatch, "Overwatch", "Blizzard", 28));
        juegoArray.add(new Juego(7, R.drawable.spiderman, "Spider Man", "Insomniac Games", 39));
        juegoArray.add(new Juego(8, R.drawable.spyro, "Spyro Reignited Trilogy", "Activision", 25));

        initViews();
        addEvents();
    }

    private void initViews() {
        juegos = findViewById(R.id.games);

        gameAdapter = new GameAdapter(mContext, juegoArray);
        juegos.setAdapter(gameAdapter);
    }

    private void addEvents() {
        juegos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Juego game = juegoArray.get(position); //Obtener cual cancion
                Intent intent = new Intent(mContext, PlayActivity.class); //Iniciar intent
                intent.putExtra(Constants.KEY_JUEGO, new Gson().toJson(game)); //Cargar la data en String (serializada)
                startActivity(intent);
            }
        });
    }
}
