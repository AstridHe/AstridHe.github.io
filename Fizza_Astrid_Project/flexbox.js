function logoColor() {
    const lc = document.getElementById("logo");
    lc.style.color = "white";
}

function logoColorBack() {
    const lc = document.getElementById("logo");
    lc.style.color = "Black";
}
function pageWelcome() {
    const headingEl = document.getElementById("website-heading");
    headingEl.innerHTML = "Välkommen till vår Flexbox Webbsida";
}
function changeBack() {
    const headingEl = document.getElementById("website-heading");
    headingEl.innerHTML = "Flexbox Webbsida";
}
function navTip1() {
    alert("Klicka på länkarna till vänster för snabb navigering!");
}