<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="number" id="num1"> +
	<input type="number" id="num2"> =
	<input type="number" id="sum">	<br>
	<button id="button1">계산</button>
	
	<hr>
	
	<input type="number" id="mno">  <br>
	<input type="text" id="firstName"> <br>
	<input type="text" id="lastName"> <br>
	<button id="button2">json 처리 확인</button> <br>
	<span >home</span>
	
	<script 
		src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
		
	<script>
		$("#button1").on("click", function() {
			var num1 = $("#num1").val();
			var num2 = $("#num2").val();

			$.ajax({
				type : "get",
				url : "/sample/all/" + num1 + "/" + num2,
				success : function(data) {
					//값을 보내고 결과받아온 값! 
					console.log("받아온 값 : ", data);
					$("#sum").val(data);
				}
			})
		});
		
		
		$("#button2").on("click",function(){		
			var obj={};   //객체
			obj.mno=$("#mno").val();
			obj.firstName=$("#firstName").val();
			obj.lastName=$("#lastName").val();
			console.log("자바스크림트로 만든 객체 : ",obj);  //obj 자바스크립트 객체
			var jsondata=JSON.stringify(obj);  //obj 자바스크림트 객체를 json포맷으로 변경
			console.log("json 포맷 : ",jsondata);
			//$("span").prepend("되는건가?");
			
			$.ajax({
				type : "post" ,
				url : "/sample/getSample" ,      //꼭 절대경로로! /붙이기 // .json 넣으면 응답을 json으로 함!
				data : jsondata ,                //보내는 데이터!(요청 데이터)
				contentType :"application/json; charset=UTF-8" ,  //보내는 데이터 형식 (전송 데이터,요청데이터)
				dataType : "json" , //받아오는 데이터 형식 (응답데이터) text, json, xml -생략시는 content type을 보고 자동처리
				//지금 응답을 json으로 하라고 했는데,현재 자동으로 텍스트형식으로 읽었기 때문에 받아올때 오류가 남 
				//그런데 컨트롤러를 String 말고, SampleVO로 받아오면 dataType : "json"적으면 json으로 잘 받아짐 요청헤더 accept에서 json!
				//근데 여기서 dataType : "json" 생략시 accept는 / 이렇게 표기되고 xml로 응답함!
				success : function(data){        //가져오는 데이터! (응답데이터)
					console.log("받아온 데이터 : ",data)
					$("span").prepend(data);
				}		
			
			});			
			
		});
		
		
		
		
	</script>

</body>
</html>