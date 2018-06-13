public class CountyAndCity extends County {

    public static Integer numberOfCountiesAndCities = 0;

    public CountyAndCity(int provinceNo, int countyNo, String communityName, String communityType) {
        super(provinceNo, countyNo, communityName, communityType);
        ++numberOfCountiesAndCities;
    }

}