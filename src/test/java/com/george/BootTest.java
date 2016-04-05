package com.george;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
public class BootTest {

    /* @RequestMapping("/")
     String home() {
         return "Hello World!";
     }
 */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootTest.class, args);
    }

}
