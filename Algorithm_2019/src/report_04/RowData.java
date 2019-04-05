package report_04;

public class RowData {

	public String ip;
	public long time;
	public String url;
	public String status;
	
	public RowData(String ip, long time, String url, String status) {
		super();
		this.ip = ip;
		this.time = time;
		this.url = url;
		this.status = status;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
