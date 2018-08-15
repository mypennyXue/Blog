package JavaBase;

import javax.sound.midi.Soundbank;

class Dog {
	String name;

	Dog(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getObjectAddress() {
		return super.toString();
	}
}

public class PassByValueExample {
	public static void main(String[] args) {
		Dog dog = new Dog("A");
		System.out.println(dog.getObjectAddress());
		func(dog);
		System.out.println(dog.getObjectAddress());
		System.out.println(dog.getName());
		System.out.println("============================");

		testStringBuffer();
	}
	private static void func(Dog dog) {
		System.out.println(dog.getObjectAddress());
		dog = new Dog("B");
		dog.setName("B");
		System.out.println(dog.getObjectAddress());
		System.out.println(dog.getName());
	}

	public static void testStringBuffer() {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		operator(a, b);
		System.out.println(a + "," + b);
	}

	public static void operator(StringBuffer x, StringBuffer y) {
		x.append(y);
		y = x;
	}
}
