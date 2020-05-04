package com.codegym;
public class Car {
  private String _name;
  private String _engine;

  public static int numberOfCars;

  public Car(String name, String engine) {
    this._name = name;
    this._engine = engine;
    numberOfCars++;
  }
  public String getName() {
    return this._name;
  }
  public void setName(String name) {
    this._name = name;
  }
  public String getEngine() {
    return this._engine;
  }
  public void setEngine(String engine) {
    this._engine = engine;
  }
}
