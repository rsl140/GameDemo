package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Code.AddBackgroundImage;
import Code.Modle.NameId;

public class BeginGameView extends JFrame{
	public NameId loginUserInfo;
	//创建一个JLayeredPane用于分层的。  
    JLayeredPane layeredPane;  
    //创建一个Panel和一个Label用于存放图片，作为背景。  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//用于显示内容的panel
	public BeginGameView(NameId loginUserInfo){
		this.loginUserInfo = loginUserInfo;
		layeredPane=new JLayeredPane();
		bgjp = new JPanel();
		//设置背景
		new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "bg.png", 0, -3);
		
		this.setLayeredPane(layeredPane);
        setVisible(true);
	}
}
