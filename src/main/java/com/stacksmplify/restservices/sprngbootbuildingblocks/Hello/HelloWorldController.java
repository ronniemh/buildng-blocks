package com.stacksmplify.restservices.sprngbootbuildingblocks.Hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 */
@RestController
public class HelloWorldController {

    @Autowired
    private ResourceBundleMessageSource messageSource;
    /**
     * Simple Method URI - /helloworld GET
     */
    // @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    @GetMapping("/helloworld")
    public String helloWorld() {

        System.out.println("Entrando al método");
        return "Hello World final!";
    }

    @GetMapping("/helloworld-bean")
    public UserDetails helloWorldBean(){
        return new UserDetails("firstName", "lastName", "city");
    }

    @GetMapping("/hello-int")
    public String getMessagesInI18nFormat(@RequestHeader(name = "Accept-Language", required = false) String locale){
        return messageSource.getMessage("label.hello", null, new Locale(locale));
    }

    @GetMapping("/hello-int2")
    public String getMessagesInI18nFormat2(){
        return messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
    }
}