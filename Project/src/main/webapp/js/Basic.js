const overlay = document.getElementsByClassName("overlay");
const guideBar = document.getElementById("guide_bar");

function guide(direct) {
    if(direct)
    {
        overlay[0].setAttribute("style", `display: block; background-color: rgba(0,0,0, 0.4);`);
        guideBar.setAttribute("style", `left: 0;`);
    }
    else
    {
        overlay[0].setAttribute("style", `display: none; background-color: rgba(0,0,0, 0);`);
        guideBar.setAttribute("style", `left: -300px;`);
    }
}