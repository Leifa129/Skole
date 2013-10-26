<%@ include file="/WEB-INF/pageheader.jsp"%>

<title>Registrering</title>
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
          <a class="navbar-brand" href="index.html">YatzyApp</a>
        </div>
        <div class="collapse navbar-collapse">
        	<ul class="nav navbar-nav">
				<li>&nbsp;&nbsp;</li>
            	<li><a href="meny">Meny</a></li>
            	<li><a href="#">Ranking</a></li>
            	<li><a href="login">Logg inn</a></li>
            </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
  
  <div class="container">
    <div  class="row">
      <div class="col-md-12 col-md-offset-0">
        <div class="text-center alert alert-danger">
          Ugyldig input. Brukernavn eller epost kan allerede være i bruk.
        </div>
      </div>
    </div>
    
    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center">
            <h2>Registrering</h2>
            <p>Både brukernavn og passord må bestå av minst fire tegn og kun bokstaver og/eller tall.</p><br>
        </div>
    </div>

    <div  class="row">
        <div class="col-md-4 col-md-offset-4 text-center">
        
            <!-- USIKKER PÅ OM DETTE VIRKER. MÅ MULIGENS ENDRES FOR Å VIRKE MED SERVLETEN! -->
            <form action="registrering" method="post">
            	<div class="form-group">
                    <input type="text" class="form-control" name="brukernavn" placeholder="Brukernavn">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="navn" placeholder="Fullt navn">
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" name="epost" placeholder="Gyldig e-post">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="passord" placeholder="Passord">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block">Registrer</button>
                </div>
            </form>
        </div>
    </div>
      
  </div>

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3.0.0/js/bootstrap.min.js"></script>
</body>
</html>