package 观察者模式;

public class ObserverClass1 implements SuperObsever{

	@Override
	public void update(Object data) {
		String str = (String) data;
		System.out.println("我是观察者1，通知给我的内容是: " + str);
	}
}
