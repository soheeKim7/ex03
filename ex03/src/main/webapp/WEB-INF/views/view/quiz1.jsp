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
<span></span>


<script 
		src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
		
<script>
	$("button").on("click",function(){		
		
		$.ajax({
			type : "get" ,
			url : "/quiz/quiz1" ,   
			success : function(data){     
				console.log("받아온 데이터 : ",data)
				$("span").prepend(data);
			}		
		});			
	});




</script>



</body>
</html>