import java.awt.Rectangle;

public class Blaziken extends FireType {

    /**
     * Constructor
     * @param x The X position of Blaziken
     * @param y The Y position of Blaziken
     * @param bounds The bounding Rectangle
     */
    public Blaziken(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/blaziken.png");
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof FireType) {
            if (this.getLevel() >= other.getLevel()) {
                if (getRand().nextInt(9) < 9) {
                    return true;
                }
            } else {
                if (getRand().nextInt(99) < 12) {
                    return true;
                }
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

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof Blaziken) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (this.getChildren() < 2 && other.getChildren() < 2) {
            if (getRand().nextInt(99) < 25) {
                this.setChildren(this.getChildren() + 1);
                other.setChildren(other.getChildren() + 1);
                return new Blaziken(getXPos(), getYPos(),
                                    getBounds());
            }
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (this.getLevel() >= 175) {
            return true;
        }
        return false;
    }
}
