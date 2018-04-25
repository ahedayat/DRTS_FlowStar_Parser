import java.util.*;

public class Parser{

	public static void parse(String content){
		Scope global = new Scope(); 

		Scope crrScope = new Scope();
		Stack<Scope> scopeStack = new Stack<Scope>();

		scopeStack.push(global);
		crrScope = scopeStack.pop();
		do{
			String line = getNewLine(content);
			if(line.equals("{")){
				scopeStack.push(crrScope);
				crrScope = new Scope();
			}
			else if(line.equals("}")){
				scopeStack.peek().addScope(crrScope);
				crrScope = scopeStack.pop();
			}
			else{
				crrScope.addLine(line);
			}
		}while(!scopeStack.empty())
		return global;
	}
}