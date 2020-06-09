/**
 * Purpose:Filter the request from JSP and pass to Login servlet
 */
package login.demo.registration.filter;

import login.demo.registration.model.Customer;
import login.demo.registration.CustomerOperationImplementation;
import login.demo.registration.interfaces.ICustomerOperation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(
        description = "Login servlet testing",
        urlPatterns = ("/Login")
)
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     *
     * @param request from browser
     * @param response to browser
     * @param filterChain to filter result
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest) request;
        HttpSession session= req.getSession();

        ICustomerOperation cd = new CustomerOperationImplementation();
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String submit = request.getParameter("submit");

        System.out.println("filter..........");

        if (submit.equals("Login")) {
            Customer customer = cd.getCustomer(userName, password);
            System.out.println(customer.getUserName());
            if (customer.getUserName() != null) {
                filterChain.doFilter(request,response);

            } else {
                session.setAttribute("Error","Error");
                req.getRequestDispatcher("login.jsp").include(request,response);
                System.out.println("dispatch");

            }
        }
    }

    @Override
    public void destroy() {

    }
}