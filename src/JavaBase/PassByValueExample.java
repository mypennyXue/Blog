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

	}

	String getObjectAddress() {
		return super.toString();
	}
}

public class PassByValueExample {
	public static void main(String[] args) {
		Dog dog = new Dog("A");
		System.out.println(dog.getObjectAddress());
		int a = 5;

		func(dog,a);
		System.out.println(a);
		System.out.println(dog.getObjectAddress());
		System.out.println(dog.getName());



	}

	private static void func(Dog dog,int a) {
		System.out.println(dog.getObjectAddress());
//		dog = new Dog("B");
		dog.setName("B");
		System.out.println(dog.getObjectAddress());
		System.out.println(dog.getName());
		a = 10;
		System.out.println(a);
	}
}
