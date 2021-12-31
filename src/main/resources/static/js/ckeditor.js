ClassicEditor .create(document.querySelector(`#contentArea`))
    .then(editor => {
        // console.log(editor);
    })
    .catch(error => {
        console.error(error);
    });