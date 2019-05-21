public class Zoo {

    private Animal[] animals;

    public Zoo(Animal ... as) {
        animals = as;
    }

    public void soundOff() {
        for (Animal a : animals) {
            System.out.println(a.speak());
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo(new Animal("Dog", "Chloe"),
                          new Animal("Cat", "Maggie"),
                          new Animal("Bear", "Fozzie");
        zoo.soundOff();
    }
}
