package ����ģʽ;

public class Singleton {
	
	private static Singleton instance;
	
	private Singleton(){ }
	
	public static Singleton getInstance(){
		//�̰߳�ȫ�����
		/*if(instance == null){
			instance = new Singleton();
		}*/
		//���̰߳�ȫ(˫����)
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	public void putScreen(){
		System.out.println("����ģʽ������");
	}
	
	public static void main(String[] args) {
		Singleton.getInstance().putScreen();
	}
}
