/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class NaturalExponential solves, integrates, differentiates, and evaluates
 * generic natural(base e) exponential functions. Form: y=a*e^(b*x+c)+d
 *
 * @author Robert Kirchner Jr.
 */
public class NaturalExponential {

    private double a, b, c, d, y, aorg, borg, corg, dorg, yorg, x, tanslope, defint;
    private boolean solution;
    private String natdiff, natint, equation;

    /**
     * Declares a new natural exponential equation.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public NaturalExponential(double a, double b, double c, double d, double y) {
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

    private void natSolve() {
        this.equation = this.y + " = " + this.a
                + "e^(" + this.b + "x + " + this.c + ") + " + this.d;
        if (this.a == 0 || this.b == 0) {
            this.solution = false;
        } else {

            double g;
            g = (this.y - this.d) / this.a;
            if (g <= 0) {
                this.solution = false;
            } else {
                this.solution = true;
                this.x = (Math.log(g) - this.c) / this.b;
            }
        }
    }

    /**
     * Returns the entered equation as a string.
     *
     * @return
     */
    public String getEquation() {
        this.natSolve();
        return this.equation;
    }

    /**
     * Returns true if a solution x exist.
     *
     * @return
     */
    public boolean trueSolution() {
        this.natSolve();
        return this.solution;
    }

    /**
     * Returns the solution x as a double
     *
     * @return
     */
    public double getSol() {
        this.natSolve();
        return this.x;
    }

    /**
     * Returns the solution x as a string.
     *
     * @return
     */
    public String getSolStr() {
        this.natSolve();
        return "x = " + this.getSol();
    }

    private void natDif() {
        this.natdiff = "dy/dx = " + this.a * this.b + "e^("
                + this.b + "x + " + this.c + ")";
    }

    /**
     * Returns the derivative as a string.
     *
     * @return
     */
    public String getDiff() {
        this.natDif();
        return this.natdiff;
    }

    /**
     * Returns the slope of the line tangent to point x.
     *
     * @param x
     * @return
     */
    public double getTanSlope(double x) {
        this.tanslope = (Math.exp(this.b * x + this.c)) * this.a * this.b;
        return this.tanslope;
    }

    /**
     * Finds the indefinite integral of the natural exponential equation.
     */
    private void natInt() {
        this.natint = "Sf(x)dx = (" + this.a + "e^("
                + this.b + "x + " + this.c + ")*x + C";
    }

    /**
     * Returns the indefinite integral as a string.
     *
     * @return
     */
    public String getInt() {
        this.natInt();
        return this.natint;
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
        fb = (this.a * (Math.exp(this.b * b + this.c)) + this.d) * b;
        fa = (this.a * (Math.exp(this.b * a + this.c)) + this.d) * a;
        this.defint = fb - fa;
        return this.defint;
    }

    /**
     * Evaluates the natural exponential function at value x.
     *
     * @param x
     * @return
     */
    public double natEval(double x) {
        double temp = this.a * Math.exp(this.b * x + this.c) + this.d;
        return temp;
    }

    /**
     * Evaluates the integral at value x.
     *
     * @param x
     * @return
     */
    public double natIntEval(double x) {
        double temp = (this.a * (Math.exp(this.b * b + this.c)) + this.d) * b;
        return temp;
    }

    /**
     * Changes the natural exponential equation.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public void changeNatExp(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;
    }

    /**
     * Changes the natural exponential equation back into the originally
     * declared one.
     */
    public void changeNatExpOriginal() {
        this.changeNatExp(aorg, borg, corg, dorg, yorg);
    }

}