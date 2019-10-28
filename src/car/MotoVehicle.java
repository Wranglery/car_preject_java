package car;

public abstract class MotoVehicle {

    //    车牌号，品牌，颜色，里程
    private String No, Brand, Color;
    private int Mileage;

    MotoVehicle(){};

    MotoVehicle(String nNo, String nBrand, String nColor, int nMileage) {

    }

//    显示车辆信息
    abstract void CarObvious();

//    显示车辆信息
    public static void Obvious(MotoVehicle motoVehicle){
            motoVehicle.CarObvious();
    }

    public abstract Void Calrent(int day);

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }
}
