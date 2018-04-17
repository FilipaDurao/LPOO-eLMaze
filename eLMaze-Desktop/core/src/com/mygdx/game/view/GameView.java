package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ELMaze;
import com.mygdx.game.model.GameModel;
import com.mygdx.game.view.entities.*;

public class GameView extends ScreenAdapter {
	
    public final static float PIXEL_TO_METER = 0.02f;
    private static final float VIEWPORT_WIDTH = 20;
    private static final float SCREEN_RATIO = (float)(Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth());
	
    private final ELMaze game;
    private final GameModel model;
    //private final GameController controller;
    private final OrthographicCamera camera;
    private final BallView ballView;
    private final DoorView doorView;
    private final ButtonView buttonView;
    private final ExitView exitView;
    private final WallView wallView;
    
    public GameView(ELMaze game, GameModel model/*, GameController controller*/) {
    	this.game = game;
    	this.model = model;
    	//this.controller = controller;
    	
    	loadAssets();
    	
    	camera = initCamera();
    	
    	ballView = new BallView(game);
    	doorView = new DoorView(game);
    	buttonView = new ButtonView(game);
    	exitView = new ExitView(game);
    	wallView = new WallView(game);
    }
    
    private void loadAssets() {
        this.game.getAssetManager().load( "ball.png" , Texture.class);
        this.game.getAssetManager().load( "wall.png" , Texture.class);
        this.game.getAssetManager().load( "background.png" , Texture.class);
        //this.game.getAssetManager().load( "door.png" , Texture.class);
        //this.game.getAssetManager().load( "exit.png" , Texture.class);
        //this.game.getAssetManager().load( "button.png" , Texture.class);

        this.game.getAssetManager().finishLoading();
    }
    
    private OrthographicCamera initCamera() {
        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH / PIXEL_TO_METER, VIEWPORT_WIDTH / PIXEL_TO_METER * SCREEN_RATIO);

        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
        
        return camera;
    }   
    
    @Override
    public void render(float delta) {
        //handleInputs(delta);

        //controller.update(delta);

        camera.update();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);

        game.getSpriteBatch().begin();
        drawBackground();
        drawEntities();
        game.getSpriteBatch().end();
    }
    
    public void drawBackground() {
    	 Texture background = game.getAssetManager().get("background.png", Texture.class);
         background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
         game.getSpriteBatch().draw(background, 0, 0, 0, 0, (int)(VIEWPORT_WIDTH / PIXEL_TO_METER), (int) (VIEWPORT_WIDTH / PIXEL_TO_METER));
    }
    
    public void drawEntities() {
    	// TODO
    }
}
