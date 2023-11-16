package org.hbrs.se1.ws23.uebung4.Controller;

import org.hbrs.se1.ws23.uebung4.Model.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.Model.Container;
import org.hbrs.se1.ws23.uebung4.Model.UserStories;
import org.hbrs.se1.ws23.uebung4.view.Table;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] prompts = {"(e)nter", "(st)ore", "(l)oad", "(d)ump", "(hbrs) dump project Coll@HBRS", "(s)earch", "(ex)it"};

    public void consoleUI(Container container) {

        System.out.println("Welcome to the UserStory-Tool by Russel Marcelo! Press (h)elp to see all prompts.");
        System.out.println("> befehl");
        while (scanner.hasNext()) {
            String answer = scanner.next().toLowerCase();
            switch (answer) {
                case "h":
                    showAllPrompts();
                    break;
                case "e":
                    enterUserStories(container);
                    message("enter");
                    break;
                case "st":
                    storeUserStories(container);
                    message("store");
                    break;
                case "l":
                    loadUserStories(container);
                    message("load");
                    break;
                case "s":
                    searchUserStories(container);
                    message("search");
                    break;
                case "d":
                    dumpUserStories(container);
                    message("dump");
                    break;
                case "hbrs":
                    dumpUserStoriesHBRS(container);
                    message("dump project Coll@Hbrs");
                    break;
                case "ex":
                    scanner.close();
                    System.exit(0);
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

    private static void message(String prompt) {
        System.out.println(prompt + " was successful! Press (h)elp to see all prompts.");
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
            Table.printTable(container.getCurrentList());
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
            //Table.printTable(container.getCurrentList());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static void searchUserStories(Container container) {
        System.out.print("Bitte geben Sie das gesuchte Projekt ein: ");
        String searchedProject = scanner.next();
        Table.printTable(container.getCurrentList().stream().filter(userStories -> userStories.getProjekt()
                .equals(searchedProject)).collect(Collectors.toList()));
    }

    private static void dumpUserStories(Container container) {
        Collections.sort(container.getCurrentList());
        Table.printTable(container.getCurrentList());
    }

    private static void dumpUserStoriesHBRS(Container container) {
        List<UserStories> userStoriesHBRS = container.getCurrentList().stream().filter(userStories -> userStories.getProjekt()
                .equals("Coll@HBRS")).filter(userStories -> userStories.getRisiko() >= 5).collect(Collectors.toList());
        Table.printTable(userStoriesHBRS);
    }
}

