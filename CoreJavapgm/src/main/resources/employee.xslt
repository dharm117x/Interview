<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" />
	<xsl:template match="/">
		<html>
			<head>
			</head>
			<body>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Name</th>
						<th>Email</th>
						<th>DOB</th>
					</tr>
					<xsl:for-each select="employees/employee">
						<tr>
							<td><xsl:value-of select="name" /></td>
							<td><xsl:value-of select="email" /></td>
							<td><xsl:value-of select="dob" /></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>
