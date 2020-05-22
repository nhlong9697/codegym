import java.util.Random;

public class Car implements Runnable {
  private String name;

  public Car(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    //initialize starting point
    int runDistance = 0;

    //initialize starting time
    long startTime = System.currentTimeMillis();

    //check to distance
    while(runDistance < Main.DISTANCE) {
      try {
        //Random speed
        int speed = (new Random()).nextInt(20);
        //Calculate traveled distanced
        runDistance += speed;
        //Build result graphic
        StringBuilder log = new StringBuilder("|");
        int percentTravel = (runDistance * 100) / Main.DISTANCE;
        for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
          if (percentTravel >= i + Main.STEP) {
            log.append("=");
          } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
            log.append("o");
          } else {
            log.append("-");
          }
        }
        log.append("|");
        System.out.println("Car" + this.name + ": " + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("Car " + this.name + " is broken");
        break;
      }
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Car " + this.name + " finish in " + (endTime - startTime) / 1000 + "s");
  }
}
