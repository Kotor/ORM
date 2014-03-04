package com.example.bazaaut;

import java.util.List;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.query.Condition;
import com.orm.query.Select;

public class ModelSamochodu extends ListActivity {
	TextView model;
	ListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_samochodow);
		
		Intent intent = getIntent();
		//String userId = intent.getStringExtra("marka");
		
		List<Samochod> model = Select.from(Samochod.class).where(Condition.prop("marka").eq(intent.getStringExtra("marka"))).list();
		
		//List<Samochod> auta = Select.from(Samochod.class).where(Condition.prop("model").eq("Astra")).list();
		//setListAdapter(new ArrayAdapter<Samochod>(this,android.R.layout.simple_list_item_1, auta));
		
		adapter = new ListAdapter(this);
		for (Samochod s : model) {
			adapter.add(s.getModel());			
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
		//Toast.makeText(getBaseContext(), adapter.getItem(pos), Toast.LENGTH_LONG).show();
		
	}
}
