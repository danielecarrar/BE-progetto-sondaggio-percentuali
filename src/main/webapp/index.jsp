<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="style/stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sondaggio MOLTO semplice</title>
    </head>
    <body>
    
        <h1 class ="neon">Sondaggio!</h1>
  
<h2>Ti piace rispondere ai sondaggi?</h2>

        <form action="index.jsp" method="get">
            <input type="radio" name="voto" value="si"/>SI<br/>
            <input type="radio" name="voto" value="no"/>NO<br/>
            <input type="radio" name="voto" value="both"/>ENTRAMBI<br/>
        <!-- <marquee
  loop="-1"
  scrollamount="100"
  scrolldelay="100"
  direction="right"
  height="30"
  width="200"
  align="right">
            <input type="radio" name="voto" value="six"/>100 SI<br/>
            </marquee><br/>
            <marquee
  loop="-1"
  scrollamount="10"
  scrolldelay="50"
  direction="left"
  height="50"
  width="200"
  align="left">
            <input type="radio" name="voto" value="nox"/>100 NO<br/>
             </marquee><br/> --> 
           <hr> <input type="radio" name="voto" value="reset"/>AZZERA<br/><hr>
            <input type="submit" value="Invia"/>            
        </form>
     
        <img src="grafico?voto=<%=request.getParameter("voto")%>" />
    </body>
</html>