package �۲���ģʽ;

public class ObserverClass1 implements SuperObsever{

	@Override
	public void update(Object data) {
		String str = (String) data;
		System.out.println("���ǹ۲���1��֪ͨ���ҵ�������: " + str);
	}
}
