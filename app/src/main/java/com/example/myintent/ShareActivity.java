package com.example.myintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

//
// To allow other apps to start your activity, you need to add an <intent-filter> element in your
// manifest file for the corresponding <activity> element.
//
/*<activity
        android:name=".ShareActivity"
        android:label="@string/title_activity_share"
        android:theme="@style/AppTheme.NoActionBar">
        <intent-filter>
        <action android:name="android.intent.action.SEND" />

        <category android:name="android.intent.category.DEFAULT" />

        <data android:mimeType="text/plain" />
        <data android:mimeType="image/*" />
        </intent-filter>
        </activity>
*/

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Get the intent that started this activity
        Intent intent = getIntent();
        Uri data = intent.getData();

        // Figure out what to do based on the intent type
        /*if (intent.getType().indexOf("image/") != -1) {
            // Handle intents with image data ...
        } else if (intent.getType().equals("text/plain")) {
            // Handle intents with text ...
        }*/

        // Create intent to deliver some kind of result data
        //Intent result = new Intent("com.example.RESULT_ACTION", Uri.parse("content://result_uri"));
        //setResult(Activity.RESULT_OK, result);
        setResult(Activity.RESULT_OK);
        //finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
