package com.blogspot.pavankreddy.moviesinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int images[];
    String movies[],actors[];
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpData();
        recyclerView = findViewById(R.id.recyclerview);
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

    class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder>{

        /*The following method is responsible to attach the design.xml to all
        * the items in the recyclerview*/
        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.design,parent,false);
            return new MovieViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    /*This class helps us to connect with Views on the design.xml for
    * every entry in the recyclerview*/
    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView p;
        TextView mn,an;
        public MovieViewHolder(View itemView) {
            super(itemView);
            p = itemView.findViewById(R.id.posters);
            mn = itemView.findViewById(R.id.moviename);
            an = itemView.findViewById(R.id.actorname);
        }
    }
}
