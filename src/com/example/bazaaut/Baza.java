package com.example.bazaaut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Baza extends Activity {
	Button przyciskPowrot, dodajSamochod, wyswietlSamochody;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baza);
		
		dodajSamochod = (Button)findViewById(R.id.dodaj);
		dodajSamochod.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	Intent intent = new Intent(Baza.this, DodajSamochod.class);  
                	startActivity(intent);                	
                }
        });
		wyswietlSamochody = (Button)findViewById(R.id.wyswietl);
		wyswietlSamochody.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {                	
                	Intent intent = new Intent(Baza.this, ListaSamochodow.class);  
                	startActivity(intent); 
                }
        });
		przyciskPowrot = (Button)findViewById(R.id.wyjdz);
		przyciskPowrot.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	finish();                	
                }
        });			
	}
}
