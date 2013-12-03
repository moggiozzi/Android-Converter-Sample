package com.example.converter;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void doConvert(View view)
	{
		EditText textBox1 = (EditText) findViewById( R.id.editText1 );
		EditText textBox2 = (EditText) findViewById( R.id.editText2 );
		String strGrad = textBox1.getText().toString();
		String strRad = "";
		float grad = 0.0f;
		float rad = 0.0f;
		try{
	      grad = Float.parseFloat(strGrad);
		}
		catch(NumberFormatException e){}
		rad = grad * (float)Math.PI / 180.0f;
        textBox2.setText(Float.toString(rad));
	}

}
