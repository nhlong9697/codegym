let Battery = () => {
  this.setEnergy = (energy) => {
    this.energy = energy;
  };

  this.getEnergy = () => {
    return this.energy;
  };

  this.decreaseEnergy = () => {
    if (this.enerygy > 0) {
      this.energy--;
    }
  };
};

let FlashLamp = () => {
  this.setBattery = (battery) => {
    this.battery = battery;
  };

  this.getBatteryInfo = () => {
    return this.battery.getEnergy;
  };

  this.turnOn = () => {
    this.status = true;
  };

  this.turnOff = () => {
    this.status = false;
  };
  this.light = () => {
    if (this.status) {
      alert("Lightning");
    } else {
      alert("Not lightning");
    }
  };
};

var battery = new Battery();
battery.setEnergy(10);

var flashLamp = new FlashLamp();
flashLamp.setBattery(battery);

document.write("Battery info: " + flashLamp.getBatteryInfo() + "<br/>");
flashLamp.light();

document.write("Turn on <br/>");
flashLamp.turnOn();
flashLamp.light();
document.write("Battery info: " + flashLamp.getBatteryInfo() + "<br/>");

document.write("Turn off <br/>");
flashLamp.turnOff();
flashLamp.light();
