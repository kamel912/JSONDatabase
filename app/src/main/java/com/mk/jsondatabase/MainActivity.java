package com.mk.jsondatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.PublicKey;

import static com.mk.jsondatabase.CustomTask.result;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
   // public static String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_text);
     //  userName = editText.getText().toString();
        textView = (TextView) findViewById(R.id.text_view);
       new  CustomTask().execute("http://oriflamebeauty.net/app/read.php?username=mohamed&password=123");
    }
    public void getData(View view){

        textView.setText(result);
    }
}
