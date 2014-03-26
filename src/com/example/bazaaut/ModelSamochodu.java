package com.example.bazaaut;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ModelSamochodu extends ListActivity {
	TextView model;
	ListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_samochodow);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_samochodow, menu);
		return true;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
		//Toast.makeText(getBaseContext(), adapter.getItem(pos), Toast.LENGTH_LONG).show();
		
	}
}
