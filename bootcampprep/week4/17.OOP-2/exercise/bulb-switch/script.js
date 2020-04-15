function SwitchButton(status, lamp) {
  this.status = status;
  this.lamp = lamp;

  this.connectToLamp = (lamp) => {
    this.lamp = lamp;
  };

  this.switchOff = () => {
    this.status = false;
    this.lamp.turnOff();
  };

  this.switchOn = () => {
    this.status = true;
    this.lamp.turnOn();
  };
}

function ElectricLamp(status) {
  this.status = status;

  this.turnOff = () => {
    this.status = false;
  };

  this.turnOn = () => {
    this.status = true;
  };
}
