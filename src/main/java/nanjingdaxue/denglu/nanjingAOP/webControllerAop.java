package nanjingdaxue.denglu.nanjingAOP;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class webControllerAop {
    //创建Log4j日志，每个方法调用，都要通过这个日志记录
    protected  static final Logger logger = Logger.getLogger(webControllerAop.class);
    @Pointcut("execution(* nanjingdaxue.denglu.controller..*.*(..))")
    public void webLog(){

    };
    //前置增强，用户每次调用都需要获取用户调用方法。
     @Before("webLog()")
    public void before(JoinPoint joinPoint)throws Throwable{
            ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                     HttpServletRequest request =attributes.getRequest();
                    logger.info("############请求开始##########");
                    logger.info("URL==========>"+request.getRequestURI().toString());
                    logger.info("METHOD（请求方式）============>"+request.getMethod());
                    logger.info("获取请求方ip地址:"+request.getRemoteAddr());
         Enumeration<String> enumeration = request.getParameterNames();
                       while (enumeration.hasMoreElements()){
                            String name=(String)enumeration.nextElement();
                            String value=request.getParameter(name);
                          logger.info("name:{"+name+"}"+"value:{"+value+"}");
                        }
     }
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("############请求结束##########");
        if(null!=ret)
            logger.info("response===" + ret.toString());
    }
}
