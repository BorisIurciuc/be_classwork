package lesson_01.multithreading.task_03;

import lesson_01.multithreading.task_03.MyThread;

public class Counter {

  private static int counter;

  public static void main(String[] args) {

    MyThread myThread1 = new MyThread();
    MyThread myThread2 = new MyThread();

    myThread1.start();
    myThread2.start();

    for (int i = 0; i < 1_000_000; i++) {
      counterIncrement();
    }

    try {
      myThread1.join();
      myThread2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("value of counter: " + counter);
  }
  // method for thread synchronization
  public static synchronized void counterIncrement() {
    counter++;
  }
}
