package login.demo.registration.interfaces;

import login.demo.registration.model.Customer;

public interface ICustomerOperation {
    int insertCustomer(Customer c);

    Customer getCustomer(String userName, String passwd);

    Customer getCustomer(String emailId);
}
