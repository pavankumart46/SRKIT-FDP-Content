package pavankreddy.blogspot.srkitfdpfirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.counttv);

        if(savedInstanceState!=null){
            count = savedInstanceState.getInt("COUNT");
            tv.setText(String.valueOf(count));
        }
    }

    public void showToast(View view) {

       /* Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();*/
        count--;
        tv.setText(String.valueOf(count));
    }

    public void showCount(View view) {
        count++;
        /*tv.setText(""+count); --> this works too */
        tv.setText(String.valueOf(count));
    }

    // Step - 1 -> Override onsaveInstanceState
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Step-2 --> Decide on what to save!
        outState.putInt("COUNT",count);
    }
}
