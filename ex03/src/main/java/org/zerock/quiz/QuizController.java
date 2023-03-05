package org.zerock.quiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping
public class QuizController {
	
	@GetMapping(value="cal/{cal}/{num1}/{num2}", produces="text/plain;" ) 
	public String addsub(@PathVariable("cal") String cal,@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
//		String result=null;
//		if(cal.equals("add")) {
//			result=num1+num2+"";
//		}else {
//			result=num1-num2+"";
//		}					
//		return result;	
		
		
//		int sum=0;
//		if(cal.equals("add")) {
//			sum=num1+num2;
//		}else {
//			sum=num1-num2;
//		}					
//		return sum;		
		
		return cal.equals("add") ? num1+num2+"" : num1-num2+"";		
	}
	
	//restcontroller 보내는 메소드 타입이 String과 객체 이렇게 두개뿐!! ->데이터를 보내는거기 때문에 텍스트로 보내야해 그중에서 json과 xml 타입이 있는것
	//그래서 int는 객체로 자동 변환되서 간다!
	//json과 xml 로 텍스트를 어떻게 보내서 받을지 하는것
	

}
