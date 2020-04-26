<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <#-- <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
<div class="container" id="wrapper">
   <img alt='pattot' src="/images/phparrot.gif">
    <#list items as item>
        <div class="item-card">
            <div class="item-header">
                <h3 class="item-name">${item.name}</a></h3>
                <span class="item-url">${item.image_url}</span>
                <span class="item-info">${item.brand}</span>
            </div>
            <div class="item-description">${item.description}</div>
        </div>
    </#list>
    <div id="blog" onclick="LoadNews()">
        <img alt='parrot' src="/images/sherlockholmesparrot.gif">
    </div>
    
</div>
<script>
    $('#blog').scroll(function () {
        LoadNews()
    });

    function LoadNews() {
        /*let itemSelect = $('#future');*/
        $.getJSON("/items/all", function () {
            itemSelect.empty();
            $.each(function (i) {
                $('.container').append('<div class="item-card">' + i + this + '</div>');
            });
        })
    }

    $(document).ready(function () {
        LoadNews();
    });

</script>