package com.real.demo.designpatterns.sevenprinciples;

/**
 * @ClassName SinglePrinciple
 * @Description: 设计模式基本原则 1 单一原则
 * @Author Smile
 * @Date 2021/5/13
 * @Version V1.0
 **/
public class SinglePrinciple {
    public static void main(String[] args) {


        RoadVehicle vehicle = new RoadVehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");


    }

    //交通工具
    //
    static class Vehicle {
        public void run(String vehicle) {
            System.out.println(vehicle + "在公路上跑");
        }
    }

    //优化1
    static class RoadVehicle {
        public void run(String vehicle) {
            System.out.println(vehicle + "在公路上跑");
        }
    }

    //优化1
    static class AirVehicle {
        public void run(String vehicle) {
            System.out.println(vehicle + "在公路上跑");
        }
    }

    //优化2
    static class Vehicle2 {
        public void run(String vehicle) {
            System.out.println(vehicle + "在公路上跑");
        }

        public void runAir(String vehicle) {
            System.out.println(vehicle + "在飞机上跑");
        }

        public void runWater(String vehicle) {
            System.out.println(vehicle + "在水上跑");
        }
    }


}
