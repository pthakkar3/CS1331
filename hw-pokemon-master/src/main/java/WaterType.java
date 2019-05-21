/**
 * A water type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class WaterType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of this Water Type Pokemon
     * @param y The Y position of this Water Type Pokemon
     * @param bounds The bounding Rectangle
     */
    public WaterType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
    public void move() {
        if (getXPos() >= 0 && getXPos() <= ((PokeWorld.WIDTH) / 2 - 90)
            && getYPos() > ((PokeWorld.HEIGHT) / 2 - 90) && getYPos()
            <= (PokeWorld.HEIGHT - 90)) {
            setLevel(getLevel() + 2);
        }
        super.move();
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof WaterType) {
            if (getRand().nextInt(9) < 5) {
                return true;
            }
        } else if (other instanceof FireType) {
            if (getRand().nextInt(9) < 7) {
                return true;
            }
        } else if (other instanceof GrassType) {
            if (getRand().nextInt(9) < 3) {
                return true;
            }
        } else if (other instanceof ElectricType) {
            if (getRand().nextInt(9) < 4) {
                return true;
            }
        }
        return false;
    }
}
