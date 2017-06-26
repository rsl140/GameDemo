package Code;

import java.util.ArrayList;
import java.util.List;

import Code.Modle.Page;
import Code.Modle.RolePereson;

/**
 * @author rsl
 *
 * 分页逻辑代码
 */
public class Pagination {
	/**
	 * 返回循环开始的下标
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
	 * 返回结束下标
	 */

	public int endPage(int currentPage, int pageSize, int totlePage, int count) {
		if (currentPage == totlePage-1) {
			return count;
		}else{
			return this.starPage(currentPage,pageSize) + pageSize;
		}
	}
	
	/**
	 * 返回数据
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
