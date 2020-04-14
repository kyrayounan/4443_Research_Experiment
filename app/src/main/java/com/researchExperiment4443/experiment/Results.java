package com.researchExperiment4443.experiment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.concurrent.TimeUnit;

public class Results extends AppCompatActivity {
    static EditText initialsInput;
    final static String[] GROUP_NUMBER = {"1", "2"};
    Long textTime = 0l;
    long speechTime = 0l;
    int textError = 0;
    int speechError = 0;
    Long textTime2 = 0l;
    long speechTime2 = 0l;
    int textError2 = 0;
    int speechError2 = 0;
    Long textTime3 = 0l;
    long speechTime3 = 0l;
    int textError3 = 0;
    int speechError3 = 0;
    Long textTime4 = 0l;
    long speechTime4 = 0l;
    int textError4 = 0;
    int speechError4 = 0;
    Long textTime5 = 0l;
    long speechTime5 = 0l;
    int textError5 = 0;
    int speechError5 = 0;
    Long textTime6 = 0l;
    long speechTime6 = 0l;
    int textError6 = 0;
    int speechError6 = 0;
    String initials = "";
    String group = "";
    int blockComplete;
    int blockComplete2;
    int blockComplete3;
    int blockComplete4;
    int blockComplete5;
    int blockComplete6;

	/*final static String[] GAIN = { "Very low", "Low", "Medium", "High", "Very high" };
	final static String[] PATH_TYPE = { "Square", "Circle", "Free" };
	final static String[] PATH_WIDTH = { "Narrow", "Medium", "Wide" };
	 */

    //final static int[] GROUP_NUMBER = {1, 2};
    //final static int[] GAIN_ARG_VELOCITY_CONTROL = { 25, 50, 100, 200, 400 };

    //Spinner spinOrderOfControl, spinGain, spinPathMode, spinPathWidth, spinLaps;



    // called when the activity is first created
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        Intent intent = getIntent();
        textTime = TypingInput.time2;
        speechTime = SpeechInput.time;
        textError = TypingInput.errors;
        speechError = SpeechInput.errors + 1;

        textTime2 = TypingInput2.time2;
        speechTime2 = SpeechInput2.time;
        textError2 = TypingInput2.errors;
        speechError2 = SpeechInput2.errors;

        textTime3 = TypingInput3.time2;
        speechTime3 = SpeechInput3.time;
        textError3 = TypingInput3.errors;
        speechError3 = SpeechInput3.errors;

        textTime4 = TypingInput4.time2;
        speechTime4 = SpeechInput4.time;
        textError4 = TypingInput4.errors;
        speechError4 = SpeechInput4.errors;

        textTime5 = TypingInput5.time2;
        speechTime5 = SpeechInput5.time;
        textError5 = TypingInput5.errors;
        speechError5 = SpeechInput5.errors;

        textTime6 = TypingInput6.time2;
        speechTime6 = SpeechInput6.time;
        textError6 = TypingInput6.errors;
        speechError6 = SpeechInput6.errors;

        blockComplete = SpeechInput.block - 1;
        blockComplete2 = SpeechInput2.block - 1;
        blockComplete3 = SpeechInput3.block - 1;
        blockComplete4 = SpeechInput4.block - 1;
        blockComplete5 = SpeechInput5.block - 1;
        blockComplete6 = SpeechInput6.block - 1;

        initials = intent.getStringExtra("initials");
        group = intent.getStringExtra("group");;
        speechError = speechError -1;
        TextView te = (TextView) findViewById(R.id.textE);
        TextView se = (TextView) findViewById(R.id.speechE);
        TextView tt = (TextView) findViewById(R.id.textTime);
        TextView st = (TextView) findViewById(R.id.speechTime);
        TextView i = (TextView) findViewById(R.id.name);
        TextView g = (TextView) findViewById(R.id.group);
        TextView c = (TextView) findViewById(R.id.complete);
        TextView c2 = (TextView) findViewById(R.id.complete2);
        TextView b = (TextView) findViewById(R.id.block);




        String t = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( textTime),
                textTime-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( textTime))));
        String t2 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( speechTime),
                speechTime-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( speechTime))));
        String t3 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( textTime2),
                textTime2-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( textTime2))));
        String t4 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( speechTime2),
                speechTime2-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( speechTime2))));
        String t5 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( textTime3),
                textTime3-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( textTime3))));
        String t6 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( speechTime3),
                speechTime3-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( speechTime3))));
        String t7 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( textTime4),
                textTime4-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( textTime4))));
        String t8 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( speechTime4),
                speechTime4-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( speechTime4))));
        String t9 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( textTime5),
                textTime5-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( textTime5))));
        String t10 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( speechTime5),
                speechTime5-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( speechTime5))));
        String t11 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( textTime6),
                textTime6-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( textTime6))));
        String t12 = String.format("%02d:%02d" + "s",
                TimeUnit.MILLISECONDS.toSeconds( speechTime6),
                speechTime6-TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds( speechTime6))));

        String e = "" + textError + ", " + textError2  + ", " + textError3  + ", " + textError4  + ", " + textError5  + ", " + textError6;
        String e2 = "" + speechError + ", " + speechError2  + ", " + speechError3  + ", " + speechError4  + ", " + speechError5  + ", " + speechError6;
        String n = "" + initials;
        String gr = "" + group;
        String task = SpeechInput.task;
        String task2 = TypingInput.task;
        String task3 = SpeechInput2.task;
        String task4 = TypingInput2.task;
        String task5 = SpeechInput3.task;
        String task6 = TypingInput3.task;
        String task7 = SpeechInput4.task;
        String task8 = TypingInput4.task;
        String task9 = SpeechInput5.task;
        String task10 = TypingInput5.task;
        String task11 = SpeechInput6.task;
        String task12 = TypingInput6.task;

        String blocks = "" + blockComplete + ", " + blockComplete2+ ", " + blockComplete3+ ", " + blockComplete4+ ", " + blockComplete5+ ", " + blockComplete6;
        tt.append(t + ", " + t3 + ", " + t5+ ", " + t7+ ", " + t9+ ", " + t11);
        st.append(t2 + ", " + t4 + ", " + t6 + ", " + t8 + ", " + t10 + ", " + t12);
        te.append(e);
        se.append(e2);
        i.append(n);
        g.append(gr);
        b.append(blocks);
        c.append(task + ", " + task3  + ", " + task5  + ", " + task7  + ", " + task9  + ", " + task11);
        c2.append(task2 + ", " + task4  + ", " + task6  + ", " + task8  + ", " + task10  + ", " + task12);







    }

    // called when the "OK" button is tapped
    public void clickOK(View view)
    {


        // bundle up parameters to pass on to activity

        Bundle b = new Bundle();


        Intent i = new Intent(getApplicationContext(), Setup.class);
        i.putExtras(b);
        startActivity(i);
        textError = 0;
        speechError = 0;
        textError2 = 0;
        speechError2 = 0;
        textError3 = 0;
        speechError3 = 0;
        textError4 = 0;
        speechError4 = 0;
        textError5 = 0;
        speechError5 = 0;
        textError6 = 0;
        speechError6 = 0;

        // comment out (return to setup after clicking BACK in main activity
        //finish();
    }

    /** Called when the "Exit" button is pressed. */

}
