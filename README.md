# PdfTemplate

PDF template server

## Getting Started

### Prerequisites

- Java SDK
- AWS S3
- [iText 7](https://github.com/itext/itext7)

### Running

1. Put pdfTemplateForTest.pdf to your S3 bucket.
2. Run server

```
cp .envrc.sample .envrc
vi .envrc
direnv allow
./mvnw spring-boot:run
```

3. Run curl
```
 curl -H "Accept: application/pdf" -H "Content-type: application/json" -X POST -d '{"template":"pdfTemplateForTest.pdf", "data": {"1A": "1A1A1A1A\n line2", "2A": "2A 漢字", "1B":"123,456", "notes": "\n 複数行テキスト \n Multile line"}}' http://localhost:8080/process > ~/tmp.pdf
```

### Packaging

```
./mvnw package
```

### Cleaning

```
./mvnw clean install
```

## Running the tests

```
./mvnw test
```

## Deployment

We have a  `Dockerfile`.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## License

This project is licensed under the AGPL License - see the [LICENSE.md](LICENSE.md) file for details

