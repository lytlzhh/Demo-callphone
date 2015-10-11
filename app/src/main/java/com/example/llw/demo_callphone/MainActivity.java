package com.example.llw.demo_callphone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView textView;
    private EditText editText;
    private String state = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text);
        editText = (EditText) findViewById(R.id.edit1);

      editText.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (((state=editText.getText().toString())!=null)&&state.length()<=11)
            {
                textView.setText(state);
            }else {
                Toast.makeText(MainActivity.this, "你拨打的号码是空号", Toast.LENGTH_SHORT).show();
            }
          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // state = editText.getText().toString();
                if (state.length()!=0)
                {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(state));
                    MainActivity.this.startActivity(intent);
                }else {

                    Toast.makeText(MainActivity.this, "电话来了", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
