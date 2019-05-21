import java.awt.Rectangle;

public class Pikachu extends ElectricType {

    public Pikachu(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/pikachu.png");
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof ElectricType) {
            if (getRand().nextInt(9) < 2) {
                return true;
            }
        } else if (other instanceof WaterType) {
            if (getRand().nextInt(9) < 9) {
                return true;
            }
        } else if (other instanceof FireType) {
            if (getRand().nextInt(9) < 9) {
                return true;
            }
        } else if (other instanceof GrassType) {
            if (getRand().nextInt(9) < 9) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof Pikachu) {
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
                return new Pikachu(this.getXPos(), this.getYPos(),
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
