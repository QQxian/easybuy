package vo;

import java.util.List;

import model.EasybuyProduct;

public class Page {
	private int curPage;
	private int pageSize = 5;
	private int totalRecord;
	private int tatalPage;
	
	private List<EasybuyProduct> data;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		this.tatalPage = this.totalRecord % this.pageSize == 0 ? 
				this.totalRecord / this.pageSize : 
					this.totalRecord / this.pageSize + 1;
	}

	public int getTatalPage() {
		return tatalPage;
	}

	public List<EasybuyProduct> getData() {
		return data;
	}

	public void setData(List<EasybuyProduct> data) {
		this.data = data;
	}

	public int getPageStart() {
		return (curPage - 1) * pageSize;
	}
	
}
