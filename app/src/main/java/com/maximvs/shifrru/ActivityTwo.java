package com.maximvs.shifrru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    private Button buttonDeCrypt;
    private Button buttonDeleteAllTwo;
    private Button buttonGoCrypt;
    private EditText editTextCryptTwo;
    private TextView editTextDeCrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        buttonDeCrypt = (Button) findViewById(R.id.buttonDeCrypt);
        buttonDeleteAllTwo = (Button) findViewById(R.id.buttonDeleteAllTwo);
        buttonGoCrypt = (Button) findViewById(R.id.buttonGoCrypt);
        editTextCryptTwo = (EditText) findViewById(R.id.editTextCryptTwo);
        editTextDeCrypt = (TextView) findViewById(R.id.editTextDeCrypt);

        buttonDeCrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextCryptTwo.getText().length() == 0)
                    Toast.makeText(ActivityTwo.this, R.string.instruction5, Toast.LENGTH_SHORT).show();
                else {
                    String eTextCry = editTextCryptTwo.getText().toString();
                    editTextDeCrypt.setText(decrypter(eTextCry));
                }
            }
        });

        buttonDeleteAllTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextDeCrypt.setText(" ");
                editTextCryptTwo.setText(" ");
            }
        });

        buttonGoCrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTwo.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public static String decrypter(String string) {

        String newString14 = string.replace('4', '??');
        String newString15 = newString14.replace('f', ' ');
        String newString16 = newString15.replace('$', '??');
        String newString17 = newString16.replace('r', '??');
        String newString18 = newString17.replace('7', '??');
        String newString19 = newString18.replace('s', '??');
        String newString20 = newString19.replace('9', '??');
        String newString21 = newString20.replace('w', '??');
        String newString22 = newString21.replace('5', '??');
        String newString23 = newString22.replace('0', '??');
        String newString24 = newString23.replace('?', '??');
        String newString25 = newString24.replace('%', '??');
        String newString26 = newString25.replace('!', '??');
        String newString27 = newString26.replace('+', '??');

        return newString27;
    }
}