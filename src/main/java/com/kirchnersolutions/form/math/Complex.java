package com.kirchnersolutions.form.math;

public class Complex {

    private double re, im, reorg, imorg, r, rer, imr, rep, imp, theta, readd, imadd;
    private double resubtract, imsubtract, reproduct, improduct;
    private String original, power, root, add, sub, product, modulus, angle;
    public static final double pi = Math.atan(1) * 4;
   
    /**Declares new complex number
     * 
     * @param a
     * @param b 
     */
    public Complex(double a, double b) {
        this.re = a;
        this.im = b;
        this.reorg = a;
        this.imorg = b;
        this.original = "z = " + a + " + " + b + "i";
        this.rer = 0;
        this.imr = 0;
        this.rep = 0;
        this.imp = 0;
        this.resubtract = 0;
        this.imsubtract = 0;
        this.readd = 0;
        this.imadd = 0;
        this. reproduct = 0;
        this.improduct = 0;
    }
    
   
    
    /**
     * Returns the original complex number z as a string.
     * @return 
     */
    public String getComplex(){
        return this.original;
    }
    
    /**
     * Finds the modulus of the original complex 
     * number z in polar form.
     */
    private void modulus() {
        double temp;
        temp = Math.pow(this.re, 2) + Math.pow(this.im, 2);
        this.r = Math.sqrt(temp);
        this.modulus = "r = " + this.root;
    }
    
    /**
     * Finds the angle of the modulus of the original
     * complex number z in polar coordinates.
     */
    private void compAngle() {
        double temp;
        temp = this.im / this.re;
        this.theta = Math.atan(temp);
        this.angle = "Theta = " + this.theta;
    }
    
    /**
     * Returns the modulus of the original
     * complex number z in polar form as a double.
     * @return 
     */
    public double getMod() {
        this.modulus();
        return this.r;
    }
    
    /**
     * Returns the modulus of the original
     * complex number z as a string.
     * @return 
     */
    public String getModStr(){
        this.modulus();
        return this.modulus;
    }
    
    /**
     * Returns the angle of the modulus of the
     * original complex number z in polar form
     * as a double.
     * @return 
     */
    public double getTheta() {
        this.compAngle();
        return this.theta;
    }
    
    /**
     * Returns the angle of then modulus of
     * the original complex number z in 
     * polar form as a string.
     * @return 
     */
    public String getThetaStr(){
        this.compAngle();
        return this.angle;
    }
    
    /**
     * Finds the specified root of the original
     * complex number z.
     * @param root 
     */
    private void compRoot(double root) {
        double real, img;
        this.modulus();
        this.compAngle();
        real = Math.pow(this.r, 1.0 / root) * Math.cos(this.theta * (1.0 / root) + pi);
        img = Math.pow(this.r, 1.0 / root) * Math.sin(this.theta * (1.0 / root) + pi);
        this.rer = real;
        this.imr = img;
        this.root = "z^(1/" + root + ") = " + real + " + " + img + "i";
    }
    
    /**
     * Returns the specified root of the original
     * complex number z as a string.
     * @param root
     * @return 
     */
    public String getRoot(double root){
        this.compRoot(root);
        return this.root;
    }
    
    /**
     * Returns the real part of the specified
     * root of the original complex number z
     * as a double.
     * @param root
     * @return 
     */
    public double getRealRoot(double root) {
        this.compRoot(root);
        return this.rer;
    }
    
    /**
     * Returns the imaginary part of the specified
     * root of the original complex number z 
     * as a double .
     * @param root
     * @return 
     */
    public double getImgRoot(double root) {
        this.compRoot(root);
        return this.imr;
    }
    
    /**
     * Finds a specified power of the original complex 
     * number z.
     * complex number z.
     * @param pow 
     */
   private void compPower(double pow) {
        double real, img;
        this.modulus();
        this.compAngle();
        real = Math.pow(this.r, pow) * Math.cos(this.theta * pow + pi);
        img = Math.pow(this.r, pow) * Math.sin(this.theta * pow + pi);
        this.rep = real;
        this.imp = img;
        this.power = "z^" + pow + " = " + real + " + " + img + "i";
    }
    
    /**
     * Returns the specified complex power of the original
     * complex number z as a string.
     * @param pow
     * @return 
     */
    public String getPower(double pow){
        this.compPower(pow);
        return this.power;
    }
    
    /**
     * Returns the real part of a specified power of the original 
     * complex number z as a double.
     * @param pow 
     * @return 
     */
    public double getRealPower(double pow) {
        this.compPower(pow);
        return this.rep;
    }
    
    /**
     * Returns the imaginary part of a specified power of the original 
     * complex number z as a double.
     * @param pow
     * @return 
     */
    public double getImgPower(double pow) {
        this.compPower(pow);
        return this.imp;
    }
       
    
    /** 
     * Adds the complex number u = re + (im)*i to the original
     * complex number z.
     * @param re
     * @param im 
     */
     private void complexAdd(double re, double im) {
     this.readd = this.re + re;
     this.imadd = this.im + im;
     this.add = "z + u = " + this.readd + " + " +
             this.imadd + "i";

    }
     
