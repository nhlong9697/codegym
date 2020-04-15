function Circle(radius) {
  this.radius = radius
  this.GetArea = () => {
    return this.radius*this.radius*Math.PI
  }
  this.GetPerimeter = () => {
    return this.radius*2*Math.PI
  }
  this.drawCanvas = () => {
    let canvas = document.getElementById("circle")
    let ctx = document.getElementById("circle").getContext("2d");
    ctx.arc(canvas.width / 2, canvas.height /2, this.radius, 0, 2 * Math.PI, false)
    ctx.fillStyle = 'green';
    ctx.fill();
  }
}

let circle1 = new Circle(15);
circle1.drawCanvas();