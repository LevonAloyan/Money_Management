function disableScroll() {
    document.getElementById('html').style.display = 'block';
    document.getElementById('html').style.overflow = 'hidden';
    document.body.style.overflow = 'hidden';
    // document.html.style.overflow = 'hidden';
}

function enableScroll() {
    document.getElementById('html').style.display = '';
    document.getElementById('html').style.overflow = '';
    document.body.style.overflow = '';
    // document.html.style.overflow = '';
}
function PopUpShow() {
    $("#popup-container").show();
    $("#sec-a6db").css("-webkit-filter", "blur(10px)");
    $("#carousel_d01d").css("-webkit-filter", "blur(10px)");
    $("#sec-d3ed").css("-webkit-filter", "blur(10px)");
    $("#carousel_7275").css("-webkit-filter", "blur(10px)");
    disableScroll();
    // $("#sec-d3ed").css("pointer-events", "none");   add all buttons which will be seen under the blur

}

function PopUpHide() {
    $("#popup-container").hide();
    $("#sec-a6db").css("-webkit-filter", "blur(0px)");
    $("#carousel_d01d").css("-webkit-filter", "blur(0px)");
    $("#sec-d3ed").css("-webkit-filter", "blur(0px)");
    $("#carousel_7275").css("-webkit-filter", "blur(0px)");
    enableScroll();

}

function  popUpPositionDynamicChange(){
    const popupContainer = document.getElementById('popup-container');

// listen for the window scroll event
    window.addEventListener('scroll', () => {
        // calculate the current scroll position
        const scrollPosition = window.scrollY;

        // calculate the top position for the popup container
        const windowHeight = window.innerHeight;
        const popupHeight = popupContainer.offsetHeight;
        const topPosition = Math.max((windowHeight - popupHeight) / 2, 4) + scrollPosition;

        // update the CSS style for the popup container
        popupContainer.style.top = `${topPosition}px`;
    });
}