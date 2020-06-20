package jp.moreslowly.pdfTemplate;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PdfTemplateController {
  @RequestMapping("/")
	public String index() {
		return "'Greetings'";
	}

	@RequestMapping(path = "/hello", produces = MediaType. APPLICATION_JSON_VALUE)
	public String hello() {
		return "'Hello'";
	}

	@RequestMapping(path = "/process", method = RequestMethod.POST, produces = MediaType. APPLICATION_JSON_VALUE)
	public String process(@RequestBody Map<String, Object> payload) {
		System.out.println(payload);
		return "'Hello'";
	}
}
