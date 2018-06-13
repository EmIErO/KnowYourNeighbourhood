import java.util.*;

abstract class Table {

    private final int SIGN_SIZE = 1;

    private int totalLength;
    private int columnOneLength;
    private int columnTwoLength;

    private List<TeritoryUnit> units;

    public Table(List<TeritoryUnit> units, int columnOneLength, int columnTwoLength) {
        this.units = units;
        this.columnOneLength = columnOneLength;
        this.columnTwoLength = columnTwoLength;
        this.totalLength = columnOneLength + columnTwoLength + 3 * SIGN_SIZE;
    }

    public String getSmallLine(int length) {
        return String.join("", Collections.nCopies(n, "-"));
    }

    public String getTopLine() {
        return "/" + getSmallLine(this.totalLength) + "\\" + "\n";
    }

    public String getBottomLine() {
        return "\\" + getSmallLine(this.totalLength) + "/" + "\n";
    }

    public String getSeparatingLine() {
        return "|" + getSmallLine(this.columnOneLength) + "+" + getSmallLine(this.columnTwoLength) + "|"  + "\n";
    }

    public abstract String getInfoLine(String... args);

    public abstract String getTable();

    private abstract String getTopOfTable();

    private abstract String getInfoForTable();

}