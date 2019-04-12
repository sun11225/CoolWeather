package com.huatec.coolweather.util;

import android.sax.RootElement;
import android.text.TextUtils;

import com.huatec.coolweather.db.City;
import com.huatec.coolweather.db.County;
import com.huatec.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/4/12 0012.
 */

public class Utility {

    //使用jsonobject解析服务器返回的数据
    //省级数据
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray provinces=new JSONArray(response);
                for (int i=0;i<provinces.length();i++){
                    JSONObject provinceObject=provinces.getJSONObject(i);
                    //省
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (Exception e){
            e.printStackTrace();
            }
        }
        return false;
    }

    //市级数据
    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray cities=new JSONArray(response);
                for (int i=0;i<cities.length();i++){
                    JSONObject cityObject=cities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    //县级数据
    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray counties=new JSONArray(response);
                for (int i=0;i<counties.length();i++){
                    JSONObject countyObject=counties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

}
