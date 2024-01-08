package com.coderscampus.assignment6;

import java.time.YearMonth;

public class ResultByMonth {
	
	private int totalSales;
	private YearMonth yearMonth;
	
	
	public ResultByMonth(YearMonth yearMonth, int totalSales) {
		this.yearMonth = yearMonth;
		this.totalSales = totalSales;
	}
	
	public Integer getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public YearMonth getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(YearMonth yearMonth) {
		this.yearMonth = yearMonth;
	}
	

}
