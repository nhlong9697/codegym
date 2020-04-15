let c = document.getElementById("myCanvas");
let ctx = c.getContext("2d");
function Rectangle(width, height) {
  this.width = width;
  this.height = height;
  this.area = () => {
    return width * height;
  };
  this.perimeter = () => {
    return 2 * (width + height);
  };
  this.drawCanas = function () {
    let ctx = document.getElementById("myCanvas").getContext("2d");
    //reset cursor to default postion
    ctx.beginPath();
    ctx.lineWidth = "6";
    ctx.strokeStyle = "blue";
    ctx.rect(20, 20, this.width, this.height);
    ctx.fillStyle = "red";
    ctx.fill();
    ctx.stroke();
  };
  this.setWidth = (width) => {
    this.width = width;
  };
  this.setHeight = (height) => {
    this.height = height;
  };
}

let rectangle = new Rectangle(250, 180);
rectangle.drawCanas();
rectangle.setHeight(90);
rectangle.setWidth(125);
alert(rectangle.area());
alert(rectangle.perimeter());
