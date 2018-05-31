<!DOCTYPE HTML>
<head>
    <title>Our Love Story</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        @font-face {
            font-family: digit;
            src: url('${cxt.contextPath}/font-awesome/digital-7_mono.ttf') format("truetype");
        }
    </style>
    <link href="${cxt.contextPath}/css/profession.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${cxt.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${cxt.contextPath}/js/profession.js"></script>
    <script type="text/javascript" src="${cxt.contextPath}/js/profession1.js"></script>
</head>

<body>
<div id="mainDiv">
    <div id="content">
        <div id="code">
            <span class="comments">/**</span><br/>
            <span class="space"/><span class="comments">* we are both rational turn of mind,</span><br/>
            <span class="space"/><span
                class="comments">* so I write some code to anniversary and tell you my love.</span><br/>
            <span class="space"/><span class="comments">*/</span><br/>
            Boy i = <span class="keyword">new</span> Boy(<span class="string">"xianzhi.wang"</span>);<br/>
            Girl u = <span class="keyword">new</span> Girl(<span class="string">"lihui.gu"</span>);<br/>
            <span class="comments">// Feb. 14, 2018, I told you I fall in love with you. </span><br/>
            i.love(u);<br/>
            <span class="comments">// Luckily, you accepted and became my girlfriend eversince.</span><br/>
            u.accepted();<br/>
            <span class="comments">// Since then, I miss u every every single day.</span><br/>
            i.miss(u);<br/>
            <span class="comments">// And take care of u and our love.</span><br/>
            i.takeCareOf(u);<br/>
            <span class="comments">// You say that you won't be so easy to love me.</span><br/>
            <span class="comments">// So I keep waiting and I have confidence that you will.</span><br/>
            <span class="keyword">boolean</span> isHesitate = <span class="keyword">true</span>;<br/>
            <span class="keyword">while</span> (isHesitate) {<br/>
            <span class="placeholder"/>i.waitFor(u);<br/>
            <span class="placeholder"/><span class="comments">// I think it is an important decision</span><br/>
            <span class="placeholder"/><span class="comments">// and you should think it over.</span><br/>
            <span class="placeholder"/>isHesitate = u.thinkOver();<br/>
            }<br/>
            <span class="comments">// After a romantic wedding, we will live happily ever after.</span><br/>
            i.marry(u);<br/>
            i.liveHappilyWith(u);<br/>
        </div>
        <div id="loveHeart">
            <canvas id="garden"></canvas>
            <div id="words">
                <div id="messages">
                    lihui, I have fallen in love with you for
                    <div id="elapseClock"></div>
                </div>
                <div id="loveu">
                    love u forever and ever.<br/>
                    <div class="signature">- xianzhi.wang</div>
                </div>
            </div>
        </div>
    </div>
    <div id="copyright">
        Inspired by <a href="">WXZ</a> project.<br/>
        Copyright © 2018 <a href=''></a> 2018-ever
    </div>
</div>
<script type="text/javascript">
    var offsetX = $("#loveHeart").width() / 2;
    var offsetY = $("#loveHeart").height() / 2 - 55;
    var together = new Date();
    together.setFullYear(2018, 1, 14);
    together.setHours(11);
    together.setMinutes(0);
    together.setSeconds(0);
    together.setMilliseconds(0);

    if (!document.createElement('canvas').getContext) {
        var msg = document.createElement("div");
        msg.id = "errorMsg";
        msg.innerHTML = "Your browser doesn't support HTML5!<br/>Recommend use Chrome 14+/IE 9+/Firefox 7+/Safari 4+";
        document.body.appendChild(msg);
        $("#code").css("display", "none")
        $("#copyright").css("position", "absolute");
        $("#copyright").css("bottom", "10px");
        document.execCommand("stop");
    } else {
        setTimeout(function () {
            startHeartAnimation();
        }, 5000);

        timeElapse(together);
        setInterval(function () {
            timeElapse(together);
        }, 500);

        adjustCodePosition();
        $("#code").typewriter();
    }

</script>
</body>
</html>
