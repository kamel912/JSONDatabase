package com.mk.jsondatabase;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by MK on 29/03/2017.
 */

class CustomTask extends AsyncTask<String,String,String> {
    protected static String result;
    TextView textView;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

      //  Toast.makeText(MainActivity, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            String myurl = params[0];
            //    String s = URLEncoder.encode(MainActivity.userName,"utf-8");

            URL url = new URL(myurl);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            result = "";
            while ((line = bufferedReader.readLine()) != null) {

                result += line;
                inputStream.close();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        String name = "";
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                name = "id : " + jsonObject.getString("id")+
                        "name : " + jsonObject.getString("name");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

}
