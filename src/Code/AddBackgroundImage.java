package Code;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * ���������ñ���
 * */
public class AddBackgroundImage {
	
	public void addBackgroundImg(JFrame frame,JLayeredPane layeredPane,JPanel bgjp,ImageIcon image,String src,int x,int y){
		//ͼƬ·��
        image=new ImageIcon(this.getClass().getResource("/img/"+ src).getFile());        
        //��������
	    JLabel bgjl;//��ű���ͼƬ�� panelΪ����ͼ��
	    bgjp.setBounds(x,y,image.getIconWidth(),image.getIconHeight());  
  
        bgjl=new JLabel(image);   
        bgjp.add(bgjl); 
        
	    //��bgjp�ŵ���ײ㡣
        layeredPane.add(bgjp,JLayeredPane.DEFAULT_LAYER);
        
        //frame.setLayeredPane(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(image.getIconWidth(),image.getIconHeight());
        frame.setUndecorated(true);//ɾ��title
        frame.setResizable(false);//���ܷŴ�
      //����
        SetFrameCenter center = new SetFrameCenter();
        center.Center(frame, image.getIconWidth(), image.getIconHeight());;
	}
}
