package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public abstract class MenuView extends ScreenAdapter {

    public enum TYPE { MAIN, CREDITS, INSTRUCTIONS, PLAY, CONNECTION };

    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    protected final ELMaze game;
    protected Stage stage;
    protected Image backgroundImage;
    private TYPE type;

    public MenuView(ELMaze game, TYPE type) {
        this.game = game;
        this.type = type;
        setupBackground();
        stage = new Stage();
        stage.addActor(backgroundImage);
    }

    public void activate() {
        Gdx.input.setInputProcessor(stage);
    }

    public TYPE getType() {
        return type;
    }

    private void setupBackground(){
        Texture backgroundTexture = new Texture("background.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
    }

}
