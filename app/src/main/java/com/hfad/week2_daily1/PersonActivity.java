package com.hfad.week2_daily1;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hfad.week2_daily1.views.model.Person;

import java.util.ArrayList;

public class PersonActivity extends Activity {
    private static final String TAG = Activity.class.getSimpleName() + "_TAG";

    //    private EditText edPhone;
    private EditText edPersonName;
    private EditText edPersonAge;
    private EditText edPersonGender;
//
//    public personName;
//    public personAge;
//    public personGender;

    ArrayList<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        bindViews();
        Log.d(TAG, "onCreate: ");

        //Person getInput = (Person) getIntent().getParcelableExtra("myDataKey");

        //people.add(getInput);


//        Toast.makeText(this, person.toString(), Toast.LENGTH_LONG).show();


//        listPerson = findViewById(R.id.personList);

//        ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this,
//                android.R.layout.simple_list_item_1, people);

//        listPerson.setAdapter(adapter);

//        String listPersonProfile = getIntent().getStringExtra(Constants.KEYS.)

    }

//    track instances
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    private void bindViews() {

        edPersonName = findViewById(R.id.edPersonName);
        edPersonAge = findViewById(R.id.edPersonAge);
        edPersonGender = findViewById(R.id.edPersonGender);
    }


    public void createPerson(View view) {
        String personName = edPersonName.getText().toString();
        String personAge = edPersonAge.getText().toString();
        String personGender = edPersonGender.getText().toString();

        Person addPerson = new Person(personName, personAge, personGender);
        people.add(addPerson);

        Toast.makeText(this, addPerson.toString(), Toast.LENGTH_LONG).show();

        edPersonName.setText("");
        edPersonAge.setText("");
        edPersonGender.setText("");

        //Intent i = new Intent(this, Person.class);
//        Intent createPerson = new Intent(getApplicationContext(), PersonActivity.class);
//        createPerson.putExtra("personList", (Parcelable) people); // using the (String name, Parcelable value) overload!

        //createPerson.putExtra("Person", addPerson);

        //startActivity(createPerson);
    }

    public void showPeopleList(View view) {
        Intent showList = new Intent(getApplicationContext(), DisplayPeople.class);
        showList.putExtra("personList", people);
        startActivity(showList);

    }

}
