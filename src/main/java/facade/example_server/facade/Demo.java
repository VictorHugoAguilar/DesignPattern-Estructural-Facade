package facade.example_server.facade;

public class Demo {

	public static void main(String[] args) {
		SheduleServer server = new SheduleServer();
		
		IFacade facade = new FacadeImpl(server);
		facade.startServer();
		System.out.println("Start server");
		
		facade.stopServer();
		System.out.println("Stop server");
		
		
	}
	
}
