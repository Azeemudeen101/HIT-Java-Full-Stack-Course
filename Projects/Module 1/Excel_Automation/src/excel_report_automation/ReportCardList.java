package excel_report_automation;

import java.util.ArrayList;
import java.util.List;

public class ReportCardList {
	public static List<ReportCard> getMarkList()  {
		List<ReportCard> reportCards=new ArrayList<>();
		reportCards.add(new ReportCard("101","example@gmail.com",25,40,60,70,48));
		reportCards.add(new ReportCard("102","example@gmail.com",30,60,34,75,62));
		reportCards.add(new ReportCard("103","example@gmail.com",25,56,37,82,55));
		return reportCards;
	}
}
