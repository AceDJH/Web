import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Author AceDJH
 * @Date 2020/3/1 19:12
 */
// @WebServlet({"/demo1","/*"})
@WebServlet("/demo1")
public class ServletDemo1 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hehe");
    }
}
