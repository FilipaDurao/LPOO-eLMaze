package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.Utilities;
import com.mygdx.elmaze.networking.NetworkManager;

import java.util.ArrayList;
import java.util.LinkedList;

public class ServerConnectionView extends MenuView {

    // Title
    private Image title;

    // Background
    private Image inputArea;
    private Button startButton;
    private Button backspaceButton;

    // Symbol Buttons
    private ArrayList<Button> keypadButtons = new ArrayList<Button>();
    private ArrayList<String> symbolFileNames = new ArrayList<String>();

    // Game Code input
    private static final int keyCodeImgSize = (int)(SCREEN_WIDTH*0.07);
    private LinkedList<Integer> keyCode = new LinkedList<Integer>();
    private ArrayList<Image> keyCodeImages = new ArrayList<Image>();

    public ServerConnectionView(ELMaze game) {
        super(game, TYPE.CONNECTION);

        setupSymbolNames();
        loadAssets();
        setupButtons();
        setupImages();
        setupStage();
        createButtonListeners();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        System.out.println(keyCode);
    }

    private void setupImages() {
        inputArea = ImageFactory.makeImage(
                game,
                "wood.png",
                SCREEN_WIDTH/2,
                SCREEN_HEIGHT*887/1200,
                (int)(SCREEN_WIDTH*0.8),
                (int)(SCREEN_WIDTH*0.1)
        );
    }

    private void setupButtons() {
        int buttonSize = (int)(SCREEN_WIDTH*0.15);
        startButton = ButtonFactory.makeButton(game,"startButtonUp.png","startButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*1/8, (int)(0.55*SCREEN_WIDTH), buttonSize);
        backspaceButton = ButtonFactory.makeButton(game,"backspaceButtonUp.png","backspaceButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*1/8, buttonSize, buttonSize);
        keypadButtons.add(ButtonFactory.makeButton(game,"alphaButtonUp.png","alphaButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"betaButtonUp.png","betaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"chiButtonUp.png","chiButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"deltaButtonUp.png","deltaButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"epsilonButtonUp.png","epsilonButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"etaButtonUp.png","etaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"gamaButtonUp.png","gamaButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"lambdaButtonUp.png","lambdaButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"muButtonUp.png","muButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"omegaButtonUp.png","omegaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"phiButtonUp.png","phiButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"piButtonUp.png","piButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"psiButtonUp.png","psiButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*2/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"rhoButtonUp.png","rhoButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*2/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"sigmaButtonUp.png","sigmaButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*2/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton(game,"tauButtonUp.png","tauButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*2/8, buttonSize, buttonSize));

        for (int i=0 ; i<8 ; i++) {
            keyCodeImages.add(ImageFactory.makeImage(game,"empty.png", SCREEN_WIDTH*(11f/100+(float)0.1*i) + keyCodeImgSize/2,
                    SCREEN_HEIGHT*887/1200, keyCodeImgSize, keyCodeImgSize));
        }
    }

    private void setupSymbolNames() {
        symbolFileNames.add("alphaSymbol.png");
        symbolFileNames.add("betaSymbol.png");
        symbolFileNames.add("chiSymbol.png");
        symbolFileNames.add("deltaSymbol.png");
        symbolFileNames.add("epsilonSymbol.png");
        symbolFileNames.add("etaSymbol.png");
        symbolFileNames.add("gamaSymbol.png");
        symbolFileNames.add("lambdaSymbol.png");
        symbolFileNames.add("muSymbol.png");
        symbolFileNames.add("omegaSymbol.png");
        symbolFileNames.add("phiSymbol.png");
        symbolFileNames.add("piSymbol.png");
        symbolFileNames.add("psiSymbol.png");
        symbolFileNames.add("rhoSymbol.png");
        symbolFileNames.add("sigmaSymbol.png");
        symbolFileNames.add("tauSymbol.png");
    }

    private void setupStage() {
        title = ImageFactory.makeImage(game, "passcode.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*8f/9,SCREEN_WIDTH*82/100);

        stage.addActor(title);
        stage.addActor(startButton);
        stage.addActor(backspaceButton);
        stage.addActor(inputArea);

        // Add Keypad Buttons
        for (Button button : keypadButtons) {
            stage.addActor(button);
        }

        // Add Keypad 'Input'
        for (Image img : keyCodeImages) {
            stage.addActor(img);
        }
    }

    private void createButtonListeners() {
        for (int i=0 ; i<keypadButtons.size() ; i++) {
            final int myIndex = i;
            keypadButtons.get(i).addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (keyCode.size() < 8) {
                        keyCodeImages.get(keyCode.size()).setDrawable(new TextureRegionDrawable(
                                new TextureRegion(new Texture(symbolFileNames.get(myIndex)))));
                        keyCode.add(myIndex);
                    }
                }
            });
        }

        backspaceButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!keyCode.isEmpty()) {
                    keyCode.removeLast();
                    keyCodeImages.get(keyCode.size()).setDrawable(null);
                }
            }
        });

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                connectToServer();
            }
        });
    }

    private void connectToServer() {
        if (keyCode.size() == 8 &&
            NetworkManager.getInstance().establishConnection(Utilities.parse(keyCode), 3000)) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.SERVER_WAIT));
        }
        else {
            clearKeyCode();
        }
    }

    private void clearKeyCode() {
        while (!keyCode.isEmpty()) {
            keyCode.removeLast();
            keyCodeImages.get(keyCode.size()).setDrawable(null);
        }
    }

    protected void loadAssets() {
        this.game.getAssetManager().load("passcode.png" , Texture.class);
        this.game.getAssetManager().load("wood.png" , Texture.class);
        this.game.getAssetManager().load("empty.png" , Texture.class);
        this.game.getAssetManager().load("startButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("startButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("backspaceButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("backspaceButtonDown.png" , Texture.class);

        loadSymbolAssets();

        this.game.getAssetManager().finishLoading();
    }

    private void loadSymbolAssets() {
        this.game.getAssetManager().load("alphaButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("alphaButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("betaButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("betaButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("chiButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("chiButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("deltaButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("deltaButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("epsilonButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("epsilonButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("etaButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("etaButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("gamaButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("gamaButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("lambdaButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("lambdaButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("muButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("muButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("omegaButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("omegaButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("phiButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("phiButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("piButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("piButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("psiButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("psiButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("rhoButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("rhoButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("sigmaButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("sigmaButtonDown.png" , Texture.class);
        this.game.getAssetManager().load("tauButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("tauButtonDown.png" , Texture.class);

        for (String fileName : symbolFileNames) {
            this.game.getAssetManager().load(fileName , Texture.class);
        }
    }

}
