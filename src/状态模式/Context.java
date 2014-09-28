package ״̬ģʽ;

/**
 * ״̬ģʽ
 * @author Administrator
 *
 */
public class Context {
	private State currentState;
	
	public Context(){
		currentState = new State1("state1");	
	}
	
	public void changeCurrentState(State currentState){
		this.currentState = currentState;
	}
	
	public State getCurrentState(){
		return currentState;
	}
	
	/**
	 * ״̬�ĳ�����
	 * @author Administrator
	 *
	 */
	abstract class State{
		
		protected String stateName;
		
		protected abstract void doSomething();
		protected abstract void changeToNextState();
		public State(String stateName){
			this.stateName = stateName;
		}
		private String getStateName(){
			return stateName;
		}
	}
	
	/**
	 * ״̬1
	 * @author Administrator
	 *
	 */
	class State1 extends State{

		public State1(String stateName) {
			super(stateName);
		}

		@Override
		public void doSomething() {
			System.out.println("curr");
		}

		@Override
		public void changeToNextState() {
			changeCurrentState(new State2("state2"));
		}	
	}
	
	/**
	 * ״̬2
	 * @author Administrator
	 *
	 */
	class State2 extends State{

		public State2(String stateName) {
			super(stateName);
		}

		@Override
		public void doSomething() {
		
		}

		@Override
		public void changeToNextState() {
			changeCurrentState(new State3("state3"));
		}
		
	}
	
	/**
	 * ״̬3
	 * @author Administrator
	 *
	 */
	class State3 extends State{

		public State3(String stateName) {
			super(stateName);
		}

		@Override
		protected void doSomething() {
			
		}

		@Override
		protected void changeToNextState() {
			changeCurrentState(new State1("state1"));
		}
	}
	
	public static void main(String[] args) {
		Context context = new Context();
		for(int i = 0; i < 10; i++){
			System.out.println(
					"��ǰ״̬��____" + context.getCurrentState().getStateName());
			context.getCurrentState().changeToNextState();
		}
	}
}
