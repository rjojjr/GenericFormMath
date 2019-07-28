/**
 * Developed and owned by Kirchner Math and Electronics Solutions. Unauthorized
 * use is strictly prohibited.
 */
package com.kirchnersolutions.form.math;

/**
 * Class Poly solves, integrates, differentiates, adds together, subtracts, and
 * evaluates polynomial functions of a degree less than or equal to three. Form:
 * y=a*x^(3)+b*x^(2)+c*x+d
 *
 * @author Robert Kirchner Jr.
 */
public class Poly {

    private double a, b, c, d, y, x1, x2, x3, da, db, dc, ia, ib, ic, id;
    private double daa, das, dba, dbs, dca, dcs, iaa, ias, iba,
            ibs, ica, ics, ida, ids;
    private double aorg, borg, corg, dorg, yorg;
    private double x1re, x2re, x1im, x2im, x3re, tanslope, defint, addtanslope, subtanslope,
            adddefint, subdefint;
    private double aadd, badd, cadd, dadd, yadd, asub, bsub, csub, dsub, ysub;
    private double x1add, x2add, x3add, x1sub, x2sub, x3sub,
            x1readd, x2readd, x1imadd, x2imadd, x1resub, x2resub, x1imsub,
            x2imsub;
    private int degree, adddegree, subdegree;
    private String diff, integral, x1comp, x1real, x2real, x2comp,
            x3real, equation, polyadd, polysubtract, x1compadd,
            x2compadd, x1realadd, x2realadd, x3realadd,
            x1compsub, x2compsub, x1realsub, x2realsub, x3realsub,
            adddiff, addintegral, subdiff, subintegral;
    boolean real, addreal, subreal;

    /**
     * Declares a polynomial function with coefficients a1, b1, c1, constant d1,
     * and set equal to y1
     *
     * @param a1
     * @param b1
     * @param c1
     * @param y1
     * @param d1
     */
    public Poly(double a1, double b1, double c1, double d1, double y1) {
        this.a = a1;
        this.b = b1;
        this.c = c1;
        this.d = d1;
        this.y = y1;
        this.aorg = a1;
        this.borg = b1;
        this.corg = c1;
        this.dorg = d1;
        this.yorg = y1;
        this.aadd = 0;
        this.asub = 0;
        this.badd = 0;
        this.bsub = 0;
        this.cadd = 0;
        this.csub = 0;
        this.dadd = 0;
        this.dsub = 0;
        this.yadd = 0;
        this.ysub = 0;

    }

    private void polySolve() {
        double a, b, c, d, x1, x2, x3;
        a = this.a;
        b = this.b;
        c = this.c;
        d = this.d;

        if (a != 0) {

            String eqa = "", eqb = "", eqc = "", eqd = "";
            int eb = 0, ec = 0, ed = 0;
            eqa = this.a + "x^3 ";
            if (this.b == 0) {
                eb = 1;
            } else {
                if (this.b > 0) {
                    eqb = "+ " + this.b + "x^2 ";
                } else {
                    eqb = "- " + -this.b + "x^2 ";
                }
            }
            if (this.c == 0) {
                ec = 1;
            } else {
                if (this.c > 0) {
                    eqc = "+ " + this.c + "x ";
                } else {
                    eqc = "- " + -this.c + "x ";
                }
            }
            if (this.d == 0) {
                ed = 1;
            } else {
                if (this.d > 0) {
                    eqd = "+ " + this.d;
                } else {
                    eqd = "- " + -this.d;
                }
            }
            if (eb == 0 && ec == 0 && ed == 0) {
                this.equation = this.y + " = " + eqa + eqb + eqc + eqd;
            }
            if (eb == 1 && ec == 0 && ed == 0) {
                this.equation = this.y + " = " + eqa + eqc + eqd;
            }
            if (eb == 0 && ec == 1 && ed == 0) {
                this.equation = this.y + " = " + eqa + eqb + eqd;
            }
            if (eb == 0 && ec == 0 && ed == 1) {
                this.equation = this.y + " = " + eqa + eqb + eqc;
            }
            if (eb == 1 && ec == 1 && ed == 0) {
                this.equation = this.y + " = " + eqa + eqd;
            }
            if (eb == 0 && ec == 1 && ed == 1) {
                this.equation = this.y + " = " + eqa + eqb;
            }
            if (eb == 1 && ec == 0 && ed == 1) {
                this.equation = this.y + " = " + eqa + eqc;
            }

            this.degree = 3;
            d = this.d - this.y;
            double e, f, g, h, j, t, y, b2, c2, im, re, disc;
            e = ((-Math.pow(b, 3)) / (27 * Math.pow(a, 3)))
                    + ((b * c) / (6 * Math.pow(a, 2))) - (d / (2 * a));
            f = (c / (3 * a)) - ((Math.pow(b, 2)) / (9 * Math.pow(a, 2)));
            g = (-b / (3 * a));
            h = Math.pow(e, 2) + Math.pow(f, 3);

            if (h < 0) {
                re = e;
                im = Math.sqrt(-h);
                Complex root1 = new Complex(re, im);
                Complex root2 = new Complex(re, -im);

                j = root1.getRealRoot(3) + root2.getRealRoot(3);
                x1 = j + g;
                this.x1 = x1;
                this.x3real = "x1 = " + this.x1;
                b2 = a * x1 + b;
                c2 = x1 * b2 + c;
                disc = Math.pow(b2, 2) - 4 * a * c2;
                if (disc < 0) {
                    this.real = false;
                    double r, i;
                    r = -b2 / (2 * a);
                    i = Math.sqrt(-disc) / (2 * a);
                    this.x1comp = "x3= " + r + "+" + i + "i ; ";
                    this.x2comp = "x2= " + r + "-" + i + "i ; ";
                    this.x1real = "false";
                    this.x2real = "false";

                } else {
                    this.real = true;
                    x2 = (-b2 + Math.sqrt(disc)) / (2 * a);
                    x3 = (-b2 - Math.sqrt(disc)) / (2 * a);
                    this.x2 = x2;
                    this.x3 = x3;
                    this.x1real = "x1= " + this.x2 + " ; ";
                    this.x2real = "x2= " + this.x3 + " ; ";

                }

            } else {
                double t2, y2, j2;
                t = e + Math.sqrt(h);
                y = e - Math.sqrt(h);
                y2 = Math.pow(y, 1.0 / 3.0);
                t2 = Math.pow(t, 1.0 / 3.0);
                j2 = y2 + t2;
                x1 = j2 + g;
                this.x1 = x1;
                this.x3real = "x1 = " + this.x1;
                b2 = a * x1 + b;
                c2 = x1 * b2 + c;
                disc = Math.pow(b2, 2) - 4 * a * c2;
                if (disc < 0) {
                    this.real = false;
                    double r, i;
                    r = -b2 / (2 * a);
                    i = Math.sqrt(-disc) / (2 * a);
                    this.x1re = r;
                    this.x2re = r;
                    this.x1im = i;
                    this.x2im = -i;
                    this.x1comp = "x1= " + r + "+" + i + "i ; ";
                    this.x2comp = "x2= " + r + "-" + i + "i ; ";
                    this.x1real = "false";
                    this.x2real = "false";

                } else {
                    x2 = (-b2 + Math.sqrt(disc)) / (2 * a);
                    x3 = (-b2 - Math.sqrt(disc)) / (2 * a);
                    this.x2 = x2;
                    this.x3 = x3;
                    this.real = true;
                    this.x1real = "x1= " + this.x2 + " ; ";
                    this.x2real = "x2= " + this.x3 + " ; ";
                }

            }

        }
        if (a == 0 && b != 0) {

            int ec = 0, ed = 0;
            String eqb = this.b + "x^2 ", eqc = "", eqd = "";
            if (this.c == 0) {
                ec = 1;
            } else {
                if (this.c > 0) {
                    eqc = "+ " + this.c + "x ";
                } else {
                    eqc = "- " + -this.c + "x ";
                }
            }
            if (this.d == 0) {
                ed = 1;
            } else {
                if (this.d > 0) {
                    eqd = "+ " + this.d;
                } else {
                    eqd = "- " + -this.d;
                }
            }
            if (ec == 0 && ed == 0) {
                this.equation = this.y + " = "
                        + eqb + eqc + eqd;
            }
            if (ec == 0 && ed == 1) {
                this.equation = this.y + " = "
                        + eqb + eqc;
            }
            if (ec == 1 && ed == 1) {
                this.equation = this.y + " = "
                        + eqb;
            }
            if (ec == 1 && ed == 0) {
                this.equation = this.y + " = "
                        + eqb + eqd;
            }
            this.degree = 2;
            d = this.d - this.y;
            double disc, r, i;
            disc = Math.pow(c, 2) - 4 * b * d;
            if (disc < 0) {
                this.real = false;
                r = -c / (2 * b);
                i = Math.sqrt(-disc) / (2 * b);
                this.x1comp = "x1= " + r + "+" + i + "i";
                this.x2comp = "x2= " + r + "-" + i + "i";
                this.x1real = "false";
                this.x2real = "false";

            } else {
                this.real = true;
                x1 = (-c + Math.sqrt(disc)) / (2 * b);
                x2 = (-c + Math.sqrt(disc)) / (2 * b);
                this.x1 = x1;
                this.x2 = x2;

                this.x1real = "x1= " + this.x1 + " ; ";
                this.x2real = "x2= " + this.x2 + " ; ";
            }
        }
        if (a == 0 && b == 0 && c != 0) {

            this.degree = 1;
            int ed = 0;
            String eqd = "";
            if (this.d == 0) {
                ed = 1;
            } else {
                if (this.d > 0) {
                    eqd = "+ " + this.d;
                } else {
                    eqd = "- " + -this.d;
                }
            }
            if (ed == 0) {
                this.equation = this.y + " = " + this.c + "x " + eqd;
            } else {
                this.equation = this.y + " = " + this.c + "x";
            }
            this.x1 = (this.y - this.d) / this.c;
            this.x1real = "x1= " + this.x1;

        }
        if (a == 0 && b == 0 && c == 0) {
            this.degree = 0;
            this.equation = this.y + " = " + this.d;
            if (this.d == y) {
                this.x1real = "Identity: " + this.d + " = " + this.y;

            } else {
                this.x1real = "Contradiction: " + this.d + " is not equal to " + this.y;

            }
        }

    }

