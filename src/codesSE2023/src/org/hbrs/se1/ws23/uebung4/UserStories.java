package org.hbrs.se1.ws23.uebung4;

import java.io.Serializable;

public class UserStories implements Serializable {

    private Integer id;
    private String beschreibung;
    private String akzeptanzkriterium;
    private String projekt;
    private double prioValue;

    public UserStories(Integer id, String beschreibung, String akzeptanzkriterium, int aufwand, int mehrwert, int strafe, int risiko, String projekt) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.akzeptanzkriterium = akzeptanzkriterium;
        this.projekt = projekt;
        this.prioValue = calculatePriority(aufwand, mehrwert, strafe, risiko);
    }

    private double calculatePriority(int aufwand, int mehrwert, int strafe, int risiko) {
        if (aufwand < 0 || risiko < 0 || mehrwert < 0 || strafe < 0) {
            throw new IllegalArgumentException("Failed!");
        }
        double result = (double) (mehrwert + strafe) / (aufwand + risiko);
        return (double) Math.round(result * 100) / 100 ;
    }

    public String getColumnValue(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.valueOf(id);
            case 1:
                return beschreibung;
            case 2:
                return akzeptanzkriterium;
            case 3:
                return projekt;
            case 4:
                return String.valueOf(prioValue);
            default:
                return "";
        }
    }

    public String getProjekt() {
        return projekt;
    }

    public Integer getID() {
        return id;
    }
}
