package io.geuns.csvmicroservice.csv.helper;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class AmountCsvConverter extends AbstractBeanField {

    @Override
    protected Object convert(final String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

        final NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        double number;
        try {
            number = numberFormat.parse(value).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return number;
    }
}
