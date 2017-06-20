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
	//����һ��JLayeredPane���ڷֲ�ġ�  
    JLayeredPane layeredPane;  
    //����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//������ʾ���ݵ�panel
	public ManageCardView(NameId loginUserInfo){
		this.loginUserInfo = loginUserInfo;
		layeredPane=new JLayeredPane();
		bgjp = new JPanel();
		//���ñ���
		new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "bg.png", 0, -3);
		//��ͼ
		showjp = new JPanel();
		showjp.setBounds(0, 0, this.getWidth(), this.getWidth());
		showjp.setOpaque(false);
		showjp.setLayout(null);
		Font fontStyle = new Font("����", Font.BOLD, 20);
		Color Black = Color.BLACK;
		
		JLabel goBack = new JLabel("����");
		JLabel title = new JLabel("��ǰӵ�п��ƣ�");
		SetStyle style = new SetStyle();
		style.setJlableFontStyleAndColor(goBack, fontStyle, Black, 10, 10, 50, 20);
		style.setJlableFontStyleAndColor(title, fontStyle, Color.RED, 10, 50, 200, 20);
		style.MouseInAndOut(goBack, "����");
		
		
		
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(40, 80, this.getWidth()-80, this.getHeight()-110);
		cardPanel.setOpaque(false);
		//����ӵ�п��Ʋ���ʾ
		for (int i = 0; i < loginUserInfo.getRole().size(); i++) {
			//ͼƬ·��
			ImageIcon testimage;
			testimage=new ImageIcon(this.getClass().getResource("/img/"+ loginUserInfo.getRole().get(i).getSrc() +".png").getFile());        
	        
			//��������
		    JLabel bgjl;//��ű���ͼƬ�� panelΪ����ͼ��
		    JPanel test = new JPanel();
		    test.setBounds(0,0,testimage.getIconWidth(),testimage.getIconHeight());
	        bgjl=new JLabel(testimage);
	        test.add(bgjl);
	        bgjl.setText( loginUserInfo.getRole().get(i).getName());
	        cardPanel.add(test);
			
	        test.setBackground(Color.WHITE);
		}
		
		
        //�¼�
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
