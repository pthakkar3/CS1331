import java.awt.Rectangle;

public class Poliwhirl extends WaterType {

    /**
     * Constructor
     * @param x The X position of Poliwhirl
     * @param y The Y position of Poliwhirl
     * @param bounds The bounding Rectangle
     */
    public Poliwhirl(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/poliwhirl.png");
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof WaterType) {
            if (other instanceof Poliwhirl) {
                if (getRand().nextInt(99) < 38) {
                    return true;
                }
            } else {
                if (getRand().nextInt(9) < 5) {
                    return true;
                }
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

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof Poliwhirl) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (this.getChildren() < 2 && other.getChildren() < 2) {
            if (getRand().nextInt(99) < 5) {
                this.setChildren(this.getChildren() + 1);
                other.setChildren(other.getChildren() + 1);
                return new Poliwhirl(this.getXPos(), this.getYPos(),
                                    this.getBounds());
            }
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (this.getLevel() >= 200) {
            return true;
        }
        return false;
    }
}
