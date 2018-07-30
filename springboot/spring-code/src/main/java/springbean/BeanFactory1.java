package java.springbean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import javax.xml.bind.annotation.XmlAccessOrder;

public class BeanFactory1 {

    DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

    XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("xx.xml"));
}
