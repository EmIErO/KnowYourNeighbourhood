public class CountryCommunity extends Community {

    public static Integer numberOfCountryCommunities = 0;

    public CountryCommunity(int provinceNo, int countyNo, int communityNo, int communityTypeNo, String communityName, String communityType) {
        super(provinceNo, countyNo, communityNo, communityTypeNo, communityName, communityType);
        ++numberOfCountryCommunities;
    }
}