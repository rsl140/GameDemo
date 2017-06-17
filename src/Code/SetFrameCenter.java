package Code;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * 居中显示窗口
 * @frame 窗口
 * @x 文件宽度
 * @y 文件高度
 * */
public class SetFrameCenter {
	public void Center(JFrame frame,int x,int y){
		//居中显示
				Toolkit kit=Toolkit.getDefaultToolkit();
				Dimension screenSize=kit.getScreenSize();
				int width=screenSize.width;
		        int height=screenSize.height;
		        int centerx=(width-x)/2;
		        int centery=(height-y)/2;
		        frame.setLocation(centerx,centery);
	}
}
