<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>

<body>
	<form:form action="processForm" modelAttribute="student">
	
		First name : <form:input path="firstName"/>
		
		<br><br>
		
		Last name : <form:input path="lastName"/>
		
		<br><br>
		
		<form:select path="country">
		
			<form:options items="${theCountryOptions}" />
			
		</form:select>
		
		<br><br>
		
		Favorite Language :
		
		<!-- path는 favoriteLanguage라는 이름으로 값을 바인딩, 또한 path는 student.setFavoriteLanuage()를 호출해서 값을 저장 -->
		<form:radiobuttons path="favoriteLanguage" items="${theLangOptions}" />
		
		<br><br>
		
		Operating Systems :
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Window"/>
		
		
		<br><br>
		
		<input type="submit" value="Submit" />
	
	</form:form>

</body>

</html>