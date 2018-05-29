package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.networking.NetworkManager;

public class ServerWaitingView extends MenuView {

    private Button exitButton;
    private Image textImage;

    public ServerWaitingView(ELMaze game) {
        super(game, TYPE.SERVER_WAIT);

        loadAssets();
        setupExitButton();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();

        checkGameStatusChange();
    }

    private void setupExitButton() {
        exitButton = ButtonFactory.makeButton(game,"backButtonUp.png","backButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                NetworkManager.getInstance().closeConnection();
                GameController.getInstance().stopGame();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
    }

    private void setupStage(){
        textImage = ImageFactory.makeImage(game,"waitingForServerText.png", SCREEN_WIDTH*50/100, SCREEN_HEIGHT*60/100,SCREEN_WIDTH*85/100);

        stage.addActor(textImage);
        stage.addActor(exitButton);
    }

    protected void loadAssets() {
        this.game.getAssetManager().load("waitingForServerText.png" , Texture.class);
        this.game.getAssetManager().load("backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("backButtonDown.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
    }

    private void checkGameStatusChange() {
        switch (GameController.getInstance().getStatus()) {
            case SV_FULL:
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.SERVER_FULL));
                GameController.getInstance().stopGame();
                NetworkManager.getInstance().closeConnection();
                break;
            case RUNNING:
                game.activateMenu(MenuFactory.makeMenu(game, MenuView.TYPE.PLAY));
                break;
            case DISCONNECT:
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.SERVER_DC));
                GameController.getInstance().stopGame();
                NetworkManager.getInstance().closeConnection();
                break;
            default:
                break;
        }
    }
}
