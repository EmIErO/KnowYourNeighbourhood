package com.codecool.neighbourhood.teitory_unit;

public class CityAndCountryCommunity extends Community {

    public static Integer numberOfCityAndCountryCommunities = 0;

    public CityAndCountryCommunity(int provinceNo, int countyNo, int communityNo, int communityTypeNo, String communityName, String communityType) {
        super(provinceNo, countyNo, communityNo, communityTypeNo, communityName, communityType);
        ++numberOfCityAndCountryCommunities;
    }
}