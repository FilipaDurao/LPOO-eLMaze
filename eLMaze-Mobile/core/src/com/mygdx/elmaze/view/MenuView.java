package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.elmaze.ELMaze;

public abstract class MenuView extends ScreenAdapter {

    public enum TYPE { MAIN, CREDITS, INSTRUCTIONS, PLAY, CONNECTION };

    protected final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    protected final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    protected final ELMaze game;
    protected Stage stage;
    private TYPE type;

    public MenuView(ELMaze game, TYPE type) {
        this.game = game;
        this.type = type;
    }

    protected void setupTextureRegion(TextureRegion textureRegion, int width, int height) {
        textureRegion.getTexture().setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        textureRegion.setRegionHeight(height);
        textureRegion.setRegionWidth(width);
    }

    public TYPE getType() {
        return type;
    }

    public void activate() {
        Gdx.input.setInputProcessor(stage);
    }

    public abstract void handleInputs();

}
