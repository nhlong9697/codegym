public class FactoryDemo {
  public static void main(String[] args) {
    AnimalFactory animalFactory = new AnimalFactory();

    Animal animal1 = animalFactory.getAnimal("dog");
    System.out.println(animal1.makeSound());

    Animal animal2 = animalFactory.getAnimal("cat");
    System.out.println(animal2.makeSound());
  }
}
