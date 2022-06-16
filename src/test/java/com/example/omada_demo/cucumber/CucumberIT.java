package com.example.omada_demo.cucumber;

import com.example.omada_demo.Application;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = {Application.class,
        CucumberIT.class}
)
@CucumberOptions(plugin = {"pretty", "com.example.omada_demo.cucumber.plugins.CucumberHooks"},
        tags = "",
        features = "src/test/resources/features",
        glue = "com.example.omada_demo.cucumber")

public class CucumberIT {

}
