package com.coderscampus.assignment6;

import java.util.Arrays;
import java.util.List;

public class TeslaSalesReportApplication {

	public static void main(String[] args) {
		
        List<String> models = Arrays.asList("3", "S", "X");

        for (String model : models) {
            List<ResultByMonth> results = FileService.readFile("model" + model + ".csv");
            FileService.generateReport(results, model);
            FileService.outputBestWorstMonths(results, model);
        }
		
	}

}
