package com.naya.personbd;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class BeanDefinitionsFixerBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        BeanDefinition beanDefinition;
        try {
            beanDefinition = factory.getBeanDefinition(beanName);
        } catch (Exception e) {
            return bean;
        }
        beanDefinition.getBeanClassName();
        return bean;

    }
}
