package 单例模式;

public class Singleton {
	
	private static Singleton instance;
	
	private Singleton(){ }
	
	public static Singleton getInstance(){
		//线程安全情况下
		/*if(instance == null){
			instance = new Singleton();
		}*/
		//非线程安全(双重锁)
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
		System.out.println("单例模式。。。");
	}
	
	public static void main(String[] args) {
		Singleton.getInstance().putScreen();
	}
}
