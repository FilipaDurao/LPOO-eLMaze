package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.networking.NetworkManager;

/**
 * Represents the Play Game view
 */
public class PlayGameView extends MenuView {

    private Image textImage;
    private Image ballImage;
    private float timeSinceLastUpdate = 0;
    private final int NUM_MESSAGES_PER_SECOND = 20;

    /**
     * Creates the Play Game view
     *
     * @param game Reference to the Game object
     */
    public PlayGameView(ELMaze game) {
        super(game, TYPE.PLAY);

        loadAssets();
        setupStage();
    }

    /**
     * Renders the menu on the screen
     *
     * @param delta Time since last render
     */
    @Override
    public void render(float delta) {
        handleInputs(delta);

        stage.act(delta);
        stage.draw();

        checkGameStatusChange();
    }

    /**
     * Sets up the stage
     */
    private void setupStage() {
        textImage = ImageFactory.makeImage(game,"playText.png", SCREEN_WIDTH*5/7, SCREEN_HEIGHT/2,SCREEN_WIDTH*3/10);
        ballImage = ImageFactory.makeImage(game,"ball.png", SCREEN_WIDTH*7/28, SCREEN_HEIGHT/2,SCREEN_WIDTH*3/10);

        stage.addActor(textImage);
        stage.addActor(ballImage);
    }

    /**
     * Handles the inputs from the user
     *
     * @param delta Time since last handle
     */
    private void handleInputs(float delta) {
        timeSinceLastUpdate += delta;

        // Send message with a fixed maximum rate.
        if (timeSinceLastUpdate > 1/NUM_MESSAGES_PER_SECOND) {
            GameController.getInstance().moveBall(
                    Gdx.input.getAccelerometerY(),
                    -Gdx.input.getAccelerometerX()
            );
            timeSinceLastUpdate = 0;
        }
    }

    /**
     * Loads all assets needed for the menu
     */
    protected void loadAssets() {
        this.game.getAssetManager().load("playText.png" , Texture.class);
        this.game.getAssetManager().load("ball.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
    }

    /**
     * Checks for any changes in the Game status in order to know if a screen chang is needed or
     * if the game can continue to run
     */
    private void checkGameStatusChange() {
        switch (GameController.getInstance().getStatus()) {
            case NOT_RUNNING:
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.WIN));
                NetworkManager.getInstance().closeConnection();
                GameController.getInstance().stopGame();
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
