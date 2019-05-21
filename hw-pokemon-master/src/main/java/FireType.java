/**
 * A fire type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class FireType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of this Fire type
     * @param y The Y position of this Fire type
     * @param bounds The bounding Rectangle
     */
    public FireType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
    public void move() {
        if (getXPos() > (PokeWorld.WIDTH) / 2 && getXPos() <= (PokeWorld.WIDTH
            - 90) && getYPos() >= 0 && getYPos() <= ((PokeWorld.HEIGHT) / 2
            - 90)) {
            setSpeed(5);
        }
        super.move();
        setSpeed(2);
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof FireType) {
            if (getRand().nextInt(9) < 5) {
                return true;
            }
        } else if (other instanceof GrassType) {
            if (getRand().nextInt(9) < 7) {
                return true;
            }
        } else if (other instanceof WaterType) {
            if (getRand().nextInt(9) < 3) {
                return true;
            }
        } else if (other instanceof ElectricType) {
            if (getRand().nextInt(9) < 6) {
                return true;
            }
        }
        return false;
    }
}
