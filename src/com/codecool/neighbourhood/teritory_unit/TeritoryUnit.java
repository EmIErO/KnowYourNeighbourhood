package com.codecool.neighbourhood.teitory_unit;

import java.util.*;

public abstract class TeritoryUnit implements Comparable<TeritoryUnit> {
    private int provinceNo;
    private int countyNo;
    private int communityNo;
    private int communityTypeNo;
    private String communityName;
    private String communityType;

    public TeritoryUnit(int provinceNo, int countyNo, int communityNo, int communityTypeNo, String communityName, String communityType) {
        this.provinceNo = provinceNo;
        this.countyNo = countyNo;
        this.communityNo = communityNo;
        this.communityTypeNo = communityTypeNo;
        this.communityName = communityName;
        this.communityType = communityType;
    }

    public int getProvinceNo() {
        return this.provinceNo;
    }

    public int getCountyNo() {
        return this.countyNo;
    }

    public int getCommunityNo() {
        return this.communityNo;
    }

    public int getCommunityTypeNo() {
        return this.communityTypeNo;
    }

    public String getCommunityName() {
        return this.communityName;
    }

    public String getCommunityType() {
        return this.communityType;
    }

    public String toString() {
        return provinceNo + "::" + countyNo + "::" + communityNo + "::" + communityTypeNo + "::" + communityName + "::" + communityType;
    }

    //@Override
    public int compareTo(TeritoryUnit unit) {
        int compareNameLength = ((TeritoryUnit)unit).getCommunityName().length();
        return compareNameLength - this.getCommunityName().length();
    }
}