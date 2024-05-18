
import { firebaseConfig } from './config.js';
import {fireBase} from "./config.js";
import { initializeApp } from "https://www.gstatic.com/firebasejs/10.11.1/firebase-app.js";
import { getAuth, signInWithEmailAndPassword } from "https://www.gstatic.com/firebasejs/10.11.1/firebase-auth.js";

/*=============== SHOW HIDDEN - PASSWORD ===============*/
const showHiddenPass = (loginPass, loginEye) =>{
    const input = document.getElementById(loginPass),
        iconEye = document.getElementById(loginEye)

    iconEye.addEventListener('click', () =>{
        // Change password to text
        if(input.type === 'pass word'){
            // Switch to text
            input.type = 'text'

            // Icon change
            iconEye.classList.add('ri-eye-line')
            iconEye.classList.remove('ri-eye-off-line')
        } else{
            // Change to password
            input.type = 'password'

            // Icon change
            iconEye.classList.remove('ri-eye-line')
            iconEye.classList.add('ri-eye-off-line')
        }
    })
}

showHiddenPass('login-pass','login-eye')


const app = initializeApp(firebaseConfig);

const auth = getAuth(app);

// Lắng nghe sự kiện click trên nút đăng nhập
const loginForm = document.getElementById('loginForm');

loginForm.addEventListener('submit', (e) => {
   e.preventDefault(); // Ngăn chặn hành vi mặc định của form

   const email = document.getElementById('login-email').value;
   const password = document.getElementById('login-pass').value;

// Sau khi đăng nhập thành công
    signInWithEmailAndPassword(auth, email, password)
        .then((userCredential) => {
            alert("Đăng nhập thành công!");
            const user = userCredential.user;
            const userId = user.uid; // Lấy ID của người dùng

            // Lưu ID của người dùng vào localStorage
            localStorage.setItem('userId', userId);

            // Chuyển hướng sang trang dashboard
            window.location.href = "/users";
        })
        .catch((error) => {
            alert("Đăng nhập thất bại!");
            const errorCode = error.code;
            const errorMessage = error.message;
        });

});
