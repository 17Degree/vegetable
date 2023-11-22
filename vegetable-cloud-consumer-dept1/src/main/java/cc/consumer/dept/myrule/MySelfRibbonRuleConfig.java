package cc.consumer.dept.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRibbonRuleConfig {

    @Bean
    public IRule myrule(){
        return new MyRandomRule();
    }

}
