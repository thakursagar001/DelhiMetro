package delhi.metro.card.strategy.impl;

import delhi.metro.card.strategy.FareCalculationStrategy;

public class WeekEndStrategy implements FareCalculationStrategy{
    @Override
    public double getFare() {
        return 5.5;
    }
}
