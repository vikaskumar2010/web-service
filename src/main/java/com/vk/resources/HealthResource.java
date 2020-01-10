package com.vk.resources;

import org.springframework.web.bind.annotation.*;

@RestController
public class HealthResource {

  @RequestMapping(path = "/alive", method = RequestMethod.GET)
  public String getApplicationStatus() {
    return "It's up and running!";
  }

}
