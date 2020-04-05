package com.researchExperiment4443.experiment;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SpeechInput extends AppCompatActivity {

	private TextView txvResult;
	TextView enterText;
	static int errors = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.speechstyle);
		txvResult = (TextView) findViewById(R.id.txvResult);
		enterText = (TextView) findViewById(R.id.enterTextSpeech);
	}

	public void getSpeechInput(View view) {

		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(intent, 10);
		} else {
			Toast.makeText(this, "Your Device Doesn't Support Speech Input", Toast.LENGTH_SHORT).show();
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

		if (txvResult.getText().toString().equals(enterText.getText().toString())) {
			Bundle b = new Bundle();
			b.putInt("errors", errors);
			Intent i = new Intent(getApplicationContext(), TypingInput.class);
			i.putExtras(b);
			startActivity(i);
		} else {
			Toast.makeText(this, "Input is not correct. Please try again", Toast.LENGTH_SHORT).show();
			errors += 1;
		}
	}
}
