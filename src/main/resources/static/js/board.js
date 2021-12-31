function addboardlist(itemDto) {
    return `<div class="post-preview">
                <a href="/boards/details/${itemDto.id}">
                    <h2 class="post-title">${itemDto.title}</h2>
                    <h3 class="post-subtitle">${itemDto.content.substr(0, 15)}...</h3>
                </a>
                <p class="board-meta">
                    Posted by
                    <a href="#!">Start Bootstrap</a>
                    on ${dayrenewal(itemDto.createdAt)}
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
            for (let i = 0; i < response.length; i++) {
                let itemDto = response[i];
                let tempHtml = addboardlist(itemDto);
                $('#board_list').append(tempHtml);
            }
        }
    })
}

function addboard(itemDto) {
    return `
<!--            <div class="col">-->
                <h1 class="section-heading">${itemDto.title}</h1>
                <p class="post-meta text-end">${timerenewal(itemDto.createdAt)}</p>
<!--            </div>            -->
            <div class="secondary-text">
                <p>${itemDto.content}</p>
            </div>
            `
}

function getboarddetail(targetId) {

    $.ajax({
        type: "GET",
        url: `/api/boards/${targetId}`,
        success: function (response) {
            let tempHtml = addboard(response);
            $('#board_detail').append(tempHtml);
        }
    })
}

function timerenewal(oldTime) {
    let times = oldTime.replace("T", " ");
    let timesindex = times.lastIndexOf(":");
    let newtimes = times.slice(0, timesindex);
    return newtimes;
}

function dayrenewal(oldTime) {
    return oldTime.split("T")[0];
}

function writeBoard() {
    let title = $('#title');
    let content = $('#content');
    let submit = $('#submit');


    if (!title.val()){
        submit.preventDefault();

    }
    if (!content.val()) {
        content.focus();
    }

    $.ajax({
        type: "POST",
        url: `/api/boards`,
        contentType: "application/json",
        data: JSON.stringify({"title": title.val(), "content": content.val()}),
        success: function (response) {
            let targetId = response.id;
            window.location.replace("/boards/details/"+targetId);
        }
    })
}