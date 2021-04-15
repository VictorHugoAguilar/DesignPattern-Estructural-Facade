package decorators;

import java.util.Base64;

/**
 * Decorador de codificación, Los Decoradores Concretos definen funcionalidades
 * adicionales que se pueden añadir dinámicamente a los componentes. Los
 * decoradores concretos sobrescriben métodos de la clase decoradora base y
 * ejecutan su comportamiento, ya sea antes o después de invocar al método
 * padre.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class EncryptionDecorator extends DataSourceDecorator {

	public EncryptionDecorator(DataSource source) {
		super(source);
	}

	@Override
	public void writeData(String data) {
		super.writeData(encode(data));
	}

	@Override
	public String readData() {
		return decode(super.readData());
	}

	private String encode(String data) {
		byte[] result = data.getBytes();
		for (int i = 0; i < result.length; i++) {
			result[i] += (byte) 1;
		}
		return Base64.getEncoder().encodeToString(result);
	}

	private String decode(String data) {
		byte[] result = Base64.getDecoder().decode(data);
		for (int i = 0; i < result.length; i++) {
			result[i] -= (byte) 1;
		}
		return new String(result);
	}

}
