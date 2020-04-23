<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
<div class="container">
    <label>
        <select size="1" id="brand" name="brand" onchange="loadItem()" style="float:left;">
            <#list brands as brand>
                <option value="">All brands</option>
                <optgroup label="Choose brand">
                    <option value="${brand.id}">${brand.name}</option>
                </optgroup>
            </#list>
        </select>
    </label>
    <select name="item" disabled="disabled">
        <option>Choose brand first</option>
    </select>
</div>
<script>
    function loadItem(){
        let itemSelect = $('select[name="item"]');
        // послыаем AJAX запрос, который вернёт список для выбранной области
        $.getJSON('/items', {action: 'listItems', brand_id: $('#brand').val()}, function (itemList) {
            itemSelect.html(''); // очищаем список

            // заполняем список новыми пришедшими данными
            $.each(itemList, function (i) {
                itemSelect.append('<option value="' + i.name + '">' + this + '</option>');
            });
        });
    }
</script>
</body>
</html>
