package delhi.metro.card.factory;

import delhi.metro.card.strategy.FareCalculationStrategy;
import delhi.metro.card.strategy.impl.WeekDayStrategy;
import delhi.metro.card.strategy.impl.WeekEndStrategy;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class FareCalculationFactory {

    public static FareCalculationStrategy getStrategy(LocalDateTime time){
        if(time.getDayOfWeek().equals(DayOfWeek.SATURDAY) || time.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            return new WeekEndStrategy();
        }
        else{
            return new WeekDayStrategy();
        }
    }
}
