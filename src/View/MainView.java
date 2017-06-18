package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Code.AddBackgroundImage;
import Code.SetStyle;
import Code.Listener.MainViewListener;
import Code.Modle.NameId;

public class MainView extends JFrame{
	public NameId loginUserInfo;//登陆账号
	//创建一个JLayeredPane用于分层的。  
    JLayeredPane layeredPane;  
    //创建一个Panel和一个Label用于存放图片，作为背景。  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//用于显示内容的panel
	
	public MainView(NameId loginUserInfo){
		layeredPane=new JLayeredPane();
		bgjp = new JPanel();
		//设置背景
		new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "main.jpg", 0, -3);
        //
		showjp = new JPanel();
		showjp.setBounds(290, 350, 237, 233);
		showjp.setOpaque(false);
		showjp.setLayout(null);
		JLabel hasRole = new JLabel("当前拥有角色:"+loginUserInfo.getRole().size()+"个");
		JLabel starGame = new JLabel("1.开始游戏");
		JLabel lookRole = new JLabel("2.管理卡牌");
		JLabel drawACard = new JLabel("3.开始抽牌");
		JLabel quiteGame = new JLabel("4.退出游戏");
		
		Font hasRoleFont = new Font("宋体", Font.BOLD, 16);
		Font lableFont = new Font("宋体", Font.BOLD, 24);
		Color red = Color.RED;
		Color white = Color.WHITE;
		
		SetStyle style = new SetStyle();
		style.setJlableFontStyleAndColor(hasRole, hasRoleFont, red, 40, 5, 200, 30);
		style.setJlableFontStyleAndColor(starGame, lableFont, white, 30, 40, 150, 30);
		style.setJlableFontStyleAndColor(lookRole, lableFont, white, 30, 80, 150, 30);
		style.setJlableFontStyleAndColor(drawACard, lableFont, white, 30, 120, 150, 30);
		style.setJlableFontStyleAndColor(quiteGame, lableFont, white, 30, 160, 150, 30);
		
		showjp.add(hasRole);
		showjp.add(starGame);
		showjp.add(lookRole);
		showjp.add(drawACard);
		showjp.add(quiteGame);
		
		layeredPane.add(showjp,JLayeredPane.MODAL_LAYER);
		
		//事件
		MainViewListener listener = new MainViewListener(starGame,lookRole,drawACard,quiteGame);
		listener.MouseInAndOut(starGame,"1.开始游戏");
		listener.MouseInAndOut(lookRole,"2.管理卡牌");
		listener.MouseInAndOut(drawACard,"3.开始抽牌");
		listener.MouseInAndOut(quiteGame,"4.退出游戏");
		
		this.setLayeredPane(layeredPane);
        setVisible(true);
	}
}