    /**
     * Returns the polynomial function as a string.
     *
     * @return
     */
    public String getEquation() {
        this.polySolve();
        return this.equation;
    }

    /**
     * Returns the degree of the polynomial. Returns 0 if the function is is an
     * identity or contradiction.
     *
     * @return
     */
    public int getDegree() {
        this.polySolve();
        return this.degree;
    }

    /**
     * Returns false if there exist complex solutions. Returns true if all
     * solutions are real.
     *
     * @return
     */
    public boolean realSolution() {
        this.polySolve();
        return this.real;
    }

    /**
     * Returns solution x1 as a string if it is real. Returns "false" if the
     * solution is complex.
     *
     * @return
     */
    public String getX1RealStr() {
        this.polySolve();
        return this.x1real;
    }

    /**
     * Returns solution x2 as a string if it is real. Returns "false" if the
     * solution is complex.
     *
     * @return
     */
    public String getX2RealStr() {
        this.polySolve();
        return this.x2real;
    }

    /**
     * Returns real solution x3 as a string.
     *
     * @return
     */
    public String getX3RealStr() {
        this.polySolve();
        return this.x3real;
    }

    /**
     * Returns solution x1 as a string if it is complex.
     *
     * @return
     */
    public String getX1CompStr() {
        this.polySolve();
        return this.x1comp;
    }

    /**
     * Returns solution x as a string if it is complex.
     *
     * @return
     */
    public String getX2CompStr() {
        this.polySolve();
        return this.x2comp;
    }

    /**
     * Returns real solution x1 if it exist. Returns 0010 if real solution x1
     * does not exist.
     *
     * @return
     */
    public double getSolutionX1() {
        this.polySolve();
        if (this.degree == 3 || this.degree == 1) {
            return this.x1;
        } else {
            if (this.real) {
                return this.x1;
            } else {
                return 0010;
            }
        }

    }

    /**
     * Returns real solution x2 if it exist. Returns 0010 if real solution x2
     * does not exist.
     *
     * @return
     */
    public double getSolutionX2() {
        this.polySolve();
        if (this.real) {
            return this.x2;
        } else {
            return 0010;
        }

    }

    /**
     * Returns real solution x3 if it exist.Returns 0010 if real solution x3
     * does not exist.
     *
     * @return
     */
    public double getSolutionX3() {
        this.polySolve();
        if (this.degree < 3) {
            return 0010;
        } else {
            if (this.real) {
                return this.x3;
            } else {
                return 0010;
            }
        }
    }

    /**
     * Differentiates the polynomial function, disregarding y
     *
     */
    public void polyDiff() {
        this.polySolve();
        int dd2 = 0, dd3 = 0;
        String d1 = "", d2 = "", d3 = "";
        this.da = 3 * this.a;
        this.db = 2 * this.b;
        this.dc = this.c;
        if (this.degree == 3) {
            d1 = "dy/dx = " + this.da + "x^2 ";
            if (this.b == 0) {
                dd2 = 1;
            } else {
                if (this.db > 0) {
                    d2 = "+ " + this.db + "x ";
                } else {
                    d2 = "- " + -this.db + "x ";
                }
            }
            if (this.c == 0) {
                dd3 = 1;
            } else {
                if (this.dc > 0) {
                    d3 = "+ " + this.dc;
                } else {
                    d3 = "- " + -this.dc;
                }
            }
            if (dd2 == 0 && dd3 == 0) {
                this.diff = d1 + d2 + d3;
            }
            if (dd2 == 0 && dd3 == 1) {
                this.diff = d1 + d2;
            }
            if (dd2 == 1 && dd3 == 1) {
                this.diff = d1;
            }
            if (dd2 == 1 && dd3 == 0) {
                this.diff = d1 + d3;
            }

        }
        if (this.degree == 2) {
            d1 = "dy/dx = " + this.db + "x ";
            if (this.dc == 0) {
                this.diff = d1;
            } else {
                if (this.dc > 0) {
                    this.diff = d1 + "+" + this.dc;
                } else {
                    this.diff = d1 + "-" + -this.dc;
                }
            }
        }
        if (this.degree == 1) {
            this.diff = "dy/dx = " + this.c;
        }
        if (this.degree == 0) {
            this.diff = "dy/dx = " + 0;
        }

    }

