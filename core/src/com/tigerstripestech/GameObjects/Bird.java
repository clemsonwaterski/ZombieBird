package com.tigerstripestech.GameObjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Josh on 7/13/2014.
 */
public class Bird {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;

    private Circle boundingCircle;

    public Bird(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,460);
        boundingCircle = new Circle();
    }

    public void update(float delta){
        velocity.add(acceleration.cpy().scl(delta));

        // cap the terminal velocity (falling speed)t
        if(velocity.y > 200) {
            velocity.y = 200;
        }

        position.add(velocity.cpy().scl(delta));

        // Set the circle's center to be (9, 6) with respect to the bird.
        // Set the circle's radius to be 6.5f
        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);


        // rotate counterclockwise (climbing)
        if(velocity.y < 0){
            rotation -= 600 * delta;

            if( rotation < -20) {
                rotation = -20;
            }
        }

        // rotate clockwise (falling)
        if(isFalling()){
            rotation += 480 * delta;
            if(rotation > 90){
                rotation = 90;
            }
        }
    }

    public void onClick(){
        // flap up (lower y values are higher)
        velocity.y = -140;
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }
    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }

    public float getRotation(){
        return rotation;
    }

    public boolean isFalling(){
        return velocity.y > 110;
    }

    public boolean shouldntFlap(){
        return velocity.y > 70;
    }

    public Circle getBoundingCircle(){
        return boundingCircle;
    }
}
