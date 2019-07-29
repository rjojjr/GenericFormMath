/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class Sine solves, integrates, differentiates, and evaluates generic sine
 * functions. Form: y=a*sin(b*x+c)+d
 *
 * @author Robert Kirchner Jr.
 */
public class Sine implements Equation{

    private double a, b, c, d, y, x, xdeg, difa, difb, difc, tanslope, defint,
            aorg, borg, corg, dorg, yorg;
    private boolean solution;
    private String sinediff, sineint, equation;
    
    /**
     * Mathematical constant PI.
     */
    public static final double PI = Math.PI;
    
    /**
     * Conversion factor from radians to degrees.
     */
    public static final double DEGREE = 180 / PI;
    
    /**
     * Conversion factor from degrees to radians.
     */
    public static final double RADIAN = PI / 180;

    /**
     * Declares a sine function with coefficients a and b, and constants c, and
     * d, set equal to y.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public Sine(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;
        this.aorg = a;
        this.borg = b;
        this.corg = c;
        this.dorg = d;
        this.yorg = y;
    }

    private void sineSolve() {
        if (this.b == 0 || this.a == 0) {
            this.solution = false;
        } else {
            double yda = (this.y - this.d) / this.a;
            if (yda < -1 || yda > 1) {
                this.solution = false;
            } else {
                this.x = (Math.asin(yda) - c) / this.b;
                this.xdeg = this.x * DEGREE;
                this.solution = true;
            }
            this.equation = this.y + " = " + this.a
                    + "sin(" + this.b + "x + " + this.c + ") + " + this.d;
        }
    }

    /**
     * Returns the entered equation as a string.
     *
     * @return
     */
    public String getEquation() {
        this.sineSolve();
        return this.equation;
    }

    /**
     * Returns true if a solution x exist.
     *
     * @return
     */
    public boolean trueSolution() {
        this.sineSolve();
        return this.solution;
    }

    /**
     * Returns the solution x as a double in radians.
     *
     * @return
     */
    public double getSol() {
        this.sineSolve();
        return this.x;
    }

    /**
     * Returns solution x in radians as a string.
     *
     * @return
     */
    public String getSolStr() {
        this.sineSolve();
        return "x = " + this.x;
    }

    /**
     * Returns the solution x as a double in degrees.
     *
     * @return
     */
    public double getSolDeg() {
        this.sineSolve();
        return this.xdeg;
    }

    /**
     * Returns solution x in degrees as a string.
     *
     * @return
     */
    public String getSolDegStr() {
        this.sineSolve();
        return "x = " + this.xdeg;
    }

    private void sinDiff() {
        this.sinediff = "dy/dx = " + this.a * this.b +
                "cos(" + this.b + "x+" + this.c + ")";
        this.difa = this.a * this.b;
        this.difb = this.b;
        this.difc = this.c;
    }

    /**
     * Returns the derivative of the sine function as a string.
     *
     * @return
     */
    public String getDiff() {
        this.sinDiff();
        return this.sinediff;
    }

    /**
     * Returns the slope of the line tangent to the curve at point x in radians
     * as a double.
     *
     * @param x
     * @return
     */
    public double tanSlope(double x) {
        this.sinDiff();
        double temp;
        temp = Math.cos(this.difb * x + this.difc);
        this.tanslope = this.difa * temp;
        return this.tanslope;
    }

    /**
     * Returns the slope of the line tangent to the curve at point x in degrees
     * as a double.
     *
     * @param x
     * @return
     */
    public double tanSlopeDeg(double x) {
        x = x * RADIAN;
        this.sinDiff();
        double temp;
        temp = Math.cos(this.difb * x + this.difc);
        this.tanslope = this.difa * temp;
        return this.tanslope;
    }

    private void sinInt() {
        double coscoef;
        coscoef = (180 * this.a) / (this.b * PI);
        this.sineint = "Sf(x)dx = " + -coscoef + "cos(" + this.b + "x" +
                "+" + this.c + ")" + "+" + this.d + "x + C";

    }

    /**
     * Returns the indefinite integral of the sine function as a string.
     *
     * @return
     */
    public String getInt() {
        this.sinInt();
        return this.sineint;
    }

    private void calcDefInt(double a, double b) {
        double tempb, tempa, coscoef;
        coscoef = (180 * this.a) / (this.b * PI);
        tempb = -coscoef * Math.cos(this.b * b + this.c) + this.d * b;
        tempa = -coscoef * Math.cos(this.b * a + this.c) + this.d * a;
        this.defint = tempb - tempa;
    }

    /**
     * Returns the definite integral from a to b in radians as a double.
     *
     * @param a
     * @param b
     * @return
     */
    public double defInt(double a, double b) {
        this.defInt(a, b);
        return this.defint;
    }

    /**
     * Returns the definite integral from a to b in degrees as a double.
     *
     * @param a
     * @param b
     * @return
     */
    public double getDefIntDeg(double a, double b) {
        a = a * RADIAN;
        b = b * RADIAN;
        this.defInt(a, b);
        return this.defint;
    }

    /**
     * Evaluates the sine function at value x in radians.
     *
     * @param x
     * @return
     */
    public double eval(double x) {
        double temp = this.a * Math.sin(this.b * x + this.c) + this.d;
        return temp;
    }

    /**
     * Evaluates the sine function at value x in degrees.
     *
     * @param x
     * @return
     */
    public double sineEvalDeg(double x) {
        x = x * RADIAN;
        double temp = this.a * Math.sin(this.b * x + this.c) + this.d;
        return temp;
    }

    /**
     * Evaluates the integral at value x in radians.
     *
     * @param x
     * @return
     */
    public double intEval(double x) {
        double temp, coscoef = (180 * this.a) / (this.b * PI);
        temp = -coscoef * Math.cos(this.b * x + this.c) + this.d * x;
        return temp;
    }

    /**
     * Evaluates the integral at value x in degrees.
     *
     * @param x
     * @return
     */
    public double sineIntEvalDeg(double x) {
        x = x * RADIAN;
        double temp, coscoef = (180 * this.a) / (this.b * PI);
        temp = -coscoef * Math.cos(this.b * x + this.c) + this.d * x;
        return temp;
    }

    /**
     * Changes the values of the sine function.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public void changeSine(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;
    }

    /**
     * Changes the values of the sine function back to the originally declared
     * values.
     */
    public void changeSineOriginal() {
        this.changeSine(aorg, borg, corg, dorg, yorg);
    }
}