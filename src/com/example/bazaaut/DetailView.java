package com.example.bazaaut;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;

public class DetailView extends Activity implements OnGestureListener {	
	private GestureDetector gDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_view);
		Typeface customFont = Typeface.createFromAsset(this.getAssets(), "fonts/montserrat.ttf");
		gDetector = new GestureDetector(this);
		Intent intent = getIntent();
		String json = intent.getStringExtra("json");
		
		try {
			JSONObject jsnobject = new JSONObject(json);
			JSONArray jsonArray = jsnobject.getJSONArray("modele");
		    for (int i = 0; i < jsonArray.length(); i++) {
		        JSONObject explrObject = jsonArray.getJSONObject(i);
		        		        
		        TextView modelTextView = (TextView) this.findViewById(R.id.model);
		        modelTextView.setTypeface(customFont);
				modelTextView.setText(explrObject.getString("model"));
				TextView nadwozieTextView = (TextView) this.findViewById(R.id.nadwozie);
				nadwozieTextView.setTypeface(customFont);
				nadwozieTextView.setText(explrObject.getString("nadwozie"));
				TextView silnikTextView = (TextView) this.findViewById(R.id.silnik);
				silnikTextView.setTypeface(customFont);
				silnikTextView.setText(explrObject.getString("silnik"));
		}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_view, menu);
		return true;
	}*/
	
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
	public boolean onDown(MotionEvent arg0) {
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
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
