package brunofujisaki.picpay_desafio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "PicPay desafio", version = "1", description = "API do desafio do picpay"))
public class PicpayDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpayDesafioApplication.class, args);
	}

}
