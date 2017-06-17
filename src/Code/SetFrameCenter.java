package Code;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * ������ʾ����
 * @frame ����
 * @x �ļ����
 * @y �ļ��߶�
 * */
public class SetFrameCenter {
	public void Center(JFrame frame,int x,int y){
		//������ʾ
				Toolkit kit=Toolkit.getDefaultToolkit();
				Dimension screenSize=kit.getScreenSize();
				int width=screenSize.width;
		        int height=screenSize.height;
		        int centerx=(width-x)/2;
		        int centery=(height-y)/2;
		        frame.setLocation(centerx,centery);
	}
}
