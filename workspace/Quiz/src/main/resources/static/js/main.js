$("#menu-toggle").click(function (e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
});

'use strict'

$(document).ready(function () {
    $.getJSON("../Data/data-set.json", function (json) {

        console.log("hihi")
        for (let index = 0; index < json.length; index++) {
            let a = `
            <div class="myQuizList" id="`+json[index].id+`">
            <img src="data:image/png;base64,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" style="width:100%;height:90%;border-radius:5px;border:5px;border-style:solid;border-color:rgb(168, 129, 81)">
            <p style="font-weight: bolder;font-size: 30px">`+json[index].questionSet+`</p>
            </div>
            `
            let b = `<li><a class="dropdown-item" href="../Add_Edit/quizContent.html">`+json[index].questionSet+`</a></li>`
            let end = document.createElement("span")
                end.innerHTML = a;
                document.querySelector("#main").appendChild(end);
                var doQuiz = document.getElementById(json[index].id);
                doQuiz.onclick = function () {
                    location.href="../doQuiz/index.html"
                }
                let listElement = document.createElement("span")
                listElement.innerHTML = b;
                document.querySelector("#viewList").prepend(listElement);
        }
    })
})


var modal = document.getElementById("nameModal");
var Qmodal = document.getElementById("questionModal");
var question = document.getElementById("question");
var answer = document.getElementById("answer");


// Control Create quiz
var createBtn = document.getElementById("createBtn");
var nextBtn1 = document.getElementById("nextBtn1");
var nextBtn2 = document.getElementById("nextBtn2");

// When the user clicks the button, open the modal 
createBtn.onclick = function () {
    modal.style.display = "block";
}

nextBtn1.onclick = function () {
    location.href="../Add_Edit/Add_Edit.html";
}

// Control view quiz

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal || event.target == Qmodal) {
        modal.style.display = "none";
        Qmodal.style.display = "none";
    }
}