    /**
     * Returns the derivative of the polynomial as a string.
     *
     * @return
     */
    public String getDiff() {
        return this.diff;
    }

    private void tanSlope(double x) {
        this.polyDiff();
        this.tanslope = this.da * x * x + this.db * x + this.dc;
    }

    /**
     * Returns the slope of the tangent line at point x.
     *
     * @param x
     * @return
     */
    public double getTanSlope(double x) {
        this.tanSlope(x);
        return this.tanslope;
    }

    /**
     * Integrates the polynomial indefinitely
     *
     */
    private void polyInt() {
        this.polySolve();
        this.ia = this.a * (1.0 / 4.0);
        this.ib = this.b * (1.0 / 3.0);
        this.ic = this.c * (1.0 / 2.0);
        this.id = this.d;
        String int1 = null, int2 = "", int3 = "", int4 = "";
        int inta = 0, intb = 0, intc = 0, intd = 0;
        if (this.degree == 3) {
            int1 = "Sf(x) = " + this.ia + "x^4 ";
            if (this.b == 0) {
                intb = 1;
            } else {
                if (this.b > 0) {
                    int2 = "+ " + this.ib + "x^3 ";

                } else {
                    int2 = "- " + -this.ib + "x^3 ";
                }
            }
            if (this.c == 0) {
                intc = 1;
            } else {
                if (this.c > 0) {
                    int3 = "+ " + this.ic + "x^2 ";
                } else {
                    int3 = "- " + -this.ic + "x^2 ";
                }
            }
            if (this.d == 0) {
                intd = 1;
            } else {
                if (this.d > 0) {
                    int4 = "+ " + this.id + "x ";
                } else {
                    int4 = "- " + -this.id + "x ";
                }
            }
            if (intb == 0 && intc == 0 && intd == 0) {
                this.integral = int1 + int2 + int3 + int4 + "+ C";
            }
            if (intb == 0 && intc == 0 && intd == 1) {
                this.integral = int1 + int2 + int3 + "+ C";
            }
            if (intb == 0 && intc == 1 && intd == 1) {
                this.integral = int1 + int2 + "+ C";
            }
            if (intb == 1 && intc == 1 && intd == 1) {
                this.integral = int1 + "+ C";
            }
            if (intb == 1 && intc == 0 && intd == 0) {
                this.integral = int1 + int3 + int4 + "+ C";
            }
            if (intb == 1 && intc == 0 && intd == 1) {
                this.integral = int1 + int3 + "+ C";
            }
            if (intb == 1 && intc == 1 && intd == 0) {
                this.integral = int1 + int4 + "+ C";
            }

        }
        if (this.degree == 2) {
            int1 = "Sf(x) = " + this.ib + "x^3 ";
            if (this.c == 0) {
                intc = 1;
            } else {
                if (this.c > 0) {
                    int2 = "+ " + this.ic + "x^2 ";
                } else {
                    int2 = "- " + -this.ic + "x^2 ";
                }
            }

            if (this.d == 0) {
                intd = 1;
            } else {
                if (this.d > 0) {
                    int3 = "+ " + this.id + "x ";
                } else {
                    int3 = "- " + -this.id + "x ";
                }
            }
            if (intc == 0 && intd == 0) {
                this.integral = int1 + int2 + int3 + "+ C";
            }
            if (intc == 0 && intd == 1) {
                this.integral = int1 + int2 + "+ C";
            }
            if (intc == 1 && intd == 0) {
                this.integral = int1 + int3 + "+ C";
            }
            if (intc == 1 && intd == 1) {
                this.integral = int1 + "+ C";
            }
        }
        if (this.degree == 1) {
            int1 = "Sf(x) = " + this.ic + "x^2 ";
            if (this.id == 0) {
                intd = 1;

            } else {
                if (this.id > 0) {
                    int2 = "+ " + this.id + "x ";
                } else {
                    int2 = "- " + -this.id + "x ";
                }
            }
            if (intd == 0) {
                this.integral = int1 + int2 + "+ C";
            } else {
                this.integral = int1 + int2 + "+ C";
            }

        }
        if (this.degree == 0) {
            this.integral = "Sf(x) = " + this.id + "x + C";
        }

    }

    /**
     * Integrates the polynomial definitely from a to b.
     *
     * @param a
     * @param b
     */
    private void polyDefInt(double a, double b) {
        double eb, ea;
        this.polyInt();
        eb = this.ia * Math.pow(b, 4) + this.ib * Math.pow(b, 3) + this.ic * Math.pow(b, 2) + this.id * b;
        ea = this.ia * Math.pow(a, 4) + this.ib * Math.pow(a, 3) + this.ic * Math.pow(a, 2) + this.id * a;
        this.defint = eb - ea;

    }

    /**
     * Returns the definite integral from a to b.
     *
     * @param a
     * @param b
     * @return
     */
    public double getDefInt(double a, double b) {
        this.polyDefInt(a, b);
        return this.defint;
    }

    /**
     * returns the indefinite integral as a string.
     *
     * @return
     */
    public String getIntStr() {
        this.polyInt();
        return this.integral;
    }

    /**
     * Returns the real part of complex solution x1.
     *
     * @return
     */
    public double getX1Real() {
        return this.x1re;
    }

    /**
     * Returns the imaginary part of complex solution x1.
     *
     * @return
     */
    public double getX1Imaginary() {
        return this.x1im;
    }

    /**
     * Real turns the real part of complex solution x2
     *
     * @return
     */
    public double getX2Real() {
        return this.x2re;
    }

    /**
     * Real turns the imaginary part of complex solution x2
     *
     * @return
     */
    public double getX2Imaginary() {
        return this.x2im;
    }

    /**
     * Adds another polynomial to the original.
     *
     * @param a2
     * @param b2
     * @param c2
     * @param d2
     * @param y2
     */
    public void polyAdd(double a2, double b2, double c2, double d2, double y2) {
        this.polyadd = (this.y + y2) + " = " + (this.a + a2)
                + "x^3 + " + (this.b + b2) + "x^2 + "
                + (this.c + c2) + "x + " + (this.d + d2);
        this.aadd = (this.a + a2);
        this.badd = (this.b + b2);
        this.cadd = (this.c + c2);
        this.dadd = (this.d + d2);
        this.yadd = (this.y + y2);
    }

