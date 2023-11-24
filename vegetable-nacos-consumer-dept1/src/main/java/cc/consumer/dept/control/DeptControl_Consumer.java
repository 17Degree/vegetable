package cc.consumer.dept.control;

import cc.common.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptControl_Consumer {

    //面向微服务编程，即通过微服务的名称来获取调用地址
    //使用注册到 Spring Cloud Nacos 服务注册中心中的服务，即 application.name
    private static final String REST_URL_PROVIDER_PREFIX = "http://cloudProviderDept";

    //RestTemplate 是一种简单便捷的访问 restful 服务模板类，是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，提供了多种便捷访问远程 HTTP 服务的方法
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer deptId){


        Thread thread = new Thread();
        thread.interrupt();

        Dept forObject = restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/get/" + deptId, Dept.class);
        return forObject;
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> get(){
        //restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/get/" + deptId, Dept.class);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("test_headers1", "123");

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List> exchange = restTemplate.exchange(REST_URL_PROVIDER_PREFIX + "/dept/list/", HttpMethod.GET, objectHttpEntity, List.class);

        List body = exchange.getBody();



        /*body.parallelStream().map(obj-> {
            Dept dept = new Dept();
            BeanUtils.copyProperties(obj, dept);
            return dept;
        }).collect(Collectors.toList());*/

        return body;
    }

}
