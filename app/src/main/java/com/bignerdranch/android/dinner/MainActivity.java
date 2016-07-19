package com.bignerdranch.android.dinner;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final String SAVED_TEXT = "saved text";
    private SharedPreferences mSharedPreferences;

    @BindView(R.id.button) Button mButton;
    @BindView(R.id.editText) EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadText();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveText();
                showToast("Click");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void saveText() {
        mSharedPreferences = getSharedPreferences("Guests number", MODE_PRIVATE);
        SharedPreferences.Editor ed = mSharedPreferences.edit();
        ed.putString(SAVED_TEXT, mEditText.getText().toString());
        ed.apply();
    }

    private void loadText() {
        mSharedPreferences = getSharedPreferences("Guests number", MODE_PRIVATE);
        String savedGuestNumber = mSharedPreferences.getString(SAVED_TEXT, "");
        mEditText.setText(savedGuestNumber);
    }
}
