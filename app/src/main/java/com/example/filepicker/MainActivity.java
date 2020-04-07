package com.example.filepicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView dummy;
  Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dummy=(TextView)findViewById(R.id.button_dummy);
        button=(Button)findViewById(R.id.button_pick);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                 intent.setType("*/*");
                 startActivityForResult(intent,10);

             }
         });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case 10:
                if(resultCode==RESULT_OK)
                {
                    String path=data.getData().getPath();
                    dummy.setText(path);
                }
        }
    }
}
