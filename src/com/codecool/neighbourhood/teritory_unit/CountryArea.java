package com.codecool.neighbourhood.teitory_unit;

public class CountryArea extends Community {

    public static Integer numberOfCountryAreas = 0;

    public CountryArea(int provinceNo, int countyNo, int communityNo, int communityTypeNo, String communityName, String communityType) {
        super(provinceNo, countyNo, communityNo, communityTypeNo, communityName, communityType);
        ++numberOfCountryAreas;
    }
}