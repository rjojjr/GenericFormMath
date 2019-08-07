package com.kirchnersolutions.form.math;

public interface Equation {

    //Return the input equation as a string.
    public String getEquation();

    //Get solution as a decimal.
    public double getSol();

    //Get solution as a string.
    public String getSolStr();

    //Get derivative as string.
    public String getDiff();

    //Get the slope of tangent line at coordinate x.
    public double tanSlope(double x);

    //Get the in indefinite integral as a string.
    public String getInt();

    //Get the definite integral between a and b as an decimal.
    public double defInt(double a, double b);

    //Evaluate equation at x.
    public double eval(double x);

    //Evaluate integral at x.
    public double intEval(double x);

}
