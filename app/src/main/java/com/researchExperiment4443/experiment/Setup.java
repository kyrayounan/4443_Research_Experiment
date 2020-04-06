package com.researchExperiment4443.experiment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static android.content.ContentValues.TAG;

public class Setup extends AppCompatActivity {
        static EditText initialsInput;
        final static String[] GROUP_NUMBER = {"1", "2"};
    final static String[] SENTENCE = {"enter sentence", "the twins resemble each other so much that I can never tell which is which.", "another test"};

	/*final static String[] GAIN = { "Very low", "Low", "Medium", "High", "Very high" };
	final static String[] PATH_TYPE = { "Square", "Circle", "Free" };
	final static String[] PATH_WIDTH = { "Narrow", "Medium", "Wide" };
	 */

        //final static int[] GROUP_NUMBER = {1, 2};
        //final static int[] GAIN_ARG_VELOCITY_CONTROL = { 25, 50, 100, 200, 400 };

        //Spinner spinOrderOfControl, spinGain, spinPathMode, spinPathWidth, spinLaps;

        Spinner spinGroup;
        Spinner spinSentence;
        static String initials;

        // called when the activity is first created
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.setup);

            spinGroup = (Spinner) findViewById(R.id.paramGroup);
            ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle, GROUP_NUMBER);
            spinGroup.setAdapter(adapter1);
            spinGroup.setSelection(0); // 1
            spinSentence = (Spinner) findViewById(R.id.paramSentence);
            ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle, SENTENCE);
            spinSentence.setAdapter(adapter2);
            spinSentence.setSelection(0); // 1

            initialsInput = (EditText) findViewById(R.id.initialsInput);

        }

        // called when the "OK" button is tapped
        public void clickOK(View view)
        {

            String groupNumber = GROUP_NUMBER[spinGroup.getSelectedItemPosition()];
            String sentence = SENTENCE[spinSentence.getSelectedItemPosition()];
            initials = initialsInput.getText().toString();
            // bundle up parameters to pass on to activity
            Log.d(TAG, "INITIALS: " + initials);
            Log.d(TAG, "GROUP: " + groupNumber);

            Bundle b = new Bundle();
            b.putString("group", groupNumber);
            b.putString("sentence", sentence);
            b.putString("initials", initials);


            // start experiment activity
            if (groupNumber.equals("1")) {
                Intent i = new Intent(getApplicationContext(), SpeechInput.class);
                i.putExtras(b);
               startActivity(i);
            } else {
                Intent i = new Intent(getApplicationContext(), TypingInput.class);
                i.putExtras(b);
                startActivity(i);
            }

            // comment out (return to setup after clicking BACK in main activity
            //finish();
        }

        /** Called when the "Exit" button is pressed. */
        public void clickExit(View view)
        {
            super.onDestroy(); // cleanup
            this.finish(); // terminate
        }
    }
