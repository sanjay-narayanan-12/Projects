package com.sanjaynarayanan.corejava.lambda;

interface Drawable {
	void draw();
}

interface Sayable {
	String say(String name);
}

interface Addable {
	int add(int a, int b);
}

public class LambdaExpressions {

	public static void withOutLambda(int width) {
		// without lambda, Drawable implementation using anonymous class
		Drawable d = new Drawable() {
			public void draw() {
				System.out.println("Drawing " + width);
			}
		};
		d.draw();
	}

	public static void withLambda(int width) {
		Addable add = (int x, int y) -> (x + y);
		Sayable say = name -> name;
		// with lambda, Drawable implementation
		Drawable d = () -> System.out.println("Drawing " + width);
		d.draw();
		System.out.println(add.add(width, 20));
		System.out.println(say.say("Sanjay"));
	}

	/**
	 * reference constructor method
	 */
	interface Messageable {
		Message getMessage(String msg);
	}

	class Message {
		Message(String msg) {
			System.out.print(msg);
		}

		void referenceMethodCall() {
			Messageable messageable = Message::new; // reference constructor method
			messageable.getMessage("Sanjay");
		}
	}

}
