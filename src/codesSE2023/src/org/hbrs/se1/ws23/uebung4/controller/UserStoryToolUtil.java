package org.hbrs.se1.ws23.uebung4.controller;

import org.hbrs.se1.ws23.uebung4.model.Container;
import org.hbrs.se1.ws23.uebung4.model.ContainerException;
import org.hbrs.se1.ws23.uebung4.model.UserStories;
import org.hbrs.se1.ws23.uebung4.model.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.view.Table;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserStoryToolUtil {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] prompts = {"(e)nter", "(st)ore", "(l)oad", "(d)ump",
            "(hbrs) dump project Coll@HBRS", "(s)earch", "(ex)it"};


    public static void showAllPrompts() {
        for (String prompt : prompts) {
            System.out.println(prompt);
        }
    }

    public static void message(String prompt) {
        System.out.println(prompt + " was successful! Press (h)elp to see all prompts.");
    }

    public static void enterUserStories(Container container) {
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
            container.addUserStories(new UserStories(id, beschreibung, akzeptanzkriterium, aufwand, mehrwert, strafe, risiko, project));
            Table.printTable(container.getCurrentList());
        } catch (ContainerException containerException) {
            throw new RuntimeException("Fehler beim eingeben von User Stories!");
        }
    }

    public static void storeUserStories(Container container) {
        try {
            container.store();
        } catch (PersistenceException persistenceException) {
            throw new RuntimeException("Fehler beim speichern von User Stories!");
        }
    }

    public static void loadUserStories(Container container) {
        try {
            container.load();
        } catch (PersistenceException persistenceException) {
            throw new RuntimeException("Fehler beim Laden von User Stories!");
        }
    }

    public static void searchUserStories(Container container) {
        System.out.print("Bitte geben Sie das gesuchte Projekt ein: ");
        String searchedProject = scanner.next();

        if (!container.getCurrentList().stream().anyMatch(userStory ->
                userStory.getProjekt().equals(searchedProject))) {
            throw new IllegalArgumentException("Das gesuchte Projekt ist nicht vorhanden!");
        }

        Table.printTable(container.getCurrentList().stream().filter(userStories -> userStories.getProjekt()
                .equals(searchedProject)).collect(Collectors.toList()));
    }

    public static void dumpUserStories(Container container) {

        if (container.isEmpty()) {
            throw new IllegalArgumentException("Es sind keine User Stories verfuegbar!");
        }

        Collections.sort(container.getCurrentList());
        Table.printTable(container.getCurrentList());
    }

    public static void dumpUserStoriesHBRS(Container container) {

        if (!container.getCurrentList().stream().anyMatch(userStory ->
                userStory.getProjekt().equals("Coll@HBRS"))) {
            throw new RuntimeException("Das Projekt Coll@HBRS existiert nicht!");
        }

        List<UserStories> userStoriesHBRS = container.getCurrentList().stream().filter(userStories -> userStories.getProjekt()
                .equals("Coll@HBRS")).collect(Collectors.toList());
        Table.printTable(userStoriesHBRS);
    }

    public static void exitUserStoryTool() {
        scanner.close();
        System.exit(0);
    }
}
