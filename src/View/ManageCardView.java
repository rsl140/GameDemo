package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Code.AddBackgroundImage;
import Code.SetData;
import Code.SetStyle;
import Code.Listener.ManageCardListener;
import Code.Listener.SelectCardListener;
import Code.Modle.NameId;
import Code.Modle.RolePereson;

public class ManageCardView extends JFrame{
	public NameId loginUserInfo;
	//创建一个JLayeredPane用于分层的。  
    JLayeredPane layeredPane;  
    //创建一个Panel和一个Label用于存放图片，作为背景。  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//用于显示内容的panel
	public ManageCardView(NameId loginUserInfo){
		this.loginUserInfo = loginUserInfo;
		layeredPane=new JLayeredPane();
		bgjp = new JPanel();
		//设置背景
		new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "bg.png", 0, -3);
		//绘图
		showjp = new JPanel();
		showjp.setBounds(0, 0, this.getWidth(), this.getWidth());
		showjp.setOpaque(false);
		showjp.setLayout(null);
		Font fontStyle = new Font("宋体", Font.BOLD, 20);
		Color Black = Color.BLACK;
		
		JLabel goBack = new JLabel("返回");
		JLabel title = new JLabel("当前拥有卡牌：");
		SetStyle style = new SetStyle();
		style.setJlableFontStyleAndColor(goBack, fontStyle, Black, 10, 10, 50, 20);
		style.setJlableFontStyleAndColor(title, fontStyle, Color.RED, 10, 50, 200, 20);
		style.MouseInAndOut(goBack, "返回");
		
		
		
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(40, 80, this.getWidth()-80, this.getHeight()-110);
		cardPanel.setOpaque(false);
		//遍历拥有卡牌并显示
		for (int i = 0; i < loginUserInfo.getRole().size(); i++) {
			//图片路径
			ImageIcon testimage;
			testimage=new ImageIcon(this.getClass().getResource("/img/"+ loginUserInfo.getRole().get(i).getSrc() +".png").getFile());        
	        
			//创建背景
		    JLabel bgjl;//存放背景图片用 panel为背景图层
		    JPanel test = new JPanel();
		    test.setBounds(0,0,testimage.getIconWidth(),testimage.getIconHeight());
	        bgjl=new JLabel(testimage);
	        test.add(bgjl);
	        bgjl.setText( loginUserInfo.getRole().get(i).getName());
	        cardPanel.add(test);
			
	        test.setBackground(Color.WHITE);
		}
		
		
        //事件
		ManageCardListener listener = new ManageCardListener(this,goBack,loginUserInfo);
		listener.cilickListener();
		
		showjp.add(goBack);
		showjp.add(title);
		
		
		layeredPane.add(showjp,JLayeredPane.MODAL_LAYER);
		layeredPane.add(cardPanel,JLayeredPane.POPUP_LAYER);
		this.setLayeredPane(layeredPane);
        setVisible(true);
	}
}
