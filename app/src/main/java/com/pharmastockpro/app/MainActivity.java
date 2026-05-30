package com.pharmastockpro.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStock = findViewById(R.id.btnStock);
        Button btnVentes = findViewById(R.id.btnVentes);
        Button btnClients = findViewById(R.id.btnClients);
        Button btnDeconnexion = findViewById(R.id.btnDeconnexion);

        btnStock.setOnClickListener(v -> Toast.makeText(this, "Module Stock - Bientôt", Toast.LENGTH_SHORT).show());
        btnVentes.setOnClickListener(v -> Toast.makeText(this, "Module Ventes - Bientôt", Toast.LENGTH_SHORT).show());
        btnClients.setOnClickListener(v -> Toast.makeText(this, "Module Clients - Bientôt", Toast.LENGTH_SHORT).show());
        
        btnDeconnexion.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
