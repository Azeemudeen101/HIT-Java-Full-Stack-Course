package excel_report_automation;

public class Main {

	public static void main(String[] args) {
		CreateExcel createExcel=new CreateExcel();
		createExcel.generate(ReportCardList.getMarkList());
	}
}
