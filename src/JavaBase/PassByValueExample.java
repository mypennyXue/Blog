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

	}

	private static void func(Dog dog) {
		System.out.println(dog.getObjectAddress());
		dog = new Dog("B");
		System.out.println(dog.getObjectAddress());
		System.out.println(dog.getName());
	}
}
