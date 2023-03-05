package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping(value="getSample")
	//produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE	}
	//produces= {"application/json;charset=UTF-8","application/xml;charset=UTF-8" } 
	//하나만 쓰면 한개만 됨/그래서 두개 쓰면 생략한거와 쓰는것과 동일 
	public SampleVO getSample() {
		return new SampleVO(123,"홍","길동"); //@RestController 로 쓰면, 컨버트 변환이 필요한데, 여기에서 라이브러리 필요함
	}
	
	@GetMapping("getList")
	public List<SampleVO> getList(){
		List<SampleVO> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			SampleVO vo = new SampleVO(i,"홍"+i,"길동"+i);
			list.add(vo);
		}		
		return list;		
	}
	
	//check?num=3                     //params은 특정키값이 존재하게 제한
	@GetMapping(value="check", params= {"num","num1"})   //상태코드 변경하면서 데이터 보내고 싶을때
	//여기 자체적으로 params로 지정해주면, 아래에 not null일때를 안써도 됨!! 왜냐면 무조건 존재한다는 의미를 갖고 있어서!!
	public ResponseEntity<SampleVO> check(Integer num){
		
		SampleVO vo = new SampleVO(1,"홍","길동");
		ResponseEntity<SampleVO> result=null;
		
		if(num!=null) {
			if(num>10)
				result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(vo);  //404
			else
				result = ResponseEntity.status(HttpStatus.OK).body(vo);   //200
		}
		return result;
	}
	
	//check2/num/4
	@GetMapping("check/{type}/{num}")
	public String check2(@PathVariable("type") String aaa, @PathVariable("num") int bbb) {
		return aaa+"  "+bbb;
	}
	
	@GetMapping("all/{num1}/{num2}")
	public String sum(@PathVariable int num1,@PathVariable int num2) {
		int sum=0;
		for( ; num1<=num2;num1++)
			sum += num1;
		
		return sum+"";		
	}
	
	/*	//YARC 홈페이지에서 post를 주소를 찍어서 테스트 가능한곳! 
	 *  //여기서는 꼭 보내는 타입이랑 text타입이 같아야해서 일반 String라서 plain으로 해줘야함
	 *  //여기서는 정확하게 보내는거랑 text타입이 정확하게 매칭이 되어야 테스트가 됨
	@PostMapping(value="getSample", produces="text/plain;charset=UTF-8")
	public String gogo() {
		return "gogo";
	}
	*/
	
	//클라이언트에서(자바스크립트로) 서버로 sampleVO 형태의 json 타입으로 테이터를 보낼때...
	//{"mno":123,"firstName":"홍","lastName":"길동"}
	//playload 에 위에 json형식의 값을 실어서 보내면(저기에 적으면) 테스트 됨!
	@PostMapping(value="getSample", produces="text/plain;charset=UTF-8")
	public String gogo(@RequestBody SampleVO vo) {    //@RequestBody 어노테이션 안하면 객체의 파라미터 보낸거고, 어노테이션해야 바디에 실어서 보내는거다
		log.info("수집된 값: "+vo);
		return "gogo";
	}
	
	
	
	
	
	
	
	
}
