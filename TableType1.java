import java.util.*;

public class TableType1 extends Table {

    public TableType1(List<TeritoryUnit> units) {
        super(units, 43, 7, 35);
    }

    private String getInfoLineHeader(String info1) {
        return "|               " + String.format("%-28s|%n", info1);
    }

    public String getTopOfTable() {
        String topOfTable = "";

        for (TeritoryUnit unit: this.units) {
            if (unit instanceof Province) {
                topOfTable += getTopLine();
                topOfTable += getInfoLineHeader(unit.getCommunityName());
                break;
            }
        }
        return topOfTable;
    }

    public String getInfoLine(String info1, String info2) {
        return String.format("|%6s | %-34s|%n", info1, info2);
    }

    public String getInfoForTable() {
        String infoForTable = "";

        List<String> unitNames = Arrays.asList("wojewódźtwo", "powiaty", "gmina miejska", "gmina wiejska", "gmina miejsko-wiejska",
                                                "obszar wiejski", "miasto", "miasto na prawach powiatu", "delegatura");
        
        List<Integer> unitNo = Arrays.asList(Province.numberOfProvinces, County.numberOfCounties, CityCommunity.numberOfCityCommunities,
                                            CountryCommunity.numberOfCountryCommunities, CityAndCountryCommunity.numberOfCityAndCountryCommunities,
                                            CountryArea.numberOfCountryAreas, City.numberOfCities, CountyAndCity.numberOfCountiesAndCities,
                                            Delegature.numberOfDelegatures);
        List<String> convertedUnitNo = convertList(unitNo);

        for (int i = 0; i < unitNames.size(); i++) {
            infoForTable += getSeparatingLine();
            infoForTable += getInfoLine(convertedUnitNo.get(i), unitNames.get(i));
        }
        return infoForTable;
    }

    private List<String> convertList(List<Integer> list) {
        List<String> convertedNumbers = new ArrayList<String>();
        for (Integer number: list) {
            convertedNumbers.add(String.valueOf(number));
        }
        return convertedNumbers;
    }

    public static void main(String args[]) {
        ProvinceData testData = new ProvinceData("malopolska.csv");

        TableType1 test = new TableType1(testData.getTeritoryUnits());
        System.out.println(test.getTable());

        for (TeritoryUnit unit: testData.getTeritoryUnits()) {
            if (unit instanceof Delegature) {
                System.out.println(unit.toString());
            }
        }
    }
}               