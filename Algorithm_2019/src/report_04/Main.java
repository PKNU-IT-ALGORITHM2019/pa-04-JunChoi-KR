package report_04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static public ArrayList<RowData> rowData = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sorter sorter = new Sorter();
		ReadData readData = new ReadData();
		
		while (true)
		{
			System.out.print("$ ");
			String input = scanner.nextLine();
			if(input.equals("read")) {
				System.out.print("파일 경로 입력 : ");
				input = scanner.nextLine();
				readData.read(input);
				rowData = readData.getRowData();
			} 
			
			if(rowData == null) {
				System.out.println("우선 Read 명령어를 실행하세요.");
			}
			else if(input.equals("print")) {
				printData();
			} else if(input.equals("print")) {
				printData();
			} else if(input.equals("sort -t")) {
				Collections.sort(rowData,sorter.timeSorter);
			} else if(input.equals("sort -ip")) {
				Collections.sort(rowData,sorter.ipSorter);
			} else if(input.equals("exit")) {
				break;
			}
		}
		
	}
	
	
	// orderBy를 위해 convert했던 time 데이터를 자연어로 변경
	private static String timeReConvert(long value)
	{
		String orgTime = "";
		SimpleDateFormat dateFomat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
		orgTime = dateFomat.format(value);
		return orgTime;
	}
	
	
	private static void printData()
	{
		for (int i = 0; i < rowData.size(); i++)
		{
			System.out.println("TIME : " + timeReConvert(rowData.get(i).getTime()));
			System.out.println("IP : " + rowData.get(i).getIp());
			System.out.println("URL : " + rowData.get(i).getUrl());
			System.out.println("STATUS : " + rowData.get(i).getStatus());
			System.out.println();
		}
	}

}
