<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- mã hóa mật khẩu -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>

<!-- jQuery (necessary for JavaScript plugins) -->
<script type="text/javascript" src="views/script/jquery.js"></script>
<script type="text/javascript" src="views/script/bootstrap.min.js"></script>
<script type="text/javascript" src="views/script/slick.slider.min.js"></script>
<script type="text/javascript" src="views/script/jquery.countdown.min.js"></script>
<script type="text/javascript" src="views/script/fancybox.pack.js"></script>
<script type="text/javascript" src="views/script/isotope.min.js"></script>
<script type="text/javascript" src="views/script/progressbar.js"></script>
<script type="text/javascript" src="views/script/counter.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>
<script type="text/javascript" src="views/script/functions.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        const message = document.getElementById('message');
        

        if (message.innerHTML !== '') {

            const main = document.getElementById("toast");
            const duration = 3000;
            if (main) {
                const toast = document.createElement("div");

                // Auto remove toast
                const autoRemoveId = setTimeout(function () {
                    main.removeChild(toast);
                }, duration + 1000);

                // Remove toast when clicked
                toast.onclick = function (e) {
                    if (e.target.closest(".toast__close")) {
                        main.removeChild(toast);
                        clearTimeout(autoRemoveId);
                    }
                };
                const delay = (duration / 1000).toFixed(2);

                toast.classList.add("toast", `toast--${toast__type}`);
                toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${deplay}s forwards`;

                toast.innerHTML = `
                    <div class="toast__icon">
                        <i class="${toast__icons}"></i>
                    </div>
                    <div class="toast__body">
                        <p class="toast__msg">${toast__message}</p>
                    </div>
                    <div class="toast__close">
                        <i class="fas fa-times"></i>
                    </div>`;
                main.appendChild(toast);
            }

        }

    });

</script>

<script >
    function convertPassToMD5(password) {
        // Create a new instance of the MD5 hash object
        var md5 = CryptoJS.algo.MD5.create();

        // Update the hash object with the password bytes
        md5.update(CryptoJS.enc.Utf8.parse(password));

        // Get the MD5 hash in hexadecimal format
        var passwordHash = md5.finalize().toString().toUpperCase();

        return passwordHash;
    }

    const currentPass = `${account.password}`;

    function checkOldPassword() {
        var oldPass = document.getElementById('oldpass');
        var oldPassMD5 = convertPassToMD5(oldPass.value);

        var message = document.getElementById('messageOldPass');

        if (oldPassMD5 !== currentPass) {
            oldPass.style.border = '1px solid red';
            message.innerHTML = 'Mật Khẩu Hiện Tại Không Chính Xác';
            message.style.color = 'red';
            return false;
        } else {
            oldPass.style.border = '1px solid green';
            message.innerHTML = '';
            return true;
        }

    }

    function checkNewPassword() {
        var oldPass = document.getElementById('oldpass');
        var newPass = document.getElementById('newpass');

        var message = document.getElementById('messageNewPass');
        if (convertPassToMD5(newPass.value) === currentPass) {
            newPass.style.border = '1px solid red';
            message.innerHTML = 'Mật Khẩu Không Được Trùng Với Mật Khẩu Cũ ';
            message.style.color = 'red';
            return false;

        } else {
            newPass.style.border = '1px solid green';
            message.innerHTML = '';
            return true;

        }
    }

    function checkComfirmPassword() {
        var newPass = document.getElementById('newpass');
        var confirmPass = document.getElementById('comfirmpass');

        var message = document.getElementById('messageComfirmPass');

        if (newPass.value !== confirmPass.value) {
            confirmPass.style.border = '1px solid red';
            message.innerHTML = 'Mật Khẩu Xác Nhận Không Giống Với Mật Khẩu Mới ';
            message.style.color = 'red';
            return false;

        } else {
            confirmPass.style.border = '1px solid green';
            message.innerHTML = '';
            return true;

        }
    }

    function checkSubmit() {
        if (checkOldPassword() && checkNewPassword() && checkComfirmPassword()) {
            document.getElementById('formChange').submit();
        }

    }

</script>


<%
        session.removeAttribute("toast__message");
        session.removeAttribute("toast__icons");
        session.removeAttribute("toast__type");
%>