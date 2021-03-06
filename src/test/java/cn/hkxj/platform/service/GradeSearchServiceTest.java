package cn.hkxj.platform.service;

import cn.hkxj.platform.pojo.GradeAndCourse;
import cn.hkxj.platform.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author junrong.chen
 * @date 2018/9/22
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeSearchServiceTest {
	@Resource(name = "gradeSearchService")
	private GradeSearchService gradeSearchService;
	@Autowired
	private WxMpService wxMpService;

	@Test
	public void getAccess_token() throws WxErrorException {
		String accessToken = wxMpService.getAccessToken();
		System.out.println(accessToken);
	}

    @Test
    public void getCurrentTermGrade() {
        Student student = new Student();
        student.setAccount(2016023726);
        student.setPassword("1");
        long start = System.currentTimeMillis();
        List<GradeAndCourse> currentTermGrade = gradeSearchService.getGradeFromSpiderAsync(student);
        long end = System.currentTimeMillis();
        long costtime = end - start;
        System.out.println(CollectionUtils.isEmpty(currentTermGrade));
        for (GradeAndCourse gradeAndCourse : currentTermGrade) {

            log.info(gradeAndCourse.toString());
        }

    }
}