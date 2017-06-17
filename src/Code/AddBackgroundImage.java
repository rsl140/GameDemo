package Code;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ¸ø´°¿ÚÉèÖÃ±³¾°
 * */
public class AddBackgroundImage {
	
	public JPanel addBgImg(JPanel panel,ImageIcon image,int x,int y){
		
		//Í¼Æ¬Â·¾¶
	    JLabel bgjl;//´æ·Å±³¾°Í¼Æ¬ÓÃ panelÎª±³¾°Í¼²ã
	    panel.setBounds(x,y,image.getIconWidth(),image.getIconHeight());  
  
        bgjl=new JLabel(image);   
        panel.add(bgjl); 
		
		return panel;
	}
}
