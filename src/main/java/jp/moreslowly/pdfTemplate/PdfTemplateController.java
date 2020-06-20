package jp.moreslowly.pdfTemplate;

import java.io.OutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String hello() {
		return "'Hello'";
	}

	@RequestMapping(path = "/process", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
	public void process(@RequestBody Map<String, Object> payload, HttpServletResponse response) throws IOException {
		System.out.println(payload);

		OutputStream outputStream = response.getOutputStream();
		PdfProcessor processor = new PdfProcessor();
		processor.setOutputStream(outputStream);
		processor.run(payload);
	}
}
