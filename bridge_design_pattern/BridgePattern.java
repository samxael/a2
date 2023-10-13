package bridge_design_pattern;

// Абстрактный класс TV устанавливает связь с пультом управления и определяет основные операции включения и выключения
abstract class TV {
    Remote remote; // Пульт управления
    TV(Remote r) {
        this.remote = r;
    }
    abstract void on(); // Метод включения
    abstract void off(); // Метод выключения
}

// Класс Sony расширяет абстрактный класс TV, представляя конкретную модель телевизора Sony
class Sony extends TV {
    Remote remoteType; // Тип пульта управления
    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on(); // Включение с использованием соответствующего пульта
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off(); // Выключение с использованием соответствующего пульта
    }
}

// Класс Philips также расширяет абстрактный класс TV, представляя конкретную модель телевизора Philips
class Philips extends TV {
    Remote remoteType; // Тип пульта управления
    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on(); // Включение с использованием соответствующего пульта
    }

    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off(); // Выключение с использованием соответствующего пульта
    }
}

// Интерфейс Remote определяет методы для работы с пультом управления
interface Remote {
    public void on(); // Метод для включения
    public void off(); // Метод для выключения
}

// Класс OldRemote реализует интерфейс Remote, предоставляя старый тип пульта управления
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("Включение с помощью старого пульта");
    }

    @Override
    public void off() {
        System.out.println("Выключение с помощью старого пульта");
    }
}

// Класс NewRemote реализует интерфейс Remote, предоставляя новый тип пульта управления
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("Включение с помощью нового пульта");
    }

    @Override
    public void off() {
        System.out.println("Выключение с помощью нового пульта");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Создание телевизора Sony с использованием старого пульта
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        // Создание телевизора Sony с использованием нового пульта
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        // Создание телевизора Philips с использованием старого пульта
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        // Создание телевизора Philips с использованием нового пульта
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
