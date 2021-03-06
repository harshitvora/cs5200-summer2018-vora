package edu.northeastern.cs5200.controllers.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    HelloRepository helloRepository;

    @RequestMapping("/api/hello/insert")
    public HelloObject insertHelloObject() {
        HelloObject obj = new HelloObject("Hello Harshit Vora!");
        helloRepository.save(obj);
        return obj;
    }

    @RequestMapping("/api/hello/insert/{msg}")
    public HelloObject insertMessage(@PathVariable("msg") String message) {
        HelloObject obj = new HelloObject(message);
        helloRepository.save(obj);
        return obj;
    }

    @RequestMapping("/api/hello/select/all")
    public List<HelloObject> selectAllHelloObjects() {
        return helloRepository.findAll();
    }

    @RequestMapping("/api/hello/string")
    public String sayHello() {
        return "Hello Harshit Vora!";
    }

    @RequestMapping("/api/hello/object")
    public HelloObject sayHelloObject() {
        return new HelloObject("Hello Harshit Vora!");
    }
}
