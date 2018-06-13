import java.util.*;

public class TableType2 extends Table {

        private List<String> header;

        private final int FIRST_ON_LIST = 0;
        private final int SECOND_ON_LIST = 1;

    public TableType2(List<TeritoryUnit> units, List<String> header) {
        super(units, 53, 25, 27);
        this.header = header;
    }

    public String getTopOfTable() {
        String topOfTable = "";

        topOfTable += getTopLine();
        topOfTable += getInfoLine(this.header.get(FIRST_ON_LIST), this.header.get(SECOND_ON_LIST));

        return topOfTable;
    }

    public String getInfoLine(String info1, String info2) {
        return String.format("|%-24s | %-26s|%n", info1, info2);
    }

    public String getInfoForTable() {
        String infoForTable = "";

        for (TeritoryUnit unit: this.units) {
            infoForTable += getInfoLine(unit.getCommunityName(), unit.getCommunityType());
        }
        return infoForTable;
    }

    public static void main(String args[]) {
        ProvinceData testData = new ProvinceData("malopolska.csv");

        TableType2 test = new TableType2(testData.getTeritoryUnits(), Arrays.asList("LOCATION", "TYPE"));
        System.out.println(test.getTable());
    }
}