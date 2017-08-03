package com.example.aaron.datapersentance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String MY_PREF_FILE = "FILE_ONE";
    private static final String TAG = "ACTIVITE_ONE";
    EditText etTxtOne;
    EditText etTxtTwo;
    Button saveData;
    Button getData;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTxtOne = (EditText)findViewById(R.id.text1);
        etTxtTwo = (EditText)findViewById(R.id.text2);
        saveData = (Button)findViewById(R.id.button1);
        getData = (Button)findViewById(R.id.button2);



    }

    public void saveData(View view){
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value1", etTxtOne.getText().toString());
        editor.putString("value2", etTxtTwo.getText().toString());
        editor.commit();
    }

    public void getData(View view){
        SharedPreferences sharedPReferences = getSharedPreferences(MY_PREF_FILE,Context.MODE_PRIVATE);
        Intent sendIntent = new Intent(this, SecondActivity.class);
        startActivity(sendIntent);

        Log.d(TAG, "getData: " + sharedPReferences.getString("value1","Default"));
        
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
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
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onConfigurationChanged: LANDSCAPE");
        }
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "PORTAIT", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onConfigurationChanged: PORTAIT");
        }
    }
}
