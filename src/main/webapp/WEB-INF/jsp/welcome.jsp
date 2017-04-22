<html>
    <head></head>
    <body>
        <form id="welcomeForm" method="GET" action="Javascript:submit(url)">
            URL: <input type="text" id="url" name="url"/>
            <br/><br/>
            <input type="submit" name="send" value="Submit"/>
        </form>
        <script>
            function submit(url) {
                window.location.href = '/html/analysis?url=' + url.value;
            }
        </script>
    </body>
</html>