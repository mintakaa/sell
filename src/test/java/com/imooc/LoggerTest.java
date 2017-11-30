package com.imooc;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {
    private final Logger log = LoggerFactory.getLogger(LoggerTest.class);
    public void test1(){
        log.info("info...");
        log.debug("debug...");
        log.error("error...");
    }
}
