package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Sep 9, 2009 9:50:41 AM @ [PaginationList]
 */
public class PaginationList {

	private List recordList = new ArrayList(); // all records
	private long recordCount = 0; // record count
	private int pageSize = 20; // page size
	private int currentPage = 1; // current page

	public PaginationList() {
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getCurrentPageStr() {
		return Integer.toString(currentPage);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public String getRecordCountStr() {
		return Long.toString(recordCount);
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getPageStart() {
		return (this.currentPage - 1) * this.pageSize + 1;
	}
}
