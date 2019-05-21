/**
 * A grass type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class GrassType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of the Grass type Pokemon
     * @param y The Y position of the Grass type Pokemon
     * @param bounds The bounding Rectangle
     */
    public GrassType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
    public void move() {
        if (getXPos() >= 0 && getXPos() <= ((PokeWorld.WIDTH) / 2 - 90)
            && getYPos() >= 0 && getYPos() <= ((PokeWorld.HEIGHT) / 2 - 90)) {
            setHealth(getHealth() + 10);
        }
        super.move();
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof GrassType) {
            if (getRand().nextInt(9) < 5) {
                return true;
            }
        } else if (other instanceof WaterType) {
            if (getRand().nextInt(9) < 7) {
                return true;
            }
        } else if (other instanceof FireType) {
            if (getRand().nextInt(9) < 3) {
                return true;
            }
        } else if (other instanceof ElectricType) {
            if (getRand().nextInt(9) < 5) {
                return true;
            }
        }
        return false;
    }
}
