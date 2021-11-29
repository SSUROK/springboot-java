package ru.gb.springbootjava.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.gb.springbootjava.entity.Product;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductCreatorAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields){
            ProductCreator annotation = field.getAnnotation(ProductCreator.class);
            if (annotation != null) {
                List<Product> list = new ArrayList<>();
                for (int i = 0; i < 5; i++){
                    list.add(new Product(i, "Product #" + String.valueOf(i), (int) (Math.random() * 1000)));
                }
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, list);
            }
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields){
            ProductCreator annotation = field.getAnnotation(ProductCreator.class);
            if (annotation != null) {

            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}