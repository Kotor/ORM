package com.example.bazaaut;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.orm.query.Condition;
import com.orm.query.Select;

public class ListaSamochodow extends ListActivity {
	TextView marka;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_samochodow);
		
		List<Samochod> auta = Select.from(Samochod.class).orderBy("marka").list();
		//List<Samochod> auta = Select.from(Samochod.class).where(Condition.prop("model").eq("Astra")).list();
		setListAdapter(new ArrayAdapter<Samochod>(this,android.R.layout.simple_list_item_1, auta));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_samochodow, menu);
		return true;
	}

}
