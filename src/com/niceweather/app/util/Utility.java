package com.niceweather.app.util;

import android.text.TextUtils;

import com.niceweather.app.model.City;
import com.niceweather.app.model.County;
import com.niceweather.app.model.NiceweatherDB;
import com.niceweather.app.model.Province;

public class Utility {
	/**
	 * 解析工具 处理服务器返回的省级数据
	 */
	public synchronized static boolean handleProvincesResponse(NiceweatherDB niceweatherDB,String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces = response.split(",");
			if(allProvinces != null && allProvinces.length>0){
				for(String p : allProvinces){
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//解析出来的数据存储到Province表
					niceweatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * 解析工具 处理服务器返回的市级数据
	 */
	public static boolean handleCitiesResponse(NiceweatherDB niceweatherDB,String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCities = response.split(",");
			if(allCities != null && allCities.length>0){
				for(String c : allCities){
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					//解析出来的数据存储到City表
					niceweatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * 解析工具 处理服务器返回的县级数据
	 */
	
	public static boolean handleCountiesResponse(NiceweatherDB niceweatherDB,String response,int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCounties = response.split(",");
			if(allCounties != null && allCounties.length>0){
				for(String c : allCounties){
					String[] array = c.split("\\|");
					County county = new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					//解析出来的数据存储到County表
					niceweatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
		
	}

}
