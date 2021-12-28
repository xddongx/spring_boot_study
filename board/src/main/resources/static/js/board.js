function addboardlist(itemDto) {
    return `<div class="board-preview">
                <a href="/boards/details/${itemDto.id}">
                    <h2 class="board-title">${itemDto.title}</h2>
                    <h3 class="board-subcontent">${itemDto.content.substr(0, 15)}...</h3>
                </a>
                <p class="board-meta">
                    Posted by
                    <a href="#!">Start Bootstrap</a>
                    on September 24, 2021
                </p>
            </div>
            <!-- Divider-->
            <hr class="my-4"/>`
}


function getboardlist() {
    $.ajax({
        type: "GET",
        url: "/api/boards",
        success: function (response) {
            $('#board_list').empty();
            for (let i=0; i < response.length; i++){
                let itemDto = response[i];
                let tempHtml = addboardlist(itemDto);
                $('#board_list').append(tempHtml);
            }
        }
    })
}

function addboard(itemDto) {
    return `
            <h2 class="post-title">${itemDto.title}</h2>
            <h3 class="post-subtitle">${itemDto.content}</h3>
                
            <!-- Divider-->
            <hr class="my-4"/>`
}

function getboarddetail(targetId) {

    $.ajax({
        type: "GET",
        url: `/api/boards/${targetId}`,
        success: function(response) {
            let tempHtml = addboard(response);
            $('#board_detail').append(tempHtml);
        }
    })
}
