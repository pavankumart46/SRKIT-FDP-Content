package pavankreddy.blogspot.srkitfdpfirst;

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
    }

    public void showToast(View view) {

        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        count++;
        /*tv.setText(""+count); --> this works too */
        tv.setText(String.valueOf(count));
    }
}
