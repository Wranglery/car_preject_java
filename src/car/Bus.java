package car;

public class Bus extends MotoVehicle {

    int SeatCount;//载客数量
    Database database;


    Bus() {
        database = new Database();
    }

    public Bus(String nCarType, String nNum, String nColor, String nBrand, int nSeaCount,
               String nType, int nMeleage, int nRentCarMonet) {
        super(nCarType, nNum, nColor, nMeleage);
        database = new Database();

        database.add(nCarType, nNum, nColor, nBrand, nSeaCount, nType, nMeleage, nRentCarMonet);
    }


    //    显示所有客车信息
    @Override
    void CarObvious() {
        System.out.println("以下是所有客车车辆信息");
        database.select("客车", "CarType");
    }

    @Override
    public Void Calrent(int day) {
        return null;
    }

    public int getSeatCount() {
        return SeatCount;
    }

    public void setSeatCount(int seatCount) {
        SeatCount = seatCount;
    }
}
