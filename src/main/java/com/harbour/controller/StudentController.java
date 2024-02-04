package main.java.com.harbour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @GetMapping("/v1/student/name")
  public String getStudentName(@QueryParam(value = "formal") boolean formal) {
    if (formal) {
      return "Hesam Zakeri";
    } else {
      return "Hesam";
    }
  }
}
