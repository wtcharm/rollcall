package com.xfqb.rollcall.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xfqb.rollcall.entity.IpFilter;
import com.xfqb.rollcall.mapper.IpFilterMapper;
import com.xfqb.rollcall.utils.IPUtils;

import lombok.extern.slf4j.Slf4j;
/**
 * 进行ip地址的过滤处理数据
 * @ClassName:  IpInterceptor     
 * @author: tao wang
 * @date:   2019年4月29日   
 *
 */
@Slf4j
public class IpInterceptor implements HandlerInterceptor {

	@Autowired
	private IpFilterMapper ipFilterMapper;
	
	private IpFilter ipFilter;

	/**
	 * 请求处理后拦截,(页面渲染前)，处理通过返回true，否则返回false
	 * @param req
	 * @param resp
	 * @param obj
	 * @param exc
	 * @throws Exception
	 * @author: tao wang
	 * @date:   2019年4月29日
	 */
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object obj, Exception exc)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 请求处理后拦截,(页面渲染前)，处理通过返回true，否则返回false
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws Exception
	 * @author: tao wang
	 * @date:   2019年4月29日
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 请求处理前拦截，处理通过返回true，否则返回false不进行处理
	 * @param request 响应数据
	 * @param response 返回数据
	 * @param obj 参数
	 * @return
	 * @throws Exception 异常处理
	 * @author: tao wang
	 * @date:   2019年4月29日
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		//过滤ip,若用户在白名单内，则放行
		String ipAddress=IPUtils.getRealIP(request);
		log.info("USER IP ADDRESS IS => " + ipAddress);
		if(!StringUtils.isNotBlank(ipAddress))
			return false;
		ipFilter=new IpFilter();
		ipFilter.setModule("sino-bankflow");//模块
		ipFilter.setIp(ipAddress);//ip地址
		ipFilter.setMark(0);//白名单
		ipFilter.setDr(0);//未删除的
		List<IpFilter> ips = ipFilterMapper.select(ipFilter);
		if(ips.isEmpty()){
			//返回错误标识
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JSONObject res = new JSONObject();
            res.put("status","-1");
            res.put("msg","need login");
            PrintWriter out = null ;
            out = response.getWriter();
            out.write(res.toString());
            out.flush();
            out.close();
			return false;
		}
		return true;
	}

}