    /**
     * Returns the addition polynomial as a string.
     *
     * @return
     */
    public String getPolyAdd() {
        return this.polyadd;
    }

    /**
     * Solves the addition polynomial.
     */
    private void polyAddSolve() {
        double a, b, c, d, y1, x1, x2, x3;
        a = this.aadd;
        b = this.badd;
        c = this.cadd;
        d = this.dadd;
        y1 = this.yadd;
        if (a != 0) {
            this.adddegree = 3;
            d = d - y1;
            double e, f, g, h, j, t, y, b2, c2, im, re, disc;
            e = ((-Math.pow(b, 3)) / (27 * Math.pow(a, 3)))
                    + ((b * c) / (6 * Math.pow(a, 2))) - (d / (2 * a));
            f = (c / (3 * a)) - ((Math.pow(b, 2)) / (9 * Math.pow(a, 2)));
            g = (-b / (3 * a));
            h = Math.pow(e, 2) + Math.pow(f, 3);

            if (h < 0) {
                re = e;
                im = Math.sqrt(-h);
                Complex root1 = new Complex(re, im);
                Complex root2 = new Complex(re, -im);

                j = root1.getRealRoot(3) + root2.getRealRoot(3);
                x1 = j + g;
                this.x1add = x1;
                this.x3realadd = "x1 = " + this.x1add;
                b2 = a * x1 + b;
                c2 = x1 * b2 + c;
                disc = Math.pow(b2, 2) - 4 * a * c2;
                if (disc < 0) {
                    this.addreal = false;
                    double r, i;
                    r = -b2 / (2 * a);
                    i = Math.sqrt(-disc) / (2 * a);
                    this.x1readd = r;
                    this.x2readd = r;
                    this.x1imadd = i;
                    this.x2imadd = -i;
                    this.x1compadd = "x1= " + r + "+" + i + "i ; ";
                    this.x2compadd = "x2= " + r + "-" + i + "i ; ";

                } else {
                    this.addreal = true;
                    x2 = (-b2 + Math.sqrt(disc)) / (2 * a);
                    x3 = (-b2 - Math.sqrt(disc)) / (2 * a);
                    this.x2add = x2;
                    this.x3add = x3;
                    this.x1realadd = "x1= " + this.x2 + " ; ";
                    this.x2realadd = "x2= " + this.x3 + " ; ";
                }

            } else {
                double t2, y2, j2;
                t = e + Math.sqrt(h);
                y = e - Math.sqrt(h);
                y2 = Math.pow(y, 1.0 / 3.0);
                t2 = Math.pow(t, 1.0 / 3.0);
                j2 = y2 + t2;
                x1 = j2 + g;
                this.x1add = x1;
                this.x3realadd = "x1 = " + this.x1add;
                b2 = a * x1 + b;
                c2 = x1 * b2 + c;
                disc = Math.pow(b2, 2) - 4 * a * c2;
                if (disc < 0) {
                    this.addreal = false;
                    double r, i;
                    r = -b2 / (2 * a);
                    i = Math.sqrt(-disc) / (2 * a);
                    this.x1readd = r;
                    this.x2readd = r;
                    this.x1imadd = i;
                    this.x2imadd = -i;
                    this.x1compadd = "x1= " + r + "+" + i + "i ; ";
                    this.x2compadd = "x2= " + r + "-" + i + "i ; ";
                    this.x1realadd = "false";
                    this.x2realadd = "false";

                } else {
                    x2 = (-b2 + Math.sqrt(disc)) / (2 * a);
                    x3 = (-b2 - Math.sqrt(disc)) / (2 * a);
                    this.x2add = x2;
                    this.x3add = x3;
                    this.x1realadd = "x1= " + this.x2add + " ; ";
                    this.x2realadd = "x2= " + this.x3add + " ; ";
                }

            }

        }
        if (a == 0 && b != 0) {
            this.adddegree = 2;
            d = d - y1;
            double disc, r, i;
            disc = Math.pow(c, 2) - 4 * b * d;
            if (disc < 0) {
                this.addreal = false;
                r = -c / (2 * b);
                i = Math.sqrt(-disc) / (2 * b);
                this.x1readd = r;
                this.x2readd = r;
                this.x1imadd = i;
                this.x2imadd = -i;
                this.x1compadd = "x1= " + r + "+" + i + "i";
                this.x2compadd = "x2= " + r + "-" + i + "i";
                this.x1realadd = "false";
                this.x2realadd = "false";

            } else {
                this.addreal = true;
                x1 = (-c + Math.sqrt(disc)) / (2 * b);
                x2 = (-c + Math.sqrt(disc)) / (2 * b);
                this.x1add = x1;
                this.x2add = x2;

                this.x1realadd = "x1= " + this.x1add + " ; ";
                this.x2realadd = "x2= " + this.x2add + " ; ";
            }
        }
        if (a == 0 && b == 0 && c != 0) {
            this.adddegree = 1;
            this.x1add = (y1 - d) / c;
            this.x1realadd = "x1= " + this.x1add;
        }
        if (a == 0 && b == 0 && c == 0) {
            this.adddegree = 0;

            if (d == y1) {
                this.x1realadd = "Identity: " + d + " = " + y1;

            } else {
                this.x1realadd = "Contradiction: " + d + " is not equal to " + y1;

            }
        }

    }

    /**
     * Returns the degree of the addition polynomial.
     *
     * @return
     */
    public int getPolyAddDegree() {
        this.polyAddSolve();
        return this.adddegree;
    }

    /**
     * Returns true if the solutions to the addition polynomial are all real.
     * Returns false if there exist complex solutions
     *
     * @return
     */
    public boolean realAddSolution() {
        this.polyAddSolve();
        return this.addreal;
    }

    /**
     * Returns real solution x1 from the addition polynomial as a string.
     * Returns "false" if solution x1 is complex.
     *
     * @return
     */
    public String getX1AddRealStr() {
        this.polyAddSolve();
        return this.x1realadd;
    }

    /**
     * Returns real solution x2 from the addition polynomial as a string.
     *
     * @return
     */
    public String getX2AddRealStr() {
        this.polyAddSolve();
        return this.x2realadd;
    }

    /**
     * Returns real solution x3 from the addition polynomial as a string.
     *
     * @return
     */
    public String getX3AddRealStr() {
        this.polyAddSolve();
        return this.x3realadd;
    }

    /**
     * Returns complex solution x1 from the addition polynomial as a string.
     *
     * @return
     */
    public String getX1AddCompStr() {
        this.polyAddSolve();
        return this.x1compadd;
    }

    /**
     * Returns complex solution x2 from the addition polynomial as a string.
     *
     * @return
     */
    public String getX2AddCompStr() {
        this.polyAddSolve();
        return this.x2compadd;
    }

