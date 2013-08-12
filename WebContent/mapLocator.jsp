<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Map Locator</title>
<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
	
</script>
</head>

<%
HashMap map = (HashMap)session.getAttribute("atm_details");


Set<String> keys = map.keySet();
ArrayList<ArrayList<String>> allArrays = new ArrayList<ArrayList<String>>();
Iterator<String> iterator = keys.iterator();

while(iterator.hasNext()){
	String key = iterator.next();
	ArrayList<String> array = (ArrayList<String>)map.get(key);
	array.add(key);
	allArrays.add(array);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Map Locator</title>
<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
	
</script>
</head>

<body>
	<div id="map" style="width: 1000px; height: 1000px;"></div>

	<script type="text/javascript">
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 13,
			center : new google.maps.LatLng(1.317557, 103.829620),
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});

		var infowindow = new google.maps.InfoWindow();

		var marker;
	<%
	for(int i=0; i< allArrays.size();i++){
		ArrayList<String> array = allArrays.get(i);
		String location = array.get(0);
		String numOf10s= array.get(1);
		String numOf50s= array.get(2);
		String serverStatus = array.get(3);
		double lati = Double.parseDouble(array.get(5));
		double lont = Double.parseDouble(array.get(6));
		String id = array.get(7);
		
%>
		marker = new google.maps.Marker({
			position : new google.maps.LatLng(
	<%=lati%>
		,
	<%=lont%>
		),
			map : map
		});

		var content = "ID: " +
	<%=id%>
		+ "<br />" + "Location: "
				+
	<%=location%>
		+ "<br />" + "Num Of 10s: " +
	<%=numOf10s%>
		+ "<br />" + "Num Of 50s: " +
	<%=numOf50s%>;
		
		
		google.maps.event.addListener(marker, 'click', (function(marker, i) {
			return function() {
				infowindow.setContent(content);
				infowindow.open(map, marker);
			}
		})(marker,
	<%=i%>
		));
	<%}%>
		
	</script>
</body>
</html>


