package start.aspect;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;

@ControllerAdvice
public class AppRequestAdvice<T> implements RequestBodyAdvice {
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage,
                                           MethodParameter methodParameter,
                                           Type type,
                                           Class< ? extends HttpMessageConverter< ? >> aClass) throws IOException {
        System.out.println("AppRequestAdvice - beforeBodyRead");
        return httpInputMessage;
    }

    @Override
    public Object afterBodyRead(Object o,
                                HttpInputMessage httpInputMessage,
                                MethodParameter methodParameter,
                                Type type,
                                Class< ? extends HttpMessageConverter< ? >> aClass) {
        System.out.println("AppRequestAdvice - afterBodyRead");
        return o;
    }

    @Override
    public boolean supports(MethodParameter methodParameter,
                            Type type,
                            Class< ? extends HttpMessageConverter< ? >> aClass) {
        return Arrays.stream(methodParameter.getMethodAnnotations())
                .anyMatch(annotation -> annotation.annotationType().equals(AppRequest.class));
    }

    @Override
    public Object handleEmptyBody(Object o,
                                  HttpInputMessage httpInputMessage,
                                  MethodParameter methodParameter,
                                  Type type, Class< ? extends HttpMessageConverter< ? >> aClass) {
        System.out.println("AppRequestAdvice - handleEmptyBody");
        return o;
    }
}
