package car;


/*
* 客户类:
*
*        2、实现租金计算功能(多种类和多辆数计算),用一个集合存放客户选好的车辆和数量，
*           从数据库中查找出相对应的租金，进行计算
*
*
*
* */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Client {

    Map<String, Integer> map;
    Database database;
    String mapCarType[];
    int mapDate[];
    int rentMoney[];
    int allMoney;

    Client() {
        map = new HashMap<>();
        database = new Database();
    }

    /*
     计算车辆的租金,形参是一个map集合,放置车型和租借天数
     通过车型(Type)从数据库中匹配出对应的租金，再与租借天数进行运算

     */
    public void CalcRent(Map<String, Integer> getMap) {

        mapCarType = new String[getMap.size()];//存放Map中的key值，也就是车型
        mapDate = new int[getMap.size()];//存放租借天数
        rentMoney = new int[getMap.size()];

        Set<String> set = getMap.keySet();
        Iterator<String> iterator = set.iterator();

        //获得所有车型和租车天数，存放到数组中,并且通过车型查询出对应的租金
        for (int i = 0; i < mapCarType.length; i++) {
            mapCarType[i] = iterator.next();
            mapDate[i] = getMap.get(mapCarType[i]);

            database.select(mapCarType[i], "Type");
            rentMoney[i] = database.getRentCarMonet();

            allMoney += rentMoney[i] * mapDate[i];
        }

        System.out.println(allMoney);


    }


}
