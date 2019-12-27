package com.blogspot.pavankreddy.popularquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView results;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        results = findViewById(R.id.result);
        progressBar = findViewById(R.id.progressbar);
        //This progress bar should not be visible to the
        //    user as soon as the app is launched
        progressBar.setVisibility(View.GONE);
    }

    public void fetchQuotes(View view)
    {
        progressBar.setVisibility(View.VISIBLE);
        new FetchQuotes(this,results,progressBar).execute();
    }
}
