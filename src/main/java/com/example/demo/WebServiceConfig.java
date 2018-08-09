package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs /**Enable SOAP Web Service features in this Spring Boot application.*/
@EnableAutoConfiguration
@Configuration /**This class contains Apring configuration.*/
public class WebServiceConfig {

    /**
     * - We would want to create message dispatcher servlet to act as a front controller
     * @param context
     * @return
     */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {

        MessageDispatcherServlet msgDispatcherServlet = new MessageDispatcherServlet();

        msgDispatcherServlet.setApplicationContext(context);

        msgDispatcherServlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(msgDispatcherServlet,"/ws/*");/** Configure the URL to the web services.*/

    }


    @Bean(name = "students") /** A spring bean. The name of the bean is the name of the wsdl in the URL. */
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("StudentPort");
        definition.setTargetNamespace("SPWS.com/students"); /**  - Default name space */
        definition.setLocationUri("/ws"); /**  - The url where we want to expose the wsdl at. */

        /**
         * We would create WSDL based on the xsd defined here - new SimpleXsdSchema(new ClassPathResource("student-details.xsd"))
         */
        definition.setSchema(studentSchema);

        return definition;
    }

    /**
     * A defined schema
     * @return xsd
     */
    @Bean
    public XsdSchema studentSchema(){
        return new SimpleXsdSchema(new ClassPathResource("student-details.xsd"));
    }

}
