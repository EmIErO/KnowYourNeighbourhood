package com.codecool.neighbourhood.teitory_unit;

public class County extends TeritoryUnit {

    public static Integer numberOfCounties = 0;

    public County(int provinceNo, int countyNo, String communityName, String communityType) {
        super(provinceNo, countyNo, 0, 0, communityName, communityType);
        ++numberOfCounties;
    }

}