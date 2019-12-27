package com.blogspot.pavankreddy.moviesinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
        // Set the adapter
        recyclerView.setAdapter(new MovieAdapter());
        // set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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

        /*the following method updates the data on the views based on the
        * position*/
        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            holder.p.setImageResource(images[position]);
            holder.mn.setText(movies[position]);
            holder.an.setText(actors[position]);
        }

        /*This method tells the recyclerview about how many items are
        * there in total*/
        @Override
        public int getItemCount() {
            return movies.length;
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
