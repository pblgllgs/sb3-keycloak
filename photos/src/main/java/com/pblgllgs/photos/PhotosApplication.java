package com.pblgllgs.photos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotosApplication.class, args);
    }

}
