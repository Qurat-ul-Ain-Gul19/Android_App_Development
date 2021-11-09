package pk.edu.uiit.Arid2432.Registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBase dataBase;
    EditText etName,etEmail,etPhone,etCountry,etPass,etCPass;
    Button btnRegister,btnReset,btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        performaction();
    }

    private void performaction() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();
                String Pass = etPass.getText().toString();
                String country = etCountry.getText().toString();

                if (email.length() == 0 || Pass.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter email and Password", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, email, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, phone, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, Pass, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, country, Toast.LENGTH_LONG).show();
                }

                long user_data = dataBase.signup(email, Pass, name, phone, country);

                if (user_data == -1) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                etName.setText(null);
                etEmail.setText(null);
                etPhone.setText(null);
                etPass.setText(null);
                etCPass.setText(null);
                etCountry.setText(null);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
             startActivity(intent);
            }
            });
            }

            private void initialize() {


                dataBase = new DataBase(this);
                etName = (EditText) findViewById(R.id.etName);
                etEmail = (EditText) findViewById(R.id.etEmail);
                etPhone = (EditText) findViewById(R.id.etPhone);
                etPass = (EditText) findViewById(R.id.etPass);
                etCPass = (EditText) findViewById(R.id.etCPass);
                etCountry = (EditText) findViewById(R.id.etCountry);
                btnRegister = (Button) findViewById(R.id.btnRegister);
                btnReset = (Button) findViewById(R.id.btnReset);
                btnlogin = (Button) findViewById(R.id.btnlogin);
            }


    }