public class Bear {
	private String furColor;
	private int clawLength;
	private String hibernationSeason;
	private String name;

	/*
	Note: I didn't name the params the same as the instance
	variables to shorten recitation time. You can also do
		this.name = name;

	This basically says "take the local variable name and assign
	it to the instance variable name." You can also do
		this.name = n
	and will do the same thing.

	This is variable shadowing.
	*/
	public Bear(String n, String f, int c, String h) {
		furColor = f;
		clawLength = c;
		hibernationSeason = h;
		setName(n);	// invariant
	}

	public void sleep() {
		System.out.println("Zzzzzz...");
	}

	public void introduce() {
		System.out.println("Hi my name is " + name);
	}

	public void setName(String n) {
		if (n.equals("window")) {
			System.out.println("i don't wanna be called window :(");
			System.exit(0);
		}
		name = n;
	}

	public static void main(String[] args) {
		Bear grizzly = new Bear("Grizzly", "brown", 5, "winter");
		grizzly.introduce();
		Bear bobble = new Bear("window", "rainbow", 0, null);
		bobble.introduce();
	}
}