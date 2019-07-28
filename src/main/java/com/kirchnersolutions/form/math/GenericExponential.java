/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class GenericExponential solves, integrates, differentiates, and evaluates
 * generic(base a) exponential functions. Form: y=a^(b*x+c)+d
 *
 * @author Robert Kirchner Jr.
 */
public class GenericExponential {

    private double a, b, c, d, y, aorg, borg, corg, dorg, yorg, x, tanslope, defint;
    private boolean solution;
    private String diff, genint, equation;

    /**
     * Declares a new generic exponential equation.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public GenericExponential(double a, double b, double c, double d, double y) {
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

    private void genSolve() {
        this.equation = this.y + " = "
                + this.a + "^(" + this.b + "x + " + this.c + ") + " + this.d;
        if (this.a == 0 || this.b == 0) {
            this.solution = false;
        } else {

            double g;
            g = (this.y - this.d);
            if (g <= 0) {
                this.solution = false;
            } else {
                this.solution = true;
                this.x = ((Math.log(g) / Math.log(this.a)) - this.c) / this.b;
            }
        }
    }

    /**
     * Returns the entered equation as a string.
     *
     * @return
     */
    public String getEquation() {
        this.genSolve();
        return this.equation;
    }

    /**
     * Returns true if a solution x exist.
     *
     * @return
     */
    public boolean trueSolution() {
        this.genSolve();
        return this.solution;
    }

    /**
     * Returns the solution x as a double
     *
     * @return
     */
    public double getSol() {
        this.genSolve();
        return this.x;
    }

    /**
     * Returns the solution x as a string.
     *
     * @return
     */
    public String getSolStr() {
        this.genSolve();
        return "x = " + this.getSol();
    }

    private void genDif() {
        this.diff = "dy/dx = " + Math.log(this.a) * this.b
                + this.a + "^("
                + this.b + "x + " + this.c + ")";
    }

    /**
     * Returns the derivative as a string.
     *
     * @return
     */
    public String getDiff() {
        this.genDif();
        return this.diff;
    }

    /**
     * Returns the slope of the line tangent to point x.
     *
     * @param x
     * @return
     */
    public double getTanSlope(double x) {
        this.tanslope = (Math.log(this.a) * this.b) * (Math.pow(this.a, this.b * x + this.c));
        return this.tanslope;
    }

    /**
     * Finds the indefinite integral of the general exponential equation.
     */
    private void genInt() {
        this.genint = "Sf(x)dx = (" + this.a + "^("
                + this.b + "x + " + this.c + ") + " + this.d
                + ")*x + C";
    }

    /**
     * Returns the indefinite integral as a string.
     *
     * @return
     */
    public String getInt() {
        this.genInt();
        return this.genint;
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
        fb = (Math.pow(this.a, this.b * b + this.c) + this.d) * b;
        fa = (Math.pow(this.a, this.b * a + this.c) + this.d) * a;
        this.defint = fb - fa;
        return this.defint;
    }

    /**
     * Evaluates the natural exponential function at value x.
     *
     * @param x
     * @return
     */
    public double genEval(double x) {
        double temp = Math.pow(this.a, (this.b * x + this.c)) + this.d;
        return temp;
    }

    /**
     * Evaluates the integral at value x.
     *
     * @param x
     * @return
     */
    public double genIntEval(double x) {
        double temp = (Math.pow(this.a, this.b * x + this.c) + this.d) * x;
        return temp;
    }

    /**
     * Changes the generic exponential equation.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public void changeGenExp(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;
    }

    /**
     * Changes the generic exponential equation back into the originally
     * declared one.
     */
    public void changeGenExpOriginal() {
        this.changeGenExp(aorg, borg, corg, dorg, yorg);
    }

}