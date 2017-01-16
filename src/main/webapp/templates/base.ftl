<#macro page_body>
</#macro>

<#macro extra_files>
</#macro>

<#macro dispaly_page>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Game of Thrones</title>
    <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/bootstrap/jquery-1.12.4.min.js"></script>
    <script src="../js/bootstrap/bootstrap.min.js"></script>
    <@extra_files/>
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li class="<#if activeStart??>active</#if>" role="presentation"><a class="navbar-link" href="/">Startseite</a></li>
                <li class="<#if activeStaffel??>active</#if>" role="presentation"><a class="navbar-link" href="/staffel">Staffeln</a></li>
                <li class="<#if activeHaus??>active</#if>" role="presentation"><a class="navbar-link" href="/haus">Häuser</a></li>
                <li class="<#if activeRelation??>active</#if>" role="presentation"><a class="navbar-link" href="/relation">Relationen der Personen</a></li>
            </ul>
            <#if loginKennung??>
                <a type="button" class="btn btn-default navbar-btn navbar-right" href="/logout">Abmelden</a>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="navbar-link" href="/benutzer?loginKennung=${loginKennung}"><span class="glyphicon glyphicon-user"></span> ${loginKennung}</a>
                    </li>
                </ul>
            <#else>
            <form class="navbar-form navbar-right" action="/login" method="post">
                <div class="form-group">
                    <input type="email" class="form-control" name="loginkennung" placeholder="Email/Login Kennung">
                    <input type="password" class="form-control" name="passwort" placeholder="Passwort">
                    <button type="submit" class="btn btn-primary">Anmelden</button>
                </div>
                <div class="form-group">
                    <a type="button" class="btn btn-default navbar-btn navbar-right" role="button" href="/registerieren">Registrieren</a>
                </div>
            </form>
            </#if>
        </div>
    </nav>
    <@page_body/>
    <footer class="footer">
    <div class="container">
        <h5>Ankündigung</h5>

        <p class="text-muted">Die Resourcen z.B. Bilde sind aus folgenden Webseiten heruntergeladen.</p>
        <ul>
            <li><a href="https://de.wikipedia.org/wiki/Game_of_Thrones">de.wikipedia.org</a></li>
            <li><a href="http://gameofthrones.wikia.com/wiki/Game_of_Thrones_Wiki">gameofthrones.wikia.com</a></li>
            <li><a href="http://de.gameofthrones.wikia.com/wiki/Game_of_Thrones_Wiki">de.gameofthrones.wikia.com</a></li>
        </ul>
        <p class="text-muted">
            Sie dienen nur zur akademischen Studie. Falls es Problem mit Copyright hätte,
            bitte teilen Sie <a href="mailto:halloweltyan@gmail.com?">mir</a> mit,
            dann lösche ich sie sofort. Vielen Dank!
        </p>

    </div>
    </footer>
</body>
</html>
</#macro>