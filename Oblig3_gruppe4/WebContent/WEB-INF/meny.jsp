<%@ include file="/WEB-INF/pageheader.jsp"%>
<%@ page import="dat104.obl3.models.*" %>
<%@ page import="java.util.*" %>
<%
Bruker bruker = (Bruker) session.getAttribute("bruker");
@SuppressWarnings("unchecked")
List<Spill> aktiveSpill = (List<Spill>)(session.getAttribute("aktiveSpill"));
%>

<title>Meny</title>
</head>
<body>

  <div class="navbar navbar-inverse navbar">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="meny">YatzyApp</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li>&nbsp;&nbsp;</li>
            <li><a href="meny">Meny</a></li>
            <li><a href="#">Ranking</a></li>
            <li><a href="loggut">Logg ut</a></li>
          </ul>
          <p class="navbar-text pull-right"><%=bruker.getNavn()%></p>
        </div><!--/.nav-collapse -->
      </div>
    </div>
  
  <div class="container">
    <br><br>
    
    <div class="row">
      
      <div class="col-md-3">
        <!-- KNAPP FOR NYTT SPILL -->
        <a href="opprettSpill">
          <button class="btn btn-success">
            <span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;Opprett nytt spill
          </button>
        </a>
          
      </div>

      <div class="col-md-3 col-md-offset-6">
        <form class="form-inline" action="VIDERESEND_TIL_RIKTIG_SERVLET" method="post">
            <div class="form-group">
              <input type="text" name="id" class="form-control" placeholder="Spill ID">
            </div>
            <button type="submit" class="btn btn-default">Bli med</button>
        </form>
      </div>

    </div> <!--/ROW-->

    <br>

    <div class="row">
      <div class="col-md-12">        
        <br>
        <table class="table">
          <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Host</th>
            <th class="text-center">Antall påmeldte</th>
            <th></th>
            <th></th>
          </tr>
          <% for(Spill spill : aktiveSpill) { %>
          	<tr>
         	  <td class="text-center"><%=spill.getId()%></td>
          	  <td class="text-center"><%=spill.getHost()%></td>
          	  <td class="text-center"><%=spill.getAntallDeltagere()%>/6</td>
              <td>
                <form class="pull-right" action="VIDERESEND_TIL_RIKTIG_SERVLET" method="post">
                  <input type="hidden" name="id" value="SPILL ID HER">
                  <!-- NESTE LINJE TRENGS IKKE DERSOM VI HAR FORSKJELLIG SERVLET FOR SPILLER OG OBERSERVER -->
                  <input type="hidden" name="userType" value="player">
                  <button type="submit" class="btn btn-success">Bli med</button>
                </form>
              </td>
              <td>
                <form class="pull-left" action="VIDERESEND_TIL_RIKTIG_SERVLET" method="post">
                  <input type="hidden" name="id" value="SPILL ID HER">
                  <!-- NESTE LINJE TRENGS IKKE DERSOM VI HAR FORSKJELLIG SERVLET FOR SPILLER OG OBERSERVER -->
                  <input type="hidden" name="userType" value="observer">
                  <button type="submit" class="btn btn-default">Se på</button>               
                </form>
              </td>
            </tr>
          	<%
          		}
          	%>
          	
        </table>      
      </div> <!--/col-->
    </div>
      
   
    


  </div>

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3.0.0/js/bootstrap.min.js"></script>
</body>
</html>