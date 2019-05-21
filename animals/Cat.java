public class Cat extends Animal {

    private String name;

    public Cat(String name) {
        super(9);
        this.name = name;
    }

    @Override
    public String speak() {
        return "MEOW!";
    }

    public String speak(int num) {
        String response = "";
        for (int i = 0; i < num; i++) {
            response += "MEOW! ";
        }
        return response;
    }

    public int getAge() {
        return super.getAge() * 9;
    }
}
