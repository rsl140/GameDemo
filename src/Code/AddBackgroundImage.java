package Code;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ���������ñ���
 * */
public class AddBackgroundImage {
	
	public JPanel addBgImg(JPanel panel,ImageIcon image,int x,int y){
		
		//ͼƬ·��
	    JLabel bgjl;//��ű���ͼƬ�� panelΪ����ͼ��
	    panel.setBounds(x,y,image.getIconWidth(),image.getIconHeight());  
  
        bgjl=new JLabel(image);   
        panel.add(bgjl); 
		
		return panel;
	}
}
