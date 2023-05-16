<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
	<title>Bee Info</title>
	
	<link href="<c:url value="dist/css/default/zebra_datepicker.min.css" />" rel="stylesheet" type="text/css">
    
</head>
    <script src="<c:url value="https://code.jquery.com/jquery-3.5.0.min.js" />"></script>
	<script src="<c:url value="dist/zebra_datepicker.min.js" />"></script>
    <script src="<c:url value="examples/examples.js" />"></script>
<body>
<p style="text-align: center;">&nbsp;</p>

<form action="http://localhost:8888/demo/saveBee" method="post">
<p>&nbsp;</p>

<table align="center" bgcolor="#FFCA33" border="0" cellpadding="10" cellspacing="1" style="height:200px;width:500px;">
	<tbody>
		<tr>
			<td>
			<table align="center" border="0" cellspacing="1" style="height:80px;width:500px;">
				<tbody>
					<tr>
						<td style="text-align: center;">
						<p><strong><span style="font-size:26px;"><span style="color: rgb(139, 69, 19); text-align: center;">Enter Bee Deatils</span></span></strong></p>

						<hr color="#8B4513" size="4" width="100%" /></td>
					</tr>
				</tbody>
			</table>

			<table align="center" border="0" cellpadding="5" cellspacing="0" style="width: 150px;">
				<tbody>
					<tr>
						<td colspan="2" style="text-align: center;">&nbsp;<span style="color:#008000;"><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><c:out value="${saveResponseMsg}"></c:out></strong></span></td>
					</tr>
					<tr>
						<td><span style="font-size:16px;"><strong style="text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Name:</span></strong></span></td>
						<td><input name="beeName" type="text" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Email:</span></strong></td>
						<td><input name="email" type="text" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Mobile:</span></strong></td>
						<td><input name="mobileNo" type="text" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Salary:</span></strong></td>
						<td><input name="salary" type="text" /></td>
					</tr>
					<tr>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">DOJ:</span></strong></td>
						<td><input id="datepicker" type="text" name="doj" class="form-control" data-zdp_readonly_element="true"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><input name="submit" type="submit" value="Submit" /></td>
					</tr>
					<!-- <tr>
						<td>Name:</td>
						<td><input name="beeName" type="text" /></td>
						<td>Email</td>
						<td><input type="text" name="email"/></td>
						<td>Moible</td>
						<td><input type="text" name="mobileNo"/></td>
						<td>Salary</td>
						<td><input type="text" name="salary"/></td>
						<td><input name="submit" type="submit" value="submit" /></td>
					</tr> -->
				</tbody>
			</table>

			<table align="center" border="0" cellpadding="10" cellspacing="1" style="width:500px;">
				<tbody>
					<tr>
						<td><span style="font-size:11px;"><span style="font-family:verdana,geneva,sans-serif;">&nbsp;<a href="exportPDF">Export PDF file </a></span></span></td>
					</tr>
					<tr>
						<td><span style="font-family:verdana,geneva,sans-serif;">&nbsp;<span style="font-size:12px;"><a href="result">Fetch Bees </a></span></span></td>
					</tr>
					<tr>
						<td><span style="font-family:verdana,geneva,sans-serif;">&nbsp;<span style="font-size:12px;"><a href="importBees">Import Bees </a></span></span></td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
	</tbody>
</table>

<p>&nbsp;</p>
</form>

<p>&nbsp;</p>
