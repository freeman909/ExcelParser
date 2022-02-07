package it.omicron.parser.models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;

public class Test {
	public static void main(String[] args) {
		Workbook wb= new XSSFWorkbook();		

		Gson g=new Gson();

		try {
			
//			Paths.get(System.getProperty("/ServiceMenu.json")
//			Paths.get("./input/ServiceMenu.json")
			Reader reader=Files.newBufferedReader(Paths.get("./input/ServiceMenu.json"));
			MenuContent m =g.fromJson(reader, MenuContent.class);
			List<MenuNode> mCchildren= m.getNodes();

			CellStyle headerStyle = wb.createCellStyle();

			XSSFFont font = ((XSSFWorkbook) wb).createFont();
			font.setFontName("Arial");
			font.setFontHeightInPoints((short) 11);
			font.setBold(true);
			headerStyle.setFont(font);
			
			List<String> titles= new ArrayList<String>();
			titles.add("ServiceId");
			titles.add("NodeName");
			titles.add("NodeType");
			titles.add("Grouptype");
			titles.add("Flowtype");
			titles.add("ResourceId");
			
			
			Sheet sheet= wb.createSheet("Menù "+m.getVersion());
			for (int i = 0; i < titles.size()+Utility.getMaxDepth(m); i++) {
				sheet.autoSizeColumn(i);
				sheet.setColumnWidth(i,sheet.getColumnWidth(i)*17/10);
			}

			Row header= sheet.createRow(0);

			
			
			
					for (int i = 0; i <= Utility.getMaxDepth(m); i++) {
						
						Cell headerCell= header.createCell(i);
						headerCell.setCellValue(i);
						headerCell.setCellStyle(headerStyle);
					}
					
				
					for(int i=0;i <titles.size();i++) {
						
						Cell headerCell1= header.createCell(Utility.getMaxDepth(m)+i+1);
						headerCell1.setCellValue(titles.get(i));
						headerCell1.setCellStyle(headerStyle);
						
						
					}

					
			File dir= new File(System.getProperty("./output/excelTest.xlsx"));

			FileOutputStream outputStream = new FileOutputStream(dir);
			


						Utility.menuWriter(mCchildren, sheet,m);
			wb.write(outputStream);
			
			wb.close();




			


		} catch (IOException e) {

			e.printStackTrace();
		}




	}
}
