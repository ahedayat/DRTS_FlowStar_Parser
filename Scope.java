import java.util.ArrayList;

public class Scope{
	ArrayList<String> scopeContent;
	ArrayList<Scope> subscopes;

	Scope(){
		this.scopeContent = new ArrayList<String>();
		this.subscopes = new ArrayList<Scope>();
	}

	public void addContent(String content){
		this.scopeContent.add(content);
	}

	public void addScope(Scope crrSubscope){
		this.subscopes.add(crrSubscope);
	}
	
}