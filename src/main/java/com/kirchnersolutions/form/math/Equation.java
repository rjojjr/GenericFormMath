package com.kirchnersolutions.form.math;

public interface Equation {

    public String getEquation();

    public double getSol();

    public String getSolStr();

    public String getDiff();

    public double tanSlope(double x);

    public String getInt();

    public double defInt(double a, double b);

    public double eval(double x);

    public double intEval(double x);

}
