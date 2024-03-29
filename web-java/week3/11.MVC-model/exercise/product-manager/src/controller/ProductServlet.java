package controller;

import model.Product;
import service.ProductDAO;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
  private final ProductService productService = new ProductDAO();
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch(action) {
      case "add":
        addProduct(request,response);
        break;
      case "delete":
        deleteProduct(request,response);
        break;
      case "edit":
        editProduct(request,response);
      default:
        break;
    }
  }

  private void editProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    String productName = request.getParameter("productName");
    int price = Integer.parseInt(request.getParameter("price"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String color = request.getParameter("color");
    String description = request.getParameter("description");
    String category = request.getParameter("category");
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      product.setProductName(productName);
      product.setPrice(price);
      product.setQuantity(quantity);
      product.setColor(color);
      product.setDescription(description);
      product.setCategory(category);
      this.productService.update(id, product);
      request.setAttribute("product", product);
      request.setAttribute("message", "Product information was updated");
      dispatcher = request.getRequestDispatcher("product/edit.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if (product == null) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      this.productService.remove(id);
    }
    try {
      response.sendRedirect("/products");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void addProduct(HttpServletRequest request, HttpServletResponse response) {
    String productName = request.getParameter("productName");
    int price = Integer.parseInt(request.getParameter("price"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String color = request.getParameter("color");
    String description = request.getParameter("description");
    String category = request.getParameter("category");

    Product newProduct = new Product(productName,price,quantity,color,description,category);
    this.productService.add(newProduct);

    request.setAttribute("message","New product is added");
    try {
      request.getRequestDispatcher("product/add.jsp").forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }



  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "add":
        showAddForm(request,response);
        break;
      case "delete":
        showDeleteForm(request,response);
        break;
      case "edit":
        showEditForm(request,response);
        break;
      case "view":
        viewProduct(request,response);
        break;
      case "search":
        searchProduct(request,response);
        break;
      case "sort":
        sortProduct(request,response);
        break;
      default:
        listProduct(request,response);
        break;
    }
  }

  private void sortProduct(HttpServletRequest request, HttpServletResponse response) {
    String categoryToSort = request.getParameter("categoryToSort");
    List<Product> sortedProducts = this.productService.sortBy(categoryToSort);
    request.setAttribute("products", sortedProducts);
    try {
      request.getRequestDispatcher("product/list.jsp").forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
      request.setAttribute("message","Id " + id + " not found to view");
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("product", product);
      dispatcher = request.getRequestDispatcher("product/view.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("product", product);
      dispatcher = request.getRequestDispatcher("product/edit.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if (product == null) {
      request.setAttribute("message","can't find the id to delete");
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("product", product);
      dispatcher = request.getRequestDispatcher("product/delete.jsp");
    }
    try {
      dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
    try {
      request.getRequestDispatcher("product/add.jsp").forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }
  private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
    String nameToSearch = request.getParameter("nameToSearch");
    List<Product> foundProduct = this.productService.findByName(nameToSearch);
    request.setAttribute("products", foundProduct);
    request.setAttribute("message","Found " + foundProduct.size() + " product(s)");
    try {
      request.getRequestDispatcher("product/list.jsp").forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void listProduct(HttpServletRequest request, HttpServletResponse response) {
    List<Product> productList = this.productService.findAll();
    request.setAttribute("products", productList);

    try {
      request.getRequestDispatcher("product/list.jsp").forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }
}
