package jp.moreslowly.pdfTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PdfTemplateController {
  @RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(path = "/hello", produces = MediaType. APPLICATION_JSON_VALUE)
	public String hello() {
		return "'Hello'";
	}
}
