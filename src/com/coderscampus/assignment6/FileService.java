package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class FileService {

	public static List<ResultByMonth> readFile(String filePath) {
		List<ResultByMonth> result = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
			String line;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] resultInfo = line.split(",");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy").withLocale(Locale.US);
				ResultByMonth monthlyResult = new ResultByMonth(YearMonth.parse(resultInfo[0], formatter),
						Integer.parseInt(resultInfo[1].trim()));
				result.add(monthlyResult);
			}
		} catch (IOException e) {
			System.out.println("Oops, filepath is incorrect.");
		}
		return result;
	}

	public static void generateReport(List<ResultByMonth> results, String modelName) {
		System.out.println("Model " + modelName + " Yearly Sales Report");
		System.out.println("---------------------------");

		Map<Integer, Integer> yearlySales = results.stream().collect(Collectors.groupingBy(
				result -> result.getYearMonth().getYear(), Collectors.summingInt(ResultByMonth::getTotalSales)));

		yearlySales.forEach((year, totalSales) -> System.out.println(year + " -> " + totalSales));

		System.out.println();

	}
	

	public static void outputBestWorstMonths(List<ResultByMonth> results, String modelName) {
		
	    ResultByMonth bestMonth = results.stream()
                                                                      .max(Comparator.comparingInt(ResultByMonth::getTotalSales))
                                                                      .orElse(null);
	    if (bestMonth != null) {
	        System.out.println("The best month for Model " + modelName + " was: " + bestMonth.getYearMonth());
	    }

	    ResultByMonth worstMonth = results.stream()
                                                                        .min(Comparator.comparingInt(ResultByMonth::getTotalSales))
                                                                        .orElse(null);
	    if (worstMonth != null) {
	        System.out.println("The worst month for Model " + modelName + " was: " + worstMonth.getYearMonth());
	    }

	    System.out.println();
		
	}

}
