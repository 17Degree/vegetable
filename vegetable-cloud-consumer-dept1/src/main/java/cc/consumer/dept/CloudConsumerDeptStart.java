package cc.consumer.dept;

import cc.consumer.dept.myrule.MySelfRibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "CLOUDPROVIDERDEPT", configuration = MySelfRibbonRuleConfig.class)
public class CloudConsumerDeptStart {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerDeptStart.class, args);
    }
}
