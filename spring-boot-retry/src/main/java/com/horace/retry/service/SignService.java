package com.horace.retry.service;

import com.horace.retry.exception.HelloException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-17 22:52
 */
@Slf4j
@Service
public class SignService {

    private RestTemplate restTemplate = new RestTemplate();
    private int count = 0;

    @Async
    @Retryable(value = {HelloException.class, ResourceAccessException.class}, //写父类能抓住子类异常，子类抓不住父类
            maxAttempts = 50,//本方法最大运行次数，含第一次错误
            backoff = @Backoff(value = 2000)) //重试间隔
    public void signContract() throws InterruptedException {
        count++;
        log.info("这是第" + count + "次运行方法,");
        //todo  加入日志追踪（TxId）后，貌似自定义的异步线程池没起作用，使用默认的线程池，因为日志是signContract方法 当前线程是 SimpleAsyncTaskExecutor-1
        // todo  而加入之前是signContract方法 当前线程是 async-t-1
        log.info("signContract方法 当前线程是 " + Thread.currentThread().getName());
        Thread.sleep(5000);
        this.restTemplate.setErrorHandler(responseErrorHandler(new HelloException()));
        String url = "http://localhost:8000/hello";
        try {
            String hello = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            log.error("请求失败，url {}", url, e);
            throw e;
        }
    }

    private ResponseErrorHandler responseErrorHandler(HelloException helloException) {
        return new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ||
                        response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                String body = IOUtils.toString(response.getBody(), StandardCharsets.UTF_8);
                log.error("请求{}失败，异常信息 {}", helloException.getClass().getSimpleName(), body);
                try {
                    helloException.setStatus(response.getStatusCode().value());
                    helloException.setMessage(body);
                    helloException.setServerSide(response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
                    helloException.setRetryAble(response.getStatusCode().series() != HttpStatus.Series.CLIENT_ERROR);
                    throw helloException;
                } catch (Exception e) {
                    helloException.setStatus(response.getStatusCode().value());
                    helloException.setMessage(body);
                    throw helloException;
                }
            }
        };
    }

    @Recover //监听本类中@Retryable抛出的所有符合入参的异常，符合就跑，跑了一次其他的Recover就不会跑，空参或RuntimeException表示监听所有异常，
    public void error(HttpServerErrorException e) {
        log.info("重试失败后执行的方法，如日志");
    }

    @Recover //监听本类中@Retryable抛出的所有符合入参的异常，符合就跑，跑了一次其他的Recover就不会跑，空参或RuntimeException表示监听所有异常，
    public void error(HelloException e) { //如果被上面抓住了，这个没印象
        log.info("重试失败");
    }
}
