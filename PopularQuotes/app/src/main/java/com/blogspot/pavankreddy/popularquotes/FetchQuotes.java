package com.blogspot.pavankreddy.popularquotes;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchQuotes extends AsyncTask<Void,Void,String>
{

    private static final String URL_LINK
            = "https://cat-fact.herokuapp.com/facts";
    private Context context;
    private TextView textView;
    private ProgressBar progressBar;

    public FetchQuotes(Context context, TextView textView, ProgressBar progressBar) {
        this.context = context;
        this.textView = textView;
        this.progressBar = progressBar;
    }

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
        progressBar.setVisibility(View.GONE);
        /*textView.setText(s);*/
        try {
            JSONObject root = new JSONObject(s);
            JSONArray allfacts = root.getJSONArray("all");
            /* To Fetch only first objects content
            JSONObject first_object = allfacts.getJSONObject(0);
            textView.setText(first_object.getString("text"));*/
            for(int i=0; i<allfacts.length();i++){
                JSONObject data = allfacts.getJSONObject(i);
                String fact = data.getString("text");
                textView.append(fact+"\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
