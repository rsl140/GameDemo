package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Code.AddBackgroundImage;
import Code.Modle.NameId;

public class BeginGameView extends JFrame{
	public NameId loginUserInfo;
	//����һ��JLayeredPane���ڷֲ�ġ�  
    JLayeredPane layeredPane;  
    //����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//������ʾ���ݵ�panel
	public BeginGameView(NameId loginUserInfo){
		this.loginUserInfo = loginUserInfo;
		layeredPane=new JLayeredPane();
		bgjp = new JPanel();
		//���ñ���
		new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "bg.png", 0, -3);
		
		this.setLayeredPane(layeredPane);
        setVisible(true);
	}
}
