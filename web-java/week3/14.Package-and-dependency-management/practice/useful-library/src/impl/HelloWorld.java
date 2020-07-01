package impl;

import Greeter;

public class HelloWorld implements Greeter {
    @Override
    public String greet() {
        return "Hello world";
    }
}
