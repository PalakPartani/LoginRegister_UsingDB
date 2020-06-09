package login.demo.registration.servlet;

import login.demo.registration.model.Customer;
import login.demo.registration.CustomerOperationImplementation;
import login.demo.registration.interfaces.ICustomerOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.*;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = ("/Login")
)

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("hi");
        ICustomerOperation cd = new CustomerOperationImplementation();

        String userName = req.getParameter("name");
        String password = req.getParameter("password");

        HttpSession session= req.getSession();

        Customer customer1 = cd.getCustomer(userName,password);
        session.setAttribute("customers", customer1.getUserName()+" "+customer1.getAddress()+" "+customer1.getEmailId());
        req.getRequestDispatcher("login.jsp").include(req,res);
    }
}
