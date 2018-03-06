package Lab08;


public class StackExample {

	public static Stack<Integer> getEvenNumbers(Stack<Integer> stack){
		
		Stack<Integer> newStack = new Stack<Integer>();
		Stack<Integer> inputStack = new Stack<Integer>();
		
		while(!stack.isEmpty()){
			inputStack.push(stack.pop());
		}
		
		
		while(!inputStack.isEmpty()){
			
			Integer stackPop = inputStack.pop();
			stack.push(stackPop);
			
			if(stackPop % 2 == 0){
				newStack.push(stackPop);
			}
		}
		
		
		return newStack;
	}
	
	
	
	
}
