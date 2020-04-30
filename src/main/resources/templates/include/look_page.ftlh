<div class="container">
    <h2 class="text-primary">${look.getTitle()}</h2>
    <h5>Season: ${look.getSeason()}</h5>
    <table class="table table-hover table-sm">
        <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Brand</th>
            <th scope="col">Article</th>
        </tr>
        </thead>
        <tbody>
        <#list items as item>
            <tr>
                <td>${item.getTitle()}</td>
                <td>${item.getBrand()}</td>
                <td>${item.getArticle()}</td>
                <td><img href="${item.getImage()}"></td>
            </tr>
        </#list>

        </tbody>
    </table>
    <p>${recipe.getDescription()}</p>
</div>