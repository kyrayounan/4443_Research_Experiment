package com.sriyanksiddhartha.speechtotext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TypingInput extends AppCompatActivity {

    private TextView result;
    TextView enterText;

    static int errors = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.typingstyle);
        result = (TextView) findViewById(R.id.editText);
        enterText = (TextView) findViewById(R.id.enterTextTyping);
    }

    public void onEnter(View view) {

        if (result.getText().toString().equals(enterText.getText().toString())) {
            Bundle b = new Bundle();
            b.putInt("errors", errors);
            Intent i = new Intent(getApplicationContext(), SpeechInput.class);
            i.putExtras(b);
            startActivity(i);
        } else {
            Toast.makeText(this, "Input is not correct. Please try again", Toast.LENGTH_SHORT).show();
            errors += 1;
        }
    }
}
