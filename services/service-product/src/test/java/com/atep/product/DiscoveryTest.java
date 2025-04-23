package com.atep.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    void discoveryClientTest() {

        for (String o : discoveryClient.getServices()) {
            System.out.println(o);
            List<ServiceInstance> instances = discoveryClient.getInstances(o);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getHost() + ":" + instance.getPort());
            }
        }
    }

    @Test
    void nacosDiscoveryClientTest() throws NacosException {

        for (String o : nacosServiceDiscovery.getServices()) {
            System.out.println(o);
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(o);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getHost() + ":" + instance.getPort());
            }
        }
    }
}
