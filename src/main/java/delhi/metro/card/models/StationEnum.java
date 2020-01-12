package delhi.metro.card.models;

public enum StationEnum {
    S1(0),
    S2(1),
    S3(2),
    S4(3),
    S5(4),
    S6(5),
    S7(6),
    S8(7),
    S9(8),
    S10(9);

    private int value;

    private StationEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public int getDistance(StationEnum destination){
        return Math.abs(destination.ordinal()-this.ordinal());
    }
}
