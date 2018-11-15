/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.querydto;

/**
 *
 * @author user
 */
public class CalculateIncomeQueryDTO {
    private double income;

    public CalculateIncomeQueryDTO() {
    }

    public CalculateIncomeQueryDTO(double income) {
        this.income = income;
    }

    /**
     * @return the income
     */
    public double getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "CalculateIncomeQueryDTO{" + "income=" + income + '}';
    }
    
    
    
    
    
}
