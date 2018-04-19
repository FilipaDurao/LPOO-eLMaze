package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ELMaze;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.model.GameModel;
import com.mygdx.game.model.entities.BallModel;
import com.mygdx.game.view.entities.*;

public class GameView extends ScreenAdapter {
	
    public final static float PIXEL_TO_METER = 0.02f;
    private static final float VIEWPORT_WIDTH = 20;
    private static final float SCREEN_RATIO = (float)(Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth());
	
    private final ELMaze game;
    private final OrthographicCamera camera;
    private BallView ballView;
    private DoorView doorView;
    private ButtonView buttonView;
    private ExitView exitView;
    private WallView wallView;
    
    public GameView(ELMaze game) {
    	this.game = game;
    	
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

        GameController.getInstance().update(delta);

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
    	BallModel ball = GameModel.getInstance().getBall();
    	ballView = new BallView(game);
    	ballView.update(ball);
    	ballView.draw(game.getSpriteBatch());
    }
}
