package 生产消费模型;

import java.util.ArrayList;
import java.util.List;

/**
 * 单线程的消费生产模型
 * @author Administrator
 *
 */
public class ProducerConsumerMode {
	private static final int MAX_SIZE = 10;
	private List<String> container = new ArrayList<String>();  //储存的容器
	private Object consumerMonitor;  //消费锁
	private Object producerMonitor;  //生产锁
	private static int num;			 //产品序号
	private static boolean isStop = false;  //是否停止生产了
	
	public ProducerConsumerMode(Object consumerMonitor, Object producerMonitor) {
		super();
		this.consumerMonitor = consumerMonitor;
		this.producerMonitor = producerMonitor;
	}

	/**
	 * 生产者类
	 * @author Administrator
	 *
	 */
	class Producer implements Runnable{
		
		/**
		 * 生产
		 */
		public void produce(){
			if(isFull()){  //判断容器是否已经满了
				//唤醒消费者
				synchronized (consumerMonitor) {
					if(isFull()){ //再次判断是为了防止多个生产者（多个线程）和多个消费者（多个线程）
						consumerMonitor.notify();
					}
				}
				//生产者挂起
				synchronized (producerMonitor) {
					try {
						if(isFull()){
							producerMonitor.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}else{
				//生产
				addProduce();
			}
		}
		
		private void addProduce(){
			String pName = "产品" + (++num);
			synchronized (producerMonitor) {
				if(!isFull()){
					container.add(pName);
				}
			}
			System.out.println("生产了" + pName);
		}

		@Override
		public void run() {
			while(num <= 100){
				produce();
			}
			synchronized (consumerMonitor) {
				consumerMonitor.notify();
			}
			isStop = true;
		}
	}
	
	/**
	 * 消费者
	 * @author Administrator
	 *
	 */
	class Consumer implements Runnable{
		
		/**
		 * 消费
		 */
		public void consume(){
			if(isEmpty()){
				//唤醒生产者
				synchronized (producerMonitor) {
					if(isEmpty()){
						producerMonitor.notify();
					}
				}
				//消费者挂起
				synchronized (consumerMonitor) {
					try {
						if(isEmpty()){
							consumerMonitor.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}else{
				//消费
				consumeProduce();
			}
		}
		
		private void consumeProduce(){
			synchronized (consumerMonitor) {
				if(!isEmpty()){
					System.out.println("消费了" + container.get(container.size() - 1));
					container.remove(container.size() - 1);
				}
			}
		}

		@Override
		public void run() {
			while(!isStop || !isEmpty()){
				consume();
			}
		}
	}
	
	/**
	 * 判断容器是否已经满了
	 * @return
	 */
	private boolean isFull(){
		return container.size() >= MAX_SIZE;
	}
	
	/**
	 * 判断容器是否是空的
	 * @return
	 */
	private boolean isEmpty(){
		return container.isEmpty();
	}
	
	public static void main(String[] args) {
		ProducerConsumerMode pcm = new ProducerConsumerMode(new Object(), new Object());
		
		new Thread(pcm.new Producer()).start();
		new Thread(pcm.new Producer()).start();
		new Thread(pcm.new Producer()).start();
		new Thread(pcm.new Producer()).start();
		
		new Thread(pcm.new Consumer()).start();
		new Thread(pcm.new Consumer()).start();
		new Thread(pcm.new Consumer()).start();
	}
}
