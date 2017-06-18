package Code.Listener;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
/**
 * 主页面监听事件
 *
 */
public class MainViewListener {
	private JLabel starGame;
	private JLabel lookRole;
	private JLabel drawACard;
	private JLabel quiteGame;
	
	public MainViewListener(JLabel starGame, JLabel lookRole, JLabel drawACard, JLabel quiteGame) {
		super();
		this.starGame = starGame;
		this.lookRole = lookRole;
		this.drawACard = drawACard;
		this.quiteGame = quiteGame;
	}
	
	public void MouseInAndOut(JLabel jlabel,String str){
		jlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				jlabel.setText("<HTML><U>"+ str +"</U></HTML>");
				//手指样式
				jlabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				jlabel.setText(str);
			}
		});
	}

}
