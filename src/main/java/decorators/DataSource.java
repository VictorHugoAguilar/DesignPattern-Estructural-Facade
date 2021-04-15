package decorators;

/**
 * Interfaz común para los componentes. El Componente declara la interfaz común
 * tanto para wrappers como para objetos envueltos.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public interface DataSource {

	void writeData(String data);

	String readData();

}
