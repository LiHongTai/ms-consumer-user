package github.roger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsConsumerUser7002Application {

    public static void main(String[] args) {
        SpringApplication.run(MsConsumerUser7002Application.class,args);
    }
}
