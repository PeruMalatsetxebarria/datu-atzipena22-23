package dambi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
*/

@SpringBootApplication
@RestController
public class LehenrestapiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LehenrestapiaApplication.class, args);
	}
	@GetMapping("/")
	public String home() {
		return "Gure lehen rest apia martxan dago."; 
	}
	
	@GetMapping("/kaixo")
	public String hello(@RequestParam(value = "izena", defaultValue = "mundua") String izena) {
		return String.format("Kaixo %s!", izena);
	}

	@GetMapping("/zenbatu")
	public String zenbatu(@RequestParam(value = "norarte", defaultValue = "5") String norarte) {

		String strEmaitza = "";
		for (int i = 1; i <= Integer.parseInt(norarte); i++) {
			strEmaitza += (i + "\n");
		}
		return strEmaitza;
	}
