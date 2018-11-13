package cn.hkxj.platform.service.wechat;

import cn.hkxj.platform.interceptor.WechatOpenIdInterceptor;
import cn.hkxj.platform.service.wechat.handler.messageHandler.*;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author JR Chan
 * @date 2018/6/11 17:19
 * 所有handle的路由规则都在这个service里配置
 */
@Service
public class HandlerRouteService {
	@Resource
	private WxMpMessageRouter router;

	@Resource
    CourseMessageHandler courseMessageHandler;

	@Resource
	private OpenIdHandler openIdHandler;

	@Resource
	private GradeMessageHandler gradeMessageHandler;

	@Resource
	private EmptyRoomHandler emptyRoomHandler;

	@Resource
	private WechatOpenIdInterceptor wechatOpenIdInterceptor;


	public void handlerRegister() {
		router
				.rule()
					.async(false)
					.interceptor(wechatOpenIdInterceptor)
					.handler(openIdHandler)
				.end()
				.rule()
					.content("课表")
					.handler(courseMessageHandler)
				.end()
				.rule()
					.content("成绩")
					.handler(gradeMessageHandler)
				.end()
//			.rule()
//			.async(false)
//				.content("课表")
//				.interceptor(wechatOpenIdInterceptor)
//				.handler(lessonMessageHandler)
//			.end()
				.rule()
				.async(false)
				.interceptor(wechatOpenIdInterceptor)
				.content("成绩")
				.handler(gradeMessageHandler)
				.end()
			.rule()
				.async(false)
//				.interceptor(wechatOpenIdInterceptor)
				.rContent("空教室.*?")
				.handler(emptyRoomHandler)
			.end();
//			.rule()
//				.async(false)
//				.interceptor(wechatOpenIdInterceptor)
//				.handler(openIdHandler)
//			.end();

	}
}
