package io.geuns.csvmicroservice.csv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CsvImportException extends RuntimeException {

    public CsvImportException() {
        super();
    }

    public CsvImportException(String message, Throwable cause) {
        super(message,cause);
    }

    public CsvImportException(String message) {
        super(message);
    }

    public CsvImportException(Throwable cause) {
        super(cause);
    }

}
