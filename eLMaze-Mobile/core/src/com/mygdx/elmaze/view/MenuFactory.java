package com.mygdx.elmaze.view;

import com.mygdx.elmaze.ELMaze;

import java.util.HashMap;

/**
 * Implements functions related to the creation of Menus
 */
public class MenuFactory {

    /**
     * Menu Views cache for faster menu reloading
     */
    private static HashMap<MenuView.TYPE, MenuView> menuCache = new HashMap<MenuView.TYPE, MenuView>();

    /**
     * Creates a menu view and stores them in the menu cache for future uses
     *
     * @param game Reference to the Game object
     * @param menuType Reference to a menu type
     *
     * @return Returns the requested menu
     */
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
                case PLAY:
                    menuCache.put(menuType, new PlayGameView(game));
                    break;
                case CONNECTION:
                    menuCache.put(menuType, new ServerConnectionView(game));
                    break;
                case SERVER_WAIT:
                    menuCache.put(menuType, new ServerWaitingView(game));
                    break;
                case SERVER_DC:
                    menuCache.put(menuType, new ServerDisconnectView(game));
                    break;
                case WIN:
                    menuCache.put(menuType, new WinningView(game));
                    break;
                case SERVER_FULL:
                    menuCache.put(menuType, new ServerFullView(game));
                    break;
            }
        }

        return menuCache.get(menuType);
    }
}