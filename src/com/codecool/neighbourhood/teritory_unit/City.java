package com.codecool.neighbourhood.teitory_unit;

public class City extends Community {

    public static Integer numberOfCities = 0;

    public City(int provinceNo, int countyNo, int communityNo, int communityTypeNo, String communityName, String communityType) {
        super(provinceNo, countyNo, communityNo, communityTypeNo, communityName, communityType);
        ++numberOfCities;
    }
}