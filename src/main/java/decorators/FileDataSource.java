package decorators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Escritor-lector de datos simple, Componente Concreto es una clase de objetos
 * envueltos. Define el comportamiento básico, que los decoradores pueden
 * alterar.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class FileDataSource implements DataSource {

	private String name;

	public FileDataSource(String name) {
		this.name = name;
	}

	@Override
	public void writeData(String data) {
		File file = new File(name);

		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(data.getBytes(), 0, data.length());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String readData() {
		char[] buffer = null;
		File file = new File(name);

		try (FileReader reader = new FileReader(name)) {
			buffer = new char[(int) file.length()];
			reader.read(buffer);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return new String(buffer);

	}

}
