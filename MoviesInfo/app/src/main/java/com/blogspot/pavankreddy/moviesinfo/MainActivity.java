package com.blogspot.pavankreddy.moviesinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int images[];
    String movies[],actors[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpData();
    }

    private void setUpData() {
        images = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
        R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,
        R.drawable.i,R.drawable.j};

        movies = new String[]{"Attarintiki Daredi","Bobby","Chatrapathi","Daddy",
        "Eega","Fidaa","George Reddy","Happy Days",
        "Indra","Julayi"};

        actors = new String[]{"Pavan Kalyan","Mahesh Babu","Prabhas","Chiranjeevi",
        "Eega","Varun Tej","Sandeep Madhav","So Many",
        "Chiranjeevi","Allu Arjun"};
    }
}
