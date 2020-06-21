package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

  private final CustomerService customerService = new CustomerServiceImpl();
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch(action) {
      case "creat":
        createCustomer(request,response);
        break;
      case "delete":
        deleteCustomer(request,response);
        break;
      case "edit":
        editCustomer(request,response);
        break;
      default:
        break;
    }
  }

  private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Customer customer = this.customerService.findById(id);
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    RequestDispatcher dispatcher;
    if (customer == null) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      customer.setName(name);
      customer.setEmail(email);
      customer.setAddress(address);
      request.setAttribute("customer",customer);
      request.setAttribute("message","Customer information is updated");
      dispatcher = request.getRequestDispatcher("customer/edit.jsp");
    }
    try {
      dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Customer customer = this.customerService.findById(id);
    RequestDispatcher dispatcher;
    if (customer == null) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      this.customerService.remove(id);
    }
    try {
      response.sendRedirect("/customers");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
    int id = (int) (Math.random() * 10000);
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    Customer newCustomer = new Customer(id,name,email,address);
    this.customerService.save(newCustomer);
    RequestDispatcher dispatcher = request.getRequestDispatcher("customer/creat.jsp");
    request.setAttribute("message", "New customer was created");
    try {
      dispatcher.forward(request,response);
    } catch (IOException | ServletException exception) {
      exception.printStackTrace();
    }
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "create":
        showAddForm(request,response);
        break;
      case "edit":
        showEditForm(request,response);
        break;
      case "delete":
        showDeleteForm(request,response);
        break;
      case "view":
        viewCustomer(request,response);
        break;
      default:
        listCustomer(request,response);
        break;
    }
  }

  private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
    RequestDispatcher dispatcher = request.getRequestDispatcher("customer/add.jsp");
    try {
      dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Customer customer = this.customerService.findById(id);
    RequestDispatcher dispatcher;
    if (customer == null) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("customer", customer);
      dispatcher = request.getRequestDispatcher("customer/edit.jsp");
    }
    try {
      dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Customer customer = this.customerService.findById(id);
    RequestDispatcher dispatcher;
    if (customer == null) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("customer", customer);
      dispatcher = request.getRequestDispatcher("customer/delete.jsp");
    }
    try {
      dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }
  private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
    List<Customer> customerList = this.customerService.findAll();
    request.setAttribute("customers", customerList);

    RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");

    try {
      dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Customer customer = customerService.findById(id);
    RequestDispatcher dispatcher;
    if (customer != null) {
      request.setAttribute("customer",customer);
      dispatcher = request.getRequestDispatcher("customer/view.jsp");
    } else {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    }
    try {
      dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }
}
