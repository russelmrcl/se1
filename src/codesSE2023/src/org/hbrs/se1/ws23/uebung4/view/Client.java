package org.hbrs.se1.ws23.uebung4.view;

import org.hbrs.se1.ws23.uebung4.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.Container;
import org.hbrs.se1.ws23.uebung4.ContainerException;
import org.hbrs.se1.ws23.uebung4.UserStories;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    private static Scanner scanner = new Scanner(System.in);
    private static List<UserStories> tmp;
    private static String[] headers = {"ID", "Beschreibung", "Akzeptanzkriterium", "Projekt", "Prio"};
    private static String[] prompts = {"(e)nter", "(st)ore", "(l)oad", "(d)ump", "(s)earch", "(ex)it", "(h)elp"};

    public void consoleUI(Container container) {

        System.out.println("Welcome to the UserStory-Tool by Russel Marcelo! Press (h)elp to see all prompts.");
        System.out.println("> befehl");
        while (scanner.hasNext()) {
            String answer = scanner.next().toLowerCase();
            switch (answer) {
                case "h": showAllPrompts(); break;
                case "e": enterUserStories(container); break;
                case "st": storeUserStories(container); break;
                case "l" : loadUserStories(container); break;
                case "s" : searchUserStories(container); break;
                case "ex" : System.exit(0);
                default:
                    System.out.println("Failed!");
            }
        }
    }

    private static void showAllPrompts() {
        for (String prompt : prompts) {
            System.out.println(prompt);
        }
    }

    private static void enterUserStories(Container container) {
        try {
            System.out.println("Bitte geben Sie eine ID an.");
            Integer id = scanner.nextInt();
            System.out.println("Bitte geben Sie eine Beschreibung an.");
            String beschreibung = scanner.next();
            System.out.println("Bitte geben Sie ein Akzeptanzkriterium an.");
            String akzeptanzkriterium = scanner.next();
            System.out.println("Bitte geben Sie einen Aufwand an.");
            int aufwand = scanner.nextInt();
            System.out.println("Bitte geben Sie einen Mehrwert an.");
            int mehrwert = scanner.nextInt();
            System.out.println("Bitte geben Sie eine Strafe an.");
            int strafe = scanner.nextInt();
            System.out.println("Bitte geben Sie ein Risiko an.");
            int risiko = scanner.nextInt();
            System.out.println("Bitte geben Sie ein Projekt an.");
            String project = scanner.next();
            container.addMember(new UserStories(id, beschreibung, akzeptanzkriterium, aufwand, mehrwert, strafe, risiko, project));
            Table.printTable(headers, container.getCurrentList());
        } catch (Exception exception) {
            throw new RuntimeException();
        }
    }

    private static void storeUserStories(Container container) {
        try {
            container.store();
        } catch (PersistenceException persistenceException) {
            throw new RuntimeException();
        }
    }

    private static void loadUserStories(Container container) {
        try {
            container.load();
            Table.printTable(headers, container.getCurrentList());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static void searchUserStories(Container container) {
        tmp = container.getCurrentList();
        List<UserStories> searchedUserStories = new ArrayList<>();
        System.out.print("Bitte geben Sie das gesuchte Projekt ein: ");
        String ps = scanner.next();
        for (UserStories userStories : tmp) {
            if (userStories.getProjekt().equals(ps)) {
                searchedUserStories.add(userStories);
            }
        }
        Table.printTable(headers, searchedUserStories);
    }
}
