package car;

import java.sql.*;

/*
*
* java中的JDBC,实现数据库的增删改查功能
*
*
*
* */
public class Database {

    //JDBC驱动名
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    //数据库URL：这里的tt是数据库名称
    String JDBC_URL = "jdbc:mysql://localhost:3306/car?characterEncoding=utf8&useSSL=false";

    //        数据库的用户名与密码
    String USER = "root";
    String PASS = "admin123";

    //通过DriverManager类获得该连接对象才能访问数据库
    Connection connection = null;

    //        通过Connection获得该结果对象用于执行静态的SQL语句
    Statement statement = null;

    //        查询实例对象
    ResultSet rSet;

    //    数据库表属性列
    String CarType;
    String Num;
    String Color;
    String Brand;
    int SeaCount;
    String Type;
    int Meleage;
    int RentCarMonet;

    public Database() {


//            注册JDBC驱动
        try {
            Class.forName(JDBC_DRIVER);

//            数据库的连接：通过DriverManager类的getConnection方法，传入三个参数：数据库URL、用户名、用户密码，实例化connection对象
            connection = DriverManager.getConnection(JDBC_URL, USER, PASS);

//            实例化statement对象
            statement = (Statement) connection.createStatement();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库未连接");
        }


    }

    //    增------------------------------------------------
    public void add(String nCarType, String nNum, String nColor, String nBrand, int nSeaCount,
                    String nType, int nMeleage, int nRentCarMonet) {

        String add_sql = "insert into car1 values('" + nCarType + "','" + nNum + "','" + nColor + "','" + nBrand + "','" + nSeaCount + "','" + nType + "','" + nMeleage + "','" + nRentCarMonet + "')";


        try {


//            将插入语句放进Statement对象中，进行数据库表的更新
            statement.executeUpdate(add_sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //    删------------------------------------------------
    public void delete(String choose, String name) {


//            展开查询到的数据
        try {
//            定义数据库查询语句：删除car1表中的车牌号所在列数据
            String sql = "DELETE FROM car1 where " + name + "='" + choose + "'";
            statement.execute(sql);
            System.out.println("该车辆信息成功删除");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //    改------------------------------------------------
//    第一个参数是要修改信息的列名,第三个参数是要修改信息的列名(用户看到的名字),第四个参数是车牌号
    public void change(String choose1,String choose,String Num) {
        String sql = null;
        String get = choose;
        switch (get){
            case "车型":
                sql = "update car1 set CarType='"+choose1+"'where Num="+Num;
                break;
            case "车牌号":
                sql = "update car1 set Num='"+choose1+"'where Num="+Num;
                break;
            case "颜色":
                sql = "update car1 set Color='"+choose1+"'where Num="+Num;
                break;
            case "品牌":
                sql = "update car1 set Brand='"+choose1+"'where Num="+Num;
                break;
            case "座位数":
                sql = "update car1 set Seacount='"+choose1+"'where Num="+Num;
                break;
            case "型号":
                sql = "update car1 set Type='"+choose1+"'where Num="+Num;
                break;
            case "里程":
                sql = "update car1 set Meleage='"+choose1+"'where Num="+Num;
                break;
            case "租金":
                sql = "update car1 set RentCarMonet='"+choose1+"'where Num="+Num;
                break;
        }

        try {
            statement.executeUpdate(sql);
            System.out.println("数据修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //    查------------------------------------------------


    //    显示所有车辆信息
    public void select() {


//            展开查询到的数据
        try {
//            定义数据库查询语句：查询car1表中的所有列数据
            String sql = "SELECT * FROM car1";
            rSet = statement.executeQuery(sql);

            while (rSet.next()) {

                //                获得数据库信息,这里getString()方法中的参数对应的是数据库表中的列名
                CarType = rSet.getString("CarType");
                Num = rSet.getString("Num");
                Color = rSet.getString("Color");
                Brand = rSet.getString("Brand");
                SeaCount = rSet.getInt("SeaCount");
                Type = rSet.getString("Type");
                Meleage = rSet.getInt("Meleage");
                RentCarMonet = rSet.getInt("RentCarMonet");

                //                输出数据
                System.out.println("车型:" + getCarType());
                System.out.println("车牌:" + getNum());
                System.out.println("颜色:" + getColor());
                System.out.println("品牌:" + getBrand());
                System.out.println("座位数:" + getSeaCount());
                System.out.println("型号:" + getType());
                System.out.println("里程:" + getMeleage());
                System.out.println("租金:" + getRentCarMonet());
                System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //    通过车牌号或小车种类显示车辆信息
    public void select(String choose, String name) {

//            展开查询到的数据
        try {
//            定义数据库查询语句：查询car1表中的所有列数据
            String sql = "SELECT * FROM car1 where " + name + "='" + choose + "'";
            rSet = statement.executeQuery(sql);


            while (rSet.next()) {

                //                这里getString()方法中的参数对应的是数据库表中的列名
                CarType = rSet.getString("CarType");
                Num = rSet.getString("Num");
                Color = rSet.getString("Color");
                Brand = rSet.getString("Brand");
                SeaCount = rSet.getInt("SeaCount");
                Type = rSet.getString("Type");
                Meleage = rSet.getInt("Meleage");
                RentCarMonet = rSet.getInt("RentCarMonet");

                //                输出数据
                System.out.println("车型:" + getCarType());
                System.out.println("车牌:" + getNum());
                System.out.println("颜色:" + getColor());
                System.out.println("品牌:" + getBrand());
                System.out.println("座位数:" + getSeaCount());
                System.out.println("型号:" + getType());
                System.out.println("里程:" + getMeleage());
                System.out.println("租金:" + getRentCarMonet());
                System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void close() {
        try {
            rSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String carType) {
        CarType = carType;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getSeaCount() {
        return SeaCount;
    }

    public void setSeaCount(int seaCount) {
        SeaCount = seaCount;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getMeleage() {
        return Meleage;
    }

    public void setMeleage(int meleage) {
        Meleage = meleage;
    }

    public int getRentCarMonet() {
        return RentCarMonet;
    }

    public void setRentCarMonet(int rentCarMonet) {
        RentCarMonet = rentCarMonet;
    }


}
