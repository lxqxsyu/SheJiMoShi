package 软引用;

import java.lang.ref.SoftReference;

import javax.swing.ImageIcon;

public class Client {
	SoftReference<ImageIcon> softRefrence;
	private ReferenceBitmap referenceBitmap;
	
	public static void main(String[] args) {
		Client client = new Client();
		client.referenceBitmap = new ReferenceBitmap("E:\\test.png");
		System.out.println("图片的高度是:" + client.referenceBitmap.get().getIconHeight());
		System.out.println("图片的宽度是:" + client.referenceBitmap.get().getIconWidth());
		
		//简化方法
		client.softRefrence = 
				new SoftReference<ImageIcon>(new ImageIcon("E:\\test.png"));
		System.out.println("图片的高度是:" + client.softRefrence.get().getIconHeight());
		System.out.println("图片的宽度是:" + client.softRefrence.get().getIconWidth());
	}
}
