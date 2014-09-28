package 观察者模式;

import java.util.ArrayList;
import java.util.List;

public abstract class NotifySuperClass {
	
	public List<SuperObsever> observers = new ArrayList<SuperObsever>();
	
	/**
	 * 添加观察者
	 * @param obsever
	 */
	public abstract void addObsever(SuperObsever obsever);
	
	/**
	 * 移除观察者
	 * @param observer
	 */
	public abstract void removeObserver(SuperObsever observer);
	
	/**
	 * 通知观察者
	 */
	public abstract void notifyOberver(Object data);
}
