package Code;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * 给窗口设置背景
 * */
public class AddBackgroundImage {
	
	public void addBackgroundImg(JFrame frame,JLayeredPane layeredPane,JPanel bgjp,ImageIcon image,String src,int x,int y){
		//图片路径
        image=new ImageIcon(this.getClass().getResource("/img/"+ src).getFile());        
        //创建背景
	    JLabel bgjl;//存放背景图片用 panel为背景图层
	    bgjp.setBounds(x,y,image.getIconWidth(),image.getIconHeight());  
  
        bgjl=new JLabel(image);   
        bgjp.add(bgjl); 
        
	    //将bgjp放到最底层。
        layeredPane.add(bgjp,JLayeredPane.DEFAULT_LAYER);
        
        //frame.setLayeredPane(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(image.getIconWidth(),image.getIconHeight());
        frame.setUndecorated(true);//删除title
        frame.setResizable(false);//不能放大
      //居中
        SetFrameCenter center = new SetFrameCenter();
        center.Center(frame, image.getIconWidth(), image.getIconHeight());;
	}
}
