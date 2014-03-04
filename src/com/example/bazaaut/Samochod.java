package com.example.bazaaut;

import android.content.Context;

import com.orm.SugarRecord;

public class Samochod extends SugarRecord<Samochod>  {	
	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPojSilnika() {
		return pojSilnika;
	}

	public void setPojSilnika(String pojSilnika) {
		this.pojSilnika = pojSilnika;
	}

	public String getMoc() {
		return moc;
	}

	public void setMoc(String moc) {
		this.moc = moc;
	}

	public String getNadwozie() {
		return nadwozie;
	}

	public void setNadwozie(String nadwozie) {
		this.nadwozie = nadwozie;
	}

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