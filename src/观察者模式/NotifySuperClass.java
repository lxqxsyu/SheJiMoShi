package �۲���ģʽ;

import java.util.ArrayList;
import java.util.List;

public abstract class NotifySuperClass {
	
	public List<SuperObsever> observers = new ArrayList<SuperObsever>();
	
	/**
	 * ��ӹ۲���
	 * @param obsever
	 */
	public abstract void addObsever(SuperObsever obsever);
	
	/**
	 * �Ƴ��۲���
	 * @param observer
	 */
	public abstract void removeObserver(SuperObsever observer);
	
	/**
	 * ֪ͨ�۲���
	 */
	public abstract void notifyOberver(Object data);
}
