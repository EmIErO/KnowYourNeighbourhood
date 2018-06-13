import java.util.*;

public class TableType1 extends Table {

    public TableType1(List<TeritoryUnit> units, int columnOneLength, int columnTwoLength) {
        super(units, columnOneLength, columnTwoLength);
    }

    public String getInfoLineType(String info1) {
        return "|" + StringUtils.center(info1, this.totalLength) + "|" + "\n";
    }

    public String getTable() {
        String table = "";

        table += getTopOfTable();

        for (TeritoryUnit unit: units) {}
    }

    private String getTopOfTable() {
        String topOfTable = "";

        for (TeritoryUnit unit: this.units) {
            if (unit instanceof Province) {
                table += getTopLine(this.totalLength);
                table += getInfoLineType1(unit.getCommunityName(), this.totalLength);
                break;
            }
        }
        return topOfTable;
    }

    private String getInfoForTable() {
        String infoForTable = "";

        List<String> unitNames = Arrays.asList("wojewódźtwo", "powiaty", "gmina miejska", "gmina wiejska", "gmina miejsko-wiejska",
                                                "obszar wiejski", "miasto", "miasto na prawach powiatu", "delegatura");
        
        List<Integer> unitNo = Arrays.asList(Province.numberOfProvinces, County.numberOfCounties, CityCommunity.numberOfCityCommunities,
                                            CountryCommunity.numberOfCountryCommunities, CityAndCountryCommunity.numberOfCityAndCountryCommunities,
                                            CountryArea.numberOfCountryAreas, City.numberOfCities, CountyAndCity.numberOfCountiesAndCities,
                                            Delegature.numberOfDelegatures);
                                            
        for (int i = 0; int < uni.size(); i++) {
            infoForTable += getSeparatingLine(this.columnOneLength, this.columnTwoLength);
            infoForTable += getInfoLineType2(unitNames.get(i), unitNo.get(i));
        }
        return infoForTable;
    }
}               