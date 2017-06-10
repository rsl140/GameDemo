package Code;

import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.Scanner;

public class RandomRole extends Exception {

	public Scanner input = new Scanner(System.in);

	ObjectOutputStream oos=null;
	ObjectInputStream ois=null;
	
	RandomRole() {
	}

	void RandomCM() throws Exception {

		String str = RandomRole.class.getResource("Data\\onepiece.txt").getPath();
		File file=new File(str);
//		StringBuffer stb=new StringBuffer(str);
		System.out.println(str);
		Reader reader=new FileReader(file);
		char[] data=new char[1024];
		int len=reader.read(data);
		String ck=new String(data,0,len);
		String[] ckArray=ck.split("\r\n");
		if(ckArray.length>1){
			for(int i=0;i<ckArray.length;i++){
				System.out.println(ckArray[i]);
			}
		}
		
//		oos=new ObjectOutputStream(new FileOutputStream(file));
//		String ck=oos.toString();
//		System.out.println(ck);
//		String[] ck1 =  ck.split("\n");
//		for(int i=0;i<ck1.length;i++){
//			System.out.println(ck1[i]);
//		}
	}
		
	public static void main(String[] args) throws Exception {
		RandomRole r=new RandomRole();
		r.RandomCM();
	}
}

