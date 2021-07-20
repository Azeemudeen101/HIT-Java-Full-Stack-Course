package pdf_ecertificate;

import java.util.HashSet;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

/* CLASS : CreateCertificate
 * METHODS :
 *	setName(),setDate(),setCourseName() - setters
 *	generate() - Set the Details and Loop through the HashSet
 *	createPDF()- Create the PDF document with Name,Date and Course name 
*/
public class CreateCertificate {
	String name="";
	String date="";
	String courseName="";

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void  generate(HashSet<String> nameList,String courseName,String date) {
		setCourseName(courseName);
		setDate(date);
		if(!courseName.equals("") && !date.equals("")) {
			for(String name:nameList) {
				setName(name);
				createPDF();
			}
			System.out.println("Total Certificates Created : "+nameList.size());
		}else {
			System.out.println("Invalid Course name (or) Date !! \n Try Again ;)");
		}
	}

	public void createPDF() {
		try {
		String filepath="D:/ProGs/Job/Full Stack JAVA Course/Practicals/Projects/PDFCreate/GeneratedPDF/"+name.replace(".", "-")+".pdf";
		PdfWriter pdfWriter=new PdfWriter(filepath);
		PdfDocument pdfDocument=new PdfDocument(pdfWriter);
		Document document=new Document(pdfDocument);
		PageSize pageSize=PageSize.A4.rotate();
		
		ImageData imgData=ImageDataFactory.create("D:/ProGs/Job/Full Stack JAVA Course/Practicals/Projects/PDFCreate/CertificateBG.jpg");
		Image image=new Image(imgData).setFixedPosition(0, 0).scaleAbsolute(pageSize.getWidth(), pageSize.getHeight());
		
		PdfFont font_TIMES_BOLD=PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
		Text name_print=new Text(name)
				.setFont(font_TIMES_BOLD)
				.setFontSize(46)
				.setFontColor(ColorConstants.BLACK,0.8f)
				.setCharacterSpacing(1.5f)
				.setStrokeWidth(2);
		Paragraph paraforName=new Paragraph();
		paraforName.add(name_print)
		.setFixedPosition(295, 255, 500)
		.setMargins(0, 0, 0, 0)
		.setFixedLeading(0);
		
		PdfFont font_HV_BOLD=PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		Text courseName_print=new Text("for "+courseName)
				.setFont(font_HV_BOLD)
				.setFontSize(30)
				.setFontColor(ColorConstants.BLUE,0.6f)
				.setCharacterSpacing(1f)
				.setUnderline()
				.setStrokeWidth(2);
		Paragraph paraforCourseName=new Paragraph();
		paraforCourseName.add(courseName_print)
		.setFixedPosition(295,205, 500)
		.setMargins(0, 0, 0, 0)
		.setFixedLeading(0);
		
		PdfFont font_HEVETICA=PdfFontFactory.createFont(StandardFonts.HELVETICA);
		Text date_print=new Text(date)
				.setFont(font_HEVETICA)
				.setFontSize(15)
				.setFontColor(ColorConstants.BLACK,0.7f)
				.setCharacterSpacing(1f)
				.setStrokeWidth(2);
		Paragraph paraforDate=new Paragraph();
		paraforDate.add(date_print).setFixedPosition(550, 80, 100).setMargins(0, 0, 0, 0);
		
		pdfDocument.addNewPage(pageSize);
		document.add(image);
		document.add(paraforName);
		document.add(paraforCourseName);
		document.add(paraforDate);
		
		document.close();
		System.out.println("[******* E-Certificate for "+name+" Successfully Generated *******]");
		
		}catch(Exception e) {e.getMessage();}
	}
}
