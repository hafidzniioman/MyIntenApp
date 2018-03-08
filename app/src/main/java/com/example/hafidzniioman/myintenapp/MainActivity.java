package com.example.hafidzniioman.myintenapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private Button btnMoveActivityWithData;
    private Button getBtnMoveActivityWithObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button) findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityWithData = (Button) findViewById(R.id.btn_move_data);
        btnMoveActivityWithData.setOnClickListener(this);

        getBtnMoveActivityWithObject = (Button) findViewById(R.id.btn_move_activity_object);
        getBtnMoveActivityWithObject.setOnClickListener(this); 
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveintent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveintent);
                break;
            case R.id.btn_move_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveActivityWithData.class);
                moveWithDataIntent.putExtra(MoveActivityWithData.EXTRA_NAME, "Dicoding Boy");
                moveWithDataIntent.putExtra(MoveActivityWithData.EXTRA_AGE,5);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("Hafidz Firdaus");
                mPerson.setAge(28);
                mPerson.setEmail("hafidzniioman@gmail.com");
                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, (Parcelable) mPerson);
                startActivity(moveWithObjectIntent);
                break;
        }
    }
}
