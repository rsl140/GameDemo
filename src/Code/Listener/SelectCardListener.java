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
	private JLabel pre;// ��һҳ
	private JLabel next;// ��һҳ
	private JLabel current;// ��ǰҳ
	private JPanel cardPanel;// ����panel
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
		// ������һ��
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				MainView main = new MainView(loginUserInfo);
				main.loginUserInfo = loginUserInfo;
			}
		});
		// ���ư�ť
		gitCard.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SetData data = new SetData();
				// ȡ���ƿ���Ŀ�������
				List<RolePereson> cardRole = new ArrayList<RolePereson>();
				cardRole = data.getRolePereson();
				// �������һ������
				int index = (int) (Math.random() * cardRole.size());
				// ��ʾ�鵽��ʲô
				JOptionPane.showMessageDialog(null,
						"���鵽��һ�ţ�" + cardRole.get(index).getName() + "���ȼ�Ϊ��" + cardRole.get(index).getLever(), "��ʾ",
						JOptionPane.ERROR_MESSAGE);
				// ��������������ݴ������ݿ�
				List<RolePereson> tempRole = new ArrayList<RolePereson>();
				tempRole = loginUserInfo.getRole();
				tempRole.add(cardRole.get(index));
				loginUserInfo.setRole(tempRole);
				// ȡ�����ݿ����û���Ϣ
				List<NameId> user = new ArrayList<NameId>();
				user = data.getUserInfo();
				for (int i = 0; i < user.size(); i++) {
					if (user.get(i).getId().equals(loginUserInfo.getId())) {
						user.get(i).setRole(loginUserInfo.getRole());
						break;
					}
				}
				// �޸ĺ���û�д�����ݿ�
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
		
		for (int i = 0; i < showCard.size(); i++) {//��ҳ 
			// ͼƬ·��
			ImageIcon testimage;
			testimage = new ImageIcon(
					this.getClass().getResource("/img/" + showCard.get(i).getSrc() + ".png").getFile());

			// ��������
			JLabel bgjl;// ��ű���ͼƬ�� panelΪ����ͼ��
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
