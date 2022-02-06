package ImportExport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EntityScan
@SpringBootApplication
public class Application {
    public static void main(String[] arg)
    {
        SpringApplication.run(Application.class,arg);
    }
}