package com.maximvs.shifrru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonCrypt;
    private Button buttonCopy;
    private Button buttonDeleteAll;
    private Button buttonGoDeCrypt;
    private EditText editTextInput;
    private TextView editTextCrypt;

    ClipboardManager clipboardManager;
    ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCrypt = (Button) findViewById(R.id.buttonCrypt);
        buttonCopy = (Button) findViewById(R.id.buttonCopy);
        buttonDeleteAll = (Button) findViewById(R.id.buttonDeleteAll);
        buttonGoDeCrypt = (Button) findViewById(R.id.buttonGoDeCrypt);
        editTextInput = (EditText) findViewById(R.id.editTextInput);
        editTextCrypt = (TextView) findViewById(R.id.editTextCrypt);

        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        buttonCrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextInput.getText().length() == 0)
                    Toast.makeText(MainActivity.this, R.string.instruction, Toast.LENGTH_SHORT).show();
                else {
                    String eTextInp = editTextInput.getText().toString();
                    editTextCrypt.setText(crypter(eTextInp));
                }
            }
        });

        buttonDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextInput.setText(" ");
                editTextCrypt.setText(" ");
            }
        });

        buttonGoDeCrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

        buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eTextCry = editTextCrypt.getText().toString();
                clipData = ClipData.newPlainText("text", eTextCry);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(MainActivity.this, R.string.textCopy, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static String crypter(String string) {

        String newString = string.replace('е', '4');
        String newString1 = newString.replace(' ', 'f');
        String newString2 = newString1.replace('б', '$');
        String newString3 = newString2.replace('и', 'r');
        String newString4 = newString3.replace('н', '7');
        String newString5 = newString4.replace('к', 's');
        String newString6 = newString5.replace('в', '9');
        String newString7 = newString6.replace('а', 'w');
        String newString8 = newString7.replace('т', '5');
        String newString9 = newString8.replace('р', '0');
        String newString10 = newString9.replace('с', '?');
        String newString11 = newString10.replace('л', '%');
        String newString12 = newString11.replace('м', '!');
        String newString13 = newString12.replace('у', '+');

        return newString13;
    }
}