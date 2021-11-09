package pk.edu.uiit.Arid2432.Registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentCard extends AppCompatActivity {

    DataBase dataBase;
    TextView text;
    ImageView imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_card);
        dataBase = new DataBase(this);
       // Cursor cursor = dataBase.login()
        text = (TextView)findViewById(R.id.tName);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setImageResource(R.drawable.student);


    }
}