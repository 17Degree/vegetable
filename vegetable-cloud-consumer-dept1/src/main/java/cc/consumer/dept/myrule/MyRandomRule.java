package cc.consumer.dept.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRandomRule extends AbstractLoadBalancerRule {

    //总共被调用的次数，目前要求每台被调用5次
    private int total = 0;
    //当前提供服务的机器号
    private int currentIndex = 0;

    public Server choose(ILoadBalancer loadBalancer, Object key){

        if(loadBalancer == null){
            return null;
        }

        Server server = null;
        while (server == null) {

            if(Thread.interrupted()){
                return null;
            }
            List<Server> reachableServers = loadBalancer.getReachableServers();
            List<Server> allServers = loadBalancer.getAllServers();
            if(allServers.size() == 0){
                return null;
            }

            if(total < 3){
                server = reachableServers.get(currentIndex);
                total++;

            }else{
                total = 0;
                currentIndex++;
                if(currentIndex >= reachableServers.size()){
                    currentIndex = 0;
                }

                server = reachableServers.get(currentIndex);
            }

            if(server == null){
                Thread.yield();
            }

            if(server.isAlive()){
                return (server);
            }

            server = null;
            Thread.yield();

        }

        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
