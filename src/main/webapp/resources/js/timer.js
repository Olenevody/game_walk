$(document).ready(function () {

    var timerEl = $("#timer");
    setInterval(updateTimer, 1000);

    function updateTimer() {
        timer -= 1000;
        timerEl.html(timer);
    }

});


