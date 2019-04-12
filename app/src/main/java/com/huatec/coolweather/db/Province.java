package com.huatec.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2019/4/12 0012.
 */

public class Province extends DataSupport {
    private int id;
    private String ProvinceName;//省名
    private int ProvinceCode;//省的代号

    //ID字段每个实体类都要有

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }

    public int getProvinceCode() {
        return ProvinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        ProvinceCode = provinceCode;
    }
}
