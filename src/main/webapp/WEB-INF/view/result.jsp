<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html>
<head>
	<title>Bee Info</title>
	<link href="<c:url value="dist/css/default/zebra_datepicker.min.css" />" rel="stylesheet" type="text/css">
	
	<script src="<c:url value="https://code.jquery.com/jquery-3.5.0.min.js" />"></script>
	<script src="<c:url value="dist/zebra_datepicker.min.js" />"></script>
    <script src="<c:url value="examples/examples.js" />"></script>
	
	<script type="text/javascript">
		function GetSelectedTextValue(beeObj, form) {
        	var selectedText = beeObj.options[beeObj.selectedIndex].innerHTML;
	        var selectedValue = beeObj.value;
	        //alert("Selected Text: " + selectedText + " Value: " + selectedValue);
	         form.action = "http://localhost:8888/demo/fetchBeeById?id="+selectedValue;
	         //alert("test1"+ form.action);
	         form.method="POST";
	         form.submit();
		}
		
		function searchMe(submitObj, form) {
	        var txtValue = submitObj.value;
	        alert("text Value: " + txtValue);
	         form.action = "http://localhost:8888/demo/fetchBeeById?id="+selectedValue;
	         alert("test1"+ form.action);
	         form.method="POST";
	         form.submit();
		}
		
		function fetchAllBees() {
	  		//alert("fetchAllBees()");
	        // Creating Our XMLHttpRequest object 
	        var xhr = new XMLHttpRequest();
	  
	        // Making our connection  
	        var url = 'http://localhost:8888/demo/fetchAllBees';
	        xhr.open("GET", url, true);
	  
	        // function execute after request is successful 
	        xhr.onreadystatechange = function () {
	            if (this.readyState == 4 && this.status == 200) {
	                document.getElementById("ddlFruits").innerHTML = this.responseText;
	                console.log(this.responseText);
	                //alert("responseText "+this.responseText);
	            }
	        }
	        // Sending our request 
	        xhr.send();
	    }
	    
	    function editBee(){
	    	document.getElementById('id').disabled = false;
	    	document.getElementById('beeName').disabled = false;
	    	alert("editBee() "+document.getElementById('beeName').disabled);
	    	document.getElementById('email').disabled = false;
	    	document.getElementById('mobileNo').disabled = false;
	    	document.getElementById('salary').disabled = false;
	    	document.getElementById('datepicker').disabled = false;
	    	//document.getElementById('edit').innerHTML = "Update Bee";
	    	
	    	document.getElementById("update").disabled = false;
	    	document.getElementById("delete").disabled = false;
    		document.getElementById("edit").disabled = true;
	    }
	    
	    function updateBee(form) {
		    alert("update Bee");
		    document.getElementById("update").disabled = true;
		    //document.getElementById("edit").disabled = false;
		    
	         form.action = "http://localhost:8888/demo/updateBee";
	         alert("form.action "+ form.action + "doj"+ document.getElementById('datepicker').value);
	         form.method="POST";
	         form.submit();
		}
		
		function deleteBee(form) {
		    alert("delete Bee");
		    document.getElementById("delete").disabled = true;
		    //document.getElementById("edit").disabled = false;
		    
	         form.action = "http://localhost:8888/demo/deleteBee";
	         alert("form.action "+ form.action);
	         form.method="POST";
	         form.submit();
		}
	</script>
</head>
<body onLoad='fetchAllBees()'>
<p style="text-align: center;">&nbsp;</p>

<form action="http://localhost:8888/demo/fetchBeeById">
<p>&nbsp;</p>
        
