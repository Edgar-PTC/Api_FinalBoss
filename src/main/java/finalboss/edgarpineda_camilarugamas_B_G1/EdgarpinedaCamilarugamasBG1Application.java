package finalboss.edgarpineda_camilarugamas_B_G1;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EdgarpinedaCamilarugamasBG1Application {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		SpringApplication.run(EdgarpinedaCamilarugamasBG1Application.class, args);
	}

}
