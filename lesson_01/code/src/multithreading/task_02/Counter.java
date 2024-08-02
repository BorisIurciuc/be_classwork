package lesson_01.multithreading.task_02;

import lesson_01.multithreading.task_03.MyThread;

/**
 * 22/07/2024 lesson_01 * @author Boris Iurciuc (cohort36)
 */
public class Counter {
  public static int counter;

  public static void main(String[] args) {
    MyThread myThread1 = new MyThread(); //create object
    MyThread myThread2 = new MyThread(); //create object

    myThread1.start(); // this thread inside
    myThread2.start(); // this thread inside

    for (int i = 0; i < 1_000_000; i++) {
      counter++;
    }
    try {
      myThread1.join(); // to main
      myThread2.join(); // to main
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Value of counter: " + counter);
  }
}
