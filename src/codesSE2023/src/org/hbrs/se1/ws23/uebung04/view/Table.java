package org.hbrs.se1.ws23.uebung04.view;

import org.hbrs.se1.ws23.uebung04.model.UserStories;

import java.util.List;

public class Table {

    private static String[] headers = {"ID", "Beschreibung", "Akzeptanzkriterium", "Projekt", "Prio"};

    public static void printTable(List<UserStories> data) {
        int numColumns = headers.length;

        int[] columnWidths = new int[numColumns];
        for (int i = 0; i < numColumns; i++) {
            columnWidths[i] = headers[i].length();
            for (UserStories obj : data) {
                String value = getColumnValue(obj, i);
                int cellWidth = value.length();
                if (cellWidth > columnWidths[i]) {
                    columnWidths[i] = cellWidth;
                }
            }
        }

        printLine(columnWidths);
        for (int i = 0; i < numColumns; i++) {
            System.out.printf("| %-" + (columnWidths[i] + 1) + "s", headers[i]);
        }
        System.out.println("|");
        printLine(columnWidths);

        for (UserStories obj : data) {
            for (int j = 0; j < numColumns; j++) {
                String value = getColumnValue(obj, j);
                System.out.printf("| %-" + (columnWidths[j] + 1) + "s", value);
            }
            System.out.println("|");
            printLine(columnWidths);
        }
    }

    private static void printLine(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("+");
            for (int i = 0; i < width + 2; i++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    private static String getColumnValue(UserStories story, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.valueOf(story.getID());
            case 1:
                return story.getBeschreibung();
            case 2:
                return story.getAkzeptanzkriterium();
            case 3:
                return story.getProjekt();
            case 4:
                return String.valueOf(story.getPrioValue());
            default:
                return "";
        }
    }
}
