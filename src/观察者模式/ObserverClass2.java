package �۲���ģʽ;

public class ObserverClass2 implements SuperObsever{

	@Override
	public void update(Object data) {
		String str = (String) data;
		System.out.println("���ǹ۲���2��֪ͨ���ҵ�������: " + str);
	}
}
