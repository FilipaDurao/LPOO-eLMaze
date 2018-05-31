package com.mygdx.elmaze.view.menus;

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
     * @param menuType Reference to a model
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
                case NUMPLAYERCHOICE:
                    menuCache.put(menuType, new PlayerChoiceMenuView(game));
                    break;
                case PLATFORMCHOICE:
                    menuCache.put(menuType, new PlatformChoiceMenuView(game));
                    break;
                case SPMOBILE:
                    menuCache.put(menuType, new SPMobileMenuView(game));
                    break;
                case MPMOBILE:
                    menuCache.put(menuType, new MPMobileMenuView(game));
                    break;
                case SPKEYBOARD:
                    menuCache.put(menuType, new SPKeyboardMenuView(game));
                    break;
                case MPKEYBOARD:
                    menuCache.put(menuType, new MPKeyboardMenuView(game));
                    break;
                case WIN:
                    menuCache.put(menuType, new WinningMenuView(game));
                    break;
                case CLIENTDC:
                    menuCache.put(menuType, new ClientDCMenuView(game));
                    break;
            }
        }

        return menuCache.get(menuType);
    }

}