    /**
     * Returns solution x1 from the addition polynomial as a double.
     *
     * @return
     */
    public double getX1AddSolution() {
        this.polyAddSolve();
        return this.x1add;
    }

    /**
     * Returns solution x2 from the addition polynomial as a double.
     *
     * @return
     */
    public double getX2AddSolution() {
        this.polyAddSolve();
        return this.x2add;
    }

    /**
     * Returns solution x3 from the addition polynomial as a double.
     *
     * @return
     */
    public double getX3AddSolution() {
        this.polyAddSolve();
        return this.x3add;
    }

    /**
     * Returns the real part of complex solution x1 from the addition
     * polynomial.
     *
     * @return
     */
    public double getX1AddReal() {
        this.polyAddSolve();
        return this.x1readd;
    }

    /**
     * Returns the imaginary part of complex solution x2 from the addition
     * polynomial.
     *
     * @return
     */
    public double getX1AddImaginary() {
        this.polyAddSolve();
        return this.x1imadd;
    }

    /**
     * Returns the real part of complex solution x2 from the addition
     * polynomial.
     *
     * @return
     */
    public double getX2AddReal() {
        this.polyAddSolve();
        return this.x2readd;
    }

    /**
     * Returns the imaginary part of complex solution x2 from the addition
     * polynomial
     *
     * @return
     */
    public double getX2AddImaginary() {
        this.polyAddSolve();
        return this.x2imadd;
    }

    /**
     * Differentiates the addition polynomial.
     */
    public void addDif() {
        this.polyAddSolve();
        int dd2 = 0, dd3 = 0;
        String d1 = "", d2 = "", d3 = "";
        this.daa = 3 * this.aadd;
        this.dba = 2 * this.badd;
        this.dca = this.cadd;
        if (this.adddegree == 3) {
            d1 = "dy/dx = " + this.daa + "x^2 ";
            if (this.badd == 0) {
                dd2 = 1;
            } else {
                if (this.dba > 0) {
                    d2 = "+ " + this.dba + "x ";
                } else {
                    d2 = "- " + -this.dba + "x ";
                }
            }
            if (this.cadd == 0) {
                dd3 = 1;
            } else {
                if (this.dca > 0) {
                    d3 = "+ " + this.dca;
                } else {
                    d3 = "- " + -this.dca;
                }
            }
            if (dd2 == 0 && dd3 == 0) {
                this.adddiff = d1 + d2 + d3;
            }
            if (dd2 == 0 && dd3 == 1) {
                this.adddiff = d1 + d2;
            }
            if (dd2 == 1 && dd3 == 1) {
                this.adddiff = d1;
            }
            if (dd2 == 1 && dd3 == 0) {
                this.adddiff = d1 + d3;
            }

        }
        if (this.adddegree == 2) {
            d1 = "dy/dx = " + this.db + "x ";
            if (this.dca == 0) {
                this.adddiff = d1;
            } else {
                if (this.dca > 0) {
                    this.adddiff = d1 + "+" + this.dca;
                } else {
                    this.adddiff = d1 + "-" + -this.dca;
                }
            }
        }
        if (this.adddegree == 1) {
            this.adddiff = "dy/dx = " + this.cadd;
        }
        if (this.adddegree == 0) {
            this.adddiff = "dy/dx = " + 0;
        }

    }

    /**
     * Returns the derivative of the addition polynomial as a string.
     *
     * @return
     */
    public String getAddDiff() {
        this.addDif();
        return this.adddiff;
    }

    /**
     * Returns the slope of line tangent to the addition polynomial at point x.
     *
     * @param x
     * @return
     */
    public double addTanSlope(double x) {
        this.addDif();
        this.addtanslope = this.daa * x * x + this.dba * x + this.dca;
        return this.addtanslope;

    }

    /**
     * Finds the indefinite integral of the addition polynomial.
     */
    private void addInt() {
        this.polyAddSolve();
        this.iaa = this.aadd * (1.0 / 4.0);
        this.iba = this.badd * (1.0 / 3.0);
        this.ica = this.cadd * (1.0 / 2.0);
        this.ida = this.dadd;
        String int1 = null, int2 = "", int3 = "", int4 = "";
        int inta = 0, intb = 0, intc = 0, intd = 0;
        if (this.adddegree == 3) {
            int1 = "Sf(x) = " + this.iaa + "x^4 ";
            if (this.badd == 0) {
                intb = 1;
            } else {
                if (this.badd > 0) {
                    int2 = "+ " + this.iba + "x^3 ";

                } else {
                    int2 = "- " + -this.iba + "x^3 ";
                }
            }
            if (this.cadd == 0) {
                intc = 1;
            } else {
                if (this.cadd > 0) {
                    int3 = "+ " + this.ica + "x^2 ";
                } else {
                    int3 = "- " + -this.ica + "x^2 ";
                }
            }
            if (this.dadd == 0) {
                intd = 1;
            } else {
                if (this.dadd > 0) {
                    int4 = "+ " + this.ida + "x ";
                } else {
                    int4 = "- " + -this.ida + "x ";
                }
            }
            if (intb == 0 && intc == 0 && intd == 0) {
                this.addintegral = int1 + int2 + int3 + int4 + "+ C";
            }
            if (intb == 0 && intc == 0 && intd == 1) {
                this.addintegral = int1 + int2 + int3 + "+ C";
            }
            if (intb == 0 && intc == 1 && intd == 1) {
                this.addintegral = int1 + int2 + "+ C";
            }
            if (intb == 1 && intc == 1 && intd == 1) {
                this.addintegral = int1 + "+ C";
            }
            if (intb == 1 && intc == 0 && intd == 0) {
                this.addintegral = int1 + int3 + int4 + "+ C";
            }
            if (intb == 1 && intc == 0 && intd == 1) {
                this.addintegral = int1 + int3 + "+ C";
            }
            if (intb == 1 && intc == 1 && intd == 0) {
                this.addintegral = int1 + int4 + "+ C";
            }

        }
        if (this.adddegree == 2) {
            int1 = "Sf(x) = " + this.iba + "x^3 ";
            if (this.cadd == 0) {
                intc = 1;
            } else {
                if (this.cadd > 0) {
                    int2 = "+ " + this.ica + "x^2 ";
                } else {
                    int2 = "- " + -this.ica + "x^2 ";
                }
            }

            if (this.dadd == 0) {
                intd = 1;
            } else {
                if (this.dadd > 0) {
                    int3 = "+ " + this.ida + "x ";
                } else {
                    int3 = "- " + -this.ida + "x ";
                }
            }
            if (intc == 0 && intd == 0) {
                this.addintegral = int1 + int2 + int3 + "+ C";
            }
            if (intc == 0 && intd == 1) {
                this.addintegral = int1 + int2 + "+ C";
            }
            if (intc == 1 && intd == 0) {
                this.addintegral = int1 + int3 + "+ C";
            }
            if (intc == 1 && intd == 1) {
                this.addintegral = int1 + "+ C";
            }
        }
        if (this.adddegree == 1) {
            int1 = "Sf(x) = " + this.ica + "x^2 ";
            if (this.ida == 0) {
                intd = 1;

            } else {
                if (this.ida > 0) {
                    int2 = "+ " + this.ida + "x ";
                } else {
                    int2 = "- " + -this.ida + "x ";
                }
            }
            if (intd == 0) {
                this.addintegral = int1 + int2 + "+ C";
            } else {
                this.addintegral = int1 + int2 + "+ C";
            }

        }
        if (this.adddegree == 0) {
            this.addintegral = "Sf(x) = " + this.ida + "x + C";
        }
    }

