package lesson_01.multithreading.task_04;

/**
 * 22/07/2024 lesson_01
 *
 * @author Boris Iurciuc (cohort36)
 */
public class MyThreadRunable implements Runnable{
@Override
  public void run() {
  for (int i = 10000; i < 10010; i++) {
    System.out.println(Thread.currentThread().getName() + " " + i);

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  }
}
