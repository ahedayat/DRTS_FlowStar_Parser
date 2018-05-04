import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.*;
import java.io.*;

public class CBFile{
	private List<String> statements;
	private Integer crrStatementIndex;


	public CBFile(){																				//tested 
		this.crrStatementIndex = new Integer(0);
		this.statements = new ArrayList<String>();
	}	

	public CBFile(String fileContent){
		this.crrStatementIndex = new Integer(0);

		String statementsArray[] = fileContent.split("\n");
		this.statements = Arrays.asList(statementsArray);
	}

	public void open(String filename) throws FileNotFoundException,IOException{						//tested
		File file = new File(filename);
		this.crrStatementIndex = new Integer(0);

		BufferedReader br = new BufferedReader(new FileReader(file));

		String crrStatement;
		while ((crrStatement = br.readLine()) != null){
			if( !crrStatement.trim().isEmpty() )					//The java string trim() method eliminates leading and trailing spaces.
				statements.add(crrStatement.trim());
		}
	}

	public Boolean next(){																			//tested
		return !crrStatementIndex.equals( statements.size() );
	}

	public Boolean previous(){																		//tested
		return !crrStatementIndex.equals(-1);
	}

	public String forward() throws IndexOutOfBoundsException{										//tested
		if( this.crrStatementIndex.equals(-1) )
			this.crrStatementIndex = 0 ;
		if( this.crrStatementIndex.equals( statements.size() ) )
			throw new IndexOutOfBoundsException("There isn't any statement.this statement is last one.");
		else{
			++this.crrStatementIndex;
			return this.statements.get( this.crrStatementIndex - 1 );
		}
	}

	public String backward() throws IndexOutOfBoundsException{										//tested
		if( this.crrStatementIndex.equals( statements.size() ) )
			this.crrStatementIndex = this.crrStatementIndex - 1;

		if( this.crrStatementIndex.equals( -1 ) )
			throw new IndexOutOfBoundsException("There isn't any statement.this statement is first one.");
		else{
			--crrStatementIndex;
			return this.statements.get( this.crrStatementIndex + 1 );
		}
	}

	public String getStatement(){
		return statements.get(crrStatementIndex);
	}

	public List<String> get(){
		return statements;
	}

	public void print2(){
		System.out.println("crrStatementIndex : " + crrStatementIndex );
		System.out.println("number of statements : " + statements.size() );
	}

	public void print(){
		System.out.println("crrStatementIndex : " + crrStatementIndex );
		System.out.println("number of statements : " + statements.size() );
		
		Integer statementCounter = new Integer(0);
		for( String str : statements ){
			++statementCounter;
			System.out.println( statementCounter + " |" + str );
		}
	}
}