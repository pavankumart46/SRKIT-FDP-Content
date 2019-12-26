package pavankreddy.blogspot.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMaps(View view)
    {
        EditText et = findViewById(R.id.address);
        String address = et.getText().toString();

        Intent mapsIntent = new Intent();
        mapsIntent.setAction(Intent.ACTION_VIEW);
        Uri data = Uri.parse("geo:0,0?q="+address);
        mapsIntent.setData(data);

        startActivity(mapsIntent);
    }

    public void openBrowser(View view)
    {
        EditText et = findViewById(R.id.eturl);
        String link = et.getText().toString();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri data = Uri.parse("https://"+link);
        intent.setData(data);

        /*
        * Intent intent =
        * new Intent(Intent.ACTION_VIEW,Uri.parse("https://"+link));*/

        startActivity(intent);
    }

    public void dialFriend(View view)
    {
        EditText et = findViewById(R.id.phone);
        String number = et.getText().toString();

        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:"+number);
        i.setData(data);

        startActivity(i);
    }
}
