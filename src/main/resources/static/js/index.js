let fileInput = document.getElementById("file-upload");
let check = document.getElementById("check");
let close = document.getElementById("close");

    fileInput.addEventListener("change", func)

    function func() {
        if(fileInput.files.length > 0) {
            check.style.display = "block";
            close.style.display = "none";
        } else {
            check.style.display = "none";
            close.style.display = "block";
        }
    }