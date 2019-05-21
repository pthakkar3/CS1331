import java.awt.Rectangle;

public abstract class ElectricType extends Pokemon {

    public ElectricType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
    public void move() {
        if (getXPos() > ((PokeWorld.WIDTH) / 2) && getXPos()
            <= (PokeWorld.WIDTH - 90) && getYPos() > ((PokeWorld.HEIGHT) / 2)
            && getYPos() <= (PokeWorld.HEIGHT - 90)) {
            setHealth(getHealth() + 20);
            setSpeed(3);
        }
        super.move();
        setSpeed(2);
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof ElectricType) {
            if (getRand().nextInt(9) < 5) {
                return true;
            }
        } else if (other instanceof WaterType) {
            if (getRand().nextInt(9) < 9) {
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
        }
        return false;
    }
}
