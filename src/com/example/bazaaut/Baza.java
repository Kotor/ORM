package com.example.bazaaut;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Baza extends Activity implements OnGestureListener {
	Button przyciskPowrot, dodajSamochod, wyswietlSamochody;
	private GestureDetector gDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baza);
		Typeface customFont = Typeface.createFromAsset(this.getAssets(), "fonts/montserrat.ttf");
		gDetector = new GestureDetector(this);
		TextView tytul = (TextView) findViewById(R.id.tytul);
		tytul.setTypeface(customFont);
		
		dodajSamochod = (Button)findViewById(R.id.dodaj);
		dodajSamochod.setTypeface(customFont);
		dodajSamochod.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	Intent intent = new Intent(Baza.this, DodajSamochod.class);  
                	startActivity(intent); 
                	overridePendingTransition(R.anim.from_right, R.anim.to_left);   
                }
        });
		wyswietlSamochody = (Button)findViewById(R.id.wyswietl);
		wyswietlSamochody.setTypeface(customFont);
		wyswietlSamochody.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {                	
                	Intent intent = new Intent(Baza.this, ListaSamochodow.class);  
                	startActivity(intent); 
                	overridePendingTransition(R.anim.from_right, R.anim.to_left);   
                }
        });
		przyciskPowrot = (Button)findViewById(R.id.wyjdz);
		przyciskPowrot.setTypeface(customFont);
		przyciskPowrot.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	finish(); 
                	overridePendingTransition(R.anim.from_left, R.anim.to_right);   
                }
        });			
	}
	
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
