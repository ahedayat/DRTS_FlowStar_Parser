/*#####################################################################
Ali Hedayatnia , University of Tehran
Last modified : 2018/May/06

#######################################################################*/
import java.util.Map;
import java.util.HashMap;
import java.lang.NoSuchFieldException;

public class Sample{
	Map<String,PolyNomial> polynomials;
	Map<String,Interval> ranges;

	public Sample(){																			//tested
		this.polynomials = new HashMap<String,PolyNomial>();
		this.ranges = new HashMap<String,Interval>();
	}
	public Sample(Map<String,PolyNomial> polynomials , Map<String,Interval> ranges){
		this.polynomials = polynomials;
		this.ranges = ranges;
	}

	public void addPolynomial(String name , PolyNomial polynomial)throws IllegalAccessException{ //tested
		if(this.polynomials.get(name) != null)
			throw new IllegalAccessException("There is a polynomial with this name.");
		this.polynomials.put(name , polynomial);
	}

	public void addRange(String name , Interval range)throws IllegalAccessException{			//tested											//tested
		if(this.ranges.get(name) != null)
			throw new IllegalAccessException("There is a range with this name.");
		this.ranges.put(name,range);
	}

	public void changePolynomial(String name , PolyNomial polynomial)throws IllegalAccessException{//tested
		if(this.polynomials.get(name) == null)
			throw new IllegalAccessException("There is no polynomial with this name.");
		this.polynomials.put(name , polynomial);
	}

	public void changeRange(String name , Interval range)throws IllegalAccessException{			//tested
		if(this.ranges.get(name) == null)
			throw new IllegalAccessException("There is no range with this name.");
		this.ranges.put(name,range);
	}

	public PolyNomial get(String variableName) throws NoSuchFieldException{						//tested
		if( polynomials.get(variableName)==null )
			throw new NoSuchFieldException("There is no variable with this name.");
		return polynomials.get(variableName);
	}

	public Interval getRange(String intervalName) throws NoSuchFieldException{					//tested
		if( ranges.get(intervalName)==null )
			throw new NoSuchFieldException("There is no interval range with this name.");
		return ranges.get(intervalName);
	}

	public void print(){																		//tested
		System.out.println("Polynomials:");
		for (Map.Entry<String, PolyNomial> entry : polynomials.entrySet()){
			System.out.print(entry.getKey() +" = ");
			entry.getValue().print();
			System.out.println();
		}
		System.out.println("Ranges:");
		for (Map.Entry<String, Interval> entry : ranges.entrySet()){
			System.out.print(entry.getKey() +" = ");
			entry.getValue().print();
			System.out.println();
		}

	}
}