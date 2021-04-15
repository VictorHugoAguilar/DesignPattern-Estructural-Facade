package facade.util;

import java.util.HashMap;


public class OnMemoryDataBase {

	private static final HashMap<Long, Customer> CUSTOMER_MAP = new HashMap<>();
	private static final HashMap<String, Card> CARD_BINS = new HashMap<>();

	static {
		CUSTOMER_MAP.put(1L, new Customer(1L, "Victor Aguilar", 1000, "Activo"));
		CUSTOMER_MAP.put(2L, new Customer(2L, "Paula Rodriguez", 2200, "Activo"));
		CUSTOMER_MAP.put(3L, new Customer(3L, "Coquis Rodriguez", 1400, "Suspendido"));
		CUSTOMER_MAP.put(4L, new Customer(4L, "Carlos Lorenzo", 1200, "Baja"));

		CARD_BINS.put("123", new Card("123", "VISA", "Credit"));
		CARD_BINS.put("234", new Card("234", "MASTERCARD", "Debit"));
		CARD_BINS.put("345", new Card("345", "AMEX", "Credit"));
	}

	public static Customer findCustomerStatus(Long id) {
		return CUSTOMER_MAP.get(id);
	}

	public static void changeCustomerStatus(Long id, String newStatus) {
		Customer customer = findCustomerStatus(id);
		customer.setStatus(newStatus);
		System.out.println("Cambio de status del cliente " + customer.getName() + " " + newStatus);
	}

	public static boolean validateCardBins(String creditCardPrefix) {
		if (CARD_BINS.containsKey(creditCardPrefix)) {
			String company = CARD_BINS.get(creditCardPrefix).getCompany();
			System.out.println("Tarjeta válida > " + creditCardPrefix + ", " + company + "\n");
			return true;
		}

		System.out.println("Tajera no válida >\n");
		return false;
	}

	public static String getCardCompany(String creditCardPrefix) {
		if (CARD_BINS.containsKey(creditCardPrefix)) {
			return CARD_BINS.get(creditCardPrefix).getCompany();
		}
		throw new RuntimeException("Tarjeta no válida");
	}
}
