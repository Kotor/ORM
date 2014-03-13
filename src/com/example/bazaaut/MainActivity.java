package com.example.bazaaut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button przyciskStart, przyciskWyjscie;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		przyciskStart = (Button)findViewById(R.id.wejscie);
		przyciskStart.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	Intent intent = new Intent(MainActivity.this, Baza.class);  
                	startActivity(intent);
                	
                }
        });        
        przyciskWyjscie = (Button)findViewById(R.id.wyjdz);
        przyciskWyjscie.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	finish();
                    System.exit(0);
                }
        });
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
