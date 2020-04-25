const GAMEBOARD_WIDTH = 500;
const GAMEBOARD_HEIGHT = 500;

const DIRECTION_LEFT = 180;
const DIRECTION_RIGHT = 360;
const DIRECTION_UP = 270;
const DIRECTION_DOWN = 90;

const CAR_WIDTH = 100;
const CAR_HEIGHT = 100;

const PRIZE_WIDTH = 10;
const PRIZE_HEIGHT = 10;

const OBSTACLE_WIDTH = 10;
const OBSTACLE_HEIGHT = 10;

const DEFAULT_CAR_DIRECTION = DIRECTION_RIGHT;
const DEFAULT_CAR_SPEED = 50;

const CAR_IMAGE = "./images/car.jpg";
const PRIZE_IMAGE = "./images/prize.jpg";
const OBSTACLE_IMAGE = "./images/obstacle.jpg";

function Car() {
  this.xPosition = Math.floor(
    Math.random() * (GAMEBOARD_WIDTH - CAR_WIDTH + 1)
  );
  this.yPosition = Math.floor(
    Math.random() * (GAMEBOARD_HEIGHT - CAR_HEIGHT + 1)
  );
  this.direction = DEFAULT_CAR_DIRECTION;
  this.speed = DEFAULT_CAR_SPEED;
  this.image = CAR_IMAGE;

  this.move = () => {
    switch (this.direction) {
      case DIRECTION_DOWN:
        if (this.yPosition + this.speed < GAMEBOARD_HEIGHT - CAR_HEIGHT) {
          this.yPosition += this.speed;
        } else {
          this.yPosition = GAMEBOARD_HEIGHT - CAR_HEIGHT;
        }
        break;
      case DIRECTION_UP:
        if (this.yPosition - this.speed > 0) {
          this.yPosition -= this.speed;
        } else {
          this.yPosition = 0;
        }
        break;
      case DIRECTION_RIGHT:
        if (this.xPosition + this.speed < GAMEBOARD_WIDTH - CAR_WIDTH) {
          this.xPosition += this.speed;
        } else {
          this.xPosition = GAMEBOARD_WIDTH - CAR_WIDTH;
        }
        break;
      case DIRECTION_LEFT:
        if (this.xPosition - this.speed > 0) {
          this.xPosition -= this.speed;
        } else {
          this.xPosition = 0;
        }
        break;
    }
  };

  this.turn = (direction) => {
    this.direction = direction;
  };

  this.speedUp = () => {
    this.speed += 10;
  };

  this.slowDown = () => {
    this.speed -= 10;
  };

  this.show = (ctx) => {
    let image = new Image();
    let xPosition = this.xPosition;
    let yPosition = this.yPosition;
    image.src = this.image;
    image.onload = () => {
      ctx.save();
      ctx.translate(
        // xPosition,
        // yPosition
        xPosition + 0.5 * CAR_WIDTH,
        yPosition + 0.5 * CAR_HEIGHT
      );
      ctx.rotate((Math.PI / 180) * this.direction);
      // ctx.translate(
      //   // -xPosition,
      //   // -yPosition
      //   -0.5 * image.width,
      //   -0.5 * image.height
      // );
      ctx.drawImage(
        image,
        -0.5 * CAR_WIDTH,
        -0.5 * CAR_HEIGHT,
        CAR_WIDTH,
        CAR_HEIGHT
      );
      ctx.restore();
    };
  };
}

function Board(car, prize, obstacle) {
  this.car = car;
  this.prize = prize;
  this.obstacle = obstacle;
  this.ctx = undefined;
  this.start = () => {
    this.ctx = document.getElementById("gameCanvas").getContext("2d");
    this.car.show(this.ctx);
    this.listenEvent();
    this.prize.show(this.ctx);
    this.obstacle.show(this.ctx);
  };

  this.render = () => {
    this.ctx.clearRect(0, 0, GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
    this.car.show(this.ctx);
    this.prize.show(this.ctx);
    this.obstacle.show(this.ctx);
  };

  this.moveCar = (event) => {
    let direction = 0;
    switch (event.which) {
      case 37:
        direction = DIRECTION_LEFT;
        break;
      case 38:
        direction = DIRECTION_UP;
        break;
      case 39:
        direction = DIRECTION_RIGHT;
        break;
      case 40:
        direction = DIRECTION_DOWN;
        break;
    }

    if (direction) {
      if (this.car.direction !== direction) {
        this.car.turn(direction);
        this.car.move();
      } else {
        this.car.move();
      }
      this.render();
    }
  };
  // fix this bug
  this.changeSpeed = (event) => {
    switch (event.code) {
      case "ControlLeft":
        this.car.speedUp();
        break;
      case "ControlRight":
        this.car.slowDown();
        break;
    }
  };

  this.listenEvent = () => {
    window.addEventListener("keydown", this.moveCar, this.changeSpeed);
  };
}

function Prize() {
  this.xPosition = Math.floor(
    Math.random() * (GAMEBOARD_WIDTH - PRIZE_WIDTH + 1)
  );
  this.yPosition = Math.floor(
    Math.random() * (GAMEBOARD_HEIGHT - PRIZE_HEIGHT + 1)
  );
  this.image = PRIZE_IMAGE;
  this.reset = () => {
    this.yPosition = Math.floor(
      Math.random() * (GAMEBOARD_HEIGHT - PRIZE_HEIGHT + 1)
    );
  };
  this.show = (ctx) => {
    let image = new Image();

    image.src = this.image;
    image.onload = () => {
      ctx.drawImage(image, this.xPosition, this.yPosition);
    };
  };
}

function Obstacle() {}

function Player() {}

function init() {
  let car = new Car();
  let board = new Board(car);
  board.start();
  board.listenEvent();
}
init();
