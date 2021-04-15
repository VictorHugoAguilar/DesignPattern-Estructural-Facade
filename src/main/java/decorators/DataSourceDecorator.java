package decorators;

/**
 * Decorador abstracto base. La clase Decoradora Base tiene un campo para
 * referenciar un objeto envuelto. El tipo del campo debe declararse como la
 * interfaz del componente para que pueda contener tanto los componentes
 * concretos como los decoradores. La clase decoradora base delega todas las
 * operaciones al objeto envuelto.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class DataSourceDecorator implements DataSource {

	private DataSource wrappee;

	DataSourceDecorator(DataSource source) {
		this.wrappee = source;
	}

	@Override
	public void writeData(String data) {
		wrappee.writeData(data);
	}

	@Override
	public String readData() {
		return wrappee.readData();
	}

}
