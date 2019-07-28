/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class NaturalLog solves, integrates, differentiates, and evaluates generic
 * natural(base e) logarithmic functions. Form: y=a*ln(b*x+c)+d
 *
 * @author Robert Kirchner Jr.
 */
public class NaturalLog {

    double a, b, c, d, y, aorg, borg, corg, dorg, yorg, x, tanslope, defint;
    boolean solution;
    String equation, diff, integral;

    /**
     * Declares a natural logarithmic equation.
     *
     * @param a1
     * @param b1
     * @param c1
     * @param d1
     * @param y1
     */
    public NaturalLog(double a, double b, double c, double d, double y) {
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

    private void lnSolve() {
        double f;
        this.equation = this.y + " = " + this.a + "ln("
                + this.b + "x + " + this.c + ") + " + this.d;

        if (this.a == 0 || this.b == 0) {
            this.solution = false;
        } else {
            this.solution = true;
            f = ((this.y - this.d) / this.a);
            this.x = ((Math.exp(f) - this.c) / this.b);

        }

    }

    /**
     * Returns the entered equation as a string.
     *
     * @return
     */
    public String getEquation() {
        this.lnSolve();
        return this.equation;
    }

    /**
     * Returns true if a solution x exist.
     *
     * @return
     */
    public boolean trueSolution() {
        this.lnSolve();
        return this.solution;
    }

    /**
     * Returns the solution to the logarithmic equation as a double.
     *
     * @return
     */
    public double getSol() {
        this.lnSolve();
        return this.x;
    }

    /**
     * Returns the solution to the logarithmic equation as a string.
     *
     * @return
     */
    public String getSolStr() {
        this.lnSolve();
        return "x = " + this.x;
    }

    private void lnDiff() {
        this.diff = "dy/dx = " + this.a + "/(" + this.b + "x + "
                + this.c + ")";
    }

    /**
     * Returns the derivative as a string.
     *
     * @return
     */
    public String getDiff() {
        this.lnDiff();
        return this.diff;
    }

    /**
     * Returns the slope of the tangent line at point xx.
     *
     * @param x
     * @return
     */
    public double tanSlope(double x) {
        this.tanslope = this.a / (this.b * x + this.c);
        return this.tanslope;
    }

    private void lnInt() {
        this.integral = "Sf(x)dx = (" + this.a + "ln("
                + this.b + "x + " + this.c + ") + " + this.diff;
    }

    /**
     * Returns the integral as a string.
     *
     * @return
     */
    public String getInt() {
        this.lnInt();
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
        double fb, fa;
        fb = (this.a * Math.log(this.b * b + c) + this.d) * b;
        fa = (this.a * Math.log(this.b * a + c) + this.d) * a;
        this.defint = fb - fa;
        return this.defint;
    }

    /**
     * Evaluates the logarithmic function at value x.
     *
     * @param x
     * @return
     */
    public double lnEval(double x) {
        double temp = this.a * Math.log(this.b * x + this.c) + this.d;
        return temp;
    }

    /**
     * Evaluates the integral at value x.
     *
     * @param x
     * @return
     */
    public double lnIntEval(double x) {
        double temp = (this.a * Math.log(this.b * x + c) + this.d) * x;
        return temp;
    }

    /**
     * Changes the natural logarithmic function.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public void changeLn(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;
    }

    /**
     * Changes the logarithmic function back into the originally declared
     * function.
     */
    public void changeLnOriginal() {
        this.changeLn(aorg, borg, corg, dorg, yorg);
    }

}