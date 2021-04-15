package facade.subsystems.crm;

import java.util.Map;

/**
 * Clase que representa al módulo de envío de correos electronicos
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class EmailSystem {

	public void sendEmail(Map<String, String> values) {
		String templete = 
				"\n***************************************************\n" 
				+"|To: $name\n" 
				+"|from: FacadeSystem\n" 
				+"|\n"
				+"|Muchas gracias por utilizar el servicio en \n" 
				+"|linea para realizar sus pagos\n" + "|\n"
				+"|Hace un momento acabamos de recibir un pago: \n" 
				+"|\n" 
				+"|Monto del pago: $amount €\n"
				+"|Nuevo Saldo: $newBalance €\n" 
				+"|Tarjeta terminación: $cardNumber\n"
				+"|Referencia de pago: $reference\n"
				+"|Nuevo status: $newStatus\n"
				+"|\n"
				+"|Gracias por su presencia.\n"
				+"|Este correo no deberá ser contestado ya que\n"
				+"|ha sido enviado por un proceso automático"
				+"\n***************************************************\n";

		for (String str : values.keySet()) {
			templete = templete.replace(str, values.get(str));
		}

		System.out.println(templete);
	}
}
