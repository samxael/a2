package decorator_design_pattern;

// Интерфейс Dress устанавливает метод assemble() для сборки одежды.
interface Dress {
	public void assemble();
}

// Класс BasicDress реализует интерфейс Dress, предоставляя базовые характеристики одежды.
class BasicDress implements Dress {
	@Override
	public void assemble() {
		System.out.println("Basic Dress Features");
	}
}

// Класс DressDecorator реализует интерфейс Dress и содержит ссылку на объект Dress, который он декорирует.
class DressDecorator implements Dress {
	protected Dress dress;

	public DressDecorator(Dress c) {
		this.dress = c;
	}

	@Override
	public void assemble() {
		this.dress.assemble();
	}
}

// Класс CasualDress расширяет DressDecorator и добавляет функциональность к обычной одежде, делая ее "casual".
class CasualDress extends DressDecorator {
	public CasualDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Casual Dress Features");
	}
}

// Класс SportyDress также расширяет DressDecorator и добавляет функциональность к обычной одежде, делая ее "sporty".
class SportyDress extends DressDecorator {
	public SportyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Sporty Dress Features");
	}
}

// Класс FancyDress расширяет DressDecorator и добавляет функциональность к обычной одежде, делая ее "fancy".
class FancyDress extends DressDecorator {
	public FancyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Fancy Dress Features");
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		// Создание и сборка разных видов декорированной одежды.
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
