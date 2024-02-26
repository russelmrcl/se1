package org.hbrs.se1.ws23.uebung04.controller;

import org.hbrs.se1.ws23.uebung04.model.Container;

import java.util.Scanner;
import java.util.function.Consumer;

public class Client {

    private Container container;
    private static Scanner scanner = new Scanner(System.in);

    public Client(Container container) {
        this.container = container;
    }

    //TODO: Command Pattern
    public void consoleUI() {
        System.out.println("Welcome to the UserStory-Tool by Russel Marcelo! Press (h)elp to see all prompts.");
        System.out.println("> befehl");

        while (scanner.hasNext()) {
            String answer = scanner.next().toLowerCase();
            switch (answer) {
                case "h": UserStoryToolUtil.showAllPrompts(); break;
                case "e": performAndMessage(UserStoryToolUtil::enterUserStories, "enter"); break;
                case "st": performAndMessage(UserStoryToolUtil::storeUserStories, "store"); break;
                case "l": performAndMessage(UserStoryToolUtil::loadUserStories, "load"); break;
                case "s": performAndMessage(UserStoryToolUtil::searchUserStories, "search"); break;
                case "d": performAndMessage(UserStoryToolUtil::dumpUserStories, "dump"); break;
                case "hbrs": performAndMessage(UserStoryToolUtil::dumpUserStoriesHBRS, "dump project Coll@Hbrs");break;
                case "ex": scanner.close(); UserStoryToolUtil.exitUserStoryTool();break;
                default: System.out.println("Ungueltige eingabe!");
            }
        }
    }

    private void performAndMessage(Consumer<Container> action, String message) {
        action.accept(container);
        UserStoryToolUtil.message(message);
    }
}

