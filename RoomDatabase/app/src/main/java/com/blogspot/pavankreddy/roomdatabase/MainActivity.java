package com.blogspot.pavankreddy.roomdatabase;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    TextView results;
    PersonDatabase personDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        results = findViewById(R.id.result);

        personDatabase =
                Room.databaseBuilder(this,PersonDatabase.class,"mydb")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view)
    {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        Person person = new Person(n,a);
        personDatabase.personDao().insert(person);
        getData();
    }

    private void getData() {
        List<Person> p = personDatabase.personDao().getAll();
        results.setText("");
        for(int i =0; i<p.size();i++){
            results.append(p.get(i).getIds()+"\n");
            results.append(p.get(i).getName()+"\n");
            results.append(p.get(i).getAge()+"\n\n");
        }
    }


    /*to create a table - in room - we create a class
    * - Class name --> table name
    * - Variables Names --> coloumn Names
    *
    * DAO - Data Access Object - is an interface
    * We define methods with proper annotations that
    * helps us to do data base transactions*/

}
