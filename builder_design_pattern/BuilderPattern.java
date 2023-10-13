package builder_design_pattern;

// Класс Vehicle представляет транспортное средство и имеет характеристики: двигатель, колеса, подушки безопасности
class Vehicle {
  private String engine;
  private int wheel;
  private int airbags;

  // Геттеры для характеристик
  public String getEngine() {
    return this.engine;
  }

  public int getWheel() {
    return this.wheel;
  }

  public int getAirbags() {
    return this.airbags;
  }

  // Приватный конструктор, принимающий объект VehicleBuilder для построения транспортного средства
  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  // Статический вложенный класс VehicleBuilder для пошагового построения транспортного средства
  public static class VehicleBuilder {
    private String engine;
    private int wheel;
    private int airbags;

    // Конструктор принимает основные характеристики
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Метод для установки количества подушек безопасности (необязательный параметр)
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    // Метод для построения объекта Vehicle
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

// Класс BuilderPattern содержит метод main для демонстрации использования паттерна Builder
public class BuilderPattern {
  public static void main(String[] args) {
    // Создание объекта car с помощью VehicleBuilder с указанием двигателя и количества колес
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    // Создание объекта bike с помощью VehicleBuilder с указанием двигателя и количества колес
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Вывод характеристик car
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    // Вывод характеристик bike
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