    /**
     * Returns the indefinite integral of the addition polynomial as a string.
     *
     * @return
     */
    public String getAddInt() {
        this.addInt();
        return this.addintegral;

    }

    /**
     * Finds the integral for a to b of the addition polynomial.
     *
     * @param a
     * @param b
     */
    private void addDefInt(double a, double b) {
        double eb, ea;
        this.addInt();
        eb = this.iaa * Math.pow(b, 4) + this.iba * Math.pow(b, 3) + this.ica * Math.pow(b, 2) + this.ida * b;
        ea = this.iaa * Math.pow(a, 4) + this.iba * Math.pow(a, 3) + this.ica * Math.pow(a, 2) + this.ida * a;
        this.adddefint = eb - ea;
    }

    /**
     * Returns the integral from a to b of the addition polynomial.
     *
     * @param a
     * @param b
     * @return
     */
    public double getAddDefInt(double a, double b) {
        this.addDefInt(a, b);
        return this.adddefint;
    }

    /**
     * Subtracts another polynomial from the original.
     *
     * @param a2
     * @param b2
     * @param c2
     * @param d2
     * @param y2
     */
    public void polySubtract(double a2, double b2, double c2, double d2, double y2) {
        this.polysubtract = (this.y - y2) + " = " + (this.a - a2) + "x^3 + "
                + (this.b - b2) + "x^2 + " + (this.c - c2) + "x + "
                + (this.d - d2);
        this.asub = (this.a - a2);
        this.bsub = (this.b - b2);
        this.csub = (this.c - c2);
        this.dsub = (this.d - d2);
        this.ysub = (this.y - y2);
    }

    /**
     * Returns the subtraction polynomial as a string.
     *
     * @return
     */
    public String getPolySub() {
        return this.polysubtract;
    }

    /**
     * Solves the subtraction polynomial.
     */
    private void polySubSolve() {
        double a, b, c, d, y1, x1, x2, x3;
        a = this.asub;
        b = this.bsub;
        c = this.csub;
        d = this.dsub;
        y1 = this.ysub;
        if (a != 0) {
            this.subdegree = 3;
            d = d - y1;
            double e, f, g, h, j, t, y, b2, c2, im, re, disc;
            e = ((-Math.pow(b, 3)) / (27 * Math.pow(a, 3)))
                    + ((b * c) / (6 * Math.pow(a, 2))) - (d / (2 * a));
            f = (c / (3 * a)) - ((Math.pow(b, 2)) / (9 * Math.pow(a, 2)));
            g = (-b / (3 * a));
            h = Math.pow(e, 2) + Math.pow(f, 3);

            if (h < 0) {
                re = e;
                im = Math.sqrt(-h);
                Complex root1 = new Complex(re, im);
                Complex root2 = new Complex(re, -im);

                j = root1.getRealRoot(3) + root2.getRealRoot(3);
                x1 = j + g;
                this.x1sub = x1;
                this.x3realsub = "x1 = " + this.x1sub;
                b2 = a * x1 + b;
                c2 = x1 * b2 + c;
                disc = Math.pow(b2, 2) - 4 * a * c2;
                if (disc < 0) {
                    this.subreal = false;
                    double r, i;
                    r = -b2 / (2 * a);
                    i = Math.sqrt(-disc) / (2 * a);
                    this.x1resub = r;
                    this.x2resub = r;
                    this.x1imsub = i;
                    this.x2imsub = -i;
                    this.x1compsub = "x1= " + r + "+" + i + "i ; ";
                    this.x2compsub = "x2= " + r + "-" + i + "i ; ";

                } else {
                    this.subreal = true;
                    x2 = (-b2 + Math.sqrt(disc)) / (2 * a);
                    x3 = (-b2 - Math.sqrt(disc)) / (2 * a);
                    this.x2sub = x2;
                    this.x3sub = x3;
                    this.x1realsub = "x1= " + this.x2 + " ; ";
                    this.x2realsub = "x2= " + this.x3 + " ; ";
                }

            } else {
                double t2, y2, j2;
                t = e + Math.sqrt(h);
                y = e - Math.sqrt(h);
                y2 = Math.pow(y, 1.0 / 3.0);
                t2 = Math.pow(t, 1.0 / 3.0);
                j2 = y2 + t2;
                x1 = j2 + g;
                this.x1sub = x1;
                this.x3realsub = "x1 = " + this.x1sub;
                b2 = a * x1 + b;
                c2 = x1 * b2 + c;
                disc = Math.pow(b2, 2) - 4 * a * c2;
                if (disc < 0) {
                    this.subreal = false;
                    double r, i;
                    r = -b2 / (2 * a);
                    i = Math.sqrt(-disc) / (2 * a);
                    this.x1resub = r;
                    this.x2resub = r;
                    this.x1imsub = i;
                    this.x2imsub = -i;
                    this.x1compsub = "x1= " + r + "+" + i + "i ; ";
                    this.x2compsub = "x2= " + r + "-" + i + "i ; ";
                    this.x1realsub = "false";
                    this.x2realsub = "false";

                } else {
                    x2 = (-b2 + Math.sqrt(disc)) / (2 * a);
                    x3 = (-b2 - Math.sqrt(disc)) / (2 * a);
                    this.x2sub = x2;
                    this.x3sub = x3;
                    this.x1realsub = "x1= " + this.x2sub + " ; ";
                    this.x2realsub = "x2= " + this.x3sub + " ; ";
                }

            }

        }
        if (a == 0 && b != 0) {
            this.subdegree = 2;
            d = d - y1;
            double disc, r, i;
            disc = Math.pow(c, 2) - 4 * b * d;
            if (disc < 0) {
                this.subreal = false;
                r = -c / (2 * b);
                i = Math.sqrt(-disc) / (2 * b);
                this.x1resub = r;
                this.x2resub = r;
                this.x1imsub = i;
                this.x2imsub = -i;
                this.x1compsub = "x1= " + r + "+" + i + "i";
                this.x2compsub = "x2= " + r + "-" + i + "i";
                this.x1realsub = "false";
                this.x2realsub = "false";

            } else {
                this.subreal = true;
                x1 = (-c + Math.sqrt(disc)) / (2 * b);
                x2 = (-c + Math.sqrt(disc)) / (2 * b);
                this.x1sub = x1;
                this.x2sub = x2;

                this.x1realsub = "x1= " + this.x1sub + " ; ";
                this.x2realsub = "x2= " + this.x2sub + " ; ";
            }
        }
        if (a == 0 && b == 0 && c != 0) {
            this.subdegree = 1;
            this.x1sub = (y1 - d) / c;
            this.x1realsub = "x1= " + this.x1sub;
        }
        if (a == 0 && b == 0 && c == 0) {
            this.subdegree = 0;

            if (d == y1) {
                this.x1realsub = "Identity: " + d + " = " + y1;

            } else {
                this.x1realsub = "Contradiction: " + d + " is not equal to " + y1;

            }
        }

    }

