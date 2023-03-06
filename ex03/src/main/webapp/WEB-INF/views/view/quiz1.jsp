<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<button>나를 눌러봐</button> <br>
<span></span> <br>
<div></div>


<script 
		src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
		
<script>
	$("button").on("click",function(){		
		
		$.ajax({
			type : "get" ,
			url : "/quiz/quiz1" ,   //응답! Hi>,<
			//data : 보내는거 없음
			//dataType : "text" ,     // 받아오는 데이터 생략 가능
			//contentType : 보내는거 없음
			success : function(data){     
				console.log("받아온 데이터 : ",data)
				$("span").prepend(data);
				$("div").text(data);
				
			}		
		});			
	});




</script>



</body>
</html>