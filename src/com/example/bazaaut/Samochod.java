package com.example.bazaaut;

import android.content.Context;

import com.orm.SugarRecord;

public class Samochod extends SugarRecord<Samochod>  {	
	String marka;
	String model;
	String pojSilnika;
	String moc;
	String nadwozie;

	public Samochod(Context ctx) {
		super(ctx);
	}

	public Samochod(Context ctx, String marka, String model, String pojSilnika, String moc, String nadwozie) {
		super(ctx);
		this.marka = marka;
		this.model = model;
		this.pojSilnika = pojSilnika;
		this.moc = moc;
		this.nadwozie = nadwozie;
	}	
}