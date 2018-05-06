package com.mygdx.elmaze.view.menus;

import com.mygdx.elmaze.ELMaze;

import java.util.HashMap;

public class MenuFactory {

    private static HashMap<MenuView.TYPE, MenuView> menuCache = new HashMap<MenuView.TYPE, MenuView>();

    public static MenuView makeMenu(ELMaze game, MenuView.TYPE menuType) {

        if (!menuCache.containsKey(menuType)) {
            switch (menuType) {
                case MAIN:
                    menuCache.put(menuType, new MainMenuView(game));
                    break;
                case CREDITS:
                    menuCache.put(menuType, new CreditsView(game));
                    break;
                case INSTRUCTIONS:
                    menuCache.put(menuType, new InstructionsView(game));
                    break;
                case NUMPLAYERCHOICE:
                    menuCache.put(menuType, new PlayerChoiceMenu(game));
                    break;
                case PLATFORMCHOICE:
                    menuCache.put(menuType, new PlatformChoiceMenu(game));
                    break;
            }
        }

        return menuCache.get(menuType);
    }

}