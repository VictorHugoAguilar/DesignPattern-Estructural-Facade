package facade.example_server.facade;

/**
 * Esta clase realiza la implementación de la interfaz IFacade e instancia la
 * calse ScheduleServer que simula la inicialización y apagado de un servidor.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class FacadeImpl implements IFacade {

	private final SheduleServer server;

	public FacadeImpl(SheduleServer server) {
		this.server = server;
	}

	@Override
	public void startServer() {
		server.readSystemConfigFile();
		server.init();
		server.initializeContext();
	}

	@Override
	public void stopServer() {
		server.destroy();
		server.shutdown();
	}

}
