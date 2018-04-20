package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.game.ELMaze;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.model.GameModel;
import com.mygdx.game.model.entities.BallModel;
import com.mygdx.game.model.entities.DoorModel;
import com.mygdx.game.model.entities.EntityModel;
import com.mygdx.game.model.entities.ExitModel;
import com.mygdx.game.model.entities.WallModel;
import com.mygdx.game.view.entities.*;

public class GameView extends ScreenAdapter {
	
    public static final float PIXEL_TO_METER = .05f;
    public static final float VIEWPORT_WIDTH = 20;
    public static final float SCREEN_RATIO = (float)(Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth());
	
    private final ELMaze game;
    private final OrthographicCamera camera;
    
    /**
     * A renderer used to debug the physical fixtures.
     */
    private Box2DDebugRenderer debugRenderer;

    /**
     * The transformation matrix used to transform meters into
     * pixels in order to show fixtures in their correct places.
     */
    private Matrix4 debugCamera;
    
    public GameView(ELMaze game) {
    	this.game = game;
    	
    	loadAssets();
    	
    	camera = initCamera();
    }
    
    private void loadAssets() {
        this.game.getAssetManager().load( "ball.png" , Texture.class);
        this.game.getAssetManager().load( "wall.png" , Texture.class);
        this.game.getAssetManager().load( "background.png" , Texture.class);
        this.game.getAssetManager().load( "exit.png" , Texture.class);
        this.game.getAssetManager().load( "door.png" , Texture.class);
        //this.game.getAssetManager().load( "button.png" , Texture.class);

        this.game.getAssetManager().finishLoading();
    }
    
    private OrthographicCamera initCamera() {
        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH / PIXEL_TO_METER, VIEWPORT_WIDTH / PIXEL_TO_METER * SCREEN_RATIO);

        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
        
        debugRenderer = new Box2DDebugRenderer();
        debugCamera = camera.combined.cpy();
        debugCamera.scl(1 / PIXEL_TO_METER);
        
        return camera;
    }   
    
    @Override
    public void render(float delta) {
        handleInputs();

        GameController.getInstance().update(delta);

        camera.update();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);

        game.getSpriteBatch().begin();
        drawBackground();
        drawEntities();
        game.getSpriteBatch().end();
        
        debugCamera = camera.combined.cpy();
        debugCamera.scl(1 / PIXEL_TO_METER);
        debugRenderer.render(GameController.getInstance().getWorld(), debugCamera);
    }
    
    public void drawBackground() {
    	Texture background = game.getAssetManager().get("background.png", Texture.class);
    	background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    	game.getSpriteBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    
    public void drawEntities() {
    	BallModel ball = GameModel.getInstance().getBall();
    	BallView ballView = new BallView(game, ball);
    	ballView.update(ball);
    	ballView.draw(game.getSpriteBatch());
    	
    	for (WallModel wall : GameModel.getInstance().getWalls()) {
    		WallView wallView = new WallView(game, wall);
    		wallView.update(wall);
    		wallView.draw(game.getSpriteBatch());
    	}
    	
    	ExitModel exit = GameModel.getInstance().getExit();
    	ExitView exitView = new ExitView(game, exit);
    	exitView.update(exit);
    	exitView.draw(game.getSpriteBatch());
    	
    	for (DoorModel door : GameModel.getInstance().getDoors()) {
    		DoorView doorView = new DoorView(game, door);
    		doorView.update(door);
    		doorView.draw(game.getSpriteBatch());
    	}
    }
    	
    public void handleInputs() {
    	 if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
             GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(-2, 0), true);
         }
    	 else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
             GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(2, 0), true);
         }
    	 else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
             GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(0, 2), true);
         }
    	 else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
             GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(0, -2), true);
         }
    }
}
