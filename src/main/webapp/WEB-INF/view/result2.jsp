<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<body>
	<table>
	<form action="http://localhost:8888/demo/fetchBeeById" method="get">
			<tr>
			<td><h1>Bee Search</h1></td>
			</tr>
			
			<tr><td>
				<%-- Welcome!  <c:out value="${beeList}"></c:out> --%>
				<c:if test="${beeInfo != null}">  
				   <p>Welcome! <c:out value="${beeInfo.beeName}"/><p>  
				</c:if>  
			</td></tr>
			<br>
			<br>
			<tr><td>
        	Select the Bee: <select name="beeId" id="${bees.beeName}"
				<c:forEach var="bees" items="${beeList}">
			            class="target">
			                <option name="${bees.id}" value="${bees.beeName}"><c:out value="${bees.beeName}" /></option>
				</c:forEach>
	        </select>
			</td></tr>
			<br>
			<br>
			<br>
			<tr><td>
				 <input type="text" name="id" />
				  <input type="submit" name="submit"/>
			</td></tr>
		
		<br>
		<c:if test="${beeInfo != null}">
		<table border=0>
			<tr><td>
				<u><h3>Details</h3></u>
			</td>
			<td></td>
			</tr>
			
			<%-- <c:out value="${beeInfo}"></c:out> --%>
			<tr><td>
				&nbsp;&nbsp;&nbsp;Id </td><td>:&nbsp;<c:out value="${beeInfo.id}"></c:out>
			</td></tr>
			<tr><td>
				&nbsp;&nbsp;&nbsp;Name </td><td>:&nbsp;<c:out value="${beeInfo.beeName}"></c:out>
			</td></tr>
			<tr><td>
				&nbsp;&nbsp;&nbsp;Email </td><td>:&nbsp;<c:out value="${beeInfo.email}"></c:out>
			</td></tr>
			<tr><td>
				&nbsp;&nbsp;&nbsp;Mobile </td><td>:&nbsp;<c:out value="${beeInfo.mobileNo}"></c:out>
			</td></tr>
			<tr><td>
				&nbsp;&nbsp;&nbsp;Salary </td><td>:&nbsp;<c:out value="${beeInfo.salary}"></c:out>
			</td></tr>
		<tr>
			<td>
				&nbsp;&nbsp;&nbsp;<a href="http://localhost:8888/demo/exportBeePayroll?id=${beeInfo.id}" class="btn btn-primary"><font face="Aparajita"color="#581845">Download Payroll</font></a>
			</td>
		</tr>
			</table>
		</c:if>
		<br>
		<br>
		<tr><td>
			Click on this <strong><a href="/demo/index.html">link</a></strong> to visit previous page. 
		</td></tr>
		</form>
	</table>
</body>
</html>

<script>
function onSelectDdown(){
alert("test");
}
</script>
