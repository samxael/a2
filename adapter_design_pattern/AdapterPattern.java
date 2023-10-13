package adapter_design_pattern;

// Интерфейс WebDriver устанавливает методы для работы с браузером
interface WebDriver {
	public void getElement(); // Получить элемент
	public void selectElement(); // Выбрать элемент
}

// Класс ChromeDriver реализует интерфейс WebDriver для работы с Chrome браузером
class ChromeDriver implements WebDriver {
	@Override
	public void getElement() {
		System.out.println("Получить элемент из ChromeDriver");
	}

	@Override
	public void selectElement() {
		System.out.println("Выбрать элемент из ChromeDriver");
	}
}

// Класс IEDriver предоставляет методы для работы с Internet Explorer браузером
class IEDriver {
	public void findElement() {
		System.out.println("Найти элемент в IEDriver");
	}

	public void clickElement() {
		System.out.println("Нажать на элемент в IEDriver");
	}
}

// Класс WebDriverAdapter позволяет использовать IEDriver как реализацию WebDriver
class WebDriverAdapter implements WebDriver {
	IEDriver ieDriver;

	public WebDriverAdapter(IEDriver ieDriver) {
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement() {
		ieDriver.findElement();
	}

	@Override
	public void selectElement() {
		ieDriver.clickElement();
	}
}

public class AdapterPattern {
	public static void main(String[] args) {
		// Использование ChromeDriver
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.getElement();
		chromeDriver.selectElement();

		// Использование IEDriver
		IEDriver ieDriver = new IEDriver();
		ieDriver.findElement();
		ieDriver.clickElement();

		// Использование IEDriver через адаптер WebDriverAdapter
		WebDriver webDriver = new WebDriverAdapter(ieDriver);
		webDriver.getElement();
		webDriver.selectElement();
	}
}
