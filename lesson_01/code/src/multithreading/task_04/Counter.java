package lesson_01.multithreading.task_04;



/**
 * 22/07/2024 lesson_01 * @author Boris Iurciuc (cohort36)
 */
public class Counter {

  public static void main(String[] args) throws InterruptedException {
    // 1
    MyThreadExtends myThreadExtends = new MyThreadExtends();
    // 2
    MyThreadRunable myThreadRunable = new MyThreadRunable();
    Thread thread = new Thread(myThreadRunable);

    thread.setDaemon(true);

  myThreadExtends.start();
  thread.start();

    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }
  }
}
