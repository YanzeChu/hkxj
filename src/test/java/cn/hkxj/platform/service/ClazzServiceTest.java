package cn.hkxj.platform.service;

import cn.hkxj.platform.PlatformApplication;
import cn.hkxj.platform.spider.model.UrpStudentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @author Yuki
 * @date 2019/2/26 16:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlatformApplication.class)
@WebAppConfiguration
@TestPropertySource(value = "classpath:application-prod.properties")
public class ClazzServiceTest {

    @Autowired
    private ClazzService clazzService;

    @Test
    public void parseSpiderResult() {
        UrpStudentInfo urpStudentInfo = new UrpStudentInfo();
        urpStudentInfo.setClassname("采矿16-1班");
        urpStudentInfo.setAcademy("11");
        urpStudentInfo.setAccount(2016024170);
        System.out.println(clazzService.parseSpiderResult(urpStudentInfo));;
    }
}