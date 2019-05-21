public class Animal {

    private String species;
    private String name;

    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
    }

    @Override
    public String toString() {
        return species + " " + name;
    }

    public String speak() {
        if (species.equalsIgnoreCase("Dog")) {
            return "woof!";
        } else if (species.equalsIgnoreCase("Bear")) {
            return "rowr";
        } else {
            return "meow!"
        }
    }
}
