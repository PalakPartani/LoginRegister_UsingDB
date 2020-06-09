package login.demo.registration;

import login.demo.registration.connection.ConnectionProvider;
import login.demo.registration.interfaces.ICustomerOperation;
import login.demo.registration.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerOperationImplementation implements ICustomerOperation {

    static Connection con;
    static PreparedStatement ps;

    @Override
    public int insertCustomer(Customer c) {
        int status = 0;
        try {
            System.out.println("conn ......");
            Connection con = ConnectionProvider.getCon();
            ps = con.prepareStatement("insert into customer(userName,Address,Password,EmailId,RegisteredDate) values (?,?,?,?,CURRENT_TIMESTAMP )");

            ps.setString(1, c.getUserName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getPassword());
            ps.setString(4, c.getEmailId());

            status = ps.executeUpdate();
            System.out.println(status);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public Customer getCustomer(String userName, String passwd) {
        Customer c = new Customer();

        try {
            con = ConnectionProvider.getCon();

            ps = con.prepareStatement("select  * from customer where userName=? and password=?");
            ps.setString(1, userName);
            ps.setString(2, passwd);
            System.out.println(c);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                c.setUserName(resultSet.getString(1));
                c.setAddress(resultSet.getString(2));
                c.setPassword(resultSet.getString(3));
                c.setEmailId(resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public Customer getCustomer(String emailId) {
        Customer c = new Customer();

        try {
            con = ConnectionProvider.getCon();

            ps = con.prepareStatement("select  * from customer where EmailId=?");
            ps.setString(1, emailId);
            System.out.println(c);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                c.setEmailId(resultSet.getString(5));
                System.out.println("..................");
                System.out.println(resultSet.getString("userName"));
                System.out.println(resultSet.getString("Address"));

                System.out.println("..................");
                c.setEmailId(resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }
}