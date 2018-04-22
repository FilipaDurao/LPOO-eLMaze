package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;
import com.mygdx.elmaze.view.entities.*;

public class GameView extends ScreenAdapter {
	
    public static final float PIXEL_TO_METER = .05f;
    public static final float VIEWPORT_WIDTH = 20;
    public static final float SCREEN_RATIO = (float)(Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth());
    
    private static final boolean DEBUG = false;;
	
    private final ELMaze game;
    private final OrthographicCamera camera;
    
    private Box2DDebugRenderer debugRenderer;
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
        this.game.getAssetManager().load( "button.png" , Texture.class);
        this.game.getAssetManager().load( "pressed_button.png" , Texture.class);

        this.game.getAssetManager().finishLoading();
    }
    
    private OrthographicCamera initCamera() {
        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH / PIXEL_TO_METER, VIEWPORT_WIDTH / PIXEL_TO_METER * SCREEN_RATIO);

        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
        
        if (DEBUG) {
	        debugRenderer = new Box2DDebugRenderer();
	        debugCamera = camera.combined.cpy();
	        debugCamera.scl(1 / PIXEL_TO_METER);
        }
        
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
        
        if (DEBUG) {
	        debugCamera = camera.combined.cpy();
	        debugCamera.scl(1 / PIXEL_TO_METER);
	        debugRenderer.render(GameController.getInstance().getWorld(), debugCamera);
        }
    }
    
    private void drawBackground() {
    	Texture background = game.getAssetManager().get("background.png", Texture.class);
    	background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    	game.getSpriteBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    
    private void drawEntities() {
    	drawWalls();
    	drawDoors();
    	drawButtons();
    	drawExit();
    	drawBall();
    }
    	
    private void handleInputs() {
    	float speed = 5;
    	
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
		    GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(-speed, 0), true);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
		    GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(speed, 0), true);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
		    GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(0, speed), true);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
		    GameController.getInstance().getBallBody().applyForceToCenter(new Vector2(0, -speed), true);
		}
    }
    
    private void drawBall() {
    	BallModel ball = GameModel.getInstance().getBall();
        BallView ballView = (BallView) ViewFactory.makeView(game, ball);
    	ballView.update(ball);
    	ballView.draw(game.getSpriteBatch());
    }
    
    private void drawExit() {
    	ExitModel exit = GameModel.getInstance().getExit();
    	ExitView exitView = (ExitView) ViewFactory.makeView(game, exit);
    	exitView.draw(game.getSpriteBatch());
    }
    
    private void drawWalls() {    	
    	for (WallModel wall : GameModel.getInstance().getWalls()) {
    		WallView wallView = (WallView) ViewFactory.makeView(game, wall);
    		wallView.draw(game.getSpriteBatch());
    	}
    }
    
    private void drawDoors() {
    	for (DoorModel door : GameModel.getInstance().getDoors()) {
    		if (door.isClosed()) {
    			DoorView doorView = (DoorView) ViewFactory.makeView(game, door);
        		doorView.draw(game.getSpriteBatch());
    		}
    	}
    }
    
    private void drawButtons() {
    	for (ButtonModel button: GameModel.getInstance().getButtons()) {
    		ButtonView buttonView = (ButtonView) ViewFactory.makeView(game, button);
    		buttonView.update(button);
    		buttonView.draw(game.getSpriteBatch());
    	}
    }
}
