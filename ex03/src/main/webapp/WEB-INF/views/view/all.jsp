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
			console.log("자바스크림트로 만든 객체 : ",obj);
			var jsondata=JSON.stringify(obj);
			console.log(jsondata);
			//$("span").prepend("되는건가?");
			
			$.ajax({
				type : "post" ,
				url : "/sample/getSample" ,      //꼭 절대경로로! /붙이기
				data : jsondata ,                //보내는 데이터!
				contentType :"application/json; charset=UTF-8" ,
				success : function(data){        //가져오는 데이터!
					$("span").prepend(data);
				}		
			
			});			
			
		});
		
		
		
		
	</script>

</body>
</html>