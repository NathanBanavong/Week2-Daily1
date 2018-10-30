package com.hfad.week2_daily1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayPeople extends PersonActivity {

    ListView tryList;
    ArrayList<DisplayPeople> leList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_people);

        leList = (ArrayList<DisplayPeople>) getIntent().getExtras().get("personList");

        ArrayAdapter<DisplayPeople> itemsAdapter =
                new ArrayAdapter<DisplayPeople>(this, android.R.layout.simple_list_item_1, leList);

        ListView listView = findViewById(R.id.personList);
        listView.setAdapter(itemsAdapter);

    }


}