    /**
     * Returns the degree of the subtraction polynomial.
     *
     * @return
     */
    public int getPolySubDegree() {
        this.polySubSolve();
        return this.subdegree;
    }

    /**
     * Returns true if the solutions to the subtraction polynomial are all real.
     * Returns false if there exist complex solutions
     *
     * @return
     */
    public boolean realSubSolution() {
        this.polySubSolve();
        return this.subreal;
    }

    /**
     * Returns real solution x1 from the subtraction polynomial as a string.
     * Returns "false" if solution x1 is complex.
     *
     * @return
     */
    public String getX1SubRealStr() {
        this.polySubSolve();
        return this.x1realsub;
    }

    /**
     * Returns real solution x2 from the subtraction polynomial as a string.
     *
     * @return
     */
    public String getX2SubRealStr() {
        this.polyAddSolve();
        return this.x2realsub;
    }

    /**
     * Returns real solution x3 from the subtraction polynomial as a string.
     *
     * @return
     */
    public String getX3SubRealStr() {
        this.polySubSolve();
        return this.x3realsub;
    }

    /**
     * Returns complex solution x1 from the subtraction polynomial as a string.
     *
     * @return
     */
    public String getX1SubCompStr() {
        this.polySubSolve();
        return this.x1compsub;
    }

    /**
     * Returns complex solution x2 from the subtraction polynomial as a string.
     *
     * @return
     */
    public String getX2SubCompStr() {
        this.polySubSolve();
        return this.x2compsub;
    }

    /**
     * Returns solution x1 from the subtraction polynomial as a double.
     *
     * @return
     */
    public double getX1SubSolution() {
        this.polySubSolve();
        return this.x1sub;
    }

    /**
     * Returns solution x2 from the subtraction polynomial as a double.
     *
     * @return
     */
    public double getX2SubSolution() {
        this.polySubSolve();
        return this.x2sub;
    }

    /**
     * Returns solution x3 from the subtraction polynomial as a double.
     *
     * @return
     */
    public double getX3SubSolution() {
        this.polySubSolve();
        return this.x3sub;
    }

    /**
     * Returns the real part of complex solution x1 from the subtraction
     * polynomial.
     *
     * @return
     */
    public double getX1SubReal() {
        this.polySubSolve();
        return this.x1resub;
    }

    /**
     * Returns the imaginary part of complex solution x2 from the subtraction
     * polynomial.
     *
     * @return
     */
    public double getX1SubImaginary() {
        this.polySubSolve();
        return this.x1imsub;
    }

    /**
     * Returns the real part of complex solution x2 from the subtraction
     * polynomial.
     *
     * @return
     */
    public double getX2SubReal() {
        this.polySubSolve();
        return this.x2resub;
    }

    /**
     * Returns the imaginary part of complex solution x2 from the subtraction
     * polynomial
     *
     * @return
     */
    public double getX2SubImaginary() {
        this.polySubSolve();
        return this.x2imsub;
    }

    /**
     * Differentiates the subtraction polynomial.
     */
    public void subDif() {
        this.polySubSolve();
        int dd2 = 0, dd3 = 0;
        String d1 = "", d2 = "", d3 = "";
        this.das = 3 * this.asub;
        this.dbs = 2 * this.bsub;
        this.dcs = this.csub;
        if (this.subdegree == 3) {
            d1 = "dy/dx = " + this.das + "x^2 ";
            if (this.bsub == 0) {
                dd2 = 1;
            } else {
                if (this.dbs > 0) {
                    d2 = "+ " + this.dbs + "x ";
                } else {
                    d2 = "- " + -this.dbs + "x ";
                }
            }
            if (this.csub == 0) {
                dd3 = 1;
            } else {
                if (this.dcs > 0) {
                    d3 = "+ " + this.dcs;
                } else {
                    d3 = "- " + -this.dcs;
                }
            }
            if (dd2 == 0 && dd3 == 0) {
                this.subdiff = d1 + d2 + d3;
            }
            if (dd2 == 0 && dd3 == 1) {
                this.subdiff = d1 + d2;
            }
            if (dd2 == 1 && dd3 == 1) {
                this.subdiff = d1;
            }
            if (dd2 == 1 && dd3 == 0) {
                this.subdiff = d1 + d3;
            }

        }
        if (this.subdegree == 2) {
            d1 = "dy/dx = " + this.dbs + "x ";
            if (this.dcs == 0) {
                this.subdiff = d1;
            } else {
                if (this.dcs > 0) {
                    this.subdiff = d1 + "+" + this.dcs;
                } else {
                    this.subdiff = d1 + "-" + -this.dcs;
                }
            }
        }
        if (this.subdegree == 1) {
            this.subdiff = "dy/dx = " + this.csub;
        }
        if (this.subdegree == 0) {
            this.subdiff = "dy/dx = " + 0;
        }

    }

    /**
     * Returns the derivative of the subtraction polynomial as a string.
     *
     * @return
     */
    public String getSubDiff() {
        this.subDif();
        return this.subdiff;
    }

    /**
     * Returns the slope of line tangent to the subtraction polynomial at point
     * x.
     *
     * @param x
     * @return
     */
    public double subTanSlope(double x) {
        this.subDif();
        this.subtanslope = this.das * x * x + this.dbs * x + this.dcs;
        return this.subtanslope;

    }

