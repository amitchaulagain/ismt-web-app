package com.app.repository;

import java.sql.SQLException;

/**
 * Create Statement JDBC Example
 *
 * @author Ramesh Fadatare
 */
public class CsvExample {


    public static void main(String[] argv) throws SQLException {
        CsvExample example = new CsvExample();

        String toConvert = "one,two,three";
        String[] csv = example.getValues(toConvert);
        System.out.println(csv);


    }

    public String[] getValues(String csv) {
        return csv.split(",");

    }

}
