public class Table {

    private final int SIGN_SIZE = 1;
    
    public String getSmallLine(int length) {
        return String.join("", Collections.nCopies(n, "-"));
    }

    public String getTopLine(int length) {
        return "/" + getSmallLine(length) + "\\" + "\n";
    }

    public String getBottomLine(int length) {
        return "\\" + getSmallLine(length) + "/" + "\n";
    }

    public String getSeparatingLine(int length1, int length2) {
        return "|" + getSmallLine(length1) + "+" + getSmallLine(length2) + "|"  + "\n";
    }

    public String getInfoLineType1(String info1, int length1) {
        return "|" + StringUtils.center(info1, length1) + "|" + "\n";
    }

    public String getInfoLineType2(String info1, String info2, int length1, int length2) {
        return "|" + StringUtils.center(info1, length1) + "|" + StringUtils.center(info2, length2) + "|" + "\n";
    }

    public String getTableType1(String header, int columnOneLength, int columnTwoLength, List<TeritoryUnit> units) {
        int totalLength = columnOneLength + columnTwoLength + 3 * SIGN_SIZE;
        String table = "";

        table += getTopOfTable(units, totalLength);

        for (TeritoryUnit unit: units) {}
    }

    private String getTopOfTable(List<TeritoryUnit> units; int length) {
        String topOfTable = "";

        for (TeritoryUnit unit: units) {
            if (unit instanceof Province) {
                table += getTopLine(length);
                table += getInfoLineType1(unit.getCommunityName(), length);
            }
        }
        return topOfTable;
    }

    private String getInfoForTable(List<TeritoryUnit> units, int columnOneLength, int columnTwoLength) {
        String infoForTable = "";

        for (TeritoryUnit unit: units) {
            infoForTable += getSeparatingLine(columnOneLength, columnTwoLength);
            infoForTable += getInfoLineType2()
        }
    }
}