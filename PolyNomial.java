/*#####################################################################|
Ali Hedayatnia , University of Tehran								   |
Last modified : 2018/May/06											   |
																	   |
x(t) = Σ I(i)*t + I(e)												   |
																	   |
#######################################################################*/
import java.util.ArrayList;
import java.lang.ArithmeticException;

public class PolyNomial{
	ArrayList<Interval> coefficients;
	Interval error;

	public PolyNomial(ArrayList<Interval> coefficients,Interval error){							//tested
		this.coefficients = coefficients;
		this.error = error;
	}

	public PolyNomial(){																
		coefficients = new ArrayList<Interval>();
	}

	public void changeCoefficients(Integer power , Interval newCoefficient){					//tested
		if(power < 0)
			throw new ArithmeticException("power must be grater than or equal to zero.");
		Integer size = coefficients.size();
		
		for(Integer i=0;i<(power-size);++i)							//fill the gap with [ 0.0 , 0.0 ]
			coefficients.add(new Interval(0.0,0.0));
		if( coefficients.size()-1 < power )
			coefficients.add( newCoefficient );
		else
			coefficients.set(power,newCoefficient);
	}

	public Interval calc(Interval time){
		Interval result = new Interval(0.0,0.0);
		Integer powerCounter = new Integer(0);
		
		for( Interval coefficient : coefficients ){
			result.add( coefficient.mult( time.pow(powerCounter) ) );					// x(t) += I(i)*t^i
			++powerCounter;
		}
		return result;
	}

	public Interval error(){																	//tested
		return this.error;
	}

	public void print(){
		Integer powerCounter = new Integer(0);
		for(Interval coefficient : this.coefficients){
			coefficient.print();
			System.out.print(" * t^"+powerCounter);
			++powerCounter;
			System.out.print(" + ");
		}
		this.error.print();
	}
}