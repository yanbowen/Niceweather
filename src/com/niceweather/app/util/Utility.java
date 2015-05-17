package com.niceweather.app.util;

import android.text.TextUtils;

import com.niceweather.app.model.City;
import com.niceweather.app.model.County;
import com.niceweather.app.model.NiceweatherDB;
import com.niceweather.app.model.Province;

public class Utility {
	/**
	 * �������� ������������ص�ʡ������
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
					//�������������ݴ洢��Province��
					niceweatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * �������� ������������ص��м�����
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
					//�������������ݴ洢��City��
					niceweatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * �������� ������������ص��ؼ�����
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
					//�������������ݴ洢��County��
					niceweatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
		
	}

}
