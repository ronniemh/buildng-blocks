package com.stacksmplify.restservices.sprngbootbuildingblocks.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 */
@RestController
public class HelloWorldController {

      /**
     * Simple Method URI - /helloworld GET
     */
    @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    public String helloWorld() {

        System.out.println("Entrando al método");
        return "Hello World final!";
    }
}