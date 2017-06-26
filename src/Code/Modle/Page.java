package Code.Modle;

public class Page {
	private int currentPage;//当前页
	private int totlePage;//总页
	private int pageSize;//每页显示数
	private int count;//总共有多少数据
	
	public Page(int currentPage, int count, int pageSize) {
		this.count = count;
		this.currentPage = currentPage;
		this.totlePage = count%pageSize==0?count/pageSize:count/pageSize+1;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotlePage() {
		return totlePage;
	}

	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
