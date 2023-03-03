package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
//@Controller
@Log4j
@RequestMapping("sample")
public class SampleController {

//	@GetMapping("getText")
	@GetMapping(value="getText",produces="text/plain; charset=UTF-8")
	public String getText() {
		return "안녕하세요 hello";
	}
	
	@GetMapping(value="getSample",produces= {"application/json;charset=UTF-8","application/xml;charset=UTF-8" })
	public SampleVO getSample() {
		return new SampleVO(123,"홍","길동"); //@RestController 로 쓰면, 컨버트 변환이 필요한데, 여기에서 라이브러리 필요함
	}
}
