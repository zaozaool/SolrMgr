<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Test</title>
</head>
<body>
	<form action="/SolrMgr/api/query" method="post">
		<table>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="Query" /></td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td>Page NO.<input name="pageNo" value="1" /></td>
					<td>Page Size<input name="pageSize" value="10" /></td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>paramList[0]。Logic<input name="param.paramList[0].paramList[0].logic" value="AND" /></td>
					<td>paramList[0]。Key<input name="param.paramList[0].paramList[0].key" value="SEARCH_TEXT" /></td>
					<td>paramList[0]。Value<input name="param.paramList[0].paramList[0].value" value="11" /></td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>paramList[1]。Logic<input name="param.paramList[0].paramList[1].logic" value="AND" /></td>
					<td>paramList[1]。Key<input name="param.paramList[0].paramList[1].key" value="SEARCH_TEXT" /></td>
					<td>paramList[1]。Value<input name="param.paramList[0].paramList[1].value" value="回族" /></td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>paramList[0]。Logic<input name="param.paramList[1].paramList[0].logic" value="AND" /></td>
					<td>paramList[0]。Key<input name="param.paramList[1].paramList[0].key" value="SEARCH_TEXT" /></td>
					<td>paramList[0]。Value<input name="param.paramList[1].paramList[0].value" value="11" /></td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>paramList[1]。Logic<input name="param.paramList[1].paramList[1].logic" value="AND" /></td>
					<td>paramList[1]。Key<input name="param.paramList[1].paramList[1].key" value="SEARCH_TEXT" /></td>
					<td>paramList[1]。Value<input name="param.paramList[1].paramList[1].value" value="回族" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>