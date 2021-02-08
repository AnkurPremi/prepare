package DataStructures.interviewPractice.OOODesign;

public class DesignParkingLot {
}

/**
 * What kind of parking lot is it? out side mall or office ? office
 *  what kind of vehicles it accommodates ? S, M, L
 *  Levels ? multiLevel
 *  any special accommodation for disabled ? no
 *  DB involved ? no
 *  vehicle details ? License plate and color
 *
 **/

class ParkingLot{

}


class Slot{
    SlotSize slotSize;
    int floor;
    int number;

    Slot(SlotSize slotSize, int floor, int number){
        this.floor = floor;
    }
}

enum SlotSize{
    S, M, L;
}

class Vehicle{
    Color color;
    String licensePlate;

    Vehicle(Color color, String licensePlate){
        this.color = color;
        this.licensePlate = licensePlate;
    }
}

enum Color{
    BLACK, BLUE, GREEN;
}