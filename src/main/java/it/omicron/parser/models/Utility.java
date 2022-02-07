package it.omicron.parser.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Utility {




	//	public static void menuWriter(List<MenuNode> n,Sheet sheet) {
	//
	//		for(MenuNode mn:n) {
	//	
	//			if((mn.getNodes())!=null) {
	//				writeRow(mn, sheet);
	//				menuWriter(mn.getNodes(), sheet);
	//				
	//			}
	//			else {
	//				writeRow(mn, sheet);
	//			}
	//		}
	//	}	

	public static void menuWriter(List<MenuNode> n,Sheet sheet, MenuContent m) {

		for(MenuNode node:n) {

			menuIterator(node,0,sheet,m);



		}



	}




	public static int menuIterator(MenuNode n,int depth,Sheet sheet,MenuContent m) {
					n.setDepth(depth);

		for(int i=0; i<depth;i++) {

			System.out.print("\t");

		}
		//analizzo nodo
		System.out.println(" "+n.getNodeName());
		System.out.println(depth);

		writeRow(n, sheet,m);
		if(n.getNodes()!=null) {

			for(MenuNode node: n.getNodes()) {

				menuIterator(node,depth+1,sheet,m);

			}

		}
		return depth;
	}
	


	public static int getMaxDepth(Object o) {
		int depth=0;
		
		if(o instanceof MenuContent) {
			
			if(((MenuContent)o).getNodes()!=null) {
				
				for (int i = 0; i < ((MenuContent)o).getNodes().size(); i++) {
					depth= Math.max(depth, getMaxDepth(((MenuContent)o).getNodes().get(i)));
				}
				return depth+1;
			}	
		}
		else if(o instanceof MenuNode) {
			
			if(((MenuNode)o).getNodes()!=null) {
				for (int i = 0; i < ((MenuNode)o).getNodes().size(); i++) {
					depth= Math.max(depth, getMaxDepth(((MenuNode)o).getNodes().get(i)));
				}
				return depth+1;
			}
			
		}
			
		
		return depth;
	}	







	//	public static void menuIterator(MenuNode n,Sheet sheet) {
	//		n.setDepth(0);
	//		int depth=n.getDepth();
	//		
	//		for(int i=0; i<depth;i++) {
	//
	//			System.out.print("\t");
	//
	//		}
	//		//analizzo nodo
	//		System.out.println(" "+n.getNodeName());
	//		writeRow(n, sheet);
	//		if(n.getNodes()!=null) {
	//
	//			for(MenuNode node: n.getNodes()) {
	//				n.setDepth(depth+1);
	//				menuIterator(node,sheet);
	//
	//			}
	//
	//		}





	//	}

	//	public static int checkDepth(List<MenuNode> n, Sheet sheet) {
	//		int depth=0;
	//		for (MenuNode node: n) {
	//			
	//		depth=	menuIterator(node, 0, sheet);
	//			}
	//			
	//		return depth;
	//		
	//		
	//	}




	public static void writeRow(MenuNode menu, Sheet sheet,MenuContent m) {
		List<String> menuContent= new ArrayList<String>();


		if(menu.getNodeType().equals("service")) {
			menuContent.add(menu.getNodeId()+"");
		}
		else {
			menuContent.add("");
		}

		menuContent.add(menu.getNodeName());

		menuContent.add(menu.getNodeType());

		if(!(menu.getGroupType()==null)) {
			menuContent.add(menu.getGroupType());
		}
		else {
			menuContent.add("");
		}

		if(!(menu.getFlowType()==null)) {
			menuContent.add(menu.getFlowType());
		}
		else {	
			menuContent.add("");
		}

		if(!(menu.getResource()==null)) {
			menuContent.add((menu.getResource().getId())+"");
		}
		else {
			menuContent.add("");
		}

		int rowNumber= sheet.getLastRowNum();


		Row row= sheet.createRow(rowNumber+1);
		
		for (int i = 0; i < Utility.getMaxDepth(m); i++) {
			int depth=menu.getDepth();
//			if(depth>=0) {
			Cell cell=row.createCell(menu.getDepth());
			cell.setCellValue( "X");
//			}
		}
		
		
		for (int i = 0; i < menuContent.size(); i++) {
			
			Cell cell=row.createCell(Utility.getMaxDepth(m)+i+1);
			cell.setCellValue( menuContent.get(i));


		}




	}



}














