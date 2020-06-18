import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    double listPrice = Double.parseDouble(request.getParameter("listPrice"));
    double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
    String productDescription = request.getParameter("productDescription");

    double discountAmount = listPrice * discountPercent * 0.01;

    PrintWriter writer = response.getWriter();

    writer.println("<html>");
    writer.println("<p>The product is " + productDescription + "</p>");
    writer.println("<p>The product's price is " + listPrice + "</p>");
    writer.println("<p>The product's discount percent is " + discountPercent + "</p>");
    writer.println("<p>The product's discount amount is " + discountAmount + "</p>");
    writer.println("</html>");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
