package com.tigerstripestech.ZombieBird;

import com.badlogic.gdx.Game;
import com.tigerstripestech.Screens.GameScreen;

public class ZBGame extends Game {

    @Override
    public void create() {
        System.out.println("ZBGame Created!");
        setScreen(new GameScreen());
    }
}
