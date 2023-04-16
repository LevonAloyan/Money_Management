function disableScroll() {
    document.getElementById('html').style.display = 'block';
    document.getElementById('html').style.overflow = 'hidden';
    document.body.style.overflow = 'hidden';
}

function enableScroll() {
    document.getElementById('html').style.display = '';
    document.getElementById('html').style.overflow = '';
    document.body.style.overflow = '';
}

function PopUpShow() {
    $("#popup-container").show();
    $("#sec-a6db").css("-webkit-filter", "blur(10px)");
    $("#carousel_d01d").css("-webkit-filter", "blur(10px)");
    $("#sec-d3ed").css("-webkit-filter", "blur(10px)");
    $("#carousel_7275").css("-webkit-filter", "blur(10px)");
    DynamicChangeOfPopUpPosition();
    disableScroll();
}

function PopUpHide() {
    window.location.href = $("#tab").text();
    $("#sec-a6db").css("-webkit-filter", "blur(0px)");
    $("#carousel_d01d").css("-webkit-filter", "blur(0px)");
    $("#sec-d3ed").css("-webkit-filter", "blur(0px)");
    $("#carousel_7275").css("-webkit-filter", "blur(0px)");
    enableScroll();

}

function DynamicChangeOfPopUpPosition() {
    const popupContainer = document.getElementById('popup-container');
    window.addEventListener('scroll', () => {
        const scrollPosition = window.scrollY;

        const windowHeight = window.innerHeight;
        const popupHeight = popupContainer.offsetHeight;
        const topPosition = Math.max((windowHeight - popupHeight) / 2, 4) + scrollPosition;

        popupContainer.style.top = `${topPosition}px`;
    });
}