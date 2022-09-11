package com.microservices.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {


    @Value("${my.greeting}")
    private String greetingMessage;

    /*
    //default value if property value does not exist in application.property file
    @Value("${my.greeting : this is the default value}")
    private String greetingMessage;
    */

    //static message
    @Value(" this is a static message ")
    private String staticMessage;

    //to display list of values
    @Value("${my.list.values}")
    private List<String> listValue;

    /*
    //keyValue pair
    @Value("#${dbValues}")
    private Map<String,String> dbValues;
    */

    //ConfigurationProperties
    @Autowired
    private dbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting(){
      //  return greetingMessage + staticMessage + listValue;

        return dbSettings.getConnection() + dbSettings.getHost()+ dbSettings.getPort(); //refer dbSettingsclass


    }
}
