

var ul = document.querySelector("ul");
var input = document.getElementById("myInput");

function newElement() {
    var li = document.createElement("li");
    li.appendChild(document.createTextNode(input.value));
    if (input.value === '') {
        alert("Du måste skriva något!");
    }
    else {
        ul.appendChild(li);
    }
    input.value = "";

    function check() {
        li.classList.toggle("checked");
    }
    li.addEventListener("click", check);

    var dBtn = document.createElement("button");
    dBtn.appendChild(document.createTextNode("X"));
    li.appendChild(dBtn);

    dBtn.addEventListener("click", deleteListItem);

    function deleteListItem() {
        li.classList.add("delete");
    }
}

function addListAfterKeypress(event) {
    if (event.which === 13) { newElement(); }
}

input.addEventListener("keypress", addListAfterKeypress);


