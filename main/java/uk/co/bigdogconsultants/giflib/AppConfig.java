package uk.co.bigdogconsultants.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Steve on 27/01/2016.
 */
@EnableAutoConfiguration
@ComponentScan
public class AppConfig {
    public static void main(String[] args){
        SpringApplication.run(AppConfig.class, args);
    }
}
