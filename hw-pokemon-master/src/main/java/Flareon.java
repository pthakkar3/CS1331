import java.awt.Rectangle;

public class Flareon extends FireType {

    public Flareon(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/flareon.png");
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

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof Flareon) {
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
                return new Flareon(this.getXPos(), this.getYPos(),
                                    this.getBounds());
            }
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (this.getLevel() >= 150) {
            return true;
        }
        return false;
    }

}
