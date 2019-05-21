import java.awt.Rectangle;

public class Torterra extends GrassType {

    /**
     * Constructor
     * @param x The X position of Torterra
     * @param y The Y position of Torterra
     * @param bounds The bounding Rectangle
     */
    public Torterra(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/torterra.png");
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof GrassType) {
            if (getRand().nextInt(9) < 5) {
                return true;
            }
        } else if (other instanceof WaterType) {
            if (other instanceof Poliwhirl) {
                if (getRand().nextInt(9) < 8) {
                    return true;
                }
            } else {
                if (getRand().nextInt(9) < 8) {
                    return true;
                }
            }
        } else if (other instanceof FireType) {
            if (getRand().nextInt(9) < 4) {
                return true;
            }
        } else if (other instanceof ElectricType) {
            if (getRand().nextInt(9) < 5) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof GrassType) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (this.getChildren() < 2 && other.getChildren() < 2) {
            if (getRand().nextInt(99) < 20) {
                this.setChildren(this.getChildren() + 1);
                other.setChildren(other.getChildren() + 1);
                return new Torterra(this.getXPos(), this.getYPos(),
                                    this.getBounds());
            }
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (this.getLevel() >= 100) {
            return true;
        }
        return false;
    }
}
