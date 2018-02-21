package start.aspect;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;

@ControllerAdvice
public class AppResponseAdvice<T> implements ResponseBodyAdvice<T> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType ) {
        return Arrays.stream(returnType.getMethodAnnotations())
                .anyMatch(annotation -> annotation.annotationType().equals(AppResponse.class));
    }

    @Override
    public T beforeBodyWrite(T body,
                             MethodParameter returnType,
                             MediaType selectedContentType,
                             Class<? extends HttpMessageConverter<?>> selectedConverterType,
                             ServerHttpRequest request,
                             ServerHttpResponse response) {
        System.out.println("AppResponseAdvice - beforeBodyWrite");
        return body;
    }
}
