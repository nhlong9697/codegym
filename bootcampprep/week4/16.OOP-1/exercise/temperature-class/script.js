function Temperature(celcius) {
  this.celcius = celcius;
}

Temperature.prototype.convertToFahrenheit = () => {
  return (parseInt(this.celcius) * 9) / 5 + 32;
};

Temperature.prototype.convertToKevin = () => {
  return parseInt(this.celcius) + 273.15;
};

let temperature = new Temperature(30);
alert(temperature.convertToKevin());
alert(temperature.convertToFahrenheit());
