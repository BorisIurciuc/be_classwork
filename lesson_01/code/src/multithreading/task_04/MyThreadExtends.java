package lesson_01.multithreading.task_04;

/**
 * 22/07/2024 lesson_01 * @author Boris Iurciuc (cohort36)
 */
public class MyThreadExtends extends Thread {

    public void run() {
      for (int i = 100; i < 110; i++) {
        System.out.println(getName() + " " + i);
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
}
