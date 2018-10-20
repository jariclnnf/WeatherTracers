package generalPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GneralData {

    private final StringProperty YEAR;
    private final StringProperty MINI_AVG;
    private final StringProperty MAX_AVG;

    public GneralData(String year, String min, String max){

        this.YEAR = new SimpleStringProperty(year);
        this.MINI_AVG = new SimpleStringProperty(min);
        this.MAX_AVG = new SimpleStringProperty(max);
    }

    public String getYEAR() {
        return YEAR.get();
    }

    public StringProperty YEARProperty() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR.set(YEAR);
    }

    public String getMINI_AVG() {
        return MINI_AVG.get();
    }

    public StringProperty MINI_AVGProperty() {
        return MINI_AVG;
    }

    public void setMINI_AVG(String MINI_AVG) {
        this.MINI_AVG.set(MINI_AVG);
    }

    public String getMAX_AVG() {
        return MAX_AVG.get();
    }

    public StringProperty MAX_AVGProperty() {
        return MAX_AVG;
    }

    public void setMAX_AVG(String MAX_AVG) {
        this.MAX_AVG.set(MAX_AVG);
    }
}
