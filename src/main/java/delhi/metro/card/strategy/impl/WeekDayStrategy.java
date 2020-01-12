package delhi.metro.card.strategy.impl;

import delhi.metro.card.strategy.FareCalculationStrategy;

public class WeekDayStrategy implements FareCalculationStrategy {

    @Override
    public double getFare() {
        return 7;
    }
}
