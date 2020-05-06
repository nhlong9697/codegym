package animal;
import edible.Edible;
public class Chicken extends Animal implements Edible{
  @Override
  public String makeSound() {
    return "I'm a chicken";
  }
  @Override
  public String howToEat() {
    return "could be fried";
  }
}
