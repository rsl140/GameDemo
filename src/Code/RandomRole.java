package Code;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class RandomRole extends Exception {

	public Scanner input = new Scanner(System.in);

	ObjectOutputStream oos=null;
	ObjectInputStream ois=null;
	
	RandomRole() {
	}

	void RandomCM() throws Exception {

		File str = new File(File.separator+"Users"+File.separator+"lenovo"+File.separator+"Desktop"+File.separator+"�������ݿ�"+File.separator+"����"+File.separator+"����.txt");
		oos=new ObjectOutputStream(new FileOutputStream(str));
		String ck=oos.toString();
		String[] ck1 =  ck.split("\n");
		for(int i=0;i<ck1.length;i++){
			System.out.println(ck1[i]);
		}
	}
		
	public static void main(String[] args) throws Exception {
		RandomRole r=new RandomRole();
		r.RandomCM();
	}
}

