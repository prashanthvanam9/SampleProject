<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
	<title>Bee Info</title>
</head>
<body>
<p style="text-align: center;">&nbsp;</p>

<form action="http://localhost:8888/demo/saveBee" method="post">
<p>&nbsp;</p>

<table align="center" bgcolor="#FFCA33" border="0" cellpadding="10" cellspacing="1" style="height:200px;width:500px;">
	<tbody>
		<tr>
			<td>
			<table align="center" border="0" cellspacing="1" style="height: 80px; width: 1040px;">
				<tbody>
					<tr>
						<td style="text-align: center;">
						<p><strong><span style="font-size:26px;"><span style="color: rgb(139, 69, 19); text-align: center;">Enter Bee Deatils</span></span></strong></p>

						<hr color="#8B4513" size="4" width="100%" /></td>
					</tr>
				</tbody>
			</table>

			<table align="center" border="0" cellpadding="5" cellspacing="0" style="width:500px;">
				<tbody>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td colspan="3" rowspan="1" style="text-align: center;"><span style="color:#008000;"><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><c:out value="${saveResponseMsg}" /></strong></span></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><span style="font-size:16px;"><strong style="text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Name:</span></strong></span></td>
						<td><input name="beeName" type="text" /></td>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Email:</span></strong></td>
						<td><input name="email" type="text" /></td>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Mobile:</span></strong></td>
						<td><input name="mobileNo" type="text" /></td>
						<td><strong style="font-size: 16px; text-align: center; background-color: rgb(255, 202, 51);"><span style="color: rgb(139, 69, 19);">Salary:</span></strong></td>
						<td><input name="salary" type="text" /></td>
						<td><input name="submit" type="submit" value="Submit" /></td>
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

			<table align="center" border="0" cellpadding="10" cellspacing="1" style="width: 1040px;">
				<tbody>
					<tr>
						<td><span style="font-size:11px;"><span style="font-family:verdana,geneva,sans-serif;">&nbsp;<a href="http://localhost:8888/demo/exportPDF">Export PDF file </a></span></span></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><span style="font-family:verdana,geneva,sans-serif;">&nbsp;<span style="font-size:12px;"><a href="http://localhost:8888/demo/result">Fetch Bees </a></span></span></td>
						<td>&nbsp;</td>
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
</body>
</html>
