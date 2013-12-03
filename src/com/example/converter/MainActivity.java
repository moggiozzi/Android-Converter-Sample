package com.example.converter;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText textBox1 = (EditText) findViewById( R.id.editText1 );
		final EditText textBox2 = (EditText) findViewById( R.id.editText2 );
		textBox1.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	if ( !textBox1.isFocused() ) return;
	        	String radStr = "NaN";
	        	double grad = 0.0, rad = 0.0;
	    		try{
 	  	          grad = Double.parseDouble(s.toString());
 	  	          rad = Math.toRadians(grad);
 	  	          radStr = Double.toString(rad);
	    		}catch(NumberFormatException e){}
	        	EditText textBox2 = (EditText) findViewById( R.id.editText2 );
        		textBox2.setText(radStr);
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    });
		textBox2.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	if ( !textBox2.isFocused() ) return;
	        	String gradStr = "NaN";
	        	double grad = 0.0, rad = 0.0;
	    		try{
 	  	          rad = Double.parseDouble(s.toString());
 	  	          grad = Math.toDegrees(rad);
 	  	          gradStr = Double.toString(grad);
	    		}catch(NumberFormatException e){}
	        	EditText textBox1 = (EditText) findViewById( R.id.editText1 );
         		textBox1.setText(gradStr);
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
