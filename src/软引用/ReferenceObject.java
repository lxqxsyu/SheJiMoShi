package ������;

import java.lang.ref.Reference;

/**
 * ��װ���ö���Ļ���
 * @author CodeingSnail
 *
 * @param <T>
 */
public abstract class ReferenceObject<T>{
	
	public Reference<T> ref;
	
	protected abstract T getInstance();
	protected abstract Reference<T> getReference(T t);
	
	/*
	 * ��ȡ���ö���������
	 */
	private T getRefrenceAndInstance(){
		T t = getInstance();
		getReference(t);
		return t;
	}
	
	/**
	 * ��ȡ�����õĶ���
	 * @return
	 */
	public T get(){
		if(ref == null){
			return getRefrenceAndInstance();
		}
		T t = ref.get();
		if(t == null){
			return getRefrenceAndInstance();
		}
		return t;
	}
	
	/**
	 * ��ն�������ã����ն���
	 */
	public void recycle() {
		if(ref != null){
			ref.clear();
			ref = null;
		}
	}
}
