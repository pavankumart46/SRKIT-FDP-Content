package pavankreddy.blogspot.menusanddialogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(this, "OP1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option2:
                showAlert();
                break;
            case R.id.option3:
                Toast.makeText(this, "OP3", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void showAlert() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.alerticon);
        builder.setTitle("Sample Alert");
        builder.setMessage("We are doing a sample for Alert Dialog");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "YES BUTTON CLICKED",
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "NO CLICKED",
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("Cancel",null);

        builder.show();
    }

    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
        /*Toast.makeText(this, "You cannot close the app by clicking on back button",
                Toast.LENGTH_SHORT).show();*/
        showAlert();
    }
}
