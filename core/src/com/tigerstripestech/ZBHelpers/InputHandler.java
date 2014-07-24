package com.tigerstripestech.ZBHelpers;

import com.badlogic.gdx.InputProcessor;
import com.tigerstripestech.GameObjects.Bird;
import com.tigerstripestech.GameWorld.GameWorld;

/**
 * Created by Josh on 7/13/2014.
 */
public class InputHandler implements InputProcessor{

    private GameWorld myWorld;
    private Bird myBird;

    public InputHandler(GameWorld myWorld){
        this.myWorld = myWorld;
        this.myBird = myWorld.getBird();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (myWorld.isReady()){
            myWorld.start();
        }

        myBird.onClick();

        if(myWorld.isGameOver()){
            // Reset all variables, go to GameState.READY
            myWorld.restart();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
