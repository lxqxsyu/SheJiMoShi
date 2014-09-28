package 简单工场模式;

import 简单工场模式.Client.SimpleFactory.ProductNum;

public class Client {
	
	/**
	 * 产品的抽象类
	 * @author Administrator
	 *
	 */
	static abstract class Product{
		private String productName;
		public Product(String productString){
			this.productName = productString;
		}
		protected void productMessage(){
			System.out.println("产品的名字为：" + productName);
		}
	}
	
	/**
	 * 产品1
	 * @author Administrator
	 *
	 */
	static class Product1 extends Product{

		public Product1(String productString) {
			super(productString);
		}	
	}
	
	/**
	 * 产品2
	 * @author Administrator
	 *
	 */
	static class Product2 extends Product{

		public Product2(String productString) {
			super(productString);
		}
	}
	
	/**
	 * 产品3
	 * @author Administrator
	 *
	 */
	static class Product3 extends Product{

		public Product3(String productString) {
			super(productString);
		}
	}
	
	/**
	 * 简单工场
	 * @author Administrator
	 *
	 */
	static class SimpleFactory{
		enum ProductNum{
			p1,
			p2,
			p3
		}
		public static Product getProduct(ProductNum num) throws InvalidParameterException{
			Product product;
			switch (num) {
			case p1:
				product = new Product1("产品1");
				break;
			case p2:
				product = new Product2("产品2");
				break;
			case p3:
				product = new Product3("产品3");
				break;
			default:
				throw new InvalidParameterException("传入的参数不正确");
			}
			return product;
		}
	}
	
	/**
	 * 自定义参数错误异常
	 * @author Administrator
	 *
	 */
	static class InvalidParameterException extends Exception{
		private static final long serialVersionUID = -8749343814734164584L;
		public InvalidParameterException() { }
		public InvalidParameterException(String msg){
			super(msg);
		}
		public InvalidParameterException(Throwable cause) {
			super(cause);
		}
		public InvalidParameterException(String message, Throwable cause,
				boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}
		public InvalidParameterException(String message, Throwable cause) {
			super(message, cause);
		}

	}
	
	public static void main(String[] args) {
		try {
			Product p1 = SimpleFactory.getProduct(ProductNum.p1);
			Product p2 = SimpleFactory.getProduct(ProductNum.p2);
			Product p3 = SimpleFactory.getProduct(ProductNum.p3);
			p1.productMessage();
			p2.productMessage();
			p3.productMessage();
		} catch (InvalidParameterException e) {
			e.printStackTrace();
		}
	}
}
