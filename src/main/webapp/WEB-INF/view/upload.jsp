<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
   <meta charset="ISO-8859-1">
      <title>File Upload Page</title>
   </head>
<p style="text-align: center;">&nbsp;</p>

<form action="uploadFile" enctype="multipart/form-data" method="POST">
<p>&nbsp;</p>

<table align="center" bgcolor="#FFCA33" border="0" cellpadding="10" cellspacing="1" style="height:200px;width:500px;">
	<tbody>
		<tr>
			<td>
			<table align="center" border="0" cellspacing="1" style="height: 80px; width: 500px;">
				<tbody>
					<tr>
						<td style="text-align: center;">
						<p><strong><span style="font-size:26px;"><span style="color: rgb(139, 69, 19); text-align: center;">Import Bees</span></span></strong></p>

						<hr color="#8B4513" size="4" width="100%" /></td>
					</tr>
				</tbody>
			</table>
			

			<table align="center" border="0" cellpadding="10" cellspacing="0" style="width:500px;">
				<tbody>
					<tr>
						<td><span style="font-size:16px;"><strong style="text-align: left; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Please select a file to upload : <input name="file" type="file" value="Browse File" /></span></strong></span></td>
					</tr>
					<tr>
						<td><span style="font-size:16px;"><strong style="text-align: left; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Press here to upload the file : <input type="submit" value="upload" /></span></strong></span></td>
					</tr>
					<tr>
						<td><span style="color:#008000;"><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><c:out value="${message}"></c:out></strong></span></td>
					</tr>
					<tr>
						<td><span style="font-size:16px;"><strong style="text-align: left; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Do you want to save excel data into database ? <a href="saveData"><b>Yes</b></a> &nbsp; &nbsp; <a href="resetBees"><b>No</b></a> </span></strong></span></td>
					</tr>
					<tr>
						<td><span style="color:#008000;"><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><c:if test="${noOfRecords != null}"> <b> Total ${noOfRecords} records uploaded! </b> </c:if></strong></span></td>
					</tr>
				</tbody>
			</table>
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
