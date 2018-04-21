package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class MenuView extends ScreenAdapter{

    Button singlePlayerButton = new Button();
    Button multiPlayerButton = new Button();
    Button exitButton = new Button();
    Button creditsButton = new Button();


    public MenuView(){

        singlePlayerButton.setBounds(100, 100, 100,50 );
        //singlePlayerButton.draw();


    }



    @Override
    public void render(float delta){
    }


}