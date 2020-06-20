package jp.moreslowly.pdfTemplate;

import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.template")
public class S3InputStreamBuilder {
    private String bucket;

    public InputStream build(String keyName) throws IOException {
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
        S3Object o = s3.getObject(bucket, keyName);
        return o.getObjectContent();
    }
}
