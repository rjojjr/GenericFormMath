/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class Tangent solves, integrates, differentiates, and evaluates generic
 * tangent functions. Form: y=a*tan(b*x+c)+d
 *
 * @author Robert Kirchner Jr.
 */
public class Tangent implements Equation{

    private double a, b, c, d, y, aorg, borg,
            corg, dorg, yorg, x, xdeg, tanslope;
    private boolean solution;
    private String tandiff, tanint, equation;
    public static final double PI = 4 * Math.atan(1),
            DEGREE = 180 / PI, RADIAN = PI / 180;

    /**
     * Declares a tangent function with coefficients a and b, and constants c,
     * and d, set equal to y.
     *
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public Tangent(double a, double b, double c, double d, double y) {
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

    private void tanSolve() {
        if (this.a == 0 || this.b == 0) {
            this.solution = false;
        } else {
            double yda = (this.y - this.d) / this.a;
            this.x = (Math.atan(yda) - this.c) / this.b;
            this.xdeg = this.x * DEGREE;
            this.solution = true;
        }
        this.equation = this.y + " = " + this.a
                + "tan(" + this.b + "x + " + this.c
                + ") + " + this.d;

    }

    /**
     * Returns the entered equation as a string.
     *
     * @return
     */
    public String getEquation() {
        this.tanSolve();
        return this.equation;
    }

    /**
     * Returns true if a solution x exist.
     *
     * @return
     */
    public boolean trueSolution() {
        this.tanSolve();
        return this.solution;
    }

    /**
     * Returns the solution x as a double in radians.
     *
     * @return
     */
    public double getSol() {
        this.tanSolve();
        return this.x;
    }

    /**
     * Returns solution x in radians as a string.
     *
     * @return
     */
    public String getSolStr() {
        this.tanSolve();
        return "x = " + this.x;
    }

    /**
     * Returns the solution x as a double in degrees.
     *
     * @return
     */
    public double getSolDeg() {
        this.tanSolve();
        return this.xdeg;
    }

    /**
     * Returns solution x in degrees as a string.
     *
     * @return
     */
    public String getSolDegStr() {
        this.tanSolve();
        return "x = " + this.xdeg;
    }

    private void tanDiff() {
        this.tandiff = this.a * this.b + "sec(" + this.b + "x+" + this.c + ")^2";
    }

    /**
     * Returns the derivative of the tangent function as a string.
     *
     * @return
     */
    public String getDiff() {
        this.tanDiff();
        return this.tandiff;
    }

    /**
     * Returns the slope of the line tangent to the curve at point x in radians
     * as a double.
     *
     * @param x
     * @return
     */
    public double tanSlope(double x) {
        double temp1, temp2, temp3;
        temp1 = this.a * this.b;
        temp2 = this.b * x + this.c;
        temp3 = Math.pow(1.0 / (Math.cos(temp2)), 2);
        this.tanslope = temp1 * temp3;
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
        double temp1, temp2, temp3;
        temp1 = this.a * this.b;
        temp2 = this.b * x + this.c;
        temp3 = Math.pow(1.0 / (Math.cos(temp2)), 2);
        this.tanslope = temp1 * temp3;
        return this.tanslope;

    }

    private void tanInt() {
        this.tanint = "Sf(x) = (" + this.a + "ln(1/(cos(" + this.b + "x + " + this.c
                + "))^2) + " + this.d + "(" + 2 * this.b + "x - pi" + this.c + "))"
                + "/" + 2 * this.b;
    }

    /**
     * Returns the indefinite integral of the tangent function as a string.
     *
     * @return
     */
    public String getInt() {
        this.tanInt();
        return this.tanint;
    }

    /**
     * Returns the definite integral from a to b in radians as a double.
     *
     * @param a
     * @param b
     * @return
     */
    public double defInt(double a, double b) {
        double fa, fb;
        fb = (this.a * (Math.log(1.0 / Math.pow(Math.cos(this.b * b + this.c), 2)))
                + this.d * (2 * this.b * b - PI)) / (2 * this.b);
        fa = (this.a * (Math.log(1.0 / Math.pow(Math.cos(this.b * a + this.c), 2)))
                + this.d * (2 * this.b * a - PI)) / (2 * this.b);
        return fb - fa;
    }

    /**
     * Returns the definite integral from a to b in degrees as a double.
     *
     * @param a
     * @param b
     * @return
     */
    public double tanDefIntDeg(double a, double b) {
        a = a * RADIAN;
        b = b * RADIAN;
        double fa, fb;
        fb = (this.a * (Math.log(1.0 / Math.pow(Math.cos(this.b * b + this.c), 2)))
                + this.d * (2 * this.b * b - PI)) / (2 * this.b);
        fa = (this.a * (Math.log(1.0 / Math.pow(Math.cos(this.b * a + this.c), 2)))
                + this.d * (2 * this.b * a - PI)) / (2 * this.b);
        return fb - fa;
    }

    /**
     * Evaluates the tangent function at value x in radians.
     *
     * @param x
     * @return
     */
    public double eval(double x) {
        double temp;
        temp = this.a * Math.tan(this.b * x + this.c) + this.d;
        return temp;
    }

    /**
     * Evaluates the tangent function at value x in degrees.
     *
     * @param x
     * @return
     */
    public double tanEvalDeg(double x) {
        x = x * RADIAN;
        double temp;
        temp = this.a * Math.tan(this.b * x + this.c) + this.d;
        return temp;
    }

    /**
     * Evaluates the integral at value x in radians.
     *
     * @param x
     * @return
     */
    public double intEval(double x) {
        double temp;
        temp = (this.a * (Math.log(1.0 / Math.pow(Math.cos(this.b
                * x + this.c), 2))));
        return temp;
    }

    /**
     * Evaluates the integral at value x in degrees.
     *
     * @param x
     * @return
     */
    public double tanIntEvalDeg(double x) {
        x = x * RADIAN;
        double temp;
        temp = (this.a * (Math.log(1.0 / Math.pow(Math.cos(this.b
                * x + this.c), 2))));
        return temp;
    }

    /**
     * Changes the values of the tangent function.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public void changeTan(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;
    }

    /**
     * Changes the values of the tangent function back to the originally
     * declared values.
     */
    public void changeTanOriginal() {
        this.changeTan(aorg, borg, corg, dorg, yorg);
    }
}