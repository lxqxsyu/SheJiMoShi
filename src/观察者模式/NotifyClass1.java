package 观察者模式;

public class NotifyClass1 extends NotifySuperClass{

	@Override
	public void addObsever(SuperObsever obsever) {
		observers.add(obsever);
	}

	@Override
	public void removeObserver(SuperObsever observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyOberver(Object data) {
		for(SuperObsever so : observers){
			so.update(data);
		}
	}
	
	public static void main(String[] args) {
		NotifySuperClass nc = new NotifyClass1();
		nc.addObsever(new ObserverClass1());
		nc.addObsever(new ObserverClass2());
		nc.notifyOberver("hello 你好");
	}
}
