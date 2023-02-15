package com.example.cardview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView courseRV = findViewById(R.id.idRVCourse);

        ArrayList<CardModel> cardModelArrayList = new ArrayList<CardModel>();
        cardModelArrayList.add(new CardModel("David Dufour", "Administration", R.drawable.agent2));
        cardModelArrayList.add(new CardModel("Gabriela Ortega", "Administration", R.drawable.agent2));
        cardModelArrayList.add(new CardModel("Achraf Derbal", "Administration", R.drawable.agent2));
        cardModelArrayList.add(new CardModel("Flora", "Administration", R.drawable.agent2));

        CardAdapter cardAdapter = new CardAdapter(this, cardModelArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(cardAdapter);
    }
}