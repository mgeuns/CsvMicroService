package io.geuns.csvmicroservice.csv.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import io.geuns.csvmicroservice.csv.model.CsvStatement;
import io.geuns.csvmicroservice.csv.exception.BadRequestException;
import io.geuns.csvmicroservice.csv.exception.CsvImportException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CsvService {

    public List<CsvStatement> uploadCsvFile(final MultipartFile file) {
        BufferedReader reader = null;

        checkFileEmpty(file);

        try {
            reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            var csvBean = createCsvToBean(reader);
            return csvBean.parse();
        } catch (Exception e) {
            throw new CsvImportException("Error during csv import");
        } finally {
            closeFileReader(reader);
        }

    }

    private void checkFileEmpty(final MultipartFile file) {
        if (file.isEmpty()) {
            throw new BadRequestException("File is empty");
        }
    }

    private CsvToBean<CsvStatement> createCsvToBean(final BufferedReader reader) {
        return new CsvToBeanBuilder<CsvStatement>(reader)
                .withType(CsvStatement.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withSeparator(';')
                .build();
    }

    private void closeFileReader(final BufferedReader reader) {
        try {
            reader.close();
        } catch (Exception e) {
            throw new CsvImportException("Error during csv import");
        }
    }

}
