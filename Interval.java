/*#######################################################################################
Ali Hedayatnia,University of tehran														|
Last modified : 2018/May/06																|							
																						|
good link : http://web.mit.edu/hyperbook/Patrikalakis-Maekawa-Cho/node45.html			|
----------------------------------------------------------------------------------------|
Interval arithmatic :																	|
[x1,x2] <op> [y1,y2] = {x<op>y| x∈[x1,x2] , y∈[y1,y2]}									|
∈ : elment of 																			|
----------------------------------------------------------------------------------------+
suppose : I1=[a1,b1]	I2=[a2,b2]														|
																						|																						
I = I2 + I1 	=>		I=[a2+a1 , b2+b1]												|
I = I2 - I1		=>		I=[a2-a1 , b2-b1]												|
I = I2 * I1		=>		I=[min(a1*a2,a1*b2,b1*a2,b1*b2) , max(a1*a2,a1*b2,b1*a2,b1*b2)] |
I = I2 / I1		=>		I=[min(a2/a1,a2/b1,b2/a1,b2/b1) , max(a2/a1,a2/b1,b2/a1,b2/b1)] |
----------------------------------------------------+-----------------------------------+
I = I1^n 			when n is interger(natural)		|
													|
O : Odd numbers										|
E : Even numbers									|
													|
   | n ∈ O :	I=[a1^n,b1^n]						|
I =|												|
   | m ∈ E : | a1>=0 	I=[a1^n,b1^n]				|
   |         | b1<0		I=[b1^n,a1^n]				|
   |		 | O.W.		I=[0,max(a1^n,b1^n)]		|
													|
#######################################################################################*/
import java.lang.Math;
import java.lang.ArithmeticException;

public class Interval{
	Double beggining;
	Double end;

	public Interval(String beggining , String end){										//tested 
		Double b = new Double( Double.valueOf(beggining) );						//Double.valueOf(String) returns "double"
		Double e = new Double( Double.valueOf(end) );

		if(b > e)
			throw new ArithmeticException("end of interval must be grater than beggining of it.");
		this.beggining = b;
		this.end = e;
	}
	public Interval(Double beggining , Double end){										//tested
		if(beggining > end)
			throw new ArithmeticException("end of interval must be grater than beggining of it.");
		this.beggining = beggining;
		this.end = end;
	}

	public Double beggining(){															//tested
		return this.beggining;
	}
	public Double end(){																//tested
		return this.end;
	}

	private Double max(Double d1 , Double d2 , Double d3 , Double d4 ){
		return Math.max( Math.max(d1,d2) , Math.max(d3,d4) );
	}
	private Double min(Double d1 , Double d2 , Double d3 , Double d4 ){
		return Math.min( Math.min(d1,d2) , Math.min(d3,d4) );
	}

	public Interval add(Interval interval){												//tested
		return new Interval( this.beggining + interval.beggining() , this.end + interval.end() );
	}
	public Interval sub(Interval interval){												//tested 
		return new Interval( this.beggining - interval.beggining() , this.end - interval.end() );
	}

	public Interval mult(Interval interval){											//tested
		Double bb = this.beggining * interval.beggining();
		Double be = this.beggining * interval.end();
		Double eb = this.end * interval.beggining();
		Double ee = this.end * interval.end();
		return new Interval( min(bb,be,eb,ee) , max(bb,be,eb,ee) );
	}

	public Interval div(Interval interval){												//tested
		Double bb = this.beggining / interval.beggining();
		Double be = this.beggining / interval.end();
		Double eb = this.end / interval.beggining();
		Double ee = this.end / interval.end();
		return new Interval( min(bb,be,eb,ee) , max(bb,be,eb,ee) );
	}

	private Double power(Double d1 , Integer i1){
		return new Double(Math.pow(d1,i1));
	}

	public Interval pow(Integer power){													//tested
		if( power%2==1 || this.beggining>=0 )
			return new Interval( power(this.beggining,power) , power(this.end,power) );
		else if( this.end < 0 )
			return new Interval( power(this.end,power) , power(this.beggining,power) );
		else
			return new Interval( 0.0 , Math.max( power(this.beggining,power) , power(this.end,power) ) );
	}

	public void print(){																//tested
		System.out.print("[ " + this.beggining + " , " + this.end	+ " ]");
	}

}