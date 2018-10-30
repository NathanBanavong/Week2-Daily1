package com.hfad.week2_daily1.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.week2_daily1.PersonActivity;
import com.hfad.week2_daily1.R;

import static com.hfad.week2_daily1.views.model.Constants.KEYS.REQUEST_IMAGE_CAPTURE;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private TextView txtDisplay;
    private EditText edMessage;
    //    private EditText edPhone;
    private ImageView imgPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        bindViews();

    }

    private void bindViews() {
        txtDisplay = findViewById(R.id.mainView_Text);
        edMessage = findViewById(R.id.ed_msgSend);
//        edPhone = findViewById(R.id.ed_callNumber);
        imgPic = findViewById(R.id.imgShow);
    }

    //    track state of activities
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

    //to work, camera needs to be on before using app
    //send the implicit intent of picture activity to camera
    //Worked for first picture then went hell
    public void pictureIntent(View view) {
        //show the 'intent to start a new components -> what to pass
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  //implicit camera
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        startActivity(takePictureIntent);
    }

    //receives picture taken and pushes to image-view
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgPic.setImageBitmap(imageBitmap);
        }
    }

    //    intent to send a message
    public void msgIntent(View view) {
        //show the 'intent to start a new components -> what to pass
        Intent sendMessage = new Intent(Intent.ACTION_SEND);  //implicit
        sendMessage.putExtra(Intent.EXTRA_TEXT, edMessage.getText().toString());
        sendMessage.setType("text/plain");      //set the content type
        if (sendMessage.resolveActivity(getPackageManager()) != null) {
            startActivity(sendMessage);
        }
    }

    //all user to make a call using implicit -> Action Dial
    public void phoneIntent(View view) {
        //show the 'intent to start a new components -> what to pass

        Intent makeCall = new Intent(Intent.ACTION_DIAL);  //implicit
//        makeCall.putExtra(Intent.EXTRA_TEXT, edPhone.getText().toString());
        makeCall.setData(Uri.parse("tel:0377778888"));
        if (makeCall.resolveActivity(getPackageManager()) != null) {
            startActivity(makeCall);
        }
    }

    //    go to form -> Person Activity
    public void onPeople(View view) {
        Intent goTo = new Intent(getApplicationContext(), PersonActivity.class);
        startActivity(goTo);
    }

}
