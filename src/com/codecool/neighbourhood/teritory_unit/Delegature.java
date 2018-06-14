package com.codecool.neighbourhood.teitory_unit;

public class Delegature extends Community {

    public static Integer numberOfDelegatures = 0;

    public Delegature(int provinceNo, int countyNo, int communityNo, int communityTypeNo, String communityName, String communityType) {
        super(provinceNo, countyNo, communityNo, communityTypeNo, communityName, communityType);
        ++numberOfDelegatures;
    }
}