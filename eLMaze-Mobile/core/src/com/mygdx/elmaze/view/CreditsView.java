package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.elmaze.ELMaze;

public class CreditsView extends MenuView {

    // Background
    private Image backgroundImage;

    // Text Table
    private Image textTableImage;
    private Button exitButton;

    public CreditsView(ELMaze game) {
        super(game, TYPE.CREDITS);
        setupTextTable();

        exitButton = ButtonFactory.makeButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));

        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        handleInputs();
    }

    public void handleInputs(){
        if (exitButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
        }
    }

    private void setupTextTable(){
        Texture textTableTexture = new Texture("textTable.png");
        TextureRegion textTableTextureRegion = new TextureRegion(textTableTexture);
        setupTextureRegion(textTableTextureRegion, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.60));
        textTableImage = new Image(textTableTextureRegion);
        textTableImage.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*3/5, 1);
    }

    private void setupStage(){
        stage.addActor(textTableImage);
        stage.addActor(exitButton);
    }

    private static void setupTextureRegion(TextureRegion textureRegion, int width, int height) {
        textureRegion.getTexture().setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        textureRegion.setRegionHeight(height);
        textureRegion.setRegionWidth(width);
    }

}
