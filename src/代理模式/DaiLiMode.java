package ����ģʽ;

/**
 * һ���򵥵Ĵ���ģʽ
 * @author Administrator
 *
 */
public class DaiLiMode {
	
	/**
	 * �����˹����ӿ�
	 * @author Administrator
	 *
	 */
	abstract class Subject{
		public abstract void request();
	}
	
	/**
	 * ���������
	 * @author Administrator
	 *
	 */
	class RealSubject extends Subject{

		@Override
		public void request() {
			System.out.println("��ʵ�����󡣡���");
		}	
	}
	
	/**
	 * ������
	 * @author Administrator
	 *
	 */
	class Proxy extends Subject{
		private RealSubject realSubject;
		
		@Override
		public void request() {
			if(realSubject == null){
				realSubject = new RealSubject();
			}
			realSubject.request();
		}
	}
	
	public static void main(String[] args) {
		DaiLiMode dm = new DaiLiMode();
		Proxy proxy = dm.new Proxy();
		proxy.request();
	}
}
