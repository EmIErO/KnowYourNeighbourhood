import java.util.*;

abstract class Table {

    protected int totalLength;
    protected int columnOneLength;
    protected int columnTwoLength;

    protected List<TeritoryUnit> units;

    public Table(List<TeritoryUnit> units, int totalLength, int columnOneLength, int columnTwoLength) {
        this.totalLength = totalLength;
        this.columnOneLength = columnOneLength;
        this.columnTwoLength = columnTwoLength;
        this.units = units;
    }

    public String getSmallLine(int length) {
        return String.join("", Collections.nCopies(length, "-"));
    }

    public String getTopLine() {
        return "\n/" + getSmallLine(this.totalLength) + "\\" + "\n";
    }

    public String getBottomLine() {
        return "\\" + getSmallLine(this.totalLength) + "/" + "\n";
    }

    public String getSeparatingLine() {
        return "|" + getSmallLine(this.columnOneLength) + "+" + getSmallLine(this.columnTwoLength) + "|"  + "\n";
    }

    public String getTable() {
        String table = "";

        table += getTopOfTable();
        table += getInfoForTable();
        table += getBottomLine();

        return table;
    }

    public abstract String getInfoLine(String info1, String info2);

    public abstract String getTopOfTable();

    public abstract String getInfoForTable();

}