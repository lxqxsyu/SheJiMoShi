package ��������ģ��;

import java.util.ArrayList;
import java.util.List;

/**
 * ���̵߳���������ģ��
 * @author Administrator
 *
 */
public class ProducerConsumerMode {
	private static final int MAX_SIZE = 10;
	private List<String> container = new ArrayList<String>();  //���������
	private Object consumerMonitor;  //������
	private Object producerMonitor;  //������
	private static int num;			 //��Ʒ���
	private static boolean isStop = false;  //�Ƿ�ֹͣ������
	
	public ProducerConsumerMode(Object consumerMonitor, Object producerMonitor) {
		super();
		this.consumerMonitor = consumerMonitor;
		this.producerMonitor = producerMonitor;
	}

	/**
	 * ��������
	 * @author Administrator
	 *
	 */
	class Producer implements Runnable{
		
		/**
		 * ����
		 */
		public void produce(){
			if(isFull()){  //�ж������Ƿ��Ѿ�����
				//����������
				synchronized (consumerMonitor) {
					if(isFull()){ //�ٴ��ж���Ϊ�˷�ֹ��������ߣ�����̣߳��Ͷ�������ߣ�����̣߳�
						consumerMonitor.notify();
					}
				}
				//�����߹���
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
				//����
				addProduce();
			}
		}
		
		private void addProduce(){
			String pName = "��Ʒ" + (++num);
			synchronized (producerMonitor) {
				if(!isFull()){
					container.add(pName);
				}
			}
			System.out.println("������" + pName);
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
	 * ������
	 * @author Administrator
	 *
	 */
	class Consumer implements Runnable{
		
		/**
		 * ����
		 */
		public void consume(){
			if(isEmpty()){
				//����������
				synchronized (producerMonitor) {
					if(isEmpty()){
						producerMonitor.notify();
					}
				}
				//�����߹���
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
				//����
				consumeProduce();
			}
		}
		
		private void consumeProduce(){
			synchronized (consumerMonitor) {
				if(!isEmpty()){
					System.out.println("������" + container.get(container.size() - 1));
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
	 * �ж������Ƿ��Ѿ�����
	 * @return
	 */
	private boolean isFull(){
		return container.size() >= MAX_SIZE;
	}
	
	/**
	 * �ж������Ƿ��ǿյ�
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
