package facade.subsystems.crm;

import facade.util.Customer;
import facade.util.OnMemoryDataBase;

/**
 * La clase CRMSystem representa al sistema CRM y es utilkziado para consutlar la información del clietne
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class CRMSystem {

	public Customer findCustomer(Long customerId) {
		return OnMemoryDataBase.findCustomerStatus(customerId);
	}
	
}
