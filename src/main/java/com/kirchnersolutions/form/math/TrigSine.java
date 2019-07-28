package com.kirchnersolutions.form.math;

public class TrigSine {

    private double a, b, c, d, y, x, difa, difb, difc, tanslope, defint;
    private boolean solution;
    private String sinediff, sineint, equation;
    public double PI = 4 * Math.atan(1);

    public TrigSine(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;

    }

    public void sineSolve() {
        if (this.b == 0 || this.a == 0) {
            this.solution = false;
        } else {

            double yda = (this.y - this.d) / this.a;
            if (yda < -1 || yda > 1) {
                this.solution = false;
            } else {
                this.x = (Math.asin(yda) - c) / this.b;
                this.solution = true;
            }

            this.equation = this.y + " = " + this.a
                    + "sin(" + this.b + "x + " + this.c + ") + " + this.d;

        }

    }

    public boolean returnSolTrue() {
        return this.solution;
    }

    public double returnSol() {
        return this.x;
    }

    public void sinDiff() {
        this.sinediff = this.a * this.b + "cos(" + this.b + "x+" + this.c + ")";
        this.difa = this.a * this.b;
        this.difb = this.b;
        this.difc = this.c;

    }

    public String returnDiffString() {
        this.sinDiff();
        return this.sinediff;
    }

    public void findTanSlope(double x) {
        double temp;
        temp = Math.cos(this.difb * x + this.difc);
        this.tanslope = this.difa * temp;

    }

    public double returnTanSlope(double x) {
        this.findTanSlope(x);
        return this.tanslope;
    }

    public void sinIndefIntegral() {
        double coscoef;
        coscoef = (180 * this.a) / (this.b * PI);
        this.sineint = -coscoef + "cos(" + this.b + "x" + "+" + this.c + ")" + "+" + this.d + "x + C";

    }

    public String returnIntString() {
        this.sinIndefIntegral();
        return this.sineint;
    }

    public void sinDefIntegral(double a, double b) {
        double tempb, tempa, coscoef;
        coscoef = (180 * this.a) / (this.b * PI);
        tempb = -coscoef * Math.cos(this.b * b + this.c) + this.d * b;
        tempa = -coscoef * Math.cos(this.b * a + this.c) + this.d * a;
        this.defint = tempb - tempa;

    }

    public double returnDefInt(double a, double b) {

        this.sinDefIntegral(a, b);
        return this.defint;
    }
}