package com.niceweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NiceweatherOpenHelper extends SQLiteOpenHelper {
	
	/**
	 * 建表语句:Province
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	
	public static final String CREATE_PROVINCE = "create table Province("
			+ "id integer primary key autoincrement,"
			+ "province_name text,"
			+ "province_code text)";
	
	/**
	 * 建表语句:City
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */

	public static final String CREATE_CITY = "create table City(" 
			+ "id integer primary key autoincrement,"
			+ "city_name text,"
			+ "city_code text,"
			+ "province_id integer)";
	
	/**
	 * 建表语句:County
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	
	
	public static final String CREATE_COUNTY = "create table County(" 
			+ "id integer primary key autoincrement,"
			+ "county_name text," 
			+ "county_code text,"
			+ "city_id integer)";
	
	public NiceweatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(CREATE_PROVINCE);//创建province表
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
