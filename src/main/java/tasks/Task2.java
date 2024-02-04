package main.java.tasks;

import java.util.Stack;

public class Task2 {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }

        char top = stack.pop();
        if (
          (c == ')' && top != '(') ||
          (c == '}' && top != '{') ||
          (c == ']' && top != '[')
        ) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Task2 task = new Task2();

    System.out.println(task.isValid("()[]{}")); // Output: true
    System.out.println(task.isValid("(]")); // Output: false
    System.out.println(task.isValid("([)]")); // Output: false
    System.out.println(task.isValid("{[]}")); // Output: true
  }
}
