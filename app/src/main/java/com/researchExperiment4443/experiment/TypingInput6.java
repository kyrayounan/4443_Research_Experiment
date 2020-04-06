package com.researchExperiment4443.experiment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class TypingInput6 extends AppCompatActivity {

    private TextView result;
    TextView enterText;
    public static long start = 0;
    public static long time2 = 0;
    long speechTime;
    EditText type;
    Button b;
   public static int speechError;
    int counter = 0;
    String initials = "";
    String group = "";
    public static String task = "";

    public static int errors = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.typingstyle);
        result = (TextView) findViewById(R.id.editText);
        enterText = (TextView) findViewById(R.id.enterTextTyping);
        start = System.currentTimeMillis();
        Intent intent = getIntent();
        speechTime = intent.getLongExtra("time", 0);
        speechError = intent.getIntExtra("errors", 0);
        type = (EditText) findViewById(R.id.editText);
        type.addTextChangedListener(inputTextWatcher);
        initials = intent.getStringExtra("initials");
        group = intent.getStringExtra("group");


    }

    private TextWatcher inputTextWatcher = new TextWatcher() {
        int befor = 0;
        int after = 0;
        public void afterTextChanged(Editable type) {
            after = type.length();
        }
        public void beforeTextChanged(CharSequence tyoe, int start, int count, int after)
        {

        }
        public void onTextChanged(CharSequence type, int start, int before, int count) {

            Log.d(TAG, before + " before");
            Log.d(TAG, count + " count");
            Log.d(TAG, start + " start");
            if(before > count) {
                errors+=1;
            }
        }
    };





    public void onEnter(View view) {
counter++;
        if (counter == 5 && group.equals("1")) {
            Bundle b = new Bundle();
            task = "No";
            time2 = System.currentTimeMillis() - start;
            b.putInt("errors", errors);
            b.putLong("time2", time2 );
            b.putLong("time", speechTime);
            b.putInt("textError", errors);
            b.putInt("speechError", speechError);
            b.putString("initials", initials);
            b.putString("group", group);
            Intent i = new Intent(getApplicationContext(), Results.class);
            i.putExtras(b);
            startActivity(i);
        } else if(counter == 5 && group.equals("2")){
            Bundle b = new Bundle();
            task = "No";
            time2 = System.currentTimeMillis() - start;
            b.putInt("errors", errors);
            b.putLong("time2", time2 );
            b.putLong("time", speechTime);
            b.putInt("textError", errors);
            b.putInt("speechError", speechError);
            b.putString("initials", initials);
            b.putString("group", group);
            Intent i = new Intent(getApplicationContext(), SpeechInput.class);
            i.putExtras(b);
            startActivity(i);
        }

        if (result.getText().toString().equals(enterText.getText().toString()) && group.equals("1")) {
            Bundle b = new Bundle();
            task = "Yes";
            time2 = System.currentTimeMillis() - start;
            b.putInt("errors", errors);
            b.putLong("time2", time2 );
            b.putLong("time", speechTime);
            b.putInt("textError", errors);
            b.putInt("speechError", speechError);
            b.putString("initials", initials);
            b.putString("group", group);
            Intent i = new Intent(getApplicationContext(), Results.class);
            i.putExtras(b);
            startActivity(i);
        } else if(result.getText().toString().equals(enterText.getText().toString()) && group.equals("2")){
            Bundle b = new Bundle();
            task = "Yes";
            time2 = System.currentTimeMillis() - start;
            b.putInt("errors", errors);
            b.putLong("time2", time2 );
            b.putLong("time", speechTime);
            b.putInt("textError", errors);
            b.putInt("speechError", speechError);
            b.putString("initials", initials);
            b.putString("group", group);
            Intent i = new Intent(getApplicationContext(), SpeechInput.class);
            i.putExtras(b);
            startActivity(i);
        } else {
            Toast.makeText(this, "Input is not correct. Please try again", Toast.LENGTH_SHORT).show();

        }
    }
}
