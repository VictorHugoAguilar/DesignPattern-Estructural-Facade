package facade.example_server.facade;

public class SheduleServer {
	
	public void init() {
		System.out.println("Inicialización");
	}
	
	public void initializeContext() {
		System.out.println("Inicialización context");
	}
	
	public void destroy() {
		System.out.println("Destroying");
	}
	
	public void shutdown() {
		System.out.println("Suthdown down...");
	}
	
	public void readSystemConfigFile() {
		System.out.println("Reading system config files...");
		try {
			Thread.sleep(1000);
			System.out.println("Config files OK!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
