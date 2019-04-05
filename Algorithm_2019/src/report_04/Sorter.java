package report_04;

import java.util.Comparator;

public class Sorter {
	
	public Comparator<RowData> ipSorter = new Comparator<RowData>() {
		public int compare(RowData left, RowData right) {
			int result = left.ip.compareTo(right.ip);// String 타입에 대해 사전순 정렬을 지원
			
			if(result == 0) {
				return Long.compare(left.time, right.time);
			} 
			
			return result;
		}
	};
	
	public Comparator<RowData> timeSorter = new Comparator<RowData>() {
		public int compare(RowData left, RowData right) {
			return  Long.compare(left.time, right.time);
		}
	};
	
}
