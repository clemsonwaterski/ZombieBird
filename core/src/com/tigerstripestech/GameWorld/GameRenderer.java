package com.tigerstripestech.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Josh on 7/10/2014.
 */
public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    public GameRenderer(GameWorld world){
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render() {
        System.out.println("GameRenderer - render");

        // Fill game screen background
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw filled rectangle
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(87/255.0f, 109/255.0f, 120/255.0f, 1);
        //shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y, myWorld.getRect().width, myWorld.getRect().height);
        shapeRenderer.end();

        // Draw rectangle outline
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(255/255.0f, 109/255.0f, 120/255.0f, 1);
        //shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y, myWorld.getRect().width, myWorld.getRect().height);
        shapeRenderer.end();
    }
}