    /**
     * Returns the complex number of the original complex number
     * z added to complex number u = re + (im)*i 
     * as a double.
     * @param re
     * @param im
     * @return 
     */
    public String getAdd(double re, double im){
        this.complexAdd(re, im);
        return this.add;
    }
    
    /**
     * Returns the imaginary part of the complex number of the original 
     * complex number z added to complex number u = re + (im)*i 
     * as a double.
     * @param re
     * @param im
     * @return 
     */
    public double getImAdd(double re, double im) {
        this.complexAdd(re, im); 
        return this.imadd;
    }
    
    /**
     * Returns the real part of the complex number of the original 
     * complex number z added to complex number u = re + (im)*i as a string.
     * @param re
     * @param im
     * @return 
     */
    public double getReAdd(double re, double im) {
        this.complexAdd(re, im);
        return this.readd;
    }
    
    /**
     * Subtracts the complex number u = re + (im)*i from the original.
     * complex number z.
     * @param re
     * @param im 
     */
    private void complexSubtract(double re, double im) {
        this.resubtract = this.re - re;
        this.imsubtract = this.im - im;
        this.sub = "z - u = " + this.resubtract +
                " + " + this.imsubtract + "i";
    }

    /**
     * Returns the complex number of the complex number
     * u = re + (im)*i subtracted from the original complex
     * number z as a string.
     * @param re
     * @param im
     * @return 
     */
    public String getSub(double re, double im){
        this.complexSubtract(re, im);
        return this.sub;
    }
    
    /**
     * Returns the imaginary part of the complex number of the complex number
     * u = re + (im)*i subtracted from the original complex number z
     * as a double.
     * @param re
     * @param im
     * @return 
     */
    public double getImSub(double re, double im) {
        this.complexSubtract(re, im);
        return this.imsubtract;
    }

    /**
     * Returns the real part of the complex number of the complex number
     * u = re + (im)*i subtracted from the original complex number z
     * as a double.
     * @param re
     * @param im
     * @return 
     */
    public double getReSub(double re, double im) {
        this.complexSubtract(re, im);
        return this.resubtract;
    }
    
    /**
     * Finds the product of the original complex number z
     * and the complex number u = re + (im)*i.
     * @param re
     * @param im 
     */
    private void complexProduct(double re, double im) {
        this.reproduct = (this.re * re - this.im * im);
        this.improduct = (this.re * im + this.im * re);
        this.product = "z * u = " + this.reproduct + 
                " + " + this.improduct + "i";
    }

    /**
     * Returns the product of the original complex
     * number z and the complex number u = re + (im)*i
     * as a string.
     * @param re
     * @param im
     * @return 
     */
    public String getProd(double re, double im){
        this.complexProduct(re, im);
        return this.product;
    }
    
    /**
     * Return the imaginary part of the product of the original
     * complex number z and complex number u = re + (im)*i
     * as a double.
     * @param re
     * @param im
     * @return 
     */
    public double getImProd(double re, double im) {
        this.complexProduct(re, im);
        return this.improduct;
    }

    /**
     * Return the real part of the product of the original
     * complex number z and complex number u = re + (im)*i
     * as a double.
     * @param re
     * @param im
     * @return 
     */
    public double getReProd(double re, double im) {
        this.complexProduct(re, im);
        return this.reproduct;
    }
    
    /**
     * Changes the complex number z = re + (im)*i.
     * @param re
     * @param im 
     */
    public void changeComplex(double re, double im){
        this.re = re;
        this.im = im;
        this.original = "z = " + re + " + " + im + "i";
    }
    
    /**
     * Changes the complex number z into the 
     * power complex number.
     */
    public void changeComplexPower(){
        this.changeComplex(this.rep, this.imp);
        this.original = "z = " + this.rep + " + " + this.imp + "i";
    }
    
    /**
     * Changes the complex number z into the 
     * root complex number.
     */
    public void changeComplexRoot(){
        this.changeComplex(this.rer, this.imr);
        this.original = "z = " + this.rer + " + " + this.imr + "i";
    }
    
    /**
     * Changes the complex number z into the
     * addition complex number z + u.
     */
    public void changeComplexAdd(){
        this.changeComplex(this.readd, this.imadd);
        this.original = "z = " + this.readd + " + " + this.imadd + "i";
    }
    
    /**
     * Changes the complex number z into the 
     * subtraction complex number z - u.
     */
    public void changeComplexSubtract(){
        this.changeComplex(this.resubtract, this.imsubtract);
        this.original = "z = " + this.resubtract + " + " + this.imsubtract + "i";
    }
    
    /**
     * Changes the complex number z into the
     * product complex number z * u.
     */
    public void changeComplexProduct(){
        this.changeComplex(this.reproduct, this.improduct);
        this.original = "z = " + this.reproduct + " + " + this.improduct + "i";
    }
    
    /**
     * Changes the complex number z into the
     * originally declared complex number.
     */
    public void changeComplexOriginal(){
        this.changeComplex(this.reorg, this.imorg);
        this.original = "z = " + this.reorg + " + " + this.imorg + "i";
    }

}