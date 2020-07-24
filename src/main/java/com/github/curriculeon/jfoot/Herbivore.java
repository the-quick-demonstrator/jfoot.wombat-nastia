package com.github.curriculeon.jfoot;

import greenfoot.Actor;

/**
 * @author Michael Kölling
 * @version 2.0
 */
public abstract class Herbivore extends Actor {
    protected static final int EAST = 0;
    protected static final int WEST = 1;
    protected static final int NORTH = 2;
    protected static final int SOUTH = 3;

    protected int direction;
    private int leavesEaten;

    public Herbivore() {
        setDirection(EAST);
        leavesEaten = 0;
    }

    /**
     * Move one step forward.
     */
    public final void move() {
        move(1);
    }

    public final Boolean isFacingWest() {
        return this.direction == WEST;
    }

    public final Boolean isFacingEast() {
        return this.direction == EAST;
    }

    public final Boolean isFacingNorth() {
        return this.direction == NORTH;
    }

    public Boolean isFacingSouth() {
        return this.direction == SOUTH;
    }

    /**
     * Check whether there is a leaf in the same cell as we are.
     * Return true, if there is, false otherwise.
     */
    public final boolean foundLeaf() {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        return leaf != null;
    }

    /**
     * Eat a leaf (if there is one in our cell).
     */
    public final void eatLeaf() {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if (leaf != null) {
            // eat the leaf...
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1;
        }
    }

    /**
     * Set the direction we're facing. The 'direction' parameter must
     * be in the range [0..3].
     */
    public final void setDirection(int direction) {
        if ((direction >= 0) && (direction <= 3)) {
            setRotation(direction * 90);
        }
    }

    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public final boolean canMove() {
        int rotation = getRotation();
        int x = getX();
        int y = getY();
        boolean facingEdge = false;

        switch (rotation) {
            case 0:
                facingEdge = (x == getWorld().getWidth() - 1);
                break;
            case 90:
                facingEdge = (y == getWorld().getHeight() - 1);
                break;
            case 180:
                facingEdge = (x == 0);
                break;
            case 270:
                facingEdge = (y == 0);
                break;
        }

        return !facingEdge;
    }

    /**
     * Tell how many leaves we have eaten.
     */
    public final int getLeavesEaten() {
        return leavesEaten;
    }
}
