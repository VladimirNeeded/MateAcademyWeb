import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Sign_In")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Client client = new Client(login, password);
        if (check(client)) {
            out.print("Hello, " + login);
        } else {
            out.print("Login or pass are not valid");
        }
    }

    private static boolean check(Client client) {
        for (int i = 0; i < Storage.getSize(); i++) {
            if ((Storage.getClient(i).getLogin().equals(client.getLogin()) && Storage.getClient(i).getPassword().equals(client.getPassword()))) {
                return true;
            }
        }
        return false;
    }
}
