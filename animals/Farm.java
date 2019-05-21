public class Farm {
    public static void main (String[] args) {
        Animal[] animals = {new Dog("Fido"), new Cat("Lassie")};
        for (Animal a : animals) {
            System.out.println(a.speak(5));
            System.out.println("Age:" + a.getAge());
        }
    }
}
