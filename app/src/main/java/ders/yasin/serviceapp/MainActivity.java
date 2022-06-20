package ders.yasin.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStart,btnStop;
    EditText etName;
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=findViewById(R.id.btn_Start);
        btnStop=findViewById(R.id.btn_Stop);
        etName=findViewById(R.id.et_Name);
        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        serviceIntent= new Intent(MainActivity.this, MyIntentService.class);
        Log.i("Timer", "Activity thread number:" + Thread.currentThread().getId());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Start:{
                String name=etName.getText().toString();
                serviceIntent.putExtra("NAME",name);
                startService(serviceIntent);break;
            }

            case R.id.btn_Stop:
                stopService(serviceIntent);
        }

    }
}