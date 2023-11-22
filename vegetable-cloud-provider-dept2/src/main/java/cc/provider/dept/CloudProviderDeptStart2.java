package cc.provider.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudProviderDeptStart2 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderDeptStart2.class, args);
    }
}
