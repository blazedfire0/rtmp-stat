package com.rtmp.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @作者 LEIJIE
 * @时间 2019-11-21 14:40
 * @描述 TODO
 */
public class SpringDemo {
    
    /**
     *
     * 功能描述
     * SpringApplication 是springboot启动的引导类，
     * 与Spring上下文，事件，监听器及环境组件关系密切，
     * 其中提供了控制Springboot 应用特征的行为方法
     * 
     * @返回:
     * @作者: LEI JIE
     * @时间: 2019-11-22 10:14
     */
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        //增加监听器
//        context.addApplicationListener(new MyApplicationListener());
        context.register(MyApplicationListener.class);
        //上下文启动
        context.refresh();

        //启动后 发布事件
        context.publishEvent(new MyApplicationEvent("Hello,World"));
    }

    @Component
    public static class MyApplicationListener implements ApplicationListener<MyApplicationEvent>{

        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.printf("MyApplicationListener event:%s \n",event.getSource());
        }
    }

    public static class MyApplicationEvent extends ApplicationEvent {

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }

}
