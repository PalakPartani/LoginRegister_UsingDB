package login.demo.registration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
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
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest) request;

        ICustomerOperation cd = new CustomerOperationImplementation();
        String user = request.getParameter("name");
        String pwd = request.getParameter("password");
    //    String address = request.getParameter("address");
        String submit = request.getParameter("submit");

        System.out.println("filter..........");

        if (submit.equals("Login")) {
            // check login user
            Customer c = cd.getCustomer(user, pwd);
            System.out.println(c.getUserName());
            if (c.getUserName() != null) {
                filterChain.doFilter(request,response);

            } else {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("window.alert('Username and Password Incorrect ');window.location.href='login.jsp'");
                out.println("</script>");
                System.out.println("before dispatch");
                //request.getRequestDispatcher("login.jsp").forward(request, response);
                System.out.println("after dispatch");
            }
        }
    }

    @Override
    public void destroy() {

    }
}