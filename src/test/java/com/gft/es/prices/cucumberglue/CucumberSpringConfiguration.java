package com.gft.es.prices.cucumberglue;

import com.gft.es.prices.PricesApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(classes = PricesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Profile("test")
//@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:11111", "port=11111"})
@Slf4j
public class CucumberSpringConfiguration {
   /* private static final MongoDBContainer mongoDBContainer;

    private static final LocalStackContainer localstack;

    @MockBean
    private S3Client s3Client;


    static {
        mongoDBContainer = new MongoDBContainer("mongo:6.0.5").withReuse(true);
        mongoDBContainer.start();
        localstack = new LocalStackContainer(DockerImageName.parse("localstack/localstack:0.11.3"))
                .withServices(LocalStackContainer.Service.S3);
        localstack.start();
        try {
            log.info("S3 endpoint: {}", localstack.getEndpointOverride(LocalStackContainer.Service.S3));
            localstack.execInContainer("awslocal", "s3", "mb", "s3://testbucket");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @DynamicPropertySource
    public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
        registry.add("spring.kafka.bootstrap-servers", () -> "localhost:11111");
        registry.add("kafka.delivery.point.event.topic", () -> "delivery-point-event-v1");
        registry.add("spring.kafka.consumer.group.shipping.item.event", () -> "shipping-item-event-v1");
        registry.add("kafka.notification.topic", () -> "notification-v1");
        registry.add("aws.s3.access.key.id", localstack::getAccessKey);
        registry.add("aws.s3.secret.access.key", localstack::getSecretKey);
        registry.add("aws.s3.bucket.region", localstack::getRegion);
    }*/

}
