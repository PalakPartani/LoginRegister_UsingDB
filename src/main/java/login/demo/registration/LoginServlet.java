package login.demo.registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = ("/Login")
)

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("hi");
        ICustomerOperation cd = new CustomerOperationImplementation();

        String user = req.getParameter("name");
        String pwd = req.getParameter("password");
        Customer c = cd.getCustomer(user, pwd);
        PrintWriter out = res.getWriter();
        HttpSession session= req.getSession();
        session.setAttribute("username",c.getUserName());
        session.setAttribute("email",c.getEmail());
        session.setAttribute("address",c.getAddress());
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Login successfull...!!!! "+c.getUserName()+"');window.location.href='index.jsp'");
        out.println("</script>");
    }
}
