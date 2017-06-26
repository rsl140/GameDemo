package Code.Listener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Code.Pagination;
import Code.SetData;
import Code.Modle.NameId;
import Code.Modle.Page;
import Code.Modle.RolePereson;
import View.MainView;
import View.SelectCardView;

public class SelectCardListener {
	private NameId loginUserInfo;
	private JLabel goback;
	private JLabel gitCard;
	private JLabel pre;// 上一页
	private JLabel next;// 下一页
	private JLabel current;// 当前页
	private JPanel cardPanel;// 卡牌panel
	private JFrame frame;
	private Page page;
	private List<RolePereson> CardInfo;

	public SelectCardListener(JFrame frame, JLabel goback, JLabel gitCard, NameId loginUserInfo, JLabel pre,
			JLabel next, JLabel current, JPanel cardPanel, Page page, List<RolePereson> cardInfo) {
		this.goback = goback;
		this.gitCard = gitCard;
		this.loginUserInfo = loginUserInfo;
		this.frame = frame;
		this.pre = pre;
		this.next = next;
		this.current = current;
		this.cardPanel = cardPanel;
		this.page = page;
		this.CardInfo = cardInfo;
		show();
	}

	public void cilickListener() {
		// 返回上一级
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				MainView main = new MainView(loginUserInfo);
				main.loginUserInfo = loginUserInfo;
			}
		});
		// 抽牌按钮
		gitCard.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SetData data = new SetData();
				// 取得牌库里的卡牌数据
				List<RolePereson> cardRole = new ArrayList<RolePereson>();
				cardRole = data.getRolePereson();
				// 随机产生一个卡牌
				int index = (int) (Math.random() * cardRole.size());
				// 提示抽到的什么
				JOptionPane.showMessageDialog(null,
						"您抽到了一张：" + cardRole.get(index).getName() + "，等级为：" + cardRole.get(index).getLever(), "提示",
						JOptionPane.ERROR_MESSAGE);
				// 讲随机产生的数据存入数据库
				List<RolePereson> tempRole = new ArrayList<RolePereson>();
				tempRole = loginUserInfo.getRole();
				tempRole.add(cardRole.get(index));
				loginUserInfo.setRole(tempRole);
				// 取得数据库内用户信息
				List<NameId> user = new ArrayList<NameId>();
				user = data.getUserInfo();
				for (int i = 0; i < user.size(); i++) {
					if (user.get(i).getId().equals(loginUserInfo.getId())) {
						user.get(i).setRole(loginUserInfo.getRole());
						break;
					}
				}
				// 修改后的用户写入数据库
				data.setUserInfo(user);
			}
		});

		pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int temp = page.getCurrentPage();
				temp--;
				if(temp<=1){
					temp = 1;
				}
				page.setCurrentPage(temp);
				show();
			}
		});
		
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int temp = page.getCurrentPage();
				temp++;
				if(temp>=page.getTotlePage()-1){
					temp = page.getTotlePage()-1;
				}
				page.setCurrentPage(temp);
				show();
			}
		});

	}

	public void show() {
		Pagination pagination = new Pagination();
		List<RolePereson> showCard = new ArrayList<RolePereson>();
		showCard = (ArrayList<RolePereson>)pagination.returnList(CardInfo, page);
		cardPanel.removeAll();
		cardPanel.repaint();
		
		for (int i = 0; i < showCard.size(); i++) {//分页 
			// 图片路径
			ImageIcon testimage;
			testimage = new ImageIcon(
					this.getClass().getResource("/img/" + showCard.get(i).getSrc() + ".png").getFile());

			// 创建背景
			JLabel bgjl;// 存放背景图片用 panel为背景图层
			JPanel test = new JPanel();
			test.setBounds(0, 0, testimage.getIconWidth(), testimage.getIconHeight());
			bgjl = new JLabel(testimage);
			test.add(bgjl);
			bgjl.setText(showCard.get(i).getName());
			cardPanel.add(test);

			test.setBackground(Color.WHITE);
		}

	}
}
