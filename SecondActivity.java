package pk.edu.uiit.Arid2432.Registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    DataBase dataBase;
    Button btnlogin;
    EditText etEmail,etPass;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initialize();
        performaction();

    }

    private void performaction(){
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = dataBase.login(etEmail.getText().toString(),etPass.getText().toString());
               if(cursor.getCount()>0 ){
                   Intent intent = new Intent(SecondActivity.this,StudentCard.class);
                   startActivity(intent);
               }
               else{
                   Toast.makeText(SecondActivity.this,"Invalid input",Toast.LENGTH_LONG).show();
               }


            }
        });
    }

    private void initialize(){

        dataBase = new DataBase(this);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass  = (EditText) findViewById(R.id.etPass);
        btnlogin = (Button) findViewById(R.id.btnlogin);

    }



}