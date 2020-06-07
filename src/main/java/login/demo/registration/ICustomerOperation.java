package login.demo.registration;

public interface ICustomerOperation {
    int insertCustomer(Customer c);

    Customer getCustomer(String userName, String passwd);

    Customer getCustomer(String emailId);
}
