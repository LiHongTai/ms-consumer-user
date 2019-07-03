package github.roger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsConsumerUserFeign7003Application {

    public static void main(String[] args) {
        SpringApplication.run(MsConsumerUserFeign7003Application.class,args);
    }
}
