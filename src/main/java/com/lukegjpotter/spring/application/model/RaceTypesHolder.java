package com.lukegjpotter.spring.application.model;

public class RaceTypesHolder {

    private boolean isAPlus, isA1, isA2, isA3, isA4, isVets, isWoman, isJunior, isYouth;
    
    /** Empty Constructor. */
    public RaceTypesHolder() {
        setAPlus(false);
        setA1(false);
        setA2(false);
        setA3(false);
        setA4(false);
        setVets(false);
        setWoman(false);
        setJunior(false);
        setYouth(false);
    }

    public boolean isAPlus() {
        return isAPlus;
    }

    public void setAPlus(boolean isAPlus) {
        this.isAPlus = isAPlus;
    }

    public boolean isA1() {
        return isA1;
    }

    public void setA1(boolean isA1) {
        this.isA1 = isA1;
    }

    public boolean isA2() {
        return isA2;
    }

    public void setA2(boolean isA2) {
        this.isA2 = isA2;
    }

    public boolean isA3() {
        return isA3;
    }

    public void setA3(boolean isA3) {
        this.isA3 = isA3;
    }

    public boolean isA4() {
        return isA4;
    }

    public void setA4(boolean isA4) {
        this.isA4 = isA4;
    }

    public boolean isVets() {
        return isVets;
    }

    public void setVets(boolean isVets) {
        this.isVets = isVets;
    }

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean isWoman) {
        this.isWoman = isWoman;
    }

    public boolean isJunior() {
        return isJunior;
    }

    public void setJunior(boolean isJunior) {
        this.isJunior = isJunior;
    }

    public boolean isYouth() {
        return isYouth;
    }

    public void setYouth(boolean isYouth) {
        this.isYouth = isYouth;
    }
    
    @Override public boolean equals(Object obj) {

        if (obj instanceof RaceTypesHolder) {
            RaceTypesHolder other = (RaceTypesHolder) obj;

            return this.isAPlus() == other.isAPlus()
                    && this.isA1() == other.isA1()
                    && this.isA2() == other.isA2()
                    && this.isA3() == other.isA3()
                    && this.isA4() == other.isA4()
                    && this.isVets() == other.isVets()
                    && this.isWoman() == other.isWoman()
                    && this.isJunior() == other.isJunior()
                    && this.isYouth() == other.isYouth();
        }

        return false;
    }
    
}
