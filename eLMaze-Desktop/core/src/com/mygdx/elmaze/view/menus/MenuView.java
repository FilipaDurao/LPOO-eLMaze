package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public abstract class MenuView extends ScreenAdapter{
    
	public enum TYPE { MAIN, CREDITS, INSTRUCTIONS, NUMPLAYERCHOICE, PLATFORMCHOICE };
	
    protected final ELMaze game;
    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    protected Stage stage;
    protected Image backgroundImage;
    private TYPE type;
    
    public MenuView(ELMaze game,  TYPE type) {
    	this.game = game;
    	this.type = type;
    	loadAssets();
    	setupBackground();
    	stage = new Stage();
        stage.addActor(backgroundImage);
    }
    
    protected abstract void loadAssets();
    
    private void setupBackground(){
        Texture backgroundTexture = game.getAssetManager().get("menuBackground.jpg", Texture.class);
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
    }

    public void activate() {
        Gdx.input.setInputProcessor(stage);
    }

}