<table align="center" bgcolor="#FFCA33" border="0" cellpadding="10" cellspacing="1" style="height:200px;width:500px;">
	<tbody>
		<tr>
			<td>
			<table align="center" border="0" cellspacing="1" style="height: 80px; width: 500px;">
				<tbody>
					<tr>
						<td style="text-align: center;">
						<p><strong><span style="font-size:26px;"><span style="color: rgb(139, 69, 19); text-align: center;">Bee Search</span></span></strong></p>
						<hr color="#8B4513" size="4" width="100%" />
						</td>
					</tr>
				</tbody>
			</table>

			<table align="center" border="0" cellpadding="10" cellspacing="0" style="width:500px;">
				<tbody>
					<tr>
						<td style="text-align: center;"><span style="font-size:16px;"><strong style="text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Select Bee:&nbsp;</span></strong></span>
						<select id="ddlFruits" onchange="GetSelectedTextValue(ddlFruits, this.form)">
					    	<option value="">Select</option>
							<c:forEach var="bees" items="${beeList}">
						    	<option value="${bees.id}"><c:out value="${bees.beeName}" /></option>
						    </c:forEach>
						</select>
						<!--<input name="id" type="text" />
						<input name="submitObj" type="submit" value="Search" />-->
						
						</td>
					</tr>
					<tr>
						<td style="text-align: center;">
						<span style="color:#008000;"><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><c:out value="${updateResponseMsg}" /></strong></span>
						<span style="color:#FF0000;"><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><c:out value="${deleteResponseMsg}" /></strong></span></td>
					</tr>
					<%--<tr>
						<td>
						<c:if test="${beeInfo == null}">
							<strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Bee data not found!</span></strong>
						</c:if>
						</td>
					</tr> --%>
				</tbody>
			</table>

			<table align="left" border="0" cellpadding="5" cellspacing="1" style="width:500px;">
				<tbody>
					<%--<tr>
						<%--<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Select Bee Name</span></strong>:&nbsp;
						<select name="beeId" id="${bees.beeName}">
						<c:forEach var="bees" items="${beeList}">
							<option name="${bees.id}" value="${bees.beeName}"><c:out value="${bees.beeName}" /></option>
						</c:forEach>
						</select></td> 
						
						<td>
							<select id="ddlFruits" onchange="GetSelectedTextValue(ddlFruits, this.form)">
						    	<option value="">Select</option>
								<c:forEach var="bees" items="${beeList}">
							    	<option value="${bees.id}"><c:out value="${bees.beeName}" /></option>
							    </c:forEach>
							</select>
						</td>
					</tr>
					--%>
					<tr>
						<td>
						<c:if test="${beeInfo != null}">
						<strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Welcome&nbsp;<c:out value="${beeInfo.beeName}"/>!</span></strong>
						</c:if>
						</td>
					</tr>
				</tbody>
			</table>
			
			<c:if test="${beeInfo != null}">
			<table border="0" align="center" cellpadding="5" cellspacing="1" style="width: 301px;">
				<tbody>
					<tr>
						<td><span style="font-size:18px;"><u><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">DETAILS:</span></strong></u></span></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">&nbsp;&nbsp;Id</span></strong></td>
						<td><input disabled="disabled" id="id" name="id" type="text" value="${beeInfo.id}" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">&nbsp;&nbsp;Name</span></strong></td>
						<td><input disabled="disabled" id="beeName" name="beeName" type="text" value="${beeInfo.beeName}" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">&nbsp;&nbsp;Email</span></strong></td>
						<td><input disabled="disabled" id="email" name="email" type="text" value="${beeInfo.email}" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">&nbsp;&nbsp;Mobile</span></strong></td>
						<td><input disabled="disabled" id="mobileNo" name="mobileNo" type="text" value="${beeInfo.mobileNo}" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">&nbsp;&nbsp;Salary</span></strong></td>
						<td><input disabled="disabled" id="salary" name="salary" type="text" value="${beeInfo.salary}" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">&nbsp;&nbsp;DOJ</span></strong></td>
						<td>
							<!-- <input id="datepicker" type="text" name="doj" class="form-control" data-zdp_readonly_element="true"> -->
							<input disabled="disabled" id="datepicker" name="doj" class="form-control" data-zdp_readonly_element="true" type="text" value="${beeInfo.doj}" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">&nbsp;&nbsp;Leaves</span></strong></td>
						<td><input disabled="disabled" id="leaves" name="leaves" type="text" value="${1}" /></td>
					</tr>
					<tr>
						<td><span style="font-family:verdana,geneva,sans-serif;"><span style="font-size:12px;"><a href="exportBeePayroll?id=${beeInfo.id}">Download Payroll</a></span></span></td>
						<td>&nbsp;</td>
					</tr>
					
					<!--<tr>
						<td><span style="font-family:verdana,geneva,sans-serif;"><span style="font-size:12px;"><a href="http://localhost:8888/demo/deleteBee?id=${beeInfo.id}">Delete Bee</a></span></span></td>
						<td>span style="font-family:verdana,geneva,sans-serif;"><span style="font-size:12px;"><a href="" onclick="editBee()">Edit Bee</a></span></span</td>
					</tr>-->
					
					<tr>
						<td><input id = "delete" name="delete" type="button" value="Delete Bee" onClick="deleteBee(this.form)" disabled/></td>
						<td><!--button id = "edit" name="edit" onClick="editBee()">Edit Bee</button-->
						<input id = "edit" name="edit" type="button" value="Edit Bee" onClick="editBee()"/>&nbsp;
						<input id = "update" name="update" type="button" value="Update Bee" onClick="updateBee(this.form)" disabled/>
						</td>
					</tr>
				</tbody>
			</table>
			</c:if>
			</td>
		</tr>
		<tr>
			<td>
			<p><span style="font-family:verdana,geneva,sans-serif;"><span style="font-size:12px;"><a href="login">Previous page</a></span></span></p>
			</td>
		</tr>
	</tbody>
</table>
</form>

</body>
</html>
