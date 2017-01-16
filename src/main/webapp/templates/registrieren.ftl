<#include "base.ftl">
<#macro page_body>
<div class="container col-sm-offset-2 col-sm-8">
    <form class="form-horizontal" role="form" action="/registerSubmit" method="post">
        <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">Email address</label>
            <div class="col-sm-8">
                <input type="email" class="form-control" id="inputEmail" name="newLoginkennung" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="inputPassword" name="newPasswort" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="inputName" name="newName" placeholder="Name">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-8">
                <button type="submit" class="btn btn-default">Bestätigen</button>
            </div>
        </div>
    </form>
</div>
</#macro>
<@dispaly_page/>
