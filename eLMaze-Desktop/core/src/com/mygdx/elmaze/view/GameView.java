package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
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
import com.mygdx.elmaze.model.levels.MultiPlayerLevelModel;
import com.mygdx.elmaze.model.levels.SinglePlayerLevelModel;
import com.mygdx.elmaze.networking.MessageToClient;
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.entities.*;
import com.mygdx.elmaze.view.menus.MenuFactory;
import com.mygdx.elmaze.view.menus.MenuView.TYPE;

/**
 * Represents the Game View
 */
public class GameView extends ScreenAdapter {

	private static GameView instance;
	
    public static final float PIXEL_TO_METER = .05f;
    public static final float VIEWPORT_WIDTH = 20;
    public static final float SCREEN_RATIO = (float)(Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth());
    
    private static final boolean DEBUG = false;
	
    private ELMaze game;
    private final OrthographicCamera camera;
    
    private Box2DDebugRenderer debugRenderer;
    private Matrix4 debugCamera;
    
    /**
     * @return Returns the Game View instance
     */
    public static GameView getInstance() {
    	if (instance == null) {
    		instance = new GameView();
    	}
    	return instance;
    }
    
    private GameView() {
    	camera = initCamera();
    }
    
    /**
     * Sets the game reference to the game object passed as parameter
     * 
     * @param game Reference to the Game object
     */
    public void setGameReference(ELMaze game) {
    	this.game = game;
    	loadAssets();	
    }
    
