package 代理模式;

/**
 * 一个简单的代理模式
 * @author Administrator
 *
 */
public class DaiLiMode {
	
	/**
	 * 定义了公共接口
	 * @author Administrator
	 *
	 */
	abstract class Subject{
		public abstract void request();
	}
	
	/**
	 * 被代理的类
	 * @author Administrator
	 *
	 */
	class RealSubject extends Subject{

		@Override
		public void request() {
			System.out.println("真实的请求。。。");
		}	
	}
	
	/**
	 * 代理类
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
