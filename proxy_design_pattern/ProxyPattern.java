package proxy_design_pattern;

// Интерфейс DatabaseExecuter определяет метод для выполнения запроса к базе данных.
interface DatabaseExecuter {
	void executeDatabase(String query) throws Exception;
}

// Класс DatabaseExecuterImpl реализует интерфейс DatabaseExecuter и представляет собой реального исполнителя.
class DatabaseExecuterImpl implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute Query: " + query);
	}
}

// Класс DatabaseExecuterProxy реализует интерфейс DatabaseExecuter и представляет прокси-объект.
class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd) {
		if (name.equals("Admin") && passwd.equals("Admin@123")) {
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception {
		if (ifAdmin) {
			dbExecuter.executeDatabase(query);
		} else {
			if (query.equals("DELETE")) {
				throw new Exception("DELETE not allowed for non-admin user");
			} else {
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

public class ProxyPattern {
	public static void main(String[] args) throws Exception {
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE");

		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE");
	}
}
