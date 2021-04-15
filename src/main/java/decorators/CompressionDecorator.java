package decorators;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * Decorador de compresión, Los Decoradores Concretos definen funcionalidades
 * adicionales que se pueden añadir dinámicamente a los componentes. Los
 * decoradores concretos sobrescriben métodos de la clase decoradora base y
 * ejecutan su comportamiento, ya sea antes o después de invocar al método
 * padre.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class CompressionDecorator extends DataSourceDecorator {
	private int compLevel = 6;

	public CompressionDecorator(DataSource source) {
		super(source);
	}

	public int getCompressionLevel() {
		return compLevel;
	}

	public void setCompressionLevel(int value) {
		compLevel = value;
	}

	@Override
	public void writeData(String data) {
		super.writeData(compress(data));
	}

	@Override
	public String readData() {
		return decompress(super.readData());
	}

	private String compress(String stringData) {
		byte[] data = stringData.getBytes();
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
			DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
			dos.write(data);
			dos.close();
			bout.close();
			return Base64.getEncoder().encodeToString(bout.toByteArray());
		} catch (IOException ex) {
			return null;
		}
	}

	private String decompress(String stringData) {
		byte[] data = Base64.getDecoder().decode(stringData);
		try {
			InputStream in = new ByteArrayInputStream(data);
			InflaterInputStream iin = new InflaterInputStream(in);
			ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
			int b;
			while ((b = iin.read()) != -1) {
				bout.write(b);
			}
			in.close();
			iin.close();
			bout.close();
			return new String(bout.toByteArray());
		} catch (IOException ex) {
			return null;
		}
	}
}
