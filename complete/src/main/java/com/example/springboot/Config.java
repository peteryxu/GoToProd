package com.example.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
 
import java.util.ArrayList;
import java.util.List;
 
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("demo")
public class Config {
 
    private String environment;
    private List<String> hosts = new ArrayList<>();
 
    public String getEnvironment() {
        return environment;
    }
 
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
 
    public List<String> getHosts() {
        return hosts;
    }
 
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }
 
    @Override
    public String toString() {
        return "{" + this.getEnvironment() + ", " + this.getHosts() + "}";
    }
}
