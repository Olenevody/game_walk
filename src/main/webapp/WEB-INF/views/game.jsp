<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Даешь революцию!</title>
    <script src="<c:url value="/resources/libs/js/jquery-3.1.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/game.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/game.css"/>">
    <link rel="shortcut icon" href="<c:url value="/resources/images/logo.png"/>" type="image/x-icon">
</head>
<body>
<script>
    $(document).ready(function () {
        var timerEl = $("#timer"),
            timer = ${timer};

        timerEl.html(new Date(timer * 1000).toUTCString().split(' ')[4]);
        var updateTimerID = setInterval(updateTimer, 1000);
        function updateTimer() {
            if (${game.status != 'PLAYING'}) {
                clearInterval(updateTimerID);
                return;
            }
            timer--;
            var date = new Date(timer * 1000);
            timerEl.html(date.toUTCString().split(' ')[4]);
            if (timer === 0) {
                clearInterval(updateTimerID);
                timerEl.css("color", "RED");
                updatePage();
            }
        }

        function updatePage() {
            $.ajax({
                url:"<c:url value="/checkUpdate/${game.pin}"/>",
                success: function (result) {
                if (result === true) {
                    location.reload(true);
                } else {
                    setTimeout(updatePage, 1000);
                }}
            })
        }
    })
</script>

<p id="enterCodeResult">${enterCodeResult.toString()}</p>
<p id="header">Приветствуем, ${game.team.name}</p>
<c:choose>
    <c:when test="${game.status == 'PLAYING'}">
        <c:if test="${not empty game.level.imgName}">
            <img class="bigImage" src="<c:url value="/resources/images/${game.level.imgName}"/>">
        </c:if>
        <p id="levelDescription">${game.level.description}</p>
        <p id="timer"></p>
        <ul>
            <c:forEach items="${game.level.codes}" var="code">
                <li class="codeLi <c:if test="${code.done}">codeDone</c:if>">${code.ko.toString()}</li>
            </c:forEach>
        </ul>
        <form action="<c:url value="/${game.pin}"/>" method="post">
            <input id="codeInput" name="code" type="text">
            <input type="submit">
        </form>
    </c:when>
    <c:when test="${game.status == 'PAUSED'}">
        <p>Игра приостановлена</p>
        <form action="<c:url value="/RESUME/${game.pin}"/>" method="get">
            <input type="submit">
        </form>
    </c:when>
    <c:when test="${game.status == 'FINISHED'}">
        <p>Ну что ж… Вы неплохо справились с первым испытанием! Настало время проверить Вашу команду в боевых условиях!<br/>
            Совсем недавно был разоблачен наш тайный агент! Перед тем как его вздернули на "рыбе" – он успел добыть коды доступа  к данным, которые позволят нам привлечь на свою сторону больше сторонников и остановить контрреволюционные выпады.<br/>
            Эти коды он надежно спрятал! Благодаря Вашим усилиям на предыдущем задании мы смогли получить фотографии мест, около которых спрятаны коды доступа. Каждая выполненная миссия открывает одну фотографию!<br/>
            Выдвигайтесь на рыбу: 59.82178, 30.49583<br/>
            Постарайтесь добыть для нас как можно больше кодов! Найденные коды вносите в движок, и мы тот час приступим к расшифровке полученных данных!<br/>
            Все революционное движение смотрит на Вас с надеждой!<br/>
            P.S. Будьте предельно внимательны и осторожны!</p>
        <ul>
        <c:forEach items="${doneLevels}" var="doneLevel">
            <li class="finalLi">
            <c:choose>
                <c:when test="${doneLevel.level == 2}">
                    <img src="<c:url value="/resources/images/final/NvrRXZwkfx.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 3}">
                    <img src="<c:url value="/resources/images/final/If3vW0bTpN.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 4}">
                    <img src="<c:url value="/resources/images/final/zMXCax3Pcs.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 5}">
                    <img src="<c:url value="/resources/images/final/IxasiBhZ5W.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 6}">
                    <img src="<c:url value="/resources/images/final/HBq4dObZfo.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 8}">
                    <img src="<c:url value="/resources/images/final/45mt6Yqace.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 9}">
                    <img src="<c:url value="/resources/images/final/D7oI9zBWrH.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 10}">
                    <img src="<c:url value="/resources/images/final/MXOEXdXnEy.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 11}">
                    <img src="<c:url value="/resources/images/final/01z1BOa3yp.png"/>">
                </c:when>
                <c:when test="${doneLevel.level == 12}">
                    <img src="<c:url value="/resources/images/final/617vd0TW7s.png"/>">
                </c:when>
            </c:choose>
            </li>
        </c:forEach>
        </ul>
    </c:when>
</c:choose>
</body>
</html>
