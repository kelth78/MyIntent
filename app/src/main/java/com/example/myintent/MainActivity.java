package com.example.myintent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQ_CODE_LOADURL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQ_CODE_LOADURL) {
            Log.v(TAG, "onActivityResult res: " + resultCode);
            // Format of intent data depends on which activity is called
            if (resultCode == RESULT_OK) {
                Log.v(TAG, "IntentData: " + data);
            }
        }
    }

    private boolean isIndentSafe(Intent intentToCheck) {
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intentToCheck,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        Log.v(TAG, "Is " + intentToCheck + " safe? " + isIntentSafe);
        return isIntentSafe;
    }

    /** Called when the user taps button */
    public void sendImplicitIndent(View view) {
        Log.v(TAG, "Trigger implicit intent");
        //
        // Simple intent
        //
        Uri webpage = Uri.parse("http://www.android.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (isIndentSafe(webIntent)) {
            // Force show chooser if indent has more than one choices
            /*Intent chooser = Intent.createChooser(webIntent, "testChooser");
            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }*/
            startActivity(webIntent); // Don't care about result
        }

        //
        // intent requiring extra data
        //
        /*Intent emailIntent = new Intent(Intent.ACTION_SEND);
        // The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));*/
        // You can also attach multiple items by passing an ArrayList of Uris
    }

    public void sendExplicitIndent(View view) {
        Log.v(TAG, "Trigger explicit intent");
        Intent intent = new Intent(this, ShareActivity.class);
        startActivityForResult(intent, REQ_CODE_LOADURL); // Care about result, will be notify through onActivityResult
    }
}
