package car;

public class Mcar extends MotoVehicle {

    Database database;

    Mcar() {
        database = new Database();
    }

    public Mcar(String nCarType, String nNum, String nColor, String nBrand, int nSeaCount,
                String nType, int nMeleage, int nRentCarMonet) {
        super(nCarType, nNum, nColor, nMeleage);

        database = new Database();


        database.add(nCarType, nNum, nColor, nBrand, nSeaCount, nType, nMeleage, nRentCarMonet);
    }


    //    显示所有小车车辆信息
    @Override
    void CarObvious() {
        System.out.println("以下是所有小车车辆信息");
        database.select("小车", "CarType");

    }

    @Override
    public Void Calrent(int day) {
        return null;
    }


}
