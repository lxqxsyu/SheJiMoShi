package ������;

import java.lang.ref.SoftReference;

import javax.swing.ImageIcon;

public class Client {
	SoftReference<ImageIcon> softRefrence;
	private ReferenceBitmap referenceBitmap;
	
	public static void main(String[] args) {
		Client client = new Client();
		client.referenceBitmap = new ReferenceBitmap("E:\\test.png");
		System.out.println("ͼƬ�ĸ߶���:" + client.referenceBitmap.get().getIconHeight());
		System.out.println("ͼƬ�Ŀ����:" + client.referenceBitmap.get().getIconWidth());
		
		//�򻯷���
		client.softRefrence = 
				new SoftReference<ImageIcon>(new ImageIcon("E:\\test.png"));
		System.out.println("ͼƬ�ĸ߶���:" + client.softRefrence.get().getIconHeight());
		System.out.println("ͼƬ�Ŀ����:" + client.softRefrence.get().getIconWidth());
	}
}
