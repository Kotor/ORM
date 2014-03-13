package com.example.bazaaut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {

	public ListAdapter(Context context) {
		super(context,0);
		// TODO Auto-generated constructor stub
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
		viewHolder = new ViewHolder();
		viewHolder.text = (TextView) convertView.findViewById(R.id.tytul);
		// TO DO parse marka
		viewHolder.text.setText(/* marka */));
		return convertView;
	}
	
	static class ViewHolder {
		TextView text;
	}

}
