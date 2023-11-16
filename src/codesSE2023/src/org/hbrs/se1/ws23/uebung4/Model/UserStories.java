package org.hbrs.se1.ws23.uebung4.Model;

import java.io.Serializable;

public class UserStories implements Serializable, Comparable<UserStories> {

    private Integer id;
    private String beschreibung;
    private String akzeptanzkriterium;
    private int risiko;
    private String projekt;
    private double prioValue;

    public UserStories(Integer id, String beschreibung, String akzeptanzkriterium, int aufwand, int mehrwert, int strafe, int risiko, String projekt) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.akzeptanzkriterium = akzeptanzkriterium;
        this.risiko = risiko;
        this.projekt = projekt;
        this.prioValue = calculatePriority(aufwand, mehrwert, strafe, risiko);
    }

    private double calculatePriority(int aufwand, int mehrwert, int strafe, int risiko) {
        if (aufwand < 0 || risiko < 0 || mehrwert < 0 || strafe < 0) {
            throw new IllegalArgumentException("Es sind nur positive Zahlen erlaubt!");
        }
        double result = (double) (mehrwert + strafe) / (aufwand + risiko);
        return (double) Math.round(result * 100) / 100 ;
    }


    public String getBeschreibung() {
        return beschreibung;
    }

    public String getAkzeptanzkriterium() {
        return akzeptanzkriterium;
    }

    public String getProjekt() {
        return projekt;
    }

    public int getRisiko() {
        return risiko;
    }

    public double getPrioValue() {
        return prioValue;
    }


    public Integer getID() {
        return id;
    }

    @Override
    public int compareTo(UserStories userStories) {
        return Double.compare(userStories.getPrioValue(), this.getPrioValue());
    }
}
