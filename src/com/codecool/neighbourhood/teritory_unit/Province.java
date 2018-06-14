package com.codecool.neighbourhood.teitory_unit;

public class Province extends TeritoryUnit   {

    public static Integer numberOfProvinces = 0;

    public Province(int provinceNo, String communityName, String communityType) {
        super(provinceNo, 0, 0, 0, communityName, communityType);
        ++numberOfProvinces;
    }
    
}