    /**
     * Finds the indefinite integral of the subtraction polynomial.
     */
    private void subInt() {
        this.polySubSolve();
        this.ias = this.asub * (1.0 / 4.0);
        this.ibs = this.bsub * (1.0 / 3.0);
        this.ics = this.csub * (1.0 / 2.0);
        this.ids = this.dsub;
        String int1 = null, int2 = "", int3 = "", int4 = "";
        int inta = 0, intb = 0, intc = 0, intd = 0;
        if (this.subdegree == 3) {
            int1 = "Sf(x) = " + this.ias + "x^4 ";
            if (this.bsub == 0) {
                intb = 1;
            } else {
                if (this.bsub > 0) {
                    int2 = "+ " + this.ibs + "x^3 ";

                } else {
                    int2 = "- " + -this.ibs + "x^3 ";
                }
            }
            if (this.csub == 0) {
                intc = 1;
            } else {
                if (this.csub > 0) {
                    int3 = "+ " + this.ics + "x^2 ";
                } else {
                    int3 = "- " + -this.ics + "x^2 ";
                }
            }
            if (this.dsub == 0) {
                intd = 1;
            } else {
                if (this.dsub > 0) {
                    int4 = "+ " + this.ids + "x ";
                } else {
                    int4 = "- " + -this.ids + "x ";
                }
            }
            if (intb == 0 && intc == 0 && intd == 0) {
                this.subintegral = int1 + int2 + int3 + int4 + "+ C";
            }
            if (intb == 0 && intc == 0 && intd == 1) {
                this.subintegral = int1 + int2 + int3 + "+ C";
            }
            if (intb == 0 && intc == 1 && intd == 1) {
                this.subintegral = int1 + int2 + "+ C";
            }
            if (intb == 1 && intc == 1 && intd == 1) {
                this.subintegral = int1 + "+ C";
            }
            if (intb == 1 && intc == 0 && intd == 0) {
                this.subintegral = int1 + int3 + int4 + "+ C";
            }
            if (intb == 1 && intc == 0 && intd == 1) {
                this.subintegral = int1 + int3 + "+ C";
            }
            if (intb == 1 && intc == 1 && intd == 0) {
                this.subintegral = int1 + int4 + "+ C";
            }

        }
        if (this.subdegree == 2) {
            int1 = "Sf(x) = " + this.ibs + "x^3 ";
            if (this.csub == 0) {
                intc = 1;
            } else {
                if (this.csub > 0) {
                    int2 = "+ " + this.ics + "x^2 ";
                } else {
                    int2 = "- " + -this.ics + "x^2 ";
                }
            }

            if (this.dsub == 0) {
                intd = 1;
            } else {
                if (this.dsub > 0) {
                    int3 = "+ " + this.ids + "x ";
                } else {
                    int3 = "- " + -this.ids + "x ";
                }
            }
            if (intc == 0 && intd == 0) {
                this.subintegral = int1 + int2 + int3 + "+ C";
            }
            if (intc == 0 && intd == 1) {
                this.subintegral = int1 + int2 + "+ C";
            }
            if (intc == 1 && intd == 0) {
                this.subintegral = int1 + int3 + "+ C";
            }
            if (intc == 1 && intd == 1) {
                this.subintegral = int1 + "+ C";
            }
        }
        if (this.subdegree == 1) {
            int1 = "Sf(x) = " + this.ics + "x^2 ";
            if (this.ids == 0) {
                intd = 1;

            } else {
                if (this.ids > 0) {
                    int2 = "+ " + this.ids + "x ";
                } else {
                    int2 = "- " + -this.ids + "x ";
                }
            }
            if (intd == 0) {
                this.subintegral = int1 + int2 + "+ C";
            } else {
                this.subintegral = int1 + int2 + "+ C";
            }

        }
        if (this.subdegree == 0) {
            this.subintegral = "Sf(x) = " + this.ids + "x + C";
        }
    }

    /**
     * Returns the indefinite integral of the subtraction polynomial as a
     * string.
     *
     * @return
     */
    public String getSubInt() {
        this.subInt();
        return this.subintegral;

    }

    /**
     * Finds the integral for a to b of the subtraction polynomial.
     *
     * @param a
     * @param b
     */
    private void subDefInt(double a, double b) {
        double eb, ea;
        this.subInt();
        eb = this.ias * Math.pow(b, 4) + this.ibs * Math.pow(b, 3) + this.ics * Math.pow(b, 2) + this.ids * b;
        ea = this.ias * Math.pow(a, 4) + this.ibs * Math.pow(a, 3) + this.ics * Math.pow(a, 2) + this.ids * a;
        this.subdefint = eb - ea;
    }

    /**
     * Returns the integral from a to b of the subtraction polynomial.
     *
     * @param a
     * @param b
     * @return
     */
    public double getSubDefInt(double a, double b) {
        this.subDefInt(a, b);
        return this.subdefint;
    }

    /**
     * Evaluates the polynomial at value x.
     *
     * @param x
     * @return
     */
    public double polyEval(double x) {
        double y;
        y = this.a * Math.pow(x, 3) + this.b * Math.pow(x, 2) + this.c * x + this.d;
        return y;
    }

    /**
     * Evaluates the addition polynomial at value x.
     *
     * @param x
     * @return
     */
    public double polyAddEval(double x) {
        double y;
        y = this.aadd * Math.pow(x, 3) + this.badd * Math.pow(x, 2) + this.cadd * x + this.dadd;
        return y;
    }

    /**
     * Evaluates the subtraction polynomial at value x.
     *
     * @param x
     * @return
     */
    public double polySubEval(double x) {
        double y;
        y = this.asub * Math.pow(x, 3) + this.bsub * Math.pow(x, 2) + this.csub * x + this.dsub;
        return y;
    }

    /**
     * Evaluates the indefinite integral at value x.
     *
     * @param x
     * @return
     */
    public double polyIntEval(double x) {
        this.polyInt();
        double y;
        y = this.ia * Math.pow(x, 4) + this.ib * Math.pow(x, 3)
                + this.ic * Math.pow(x, 2) + this.id * x;
        return y;
    }

    /**
     * Evaluates the indefinite addition integral at value x.
     *
     * @param x
     * @return
     */
    public double polyAddIntEval(double x) {
        this.addInt();
        double y;
        y = this.iaa * Math.pow(x, 4) + this.iba * Math.pow(x, 3)
                + this.ica * Math.pow(x, 2) + this.ida * x;
        return y;
    }

    /**
     * Evaluates the indefinite subtraction integral at value x.
     *
     * @param x
     * @return
     */
    public double polySubIntEval(double x) {
        this.subInt();
        double y;
        y = this.ias * Math.pow(x, 4) + this.ibs * Math.pow(x, 3)
                + this.ics * Math.pow(x, 2) + this.ids * x;
        return y;
    }

    /**
     * Changes the values of the polynomial function.
     *
     * @param a1
     * @param b1
     * @param c1
     * @param d1
     * @param y1
     */
    public void changePoly(double a1, double b1, double c1, double d1, double y1) {
        this.a = a1;
        this.b = b1;
        this.c = c1;
        this.d = d1;
        this.y = y1;
    }

    /**
     * Changes the polynomial into the addition polynomial.
     */
    public void changePolyAdd() {
        this.changePoly(this.aadd, this.badd, this.cadd, this.dadd, this.yadd);
    }

    /**
     * Changes the polynomial into the subtraction polynomial.
     */
    public void changePolySub() {
        this.changePoly(this.asub, this.bsub, this.csub, this.dsub, this.ysub);
    }

    /**
     * Changes the polynomial into the originally declared polynomial.
     */
    public void changePolyOriginal() {
        this.changePoly(this.aorg, this.borg, this.corg, this.dorg, this.yorg);
    }
}