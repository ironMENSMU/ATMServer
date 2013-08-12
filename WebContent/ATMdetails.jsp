<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>

<%
	String command = request.getParameter("msg");
	String id = request.getParameter("id");

	HashMap map = (HashMap) session.getAttribute(command);
	ArrayList<String> array = (ArrayList) map.get(id);

	String location = array.get(0);
	String num_of_10s = array.get(1);
	String num_of_50s = array.get(2);
	String server_status = array.get(3);
	String location_url = array.get(4);
	String location_lat = array.get(5);
	String location_lon = array.get(6);

	double locationLat = Double.parseDouble(location_lat);
	double locationLon = Double.parseDouble(location_lon);
%>

<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
</script>

<script>
function initialize()
{
	
	var myLatlng = new google.maps.LatLng(<%=locationLat%>,<%=locationLon%>);
	
var mapProp = {
  center:myLatlng,
  zoom:18,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };
var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

var marker = new google.maps.Marker({
    position: myLatlng,
    map: map
    
});

}

google.maps.event.addDomListener(window, 'load', initialize);
</script>

<%--validate the input--%>
<script>
	function update_input_validation(theForm) {

		if(isNaN(theForm.num_of_10s.value)||isNaN(theForm.num_of_50s.value)){
			alert("Please input valid number");
			return false;
		}
		
		return true;
	}
</script>


<form method="post" action="ATMUpdateServlet?id=<%=id%>"
	name="ATM_detailed_information"
	onsubmit="return update_input_validation(this)">
	<table border="1">
		<tr>
			<td>Location</td>
			<td>Detailed Information</td>
		</tr>
		<tr>
			<td><div id="googleMap" style="width: 500px; height: 380px;"></div></td>

			<td>
				<table>
					<tr>
						<td>ID:</td>
						<td><input type="text" name="id" value=<%=id%> readonly></td>
					</tr>
					<tr>
						<td>Server Status:</td>
						<td><input type="text" name="server" value=<%=server_status%>
							readonly></td>
					</tr>
					<tr>
						<td>Balance Status:</td>
						<%-- This part need to add the business rules to decide balance status --%>
						<td><input type="text" name="balance_status" value="unknown"
							readonly></td>
					</tr>
					<tr>
						<td>Number of $10 note:</td>
						<td><input type="text" name="num_of_10s"
							value=<%=num_of_10s%>></td>

					</tr>
					<tr>
						<td>Number of $50 note:</td>
						<td><input type="text" name="num_of_50s"
							value=<%=num_of_50s%>></td>

					</tr>
					<tr>
						<td conspan="2"><input type="submit" name="update"
							value="update"> <input type="submit" name="delete"
							value="delete">
						<td>
					</tr>

				</table>

			</td>
		</tr>
	</table>


</form>