    /**
	 * Loads all assets needed for the Game
	 */
    private void loadAssets() {
        this.game.getAssetManager().load( "ball.png" , Texture.class);
        this.game.getAssetManager().load( "jade_ball.png" , Texture.class);
        this.game.getAssetManager().load( "obsidian_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ocean_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ruby_ball.png" , Texture.class);
        this.game.getAssetManager().load( "wall.png" , Texture.class);
        this.game.getAssetManager().load( "background.png" , Texture.class);
        this.game.getAssetManager().load( "exit.png" , Texture.class);
        this.game.getAssetManager().load( "door.png" , Texture.class);
        this.game.getAssetManager().load( "button.png" , Texture.class);
        this.game.getAssetManager().load( "pressed_button.png" , Texture.class);
        this.game.getAssetManager().load( "ballCollision.mp3" , Sound.class);
        this.game.getAssetManager().load( "fall.mp3" , Sound.class);
        this.game.getAssetManager().load( "buttonPress.mp3" , Sound.class);
        this.game.getAssetManager().load( "metal.mp3" , Sound.class);
        this.game.getAssetManager().load( "poolBall.mp3" , Sound.class);

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
    
	/**
	 * Renders the Game on the screen
	 * 
	 * @param delta Time since last render
	 */
    @Override
    public void render(float delta) {
    	if (game.getPlatform() == ELMaze.PLATFORM.KEYBOARD) {
            handleInputs();
    	}

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
        
        checkGameStatusChange();
    }
    
    /**
     * Sets up the background of the Game with the background image
     */
    private void drawBackground() {
    	Texture background = game.getAssetManager().get("background.png", Texture.class);
    	background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    	game.getSpriteBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    
    /**
     * Draws the Entities on the screen
     */
    private void drawEntities() {
    	drawWalls();
    	drawDoors();
    	drawButtons();
    	drawExit();
    	drawBall();
    }
    
    /**
     * Handles the inputs from the player(s)
     */
    private void handleInputs() {
    	float speed = 5;
    	
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			GameController.getInstance().updateBall(0, new Vector2(-speed, 0), true);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			GameController.getInstance().updateBall(0, new Vector2(speed, 0), true);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			GameController.getInstance().updateBall(0, new Vector2(0, speed), true);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			GameController.getInstance().updateBall(0, new Vector2(0, -speed), true);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			GameController.getInstance().updateBall(1, new Vector2(-speed, 0), true);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			GameController.getInstance().updateBall(1, new Vector2(speed, 0), true);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			GameController.getInstance().updateBall(1, new Vector2(0, speed), true);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			GameController.getInstance().updateBall(1, new Vector2(0, -speed), true);
		}
    }
    
    /**
     * Draws the Ball on the screen
     */
    private void drawBall() {
    	if (game.getPlayMode() == ELMaze.PLAY_MODE.SINGLEPLAYER) {
        	BallModel ball = ((SinglePlayerLevelModel) GameModel.getInstance().getCurrentLevel()).getBall();
            BallView ballView = (BallView) ViewFactory.makeView(game, ball);
        	ballView.update(ball);
        	ballView.draw(game.getSpriteBatch());
    	}
    	else {
        	BallModel ball1 = ((MultiPlayerLevelModel) GameModel.getInstance().getCurrentLevel()).getBall1();
        	BallModel ball2 = ((MultiPlayerLevelModel) GameModel.getInstance().getCurrentLevel()).getBall2();
            BallView ball1View = (BallView) ViewFactory.makeView(game, ball1);
            BallView ball2View = (BallView) ViewFactory.makeView(game, ball2);
        	ball1View.update(ball1);
        	ball2View.update(ball2);
        	ball1View.draw(game.getSpriteBatch());
        	ball2View.draw(game.getSpriteBatch());
    	}
    }
    
    /**
     * Draws the Exit on the screen
     */
    private void drawExit() {
    	ExitModel exit = GameModel.getInstance().getCurrentLevel().getExit();
    	ExitView exitView = (ExitView) ViewFactory.makeView(game, exit);
    	exitView.draw(game.getSpriteBatch());
    }
    
    /**
     * Draws the Walls on the screen
     */
    private void drawWalls() {    	
    	for (WallModel wall : GameModel.getInstance().getCurrentLevel().getWalls()) {
    		WallView wallView = (WallView) ViewFactory.makeView(game, wall);
    		wallView.draw(game.getSpriteBatch());
    	}
    }
    
    /**
     * Draws the Doors on the screen
     */
    private void drawDoors() {
    	for (DoorModel door : GameModel.getInstance().getCurrentLevel().getDoors()) {
    		if (door.isClosed()) {
    			DoorView doorView = (DoorView) ViewFactory.makeView(game, door);
        		doorView.draw(game.getSpriteBatch());
    		}
    	}
    }
    
    /**
     * Draws the Buttons on the screen
     */
    private void drawButtons() {
    	for (ButtonModel button: GameModel.getInstance().getCurrentLevel().getButtons()) {
    		ButtonView buttonView = (ButtonView) ViewFactory.makeView(game, button);
    		buttonView.update(button);
    		buttonView.draw(game.getSpriteBatch());
    	}
    }
    
    /**
     * Checks the Game's status for updating the views
     */
    private void checkGameStatusChange() {
    	switch (GameController.getInstance().getStatus()) {
    	case DISCONNECT:
        	game.activateMenu(MenuFactory.makeMenu(game, TYPE.CLIENTDC));
        	GameController.getInstance().stopGame();
    		NetworkManager.getInstance().getSocketManager().closeConnections();
    		NetworkManager.getInstance().closeServer();
        	break;
    	case NOT_RUNNING:
        	game.activateMenu(MenuFactory.makeMenu(game, TYPE.WIN));
        	
        	if (game.getPlatform() == ELMaze.PLATFORM.PHONE) {
        		NetworkManager.getInstance().getSocketManager().broadcastMessage(
        				new MessageToClient(MessageToClient.CONTENT.GAME_FINISH));
        	}
        	
        	break;
    	default:
    		break;
    	}
    }
    
    /**
     * Plays a sound when a ball collides with a wall
     */
    public void playBallWallCollisionSound() {
    	Sound collisionSound = game.getAssetManager().get("ballCollision.mp3");
    	collisionSound.play(0.6f);
    }
    
    /**
     * Plays a sound when a ball collides with a button
     */
    public void playBallButtonCollisionSound() {
    	Sound collisionSound = game.getAssetManager().get("buttonPress.mp3");
    	collisionSound.play(0.8f);
    }
    
    /**
     * Plays a sound when a ball collides with an exit
     */
    public void playBallExitCollisionSound() {
    	Sound collisionSound = game.getAssetManager().get("fall.mp3");
    	collisionSound.play(1.0f);
    }
    
    /**
     * Plays a sound when a ball collides with a door
     */
    public void playBallDoorCollisionSound() {
    	Sound collisionSound = game.getAssetManager().get("metal.mp3");
    	collisionSound.play(0.35f);
    }
    
    /**
     * Plays a sound when a ball collides with another ball
     */
    public void playBallBallCollisionSound() {
    	Sound collisionSound = game.getAssetManager().get("poolBall.mp3");
    	collisionSound.play(0.9f);
    }
}
