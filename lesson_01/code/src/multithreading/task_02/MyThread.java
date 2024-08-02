package lesson_01.multithreading.task_02;

/**
 * 22/07/2024 lesson_01 * @author Boris Iurciuc (cohort36)
 */
public class MyThread  extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 1_000_000; i++) {
      Counter.counter++;
    }
  }

}
