let products = ["Test"];

showProducts();

function addProduct() {
  let newProduct = document.getElementById("newProduct").value;
  if (newProduct.length != 0) {
    products.push(newProduct);
  }
  document.getElementById("newProduct").value = "";
  showProducts();
}

function showProducts() {
  let table = "";
  products.forEach((product, index) => {
    table +=
      "<tr>" +
      "<td>" +
      (index + 1) +
      "</td>" +
      "<td>" +
      product +
      "</td>" +
      "<td>" +
      '<input type="button" value="Edit" onclick="editProduct(' +
      index +
      ')">' +
      "</td>" +
      "<td>" +
      '<input type="button" value="Delete" onclick="deleteProduct(' +
      index +
      ')">' +
      "</td>" +
      "</tr>";
  });
  document.getElementById("products").innerHTML = table;
  document.getElementById("total").innerHTML = products.length;
}

function editProduct(index) {
  let newProduct = prompt("Enter new product", products[index]);
  products[index] = newProduct;
  showProducts();
}

function deleteProduct(index) {
  products.splice(index, 1);
  showProducts();
}
