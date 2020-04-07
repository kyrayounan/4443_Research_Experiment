package com.researchExperiment4443.experiment;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.content.ContentValues.TAG;

public class SpeechInput6 extends AppCompatActivity {

	private TextView txvResult;
	TextView sentenceText;
	String enterText;
	public static int errors = 0;
	public static long start = 0;
	public static long time = 0;
	String initials = "";
	String group = "";
	int counter = 0;
	String sentence = "";
	int block = 1;
	TextView blockNum;
	TextView trialNum;

	public static String task = "";
	Spinner spinGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.speechstyle);
		txvResult = (TextView) findViewById(R.id.txvResult);
		blockNum = (TextView) findViewById(R.id.block);
sentenceText = (TextView) findViewById(R.id.enterTextTyping);
		trialNum = (TextView) findViewById(R.id.trial) ;
		start = System.currentTimeMillis();
		Intent intent = getIntent();
		initials = intent.getStringExtra("initials");
		group = intent.getStringExtra("group");
		sentence = "the music is too loud for my ears";

		enterText = sentence;
		sentenceText.setText(sentence);

		trialNum.setText("Trial: 6");
		errors = 0;


	}

	public void getSpeechInput(View view) {
		Log.d(TAG, "INITIALS: " + initials);
		Log.d(TAG, "GROUP: " + group);

		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

			errors++;

		Log.d(TAG, errors + " erros");

		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(intent, 10);
		} else {
			Toast.makeText(this, "Your Device Doesn't Support Speech Input", Toast.LENGTH_SHORT).show();
		}
		counter++;
		if (counter == 10 && group.equals("1")) {
			Bundle b = new Bundle();
			task = "No";
			time = System.currentTimeMillis() - start;
			b.putInt("errors", errors);
			b.putLong("time", time );
			b.putString("initials", initials);
			b.putString("group", group);
			Intent i = new Intent(getApplicationContext(), TypingInput6.class);
			i.putExtras(b);
			startActivity(i);

		} else if(counter == 10 && group.equals("2")){
			Bundle b = new Bundle();
			task = "No";
			time = System.currentTimeMillis() - start;
			b.putInt("errors", errors);
			b.putLong("time", time );
			b.putString("initials", initials);
			b.putString("group", group);
			Intent i = new Intent(getApplicationContext(), Results.class);
			i.putExtras(b);
			startActivity(i);
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
			case 10:
				if (resultCode == RESULT_OK && data != null) {
					ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
					txvResult.setText(result.get(0));
				}
				break;
		}
	}

	public void onEnter(View view) {

		if(txvResult.getText().toString().equals(enterText)) {
			block ++;
			blockNum.setText("Block: " + (block));
			errors--;
		}

		if (txvResult.getText().toString().equals(enterText) && group.equals("1") && block == 6) {
			Bundle b = new Bundle();
			task = "Yes";
			time = System.currentTimeMillis() - start;
			b.putInt("errors", errors);
			b.putLong("time", time );
			b.putString("initials", initials);
			b.putString("group", group);
			Intent i = new Intent(getApplicationContext(), TypingInput6.class);
			i.putExtras(b);
			startActivity(i);

		} else if(txvResult.getText().toString().equals(enterText) && group.equals("2") && block == 6){
			Bundle b = new Bundle();
			task = "Yes";
			time = System.currentTimeMillis() - start;
			b.putInt("errors", errors);
			b.putLong("time", time );
			b.putString("initials", initials);
			b.putString("group", group);
			Intent i = new Intent(getApplicationContext(), Results.class);
			i.putExtras(b);
			startActivity(i);
		}



			else {
			Log.d(TAG, "GROUP" + group);
			Toast.makeText(this, "Input again", Toast.LENGTH_SHORT).show();


		}
	}
}
