package com.hsleiden.groep30;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.CollisionHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Game extends GameApplication {
    private Entity player;

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(800);
        gameSettings.setTitle("HSLEIDENTALE");
        gameSettings.setVersion("1.0");

    }

    @Override
    protected void initGame(){
        player = FXGL.entityBuilder()
                .at(400,400)
                .viewWithBBox("8bit.jpg")
                .scale(0.5, 0.5)
                .with(new CollidableComponent(true))
                .type(EntityTypes.PLAYER)
                .buildAndAttach();

        FXGL.entityBuilder()
                .at(200, 200)
                .viewWithBBox(new Circle(5, Color.BLACK))
                .with(new CollidableComponent(true))
                .type(EntityTypes.STAR)
                .buildAndAttach();

    }

    @Override
    protected void initInput(){
        FXGL.onKey(KeyCode.D,() -> {
            player.translateX(5);
        });
        FXGL.onKey(KeyCode.A,() -> {
            player.translateX(-5);
        });
        FXGL.onKey(KeyCode.W,() -> {
            player.translateY(-5);
        });
        FXGL.onKey(KeyCode.S,() -> {
            player.translateY(5);
        });
    }

     @Override
     protected void initPhysics(){
        FXGL.getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityTypes.PLAYER, EntityTypes.STAR) {
            @Override
            protected void onCollision(Entity PLAYER, Entity STAR) {
                STAR.removeFromWorld();
            }
        });
     }

    public static void main(String[] args){
        launch(args);
    }
}
