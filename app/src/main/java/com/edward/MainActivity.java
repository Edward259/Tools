package com.edward;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.edward.view.PasswordEditText;

public class MainActivity extends AppCompatActivity {


    private PasswordEditText passwordEditText, customPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordEditText = findViewById(R.id.et_password);
        customPasswordEditText = findViewById(R.id.et_star);
        passwordEditText.setOnTextChangeListener(new PasswordEditText.OnTextChangeListener() {
            @Override
            public void onTextChange(String pwd) {
                if (pwd.length() == passwordEditText.getTextLength()){
                    //输入监听
                    Toast.makeText(MainActivity.this,pwd,Toast.LENGTH_SHORT).show();
                }
            }
        });
        customPasswordEditText.setOnTextChangeListener(new PasswordEditText.OnTextChangeListener() {
            @Override
            public void onTextChange(String pwd) {
                if (pwd.length() == customPasswordEditText.getTextLength()){
                    //输入监听
                    Toast.makeText(MainActivity.this,pwd,Toast.LENGTH_SHORT).show();
                }
            }
        });

        PasswordEditText currentFocusEditText = (PasswordEditText) getCurrentFocusEditText();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PasswordEditText currentFocusEditText = (PasswordEditText) getCurrentFocusEditText();
                if (currentFocusEditText == null) {
                    return;
                }
                currentFocusEditText.clearText(); //清空输入内容
            }
        });
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordEditText currentFocusEditText = (PasswordEditText) getCurrentFocusEditText();
                if (currentFocusEditText == null) {
                    return;
                }
                currentFocusEditText.addChar("2");
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordEditText currentFocusEditText = (PasswordEditText) getCurrentFocusEditText();
                if (currentFocusEditText == null) {
                    return;
                }
                currentFocusEditText.deleteChar();
            }
        });

    }

    private EditText getCurrentFocusEditText() {
        if (getCurrentFocus() == null) {
            return null;
        }
        switch (getCurrentFocus().getId()) {
            case R.id.et_password:
                return passwordEditText;
            case R.id.et_star:
                return customPasswordEditText;
            default:
                return null;
        }
    }

}
