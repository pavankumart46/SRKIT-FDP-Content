package com.blogspot.pavankreddy.popularquotes;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchQuotes extends AsyncTask<Void,Void,String>
{

    private static final String URL_LINK
            = "https://quote-garden.herokuapp.com/quotes/all";

    @Override
    protected String doInBackground(Void... voids) {
        try
        {
            URL url = new URL(URL_LINK);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            if(is!=null)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String line;
                while((line=br.readLine())!=null){
                    sb.append(line);
                }
                return sb.toString();
            }
            else
                Log.d("INFO","Input stream is null");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}
