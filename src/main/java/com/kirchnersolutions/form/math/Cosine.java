/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class Cosine solves, integrates, differentiates, and evaluates generic cosine
 * functions. Form: y=a*cos(b*x+c)+d
 *
 * @author Robert Kirchner Jr.
 */
public class Cosine {

    private double a, b, c, d, y, aorg, borg, corg, dorg, yorg,
            x, xdeg, difa, difb, difc, tanslope, defint;
    private String cosinediff, cosint, equation;
    private boolean solution;
    public static final double PI = Math.PI, DEGREE = 180 / PI, RADIAN = PI / 180;

    public Cosine(double a, double b, double c, double d, double y) {
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

    private void cosineSolve() {
        if (b == 0 || a == 0) {
            this.solution = false;
        } else {
            double yda = (this.y - this.d) / this.a;
            if (yda > 1 || yda < -1) {
                this.solution = false;
            } else {
                this.x = (Math.acos(yda) - this.c) / this.b;
                this.xdeg = this.x * DEGREE;
            }
        }
        this.equation = this.y + " = " + this.a
                + "cos(" + this.b + "x + " + this.c
                + ") + " + this.d;
    }

    /**
     * Returns the entered equation as a string.
     *
     * @return
     */
    public String getEquation() {
        this.cosineSolve();
        return this.equation;
    }

    /**
     * Returns true if a solution x exist.
     *
     * @return
     */
    public boolean trueSolution() {
        this.cosineSolve();
        return this.solution;
    }

    /**
     * Returns the solution x as a double in radians.
     *
     * @return
     */
    public double getSol() {
        this.cosineSolve();
        return this.x;
    }

    /**
     * Returns solution x in radians as a string.
     *
     * @return
     */
    public String getSolStr() {
        this.cosineSolve();
        return "x = " + this.x;
    }

    /**
     * Returns the solution x as a double in degrees.
     *
     * @return
     */
    public double getSolDeg() {
        this.cosineSolve();
        return this.xdeg;
    }

    /**
     * Returns solution x in degrees as a string.
     *
     * @return
     */
    public String getSolDegStr() {
        this.cosineSolve();
        return "x = " + this.xdeg;
    }

    private void cosineDiff() {
        this.cosinediff = "dy/dx = " + -(this.a * this.b) +
                "sin(" + this.b + "x+" + this.c + ")";
        this.difa = -(this.a * this.b);
        this.difb = this.b;
        this.difc = this.c;
    }

    /**
     * Returns the derivative of the cosine function as a string.
     *
     * @return
     */
    public String getDiff() {
        this.cosineDiff();
        return this.cosinediff;
    }

    /**
     * Returns the slope of the line tangent to the curve at point x in radians
     * as a double.
     *
     * @param x
     * @return
     */
    public double tanSlopeRad(double x) {
        this.cosineDiff();
        double temp;
        temp = Math.sin(this.difb * x + this.difc);
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
        this.cosineDiff();
        double temp;
        temp = Math.sin(this.difb * x + this.difc);
        this.tanslope = this.difa * temp;
        return this.tanslope;
    }

    private void cosineInt() {
        double intcoef = (180 * this.a) / (this.b * PI);
        this.cosint = "Sf(x)dx = " + intcoef + "sin(" +
                this.b + "x" + "+" + this.c + ")+" + this.d + "x";
    }

    /**
     * Returns the indefinite integral of the cosine function as a string.
     *
     * @return
     */
    public String getInt() {
        this.cosineInt();
        return this.cosint;
    }

    private void defInt(double a, double b) {
        double tempb, tempa, coscoef;
        coscoef = (180 * this.a) / (this.b * PI);
        tempb = coscoef * Math.sin(this.b * b + this.c) + this.d * b;
        tempa = coscoef * Math.sin(this.b * a + this.c) + this.d * a;
        this.defint = tempb - tempa;

    }

    /**
     * Returns the definite integral from a to b in radians as a double.
     *
     * @param a
     * @param b
     * @return
     */
    public double getDefIntRad(double a, double b) {
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
     * Evaluates the cosine function at value x in radians.
     *
     * @param x
     * @return
     */
    public double cosineEvalRad(double x) {
        double temp = this.a * Math.cos(this.b * x + this.c) + this.d;
        return temp;
    }

    /**
     * Evaluates the cosine function at value x in degrees.
     *
     * @param x
     * @return
     */
    public double cosineEvalDeg(double x) {
        x = x * RADIAN;
        double temp = this.a * Math.cos(this.b * x + this.c) + this.d;
        return temp;
    }

    /**
     * Evaluates the integral at value x in radians.
     *
     * @param x
     * @return
     */
    public double cosineIntEvalRad(double x) {
        double temp, coscoef = (180 * this.a) / (this.b * PI);
        temp = coscoef * Math.sin(this.b * x + this.c) + this.d * x;
        return temp;
    }

    /**
     * Evaluates the integral at value x in degrees.
     *
     * @param x
     * @return
     */
    public double cosineIntEvalDeg(double x) {
        x = x * RADIAN;
        double temp, coscoef = (180 * this.a) / (this.b * PI);
        temp = coscoef * Math.sin(this.b * x + this.c) + this.d * x;
        return temp;
    }

    /**
     * Changes the values of the cosine function.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param y
     */
    public void changeCosine(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;
    }

    /**
     * Changes the values of the cosine function back to the originally declared
     * values.
     */
    public void changeCosineOriginal() {
        this.changeCosine(aorg, borg, corg, dorg, yorg);
    }
}