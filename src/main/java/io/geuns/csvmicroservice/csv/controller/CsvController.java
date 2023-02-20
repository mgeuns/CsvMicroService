package io.geuns.csvmicroservice.csv.controller;

import io.geuns.csvmicroservice.csv.model.CsvStatement;
import io.geuns.csvmicroservice.csv.service.CsvService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/csv")
public class CsvController {

    private final CsvService csvService;

    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload-csv-file")
    public ResponseEntity<List<CsvStatement>> uploadCsvFile(@RequestParam MultipartFile file) {
        var statement = csvService.uploadCsvFile(file);
        return ResponseEntity.ok(statement);
    }

}
