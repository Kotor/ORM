package com.example.bazaaut;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.query.Condition;
import com.orm.query.Select;

public class ListaSamochodow extends ListActivity {
	TextView marka;
	ListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_samochodow);
		
		List<Samochod> marka = Select.from(Samochod.class).groupBy("marka").list();
		
		//List<Samochod> auta = Select.from(Samochod.class).where(Condition.prop("model").eq("Astra")).list();
		//setListAdapter(new ArrayAdapter<Samochod>(this,android.R.layout.simple_list_item_1, auta));
		
		adapter = new ListAdapter(this);
		for (Samochod s : marka) {
			adapter.add(s.getMarka());			
		}
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_samochodow, menu);
		return true;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
		Intent intent = new Intent(getBaseContext(), ModelSamochodu.class);
		String marka = adapter.getItem(pos);
		intent.putExtra("marka", marka);
		startActivity(intent);
	}

}
