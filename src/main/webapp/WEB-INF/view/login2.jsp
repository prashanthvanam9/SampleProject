<!DOCTYPE html>
<html>

<head>
	<title>Export PDF File</title>
</head>

<body class="container">

	<table border=0 cellpadding=0 cellspacing=0 align = "center" bgcolor="#FFCA33">
		<form action="http://localhost:8888/demo/saveBee" method="post">
			<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td border=0 cellpadding=0 cellspacing=0>
					<font color="#581845" face="Aparajita" size="6"><b>&nbsp;&nbsp;&nbsp;&nbsp;Enter Bee Details</b></font>
					<hr color="#8B4513" size="4" width="100%" /></td>
				</td>
			</tr>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td><font face="Congenial" color="#581845">&nbsp;&nbsp;&nbsp;Name: <input type="text" name="beeName"/></font></td>
				<td><font face="Congenial" color="#581845">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email: <input type="text" name="email"/></font></td>
				<td><font face="Congenial" color="#581845">Mobile: <input type="text" name="mobileNo"/></font></td>
				<td><font face="Congenial" color="#581845">Salary: <input type="text" name="salary"/></font></td>
				<td cellspacing=10 align=" center">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</form>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td>
				
				&nbsp;&nbsp;&nbsp;<a href="http://localhost:8888/demo/exportPDF" class="btn btn-primary"><font face="Aparajita"color="#581845">Export PDF file</font></a>
			</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		<tr>
			<td>
				&nbsp;&nbsp;&nbsp;<font face="Aparajita"color="#581845"><a href="http://localhost:8888/demo/fetchAllBees" class="btn btn-primary">Fetch Bees </a></font>
			</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
	</table>
</body>

</html>