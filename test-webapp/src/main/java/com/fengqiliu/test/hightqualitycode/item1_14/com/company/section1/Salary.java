package com.fengqiliu.test.hightqualitycode.item1_14.com.company.section1;

import java.io.Serializable;

public class Salary implements Serializable {
    private static final long serialVersionUID = 44663L;
    //基本工资
    private int basePay;
    //绩效工资
    private int bonus;

    public Salary(int _basePay, int _bonus) {
        basePay = _basePay;
        bonus = _bonus;
    }

    public int getBasePay() {
        return basePay;
    }

    public void setBasePay(int basePay) {
        this.basePay = basePay;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
