package com.example.hellospringboot;

import com.example.hellospringboot.HelloSpringbootApplication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //Para que spring sepa que es de tipo AspectJ
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(HelloSpringbootApplication.class);

    //Anotación para indicar que es un pointcut
    //.* todos los métodos de esa clase
    @Pointcut ("within(com.example.hellospringboot..*)")
    public void pointcut(){

        //Qué queremos que suceda cuando encuentre un pointcut

    }
    //Cuándo (intervendrá antes de los puntos de corte)
    @Before("pointcut()")

    //Cómo
    public void logMethod(JoinPoint joinPoint) {
        log.info("Invocando Logging Aspect " + joinPoint.getSignature().getName());

    }
}
