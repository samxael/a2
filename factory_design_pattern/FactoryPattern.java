package factory_design_pattern;

// Абстрактный класс Vehicle предоставляет метод getWheel() и переопределяет метод toString().
abstract class Vehicle {
	public abstract int getWheel();

	public String toString() {
		return "Wheel: " + this.getWheel();
	}
}

// Класс Car расширяет Vehicle и представляет собой автомобиль.
class Car extends Vehicle {
	int wheel;

	Car(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Класс Bike также расширяет Vehicle и представляет собой велосипед.
class Bike extends Vehicle {
	int wheel;

	Bike(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Класс VehicleFactory отвечает за создание экземпляров разных типов транспортных средств.
class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if (type.equals("car")) {
			return new Car(wheel);
		} else if (type.equals("bike")) {
			return new Bike(wheel);
		}
		return null;
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		// Создание объекта car с использованием фабрики
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		// Создание объекта bike с использованием фабрики
		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
