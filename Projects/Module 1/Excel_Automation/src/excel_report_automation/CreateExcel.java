package excel_report_automation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* CLASS : CreateExcel
 * METHODS :
 * 	generate()- Command to Call Methods in Sequential Order
 * 	setUpRowColumnHeader()- Create Row and Column Headers
 * 	fillExcelData()- Fill data from List to Excel
 * 	writeExcelandSendEmail()- Save the Excel file and Call sendEmail() in SendEmail class.
*/
public class CreateExcel {
	Workbook workbook=new XSSFWorkbook();
	Sheet sheet=workbook.createSheet("sheet-1");
	SendEmail sendEmail=new SendEmail(); //MakeConnection to SMTPServer
	
	public void generate(List<ReportCard> reportCards) {
		
		//--------Setup Column Header---------
		String[] columnHeader= {"Subjects","Marks"};
		String[] rowHeader= {"Language 1","Language 2","Science","Social","Mathematics"};
		setUpRowColumnHeader(columnHeader,rowHeader);

		//--------Fill the ReportCard----------
		fillExcelData(reportCards);
	}

	public void fillExcelData(List<ReportCard> reportCards) {
		for(ReportCard reportCard:reportCards) {
			int row=1;
			sheet.getRow(row++).createCell(1).setCellValue(reportCard.getMark1());
			sheet.getRow(row++).createCell(1).setCellValue(reportCard.getMark2());
			sheet.getRow(row++).createCell(1).setCellValue(reportCard.getMark3());
			sheet.getRow(row++).createCell(1).setCellValue(reportCard.getMark4());
			sheet.getRow(row++).createCell(1).setCellValue(reportCard.getMark5());
			setUpTotal(row);
			writeExcelandSendEmail(reportCard.getRollNo(),reportCard.getEmail());
		}
		try {
			sendEmail.transport.close();
		} catch (MessagingException e) {e.printStackTrace();}
	}
	private void writeExcelandSendEmail(String rollNo,String email) {
		try {
			String filepath="src/"+rollNo+".xlsx"; 
			FileOutputStream fileOut=new FileOutputStream(filepath);
			workbook.write(fileOut);
			fileOut.close();
			System.out.print("Excel Generated for RollNo:"+rollNo);
			sendEmail.compose(rollNo,email,filepath);
		} catch (IOException e) {e.printStackTrace();}
	}
	public void setUpRowColumnHeader(String[] columnHeader, String[] rowHeader) {
		//Create Font
		Font headerFont=workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short)12);
		headerFont.setColor(IndexedColors.BLACK.index);

		//Create CellStyle
		CellStyle cellStyle=workbook.createCellStyle();
		cellStyle.setFont(headerFont);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

		//Create ColumnHeader 
		Row rowOfcolHeader=sheet.createRow(0);
		for(int i=0;i<columnHeader.length;i++) {
			Cell cell=rowOfcolHeader.createCell(i);
			cell.setCellValue(columnHeader[i]);
			cell.setCellStyle(cellStyle);
		}

		//Create RowHeader
		int rowOfRowHeader=1;
		for(int i=0;i<rowHeader.length;i++) {
			Row row=sheet.createRow(rowOfRowHeader++);
			Cell cell=row.createCell(0);
			cell.setCellValue(rowHeader[i]);
			cell.setCellStyle(cellStyle);
		}
		//Freeze Row of Column Header
		sheet.createFreezePane(0, 1); 
		
		//-----------Auto-Resizing All Columns----------
		for(int i=0;i<columnHeader.length;i++) {
			sheet.autoSizeColumn(i);
		}
	}

	public void setUpTotal(int row) {
		String sumOfFormula="SUM(B1:B"+row+")";

		Font totalFont=workbook.createFont();
		totalFont.setBold(true);
		totalFont.setFontHeightInPoints((short) 10);
		totalFont.setColor(IndexedColors.WHITE.index);

		CellStyle totalCellStyle=workbook.createCellStyle();
		totalCellStyle.setFont(totalFont);
		totalCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		totalCellStyle.setFillForegroundColor(IndexedColors.DARK_GREEN.index);

		Row rowTotal=sheet.createRow(row);
		Cell cellTotalTitle=rowTotal.createCell(0);
		cellTotalTitle.setCellValue("Total");
		cellTotalTitle.setCellStyle(totalCellStyle);

		Cell cellTotalSum1=rowTotal.createCell(1);
		cellTotalSum1.setCellStyle(totalCellStyle);
		cellTotalSum1.setCellFormula(sumOfFormula);

	}
}