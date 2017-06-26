package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Code.AddBackgroundImage;
import Code.SetData;
import Code.SetStyle;
import Code.Listener.SelectCardListener;
import Code.Modle.NameId;
import Code.Modle.Page;
import Code.Modle.RolePereson;
/**
 * 
 * @author rsl
 *�鿨ҳ��
 */
public class SelectCardView extends JFrame {
	public NameId loginUserInfo;
	// ����һ��JLayeredPane���ڷֲ�ġ�
	JLayeredPane layeredPane;
	// ����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������
	JPanel bgjp;
	ImageIcon image;
	JPanel showjp;// ������ʾ���ݵ�panel
	int currentPage;// ��ǰҳ��

	public SelectCardView(NameId loginUserInfo) {
		this.loginUserInfo = loginUserInfo;
		currentPage = 1;
		layeredPane = new JLayeredPane();
		bgjp = new JPanel();
		// ���ñ���
		new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "bg.png", 0, -3);
		// ��ͼ
		showjp = new JPanel();
		showjp.setBounds(0, 0, this.getWidth(), this.getHeight());
		showjp.setOpaque(false);
		showjp.setLayout(null);
		Font fontStyle = new Font("����", Font.BOLD, 20);
		Color Black = Color.BLACK;

		JLabel goBack = new JLabel("����");
		JLabel gitCard = new JLabel("�鿨");
		JLabel title = new JLabel("��ǰ���Ʋֿ⣺");
		JLabel pre = new JLabel("��һҳ");
		JLabel next = new JLabel("��һҳ");
		JLabel current = new JLabel("1");
		SetStyle style = new SetStyle();
		style.setJlableFontStyleAndColor(goBack, fontStyle, Black, 10, 10, 50, 20);
		style.setJlableFontStyleAndColor(gitCard, fontStyle, Black, 60, 10, 50, 20);
		style.setJlableFontStyleAndColor(pre, fontStyle, Black, 300, this.getHeight() - 30, 60, 20);
		style.setJlableFontStyleAndColor(next, fontStyle, Black, 400, this.getHeight() - 30, 60, 20);
		style.setJlableFontStyleAndColor(title, fontStyle, Color.RED, 10, 50, 200, 20);

		style.MouseInAndOut(goBack, "����");
		style.MouseInAndOut(gitCard, "�鿨");
		style.MouseInAndOut(pre, "��һҳ");
		style.MouseInAndOut(next, "��һҳ");
		
		//��ſ���panel
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(40, 80, this.getWidth() - 80, this.getHeight() - 110);
		cardPanel.setOpaque(false);

		

		// �¼�
		// �����ֿ��еĿ��Ʋ���ʾ
		SetData getCardInfo = new SetData();
		List<RolePereson> CardInfo = new ArrayList<RolePereson>();
		CardInfo = getCardInfo.getRolePereson();
		Page page = new Page(currentPage, CardInfo.size(), 10);
		SelectCardListener select = new SelectCardListener(this, goBack, gitCard, loginUserInfo
				,pre,next,current,cardPanel,page,CardInfo);
		select.cilickListener();

		showjp.add(goBack);
		showjp.add(gitCard);
		showjp.add(title);
		showjp.add(pre);
		showjp.add(next);
		showjp.add(current);

		layeredPane.add(showjp, JLayeredPane.MODAL_LAYER);
		layeredPane.add(cardPanel, JLayeredPane.POPUP_LAYER);
		this.setLayeredPane(layeredPane);
		setVisible(true);
	}
}
