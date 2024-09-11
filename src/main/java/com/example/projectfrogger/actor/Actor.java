package com.example.projectfrogger.actor;

import com.example.projectfrogger.level.Level;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        /**
         * Move method is for movement of 2D object, decides the position of object after certain event
         * dx = difference of x coordinate
         * dy = difference of y coordinate
         */
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public Level getWorld() {
        /**
         * getWorld method call getParent method and cast the results as World
         * getParent() is JavaFX node class
         *
         */
        return (Level) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        /**
         * Using array, getIntersectingObjects calculate collision between 2 difference object
         */
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);

}
