package com.example.bazaaut;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class ListaSamochodow extends ListActivity implements OnGestureListener {
	private GestureDetector gDetector;
	TextView marka;
	ListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_samochodow);
		gDetector = new GestureDetector(this);
				
		adapter = new ListAdapter(this);

		Ion.with(getBaseContext(), "http://www.kubakot.pl/php/plik.json")
        .asJsonObject()
        .setCallback(new FutureCallback<JsonObject>() {
           @Override
            public void onCompleted(Exception e, final JsonObject result) {
        	   if (e != null) {
            	   Log.i("blad", e.getLocalizedMessage());
               } else {
            	   try {
            	   Log.i("Json", result.toString());
            	   JsonArray marki = result.getAsJsonArray("marki");
            	   for (int i = 0; i<marki.size(); i++) {
            		   adapter.add(marki.get(i).toString());
            		   setListAdapter(adapter);
            	   }
            	   } catch(Exception i) {
            		   Log.i("blad2", i.getLocalizedMessage());
            	   }
               }
            }
        });		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_samochodow, menu);
		return true;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
		//Intent intent = new Intent(getBaseContext(), ModelSamochodu.class);
		Intent intent = new Intent(getBaseContext(), DetailView.class);
		String json = (String) getListAdapter().getItem(pos);
		intent.putExtra("json", json);
		startActivity(intent);
		overridePendingTransition(R.anim.from_right, R.anim.to_left);
	}
	
	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.from_left, R.anim.to_right);
	}

	@Override
    public boolean onTouchEvent(MotionEvent me) {
        return gDetector.onTouchEvent(me);
    }
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev){
	    super.dispatchTouchEvent(ev);    
	    return gDetector.onTouchEvent(ev); 
	}
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent start, MotionEvent finish, float xVelocity, float yVelocity) {
		final int SWIPE_MIN_DISTANCE = 200;
		if (finish.getRawX() - start.getRawX() > SWIPE_MIN_DISTANCE && start.getRawX() < finish.getRawX()) {
			super.onBackPressed();
			overridePendingTransition(R.anim.from_left, R.anim.to_right);  
		} 
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}
