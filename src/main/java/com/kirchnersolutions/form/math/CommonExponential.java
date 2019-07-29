/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class CommonExponential solves, integrates, differentiates, and evaluates
 * generic common(base ten) exponential functions. Form: y=10^(a*x+b)+c
 *
 * @author Robert Kirchner Jr.
 */
public class CommonExponential implements Equation{

    double a, b, c, y, aorg, borg, corg, yorg, x, defint, tanslope;
    boolean solution;
    String diff, integral, equation;

    public CommonExponential(double a, double b, double c, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.y = y;
        this.aorg = a;
        this.borg = b;
        this.corg = c;
        this.yorg = y;
    }

    private void comSolve() {
        this.equation = this.y + " = 10^(" + this.a + "x + "
                + this.b + ") + " + this.c;
        if (this.a == 0) {
            this.solution = false;
        } else {
            double g = this.y - this.c;
            if (g <= 0) {
                this.solution = false;
            } else {
                this.solution = true;
                this.x = ((Math.log(g) / Math.log(10)) - this.b) / this.a;
            }
        }

    }

    /**
     * Returns the entered equation as a string.
     *
     * @return
     */
    public String getEquation() {
        this.comSolve();
        return this.equation;
    }

    /**
     * Returns true if a solution x exist.
     *
     * @return
     */
    public boolean trueSolution() {
        this.comSolve();
        return this.solution;
    }

    /**
     * Returns the solution to the common exponential equation if it exist.
     *
     * @return
     */
    public double getSol() {
        this.comSolve();
        return this.x;
    }

    /**
     * Returns the solution to the exponential equation as a string.
     *
     * @return
     */
    public String getSolStr() {
        this.comSolve();
        return "x = " + this.x;
    }

    private void comDiff() {
        this.diff = "dy/dx = " + (this.a * Math.log(10)) + "*10^(" + this.a + "x + "
                + this.b + ")";

    }

    /**
     * Returns the derivative as a string.
     *
     * @return
     */
    public String getDiff() {
        this.comDiff();
        return this.diff;
    }

    /**
     * Returns the slope of the line tangent at point x.
     *
     * @param x
     * @return
     */
    public double tanSlope(double x) {
        this.tanslope = (this.a * Math.log(10)) * (Math.pow(10, this.a * x + this.b));
        return this.tanslope;
    }

    private void comInt() {
        this.integral = "Sf(x)dx = (e^(ln(10)*(" + this.a + "x + " + this.b
                + ")) + " + this.c + ")*x + C";
    }

    /**
     * Returns the indefinite integral as a string.
     *
     * @return
     */
    public String getInt() {
        this.comInt();
        return this.integral;
    }

    /**
     * Returns the definite integral from a to b.
     *
     * @param a
     * @param b
     * @return
     */
    public double defInt(double a, double b) {
        double fa, fb;
        fb = (Math.exp(Math.log(10) * (this.a * b + this.b)) + this.c) * b;
        fa = (Math.exp(Math.log(10) * (this.a * a + this.b)) + this.c) * a;
        this.defint = fb - fa;
        return this.defint;
    }

    /**
     * Evaluates the function at value x.
     *
     * @param x
     * @return
     */
    public double eval(double x) {
        double y;
        y = Math.pow(10, this.a * x + this.b) + this.c;
        return y;
    }

    /**
     * Evaluates the integral at value x.
     *
     * @param x
     * @return
     */
    public double intEval(double x) {
        double temp = (Math.exp(Math.log(10) * (this.a * x + this.b)) + this.c) * x;
        return temp;
    }

    /**
     * Changes the common exponential equation.
     *
     * @param a1
     * @param b1
     * @param c1
     * @param y1
     */
    public void comChange(double a1, double b1, double c1, double y1) {
        this.a = a1;
        this.b = b1;
        this.c = c1;
        this.y = y1;
    }

    /**
     * Changes the common exponential equation back into the originally declared
     * one.
     */
    public void comChangeOriginal() {
        this.comChange(aorg, borg, corg, yorg);
    }

}