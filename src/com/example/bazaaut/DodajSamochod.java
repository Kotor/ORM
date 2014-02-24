package com.example.bazaaut;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DodajSamochod extends Activity implements OnClickListener {
	Button przyciskPowrot, dodaj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dodaj_samochod);
		
		dodaj = (Button) this.findViewById(R.id.dodaj);
		dodaj.setOnClickListener(this);
				
		przyciskPowrot = (Button)findViewById(R.id.wyjdz);
		przyciskPowrot.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	finish();                	
                }
        });			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodaj_samochod, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.dodaj) {
			EditText markaTxt = (EditText) findViewById(R.id.markaPole);
			String marka = markaTxt.getText().toString();
			EditText modelTxt = (EditText) findViewById(R.id.modelPole);
			String model = modelTxt.getText().toString();
			EditText pojSilnikaTxt = (EditText) findViewById(R.id.pojSilnikaPole);
			String pojSilnika = pojSilnikaTxt.getText().toString();
			EditText mocTxt = (EditText) findViewById(R.id.mocPole);
			String moc = mocTxt.getText().toString();
			Spinner nadwozieTxt = (Spinner) findViewById(R.id.nadwozieLista);
			String nadwozie = nadwozieTxt.getSelectedItem().toString();
			Samochod auto = new Samochod(this, marka, model, pojSilnika, moc, nadwozie);
			auto.save();
			Log.i("Marka: ", marka);
			Log.i("Model: ", model);
			Log.i("Pojemnoœæ silnika: ", pojSilnika);
			Log.i("Moc: ", moc);
			Log.i("Nadwozie: ", nadwozie);
		}
	}
}
