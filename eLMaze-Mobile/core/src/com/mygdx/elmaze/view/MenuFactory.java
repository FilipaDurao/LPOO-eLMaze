package com.mygdx.elmaze.view;

import com.mygdx.elmaze.ELMaze;

public class MenuFactory {

    public static MenuView makeMenu(ELMaze game, MenuView.TYPE menuType) {
        switch (menuType) {
            case MAIN:
                return new MainMenuView(game);
            case CREDITS:
                return new CreditsView(game);
            case INSTRUCTIONS:
                return new InstructionsView(game);
            case PLAY:
                return new PlayGameView(game);
            case CONNECTION:
                return new ServerConnectionView(game);
            default:
                return null;
        }
    }

}