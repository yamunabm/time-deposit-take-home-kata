package org.ikigaidigital.calculator;


import org.ikigaidigital.calculator.impl.BasicPlanCalculator;
import org.ikigaidigital.calculator.impl.PremiumPlanCalculator;
import org.ikigaidigital.calculator.impl.StudentPlanCalculator;
import org.ikigaidigital.model.PlanType;

public class InterestCalculatorFactory {
    public static InterestCalculator getCalculator(PlanType type) {
        return switch (type) {
            case BASIC -> new BasicPlanCalculator();
            case STUDENT -> new StudentPlanCalculator();
            case PREMIUM -> new PremiumPlanCalculator();
        };
    }
}
