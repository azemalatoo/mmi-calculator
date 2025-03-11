package org.example.bmicalculator;

/**
 * BMIModel class encapsulates the logic for calculating BMI and determining BMI status.
 * It provides methods for BMI calculation based on metric or English units,
 * and for categorizing the BMI value into different status groups.
 */
public class BMIModel {

    /**
     * Calculates the Body Mass Index (BMI) based on weight and height.
     *
     * @param weight   The weight of the person.
     * @param height   The height of the person.
     * @param isMetric True if using metric units (kg, cm), false for English units (lbs, inches).
     * @return The calculated BMI value.
     */
    public double calculateBMI(double weight, double height, boolean isMetric) {
        double bmi;
        if (isMetric) {
            // Metric calculation: BMI = weight (kg) / (height (m))^2
            // Height is converted from cm to m by dividing by 100.
            bmi = weight / Math.pow(height / 100.0, 2);
        } else {
            // English calculation: BMI = (weight (lbs) / (height (in))^2) * 703
            bmi = (weight / Math.pow(height, 2)) * 703;
        }
        return bmi;
    }

    /**
     * Determines the BMI status category based on the calculated BMI value.
     *
     * @param bmi The calculated BMI value.
     * @return The BMI status category as a String (Underweight, Normal, Overweight, Obese).
     */
    public String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}