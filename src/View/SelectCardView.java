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
 *抽卡页面
 */
public class SelectCardView extends JFrame {
	public NameId loginUserInfo;
	// 创建一个JLayeredPane用于分层的。
	JLayeredPane layeredPane;
	// 创建一个Panel和一个Label用于存放图片，作为背景。
	JPanel bgjp;
	ImageIcon image;
	JPanel showjp;// 用于显示内容的panel
	int currentPage;// 当前页面

	public SelectCardView(NameId loginUserInfo) {
		this.loginUserInfo = loginUserInfo;
		currentPage = 1;
		layeredPane = new JLayeredPane();
		bgjp = new JPanel();
		// 设置背景
		new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "bg.png", 0, -3);
		// 绘图
		showjp = new JPanel();
		showjp.setBounds(0, 0, this.getWidth(), this.getHeight());
		showjp.setOpaque(false);
		showjp.setLayout(null);
		Font fontStyle = new Font("宋体", Font.BOLD, 20);
		Color Black = Color.BLACK;

		JLabel goBack = new JLabel("返回");
		JLabel gitCard = new JLabel("抽卡");
		JLabel title = new JLabel("当前卡牌仓库：");
		JLabel pre = new JLabel("上一页");
		JLabel next = new JLabel("下一页");
		JLabel current = new JLabel("1");
		SetStyle style = new SetStyle();
		style.setJlableFontStyleAndColor(goBack, fontStyle, Black, 10, 10, 50, 20);
		style.setJlableFontStyleAndColor(gitCard, fontStyle, Black, 60, 10, 50, 20);
		style.setJlableFontStyleAndColor(pre, fontStyle, Black, 300, this.getHeight() - 30, 60, 20);
		style.setJlableFontStyleAndColor(next, fontStyle, Black, 400, this.getHeight() - 30, 60, 20);
		style.setJlableFontStyleAndColor(title, fontStyle, Color.RED, 10, 50, 200, 20);

		style.MouseInAndOut(goBack, "返回");
		style.MouseInAndOut(gitCard, "抽卡");
		style.MouseInAndOut(pre, "上一页");
		style.MouseInAndOut(next, "下一页");
		
		//存放卡牌panel
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(40, 80, this.getWidth() - 80, this.getHeight() - 110);
		cardPanel.setOpaque(false);

		

		// 事件
		// 遍历仓库中的卡牌并显示
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
