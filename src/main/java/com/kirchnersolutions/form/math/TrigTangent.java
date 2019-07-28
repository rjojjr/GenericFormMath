package com.kirchnersolutions.form.math;

public class TrigTangent {

    private double a, b, c, d, y, x, difa, difb, difc, tanslope, defint;
    private boolean solution;
    private String tandiff, tanint;
    public double PI = 4 * Math.atan(1);

    public TrigTangent(double a, double b, double c, double d, double y) {
        this.a = a;

        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;

    }

    public void tanSolve() {
        if (this.a == 0 || this.b == 0) {
            this.solution = false;
        } else {
            double yda = (this.y - this.d) / this.a;
            this.x = (Math.atan(yda) - this.c) / this.b;
            this.solution = true;
        }
    }

    public boolean returnSolTrue() {
        return this.solution;
    }

    public double returnSol() {
        return this.x;
    }

    public void tanDiff() {
        this.tandiff = this.a * this.b + "sec(" + this.b + "x+" + this.c + ")^2";
    }

    public String returnDifString() {
        return this.tandiff;
    }

    public void findTanSlope(double x) {
        double temp1, temp2, temp3;
        temp1 = this.a * this.b;
        temp2 = this.b * x + this.c;
        temp3 = Math.pow(1 / (Math.cos(temp2)), 2);
        this.tanslope = temp1 * temp3;

    }

    public double returnTanSlope(double x) {
        this.findTanSlope(x);
        return this.tanslope;
    }

    public void tanIndefIntegral() {
        double acoef;
        acoef = (90 * this.a) / (this.b * PI);
        this.tanint = acoef + "ln(1/(cos(" + this.b + "x+" + this.c + "))^2)+" + this.d * PI + "(" + this.b + "x+" + this.c + ")";

    }

    public String returnIntString() {
        this.tanIndefIntegral();
        return this.tanint;
    }

    public void tanDefIntegral(double a, double b) {
    }
}