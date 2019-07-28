package com.kirchnersolutions.form.math;

public class TrigCosine {

    private double a, b, c, d, y, x, difa, difb, difc, tanslope, defint;
    private String cosdif, cosint;
    private boolean solution;
    public double PI = 4 * Math.atan(1);

    public TrigCosine(double a, double b, double c, double d, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.y = y;
    }

    public void cosineSolve() {
        if (b == 0) {
            this.solution = false;
        } else {
            double yda = (this.y - this.d) / this.a;
            if (yda > 1 || yda < -1) {
                this.solution = false;
            } else {
                this.x = (Math.acos(yda) - this.c) / this.b;

            }
        }
    }

    public boolean returnSolTrue() {
        return this.solution;
    }

    public double returnSol() {
        return this.x;
    }

    public void cosDiff() {
        this.difa = -this.a * this.b;
        this.difb = this.b;
        this.difc = this.c;
        this.cosdif = this.difa + "sin(" + this.difb + "x" + "+" + this.difc + ")";
    }

    public String returnDifString() {
        return this.cosdif;
    }

    public void findTanSlope(double x) {
        double temp;
        temp = Math.sin(this.difb * x + this.difc);
        this.tanslope = this.difa * temp;

    }

    public double returnTanSlope(double x) {
        this.findTanSlope(x);
        return this.tanslope;
    }

    public void cosIndefIntegral() {
        double intcoef = (180 * this.a) / (this.b * PI);
        this.cosint = intcoef + "sin(" + this.b + "x" + "+" + this.c + ")+" + this.d + "x";
    }

    public String returnIntString() {
        this.cosIndefIntegral();
        return this.cosint;
    }

    public void cosDefIntegral(double a, double b) {
        double tempb, tempa, coef;
        coef = (180 * this.a) / (this.b * PI);
        tempb = coef * Math.sin(this.b * b + this.c) + this.d * b;
        tempa = coef * Math.sin(this.b * a + this.c) + this.d * a;
        this.defint = tempb - tempa;
    }

    public double returnDefInt(double a, double b) {
        this.cosDefIntegral(a, b);
        return this.defint;
    }
}