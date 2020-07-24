package com.github.curriculeon.jfoot;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        } else {
            this.turnLeft();
        }
    }

    public void turnLeft() {
        if (this.direction == EAST) {
            this.setDirection(NORTH);
        } else if (this.direction == WEST) {
            this.setDirection(SOUTH);
        } else if (this.direction == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }
}
