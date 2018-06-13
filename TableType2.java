import java.util.*;

public class TableType2 extends Table {

        private List<String> header;

    public Table(List<String> header, List<TeritoryUnit> units, int columnOneLength, int columnTwoLength) {
        super(units, columnOneLength, columnTwoLength);
        this.header = header;
    }

    public String getInfoLineType2(String info1, String info2) {
        return "|" + StringUtils.center(info1, this.columnOneLength) + "|" + StringUtils.center(info2, this.columnTwoLength) + "|" + "\n";
    }

}