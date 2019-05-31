package com.xfqb.rollcall.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class FilterController {

	@RequestMapping("url/test")
	@ResponseBody
	public String URLtest(HttpServletRequest req) {
		String addr = req.getRemoteAddr();
		System.out.println("addr" + addr);
		return "success";
	}

}
