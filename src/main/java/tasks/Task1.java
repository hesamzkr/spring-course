package main.java.tasks;

import java.util.Scanner;

public class Task1 {

  public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int reversedHalf = 0;
    while (x > reversedHalf) {
      reversedHalf = reversedHalf * 10 + x % 10;
      x /= 10;
    }
    return x == reversedHalf || x == reversedHalf / 10;
  }

  public static void main(String[] args) {
    Task1 task = new Task1();

    while (true) {
      Scanner in = new Scanner(System.in);

      System.out.print("Enter a number: ");

      int number = in.nextInt();

      boolean isPalindrome = task.isPalindrome(number);

      if (isPalindrome) {
        System.out.println("The number is a palindrome.");
      } else {
        System.out.println("The number is not a palindrome.");
      }
    }
  }
}
