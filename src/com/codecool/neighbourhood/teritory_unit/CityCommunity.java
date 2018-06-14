package com.codecool.neighbourhood.teitory_unit;

public class CityCommunity extends Community {

    public static Integer numberOfCityCommunities = 0;

    public CityCommunity(int provinceNo, int countyNo, int communityNo, int communityTypeNo, String communityName, String communityType) {
        super(provinceNo, countyNo, communityNo, communityTypeNo, communityName, communityType);
        ++numberOfCityCommunities;
    }
}