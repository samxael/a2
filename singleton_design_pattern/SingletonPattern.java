// Пример класса Singleton с жадной инициализацией.
class SingletonEager {
  // Единственный экземпляр создается сразу при загрузке класса.
  private static SingletonEager instance = new SingletonEager();

  // Приватный конструктор предотвращает создание экземпляра извне.
  private SingletonEager() {
    // Конструктор оставлен пустым.
  }

  // Метод предоставляет доступ к единственному экземпляру.
  public static SingletonEager getInstance() {
    return instance;
  }
}

// Пример класса Singleton с ленивой инициализацией.
class Singleton {
  private static Singleton instance; // Изначально экземпляр равен null.

  // Приватный конструктор предотвращает создание экземпляра извне.
  private Singleton() {
    // Конструктор оставлен пустым.
  }

  // Метод предоставляет доступ к единственному экземпляру.
  public static Singleton getInstance() {
    if(instance == null) { // Если экземпляр еще не создан...
      instance = new Singleton(); // Создаем новый экземпляр.
    }
    return instance; // Возвращаем единственный экземпляр.
  }
}

// Пример класса Singleton с синхронизированным методом.
class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance;

  // Приватный конструктор предотвращает создание экземпляра извне.
  private SingletonSynchronizedMethod() {
    // Конструктор оставлен пустым.
  }

  // Метод getInstance с синхронизированным блоком, обеспечивающий потокобезопасность.
  public static synchronized SingletonSynchronizedMethod getInstance() {
    if(instance == null) {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// Пример класса Singleton с двойной проверкой и синхронизированным блоком.
class SingletonSynchronized {
  private static SingletonSynchronized instance;

  // Приватный конструктор предотвращает создание экземпляра извне.
  private SingletonSynchronized() {
    // Конструктор оставлен пустым.
  }

  // Метод getInstance с двойной проверкой для оптимизации потокобезопасности.
  public static SingletonSynchronized getInstance() {
    if(instance == null) {
      synchronized (SingletonSynchronized.class) {
        if(instance == null) {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern {
  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
