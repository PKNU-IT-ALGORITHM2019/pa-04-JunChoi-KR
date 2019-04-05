package report_04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class ReadData {
	
	static public ArrayList<RowData> rowData = new ArrayList<RowData>();

	public void read(String path) {
		// TODO Auto-generated method stub
		try {
			File csv = new File(path);
			BufferedReader buffer = new BufferedReader(new FileReader(csv));
			String line = buffer.readLine();
			
			while ((line = buffer.readLine()) != null) {
				String[] temp = line.split(",");
				RowData row = new RowData(temp[0], timefmatter((temp[1].substring(1))), temp[2], temp[3]);
				rowData.add(row);
			}
			
			buffer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}


	private long timefmatter(String value)
	{
		long time = 0;
		try
		{
			SimpleDateFormat dateFomat = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss", Locale.ENGLISH);
			Date date = dateFomat.parse(value);
			time = date.getTime(); // January 1, 1970, 00:00:00 GMT로 부터 경과한 시간 리턴
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return time;

	}


	public ArrayList<RowData> getRowData() {
		return rowData;
	}

	
	public void setRowData(ArrayList<RowData> rowData) {
		ReadData.rowData = rowData;
	}
	
}
