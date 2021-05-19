package com.real.demo.designpatterns.sevenprinciples;

/**
 * @ClassName InterfaceSegregationPrinciple
 * @Description: 设计模式基本原则  2 接口隔离原则
 * @Author Smile
 * @Date 2021/5/13
 * @Version V1.0
 **/
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {

    }

    interface Interface1 {
        void operation1();

        void operation2();

        void operation3();

        void operation4();
    }

    static class B implements Interface1 {

        @Override
        public void operation1() {
            System.out.println("operation1");
        }

        @Override
        public void operation2() {
            System.out.println("operation2");
        }

        @Override
        public void operation3() {
            System.out.println("operation3");
        }

        @Override
        public void operation4() {
            System.out.println("operation4");
        }
    }

    static class A implements Interface1 {

        @Override
        public void operation1() {
            System.out.println("operation1");
        }

        @Override
        public void operation2() {
            System.out.println("operation2");
        }

        @Override
        public void operation3() {
            System.out.println("operation3");
        }

        @Override
        public void operation4() {
            System.out.println("operation4");
        }
    }

    //下列进行优化

}
