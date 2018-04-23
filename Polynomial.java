/*
 * Name: Nicholas Keen
 * Course: CIS 203 - Computer Science II
 * Assignment: 1
 * Due: 1/28/15
 */

public class Polynomial {

    private int degree;
    private double [] coefficients;

    //Preconditions: 0 <= degree,
    //		     coefficients.length == degree+1,
    //		     coefficients[degree] != 0.0
    public Polynomial(int degree, double [] coefficients) {
	double [] newArray = new double [coefficients.length];
	for(int i = 0; i < coefficients.length; i++)
	    newArray[i] = coefficients[i];
	    this.degree = degree;
	    this.coefficients = newArray;
    }
    
    //Preconditions: None
    //Returns: A string representation of the polynomial.
    public String toString() {
	String poly = "";
	if(coefficients[degree] != 1)
	    poly += coefficients[degree];
	else if(coefficients[degree] == 1 && degree == 0)
	    poly += coefficients[degree];
	for(int i = degree -1; i >= 0; i--) {
	    if(coefficients[i + 1] != 0 && i < 1)
		poly += "x";
	    else if(coefficients[i + 1] != 0 && i > 0)
		poly += "x^" + (i+1);
	    if(coefficients[i] == 0)
		poly += "";
	    else if(coefficients[i] < 0)
		poly += " - " + Math.abs(coefficients[i]);
	    else if(coefficients[i] == 1)
		poly += " + ";
	    else
		poly += " + " + coefficients[i];
	}
	return poly;
    }
    
    //Preconditions: None
    //Returns: The mathematical evaluation of the polynomial
    //	       at x.
    public double evaluate(double x) {
	double eval;
	double result = 0;
	int temp = degree;
	for(int i = degree; i >= 0; i--) {
	    eval = coefficients[temp] * Math.pow(x, temp);
	    result += eval;
	    temp--;
	}
	return result;
    }
    
    //Parameter: other - another polynomial object.
    //Preconditions: None
    //Returns: false if the other polynomial is null or otherwise
    //	       isn't equal to the first polynomial, and returns
    //	       true only if the degree and coefficients of both
    //	       polynomials are equal.
    public boolean equals(Polynomial other) {
	if(this.coefficients.length != other.coefficients.length)
	    return false;
	for(int i = 0; i < this.coefficients.length; i++) {
	    if(this.coefficients[i] != other.coefficients[i] ||
		this.degree != other.degree)
		return false;
	}
	return true;
    }
}