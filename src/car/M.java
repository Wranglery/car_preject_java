package car;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class M {

    static Scanner scanner;
    static Database database;


    public static void main(String[] args) {

        database = new Database();

        scanner = new Scanner(System.in);

        String choose;


        System.out.println("输入1进入cms模块，输入2进入客户端:");

        int enter = scanner.nextInt();


        switch (enter) {

            case 1://进入cms模块

                System.out.println("输入1查询车辆信息，输入2插入车辆信息，输入3删除车辆信息，输入4修改车辆信息:");

                int enter_1 = scanner.nextInt();

                switch (enter_1) {

                    case 1://查询并显示车辆信息
                        System.out.println("输入1查询所有车辆信息，输入2查询所有小车信息，输入3查询所有客车信息");
                        int SelectCarData = scanner.nextInt();
                        switch (SelectCarData) {
                            case 1:
                                database.select();
                                break;
                            case 2:
                               MotoVehicle.Obvious(new Mcar());//向上转型，通过父类自动选择相对应的类的方法，执行子类重写的方法
                                break;
                            case 3:
                                MotoVehicle.Obvious(new Bus());
                                break;
                        }
                        System.out.println("数据查询成功");
                        break;

                    case 2://插入车辆信息
                        insert();
                        break;

                    case 3://删除车辆信息
                        System.out.println("输入你要删除车辆信息的车牌号:");
                        choose = scanner.next();
                        database.delete(choose, "Num");
                        break;

                    case 4://修改车辆信息
                        System.out.println("输入车牌号选定要修改信息的车辆:");
                        choose = scanner.next();
                        database.select(choose,"Num");
                        System.out.println("输入要修改的信息的所在列名(车型、车牌、颜色、品牌、座位数、型号、里程、租金)");
                        String change = scanner.next();
                        System.out.println("输入要修改信息的内容");
                        String get_content = scanner.next();
                        database.change(get_content,change,choose);

                        break;


                }

                break;

            case 2://进入客户端模式

                Map<String, Integer> getMap = new HashMap<>();


                database.select();


                while (true) {

                    System.out.println("输入心仪的车牌号进行车辆选择:");

                    choose = scanner.next();

                    database.select(choose, "Num");
                    String getType = database.getType();//获得车的类型

                    System.out.println("输入租借天数:");
                    int date_count = scanner.nextInt();

                    getMap.put(getType, date_count);

                    System.out.println("输入1继续选择车辆，输入2结束车辆的选择:");
                    int over = scanner.nextInt();

                    if (over == 2) {
                        break;
                    }

                }


                new Client().CalcRent(getMap);

                break;


        }

    }


    //    插入车辆信息的方法
    public static void insert() {
        System.out.println("输入车辆类型(小车、客车):");
        String gCarType = scanner.next();

        System.out.println("输入车辆车牌(6位字符串):");
        String gNum = scanner.next();

        System.out.println("输入车辆颜色:");
        String gColor = scanner.next();

        System.out.println("输入车辆品牌:");
        String gBrand = scanner.next();

        System.out.println("输入车辆座位数:");
        int gSeacount = Integer.parseInt(scanner.next());

        System.out.println("输入车辆型号:");
        String gType = scanner.next();

        System.out.println("输入车辆里程(km):");
        int gMeleage = Integer.parseInt(scanner.next());

        System.out.println("输入车辆租金:");
        int gRent = scanner.nextInt();

        if (gCarType.equals("小车")) {
            Mcar mcar = new Mcar(gCarType, gNum, gColor, gBrand, gSeacount, gType, gMeleage, gRent);
            System.out.println("数据插入成功");
        } else if (gCarType.equals("客车")) {
            Bus bus = new Bus(gCarType, gNum, gColor, gBrand, gSeacount, gType, gMeleage, gRent);
            System.out.println("数据插入成功");
        }

    }

}

