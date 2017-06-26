package Code.Modle;

public class Page {
	private int currentPage;//��ǰҳ
	private int totlePage;//��ҳ
	private int pageSize;//ÿҳ��ʾ��
	private int count;//�ܹ��ж�������
	
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
