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

public class TypingInput5 extends AppCompatActivity {

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
    TextView blockNum;
    TextView trialNum;
    int block = 1;
    String sentence = "";
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
        blockNum = (TextView) findViewById(R.id.block);
        trialNum = (TextView) findViewById(R.id.trial);
        trialNum.setText("Trial: 5");
        errors = 0;
        sentence = "I am out of paper for the printer";
        enterText.setText(sentence);

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

        if(result.getText().toString().equals(enterText.getText().toString())) {
            block++;
            if(block < 6) {
                type.getText().clear();

                blockNum.setText("Block: " + (block));
            }
        }
counter++;
        if (counter == 10 && group.equals("1")) {
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
            Intent i = new Intent(getApplicationContext(), SpeechInput6.class);
            i.putExtras(b);
            startActivity(i);
        } else if(counter == 10 && group.equals("2")){
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
            Intent i = new Intent(getApplicationContext(), SpeechInput5.class);
            i.putExtras(b);
            startActivity(i);
        }

        if (result.getText().toString().equals(enterText.getText().toString()) && group.equals("1") && block == 6) {
            Bundle b = new Bundle();
            task = "Yes";
            time2 = System.currentTimeMillis() - start;
            b.putInt("errors", errors);
            b.putLong("time2", time2 );
            errors = errors - 4;
            b.putLong("time", speechTime);
            b.putInt("textError", errors);
            b.putInt("speechError", speechError);
            b.putString("initials", initials);
            b.putString("group", group);
            Intent i = new Intent(getApplicationContext(),SpeechInput6.class);
            i.putExtras(b);
            startActivity(i);
        } else if(result.getText().toString().equals(enterText.getText().toString()) && group.equals("2") && block == 6){
            Bundle b = new Bundle();
            task = "Yes";
            time2 = System.currentTimeMillis() - start;
            b.putInt("errors", errors);
            b.putLong("time2", time2 );
            b.putLong("time", speechTime);
            b.putInt("textError", errors);
            b.putInt("speechError", speechError);
            errors = errors - 4;
            b.putString("initials", initials);
            b.putString("group", group);
            Intent i = new Intent(getApplicationContext(), SpeechInput5.class);
            i.putExtras(b);
            startActivity(i);
        } else {
            Toast.makeText(this, "Input again", Toast.LENGTH_SHORT).show();

        }
    }
}
