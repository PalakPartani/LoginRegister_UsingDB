/**
 * Purpose:Filter the request from JSP and pass to Register servlet
 */
package login.demo.registration.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(
        description = "Registration servlet testing",
        urlPatterns = ("/Register")
)

public class RegistrationFilter implements Filter {
    static String NAME_PATTERN = "^[A-Z][a-z]{2,}$";
    static String ADDRESS_PATTERN = "^[A-Z][a-z]{1,}$";
    static String REGEX_PASSWORD = "^((?=[^\\W\\_]*[\\W\\_][^\\W\\_]*$)(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9\\W\\_]{8,})$";
    static String EMAIL_ID = "^\\w{3,}([-._+]\\w+)?@\\w+.[a-z]{2,4}([.][a-z]{2,4})?$";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * @param request     from browser
     * @param response    to browser
     * @param filterChain to filter the result
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String user = request.getParameter("name");
        String address = request.getParameter("address");
        String pwd = request.getParameter("password");
        String submit = request.getParameter("submit");
        String email = request.getParameter("email");

        System.out.println("filter..........");
        if (submit.equals("Register")) {

            System.out.println("hi reg");
            boolean nameMatch = user.matches(NAME_PATTERN);
            boolean passwordMatch = pwd.matches(REGEX_PASSWORD);
            boolean addressMatch = address.matches(ADDRESS_PATTERN);
            boolean emailMatch = email.matches(EMAIL_ID);

            if (nameMatch && passwordMatch && addressMatch && emailMatch) {
                System.out.println("req " + request);
                System.out.println("res " + response);
                filterChain.doFilter(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("window.alert('Invalid details!!! ');window.location.href='register.jsp'");
                out.println("</script>");
            }
            System.out.println("terminate");
        }
    }

    @Override
    public void destroy() {
    }
}
