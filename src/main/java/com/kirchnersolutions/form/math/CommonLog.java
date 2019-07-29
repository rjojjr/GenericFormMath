/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class CommonLog solves, integrates, differentiates, and evaluates generic
 * common(base 10) logarithmic functions. Form: y=a*log(b*x+c)+d
 *
 * @author Robert Kirchner Jr.
 */
public class CommonLog implements Equation{

    double a, b, c, d, y, aorg, borg, corg, dorg, yorg, x, tanslope, defint;
    boolean solution;
    String equation, diff, integral;

    /**
     * Declares a common logarithmic equation.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public CommonLog(double a, double b, double c, double d, double y) {
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

    private void logSolve() {
        double f;
        this.equation = this.y + " = " + this.a + "log("
                + this.b + "x + " + this.c + ") + " + this.d;

        if (this.a == 0 || this.b == 0) {
            this.solution = false;
        } else {
            this.solution = true;
            f = ((this.y - this.d) / this.a);
            this.x = ((Math.pow(10.0, f) - this.c) / this.b);

        }

    }

    /**
     * Returns the entered equation as a string.
     *
     * @return
     */
    public String getEquation() {
        this.logSolve();
        return this.equation;
    }

    /**
     * Returns true if a solution x exist.
     *
     * @return
     */
    public boolean trueSolution() {
        this.logSolve();
        return this.solution;
    }

    /**
     * Returns the solution to the logarithmic equation as a double.
     *
     * @return
     */
    public double getSol() {
        this.logSolve();
        return this.x;
    }

    /**
     * Returns the solution to the logarithmic equation as a string.
     *
     * @return
     */
    public String getSolStr() {
        this.logSolve();
        return "x = " + this.x;
    }

    private void logDiff() {
        this.diff = "dy/dx = (" + this.a + "log(e))/(" + this.b + "x + "
                + this.c + ")";
    }

    /**
     * Returns the derivative as a string.
     *
     * @return
     */
    public String getDiff() {
        this.logDiff();
        return this.diff;
    }

    /**
     * Returns the slope of the tangent line at point x.
     *
     * @param x
     * @return
     */
    public double tanSlope(double x) {
        this.tanslope = (this.a * (1 / Math.log(10.0))) / (this.b * x + this.c);
        return this.tanslope;
    }

    private void logInt() {
        this.integral = "Sf(x)dx = (" + this.a + "log("
                + this.b + "x + " + this.c + ")(" + this.b + "x + "
                + this.c + ")-(" + this.a + "log(e) - "
                + this.d + ")(" + this.b + "x))/" + this.b;
    }

    /**
     * Returns the integral as a string.
     *
     * @return
     */
    public String getInt() {
        this.logInt();
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
        fb = (this.a * (Math.log(this.b * b + c) / Math.log(10.0))
                * (this.b * b + this.c) - (this.a * (1.0 / Math.log(10)) - this.d)
                * (this.b * b)) / this.b;
        fa = (this.a * (Math.log(this.b * a + c) / Math.log(10.0))
                * (this.b * a + this.c) - (this.a * (1.0 / Math.log(10)) - this.d)
                * (this.b * a)) / this.b;
        this.defint = fb - fa;
        return this.defint;
    }

    /**
     * Evaluates the logarithmic function at value x.
     *
     * @param x
     * @return
     */
    public double eval(double x) {
        double temp = this.a * (Math.log(this.b * x + this.c) / Math.log(10.0)) + this.d;
        return temp;
    }

    /**
     * Evaluates the integral at value x.
     *
     * @param x
     * @return
     */
    public double intEval(double x) {
        double temp = (this.a * (Math.log(this.b * x + c) / Math.log(10.0))
                * (this.b * x + this.c) - (this.a * (1.0 / Math.log(10)) - this.d)
                * (this.b * x)) / this.b;
        return temp;
    }

    /**
     * Changes the common logarithmic function.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public void changeLog(double a, double b, double c, double d, double y) {
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
    public void changeLogOriginal() {
        this.changeLog(aorg, borg, corg, dorg, yorg);

    }
}