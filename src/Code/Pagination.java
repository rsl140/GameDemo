package Code;

import java.util.ArrayList;
import java.util.List;

import Code.Modle.Page;
import Code.Modle.RolePereson;

/**
 * @author rsl
 *
 * ��ҳ�߼�����
 */
public class Pagination {
	/**
	 * ����ѭ����ʼ���±�
	 */
	public int starPage(int currentPage, int pageSize) {
		int star = 0;
		if (currentPage == 1) {
			return star;
		} else {
			return currentPage * pageSize;
		}
	}

	/**
	 * ���ؽ����±�
	 */

	public int endPage(int currentPage, int pageSize, int totlePage, int count) {
		if (currentPage == totlePage-1) {
			return count;
		}else{
			return this.starPage(currentPage,pageSize) + pageSize;
		}
	}
	
	/**
	 * ��������
	 */
	public List<?> returnList(List<?> list,Page page){
		int star = this.starPage(page.getCurrentPage(), page.getPageSize());
		int end = this.endPage(page.getCurrentPage(), page.getPageSize(), page.getTotlePage(), page.getCount());

//		List<RolePereson> temp = new ArrayList<RolePereson>();
//		for (int i = star; i < end; i++) {
//			temp.add((RolePereson)list.get(i));
//		}
//		return temp;
		if(list.get(0) instanceof RolePereson){
			List<RolePereson> temp = new ArrayList<RolePereson>();
			for (int i = star; i < end; i++) {
				temp.add((RolePereson)list.get(i));
			}
			return temp;
		}
		
		return null;
		
		
	}
}
