package 软引用;

import java.lang.ref.Reference;

/**
 * 封装引用对象的基类
 * @author CodeingSnail
 *
 * @param <T>
 */
public abstract class ReferenceObject<T>{
	
	public Reference<T> ref;
	
	protected abstract T getInstance();
	protected abstract Reference<T> getReference(T t);
	
	/*
	 * 获取引用对象及弱引用
	 */
	private T getRefrenceAndInstance(){
		T t = getInstance();
		getReference(t);
		return t;
	}
	
	/**
	 * 获取被引用的对象
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
	 * 清空对象的引用，回收对象
	 */
	public void recycle() {
		if(ref != null){
			ref.clear();
			ref = null;
		}
	}
}
