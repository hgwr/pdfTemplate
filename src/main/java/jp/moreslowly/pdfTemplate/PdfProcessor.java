package jp.moreslowly.pdfTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

public class PdfProcessor {
  private OutputStream _outputStream;

  public void setOutputStream(OutputStream outputStream) {
    _outputStream = outputStream;
  }

  public void run(Map<String, Object> params) throws IOException {
    S3InputStreamBuilder builder = new S3InputStreamBuilder();
    InputStream is = builder.build((String) params.get("template"));
    PdfReader reader = new PdfReader(is);
    PdfDocument pdf = new PdfDocument(reader, new PdfWriter(_outputStream));
    PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);

    Map<String, String> data = (Map<String, String>) params.get("data");
    for (Map.Entry<String, String> entry : data.entrySet()) {
      System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
      String key = entry.getKey();
      String value = entry.getValue();
      // System.out.printf("key: %s, value: %s", key, value);
      Map<String, PdfFormField> formFields = form.getFormFields();
      PdfFormField tf = formFields.get(key);
      if (tf != null) {
        tf.setValue(value);
      }
    }

    pdf.close();
  }
}