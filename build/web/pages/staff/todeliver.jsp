<%@page import="java.util.ArrayList"%>
<%@page import="se.definewild.mediadist.db.UndeliveredData"%>
<%@page import="se.definewild.mediadist.db.Undelivered"%>
<%@page import="java.util.List"%>
<%@page import="se.definewild.mediadist.bean.Helper"%>
<%@page import="se.definewild.mediadist.db.Mediaitems"%><%@page import="se.definewild.mediadist.db.Employees" %>
<%
  if (session.getAttribute("employee") == null) {
    response.sendRedirect("?p=staff/login");
    out.println("<script>document.location=\"?p=staff/login\";</script>");
    return;
  }
  Employees employee = (Employees) session.getAttribute("employee");

  ArrayList addresses = new ArrayList();
  String district_addr = employee.getDistrict().getHeadquarters().getAddress() + " "
          + employee.getDistrict().getHeadquarters().getZipcode() + " "
          + employee.getDistrict().getHeadquarters().getCity();
%>
<div id="todeliver">
    <div class="items">
        <%
          List<UndeliveredData> items = Helper.GetNewMediaItems(employee.getDistrict());
          for (UndeliveredData item : items) {
            addresses.add(item.getAddress().getAddress() + " " + item.getAddress().getZipcode() + " " + item.getAddress().getCity());
        %>
        <div class="item">
            <div class="address">
                <div class="person"><%=item.getSubscription().getSubscriber().getFname()%> <%=item.getSubscription().getSubscriber().getLname()%></div> 
                <div class="street"><%=item.getAddress().getAddress()%></div>
                <div class="city"><%=item.getAddress().getZipcode()%> <%=item.getAddress().getCity()%></div>
            </div>
            <div class="media">
                <div class="name"><%=item.getMediaitem().getMedia().getName()%></div>
                <div class="title"><%=item.getMediaitem().getTitle()%></div>
            </div>
        </div>
        <hr />
        <%
          }
          String addresses_done = "";
          for (int i = 0; i < addresses.size(); i++) {
            if (i > 0)
              addresses_done += ", ";
            addresses_done += "\"" + addresses.get(i) + "\"";
          }
        %>
    </div>
    <div class="map">
        <style type="text/css">
            
        </style>
        <div id="directions-panel"></div>
        <div id="map-canvas">
            <h2>Loading map...</h2>
        </div>

    </div>
</div>


<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAOehHUbrez5vSRMF3s0eMbRyzEY1GZ2i4"></script>
<script type="text/javascript">
    var map;
    var geocoder;
    var directionsDisplay;
    var directionsService;

    var addresses = [<%=addresses_done%>];
    var hq = "<%=district_addr%>";

    var hq_latlng;
    var addri = 0;
    var waypts = new Array();

    function pageInit() {
        geocoder = new google.maps.Geocoder();

        geocoder.geocode({'address': hq}, function (results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                hq_latlng = results[0].geometry.location;
                setTimeout(GetLocations, 250);
            }
        });
    }
    function GetLocations() {
        if (addri >= addresses.length)
            return done();
        var address = addresses[addri];
        geocoder.geocode({'address': address}, function (results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                waypts.push({
                    location: results[0].geometry.location,
                    stopover: true});
                setTimeout(GetLocations, 250);
            }
        });
        addri++;
    }

    function SetUpDirections() {
        var request = {
            origin: hq_latlng,
            destination: hq_latlng,
            waypoints: waypts,
            optimizeWaypoints: true,
            travelMode: google.maps.TravelMode.DRIVING
        };
        directionsService.route(request, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
            }
        });
    }

    function done() {
        var el = document.querySelector("#map-canvas");
        if (waypts.length === 0)
            return el.innerHTML = "<h2>No deliveries</h2>";
        var mapOptions = {
            center: hq_latlng,
            zoom: 16
        };
        directionsService = new google.maps.DirectionsService();
        directionsDisplay = new google.maps.DirectionsRenderer();
        map = new google.maps.Map(el, mapOptions);
        directionsDisplay.setMap(map);
        directionsDisplay.setPanel(document.getElementById('directions-panel'));

        SetUpDirections();
    }

</script>