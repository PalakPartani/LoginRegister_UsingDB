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

@WebServlet(
        description = "Registration servlet testing",
        urlPatterns = ("/Register")
)
public class RegistrationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ICustomerOperation cd = new CustomerOperationImplementation();

        String userName = req.getParameter("name");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String emailId = req.getParameter("email");
        Customer cr = new Customer();
        cr.setUserName(userName);
        cr.setPassword(password);
        cr.setAddress(address);
        cr.setEmailId(emailId);

        int result = cd.insertCustomer(cr);

        if (result == 0) {
            PrintWriter out = res.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registration not submitted ');");
            out.println("</script>");
        } else {
            PrintWriter out = res.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Registration successfull...!!!! ');window.location.href='login.jsp'");
            out.println("</script>");
        }
    }
}