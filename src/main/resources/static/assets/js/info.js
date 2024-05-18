
import {fireBase} from "./config.js";


document.addEventListener("DOMContentLoaded", function () {
    // Lấy ID của người dùng từ localStorage
    const userId = localStorage.getItem('userId');
    console.log("ID của người dùng:", userId);

    if (userId) {
        // Thực hiện truy vấn để lấy thông tin của người dùng từ Firebase Realtime Database
        const database = fireBase.database();
        const userRef = database.ref('users/' + userId);

        // Lắng nghe sự kiện thay đổi trong nút của người dùng
        userRef.on('value', (snapshot) => {
            const userData = snapshot.val();
            console.log("Thông tin của người dùng:", userData);

            // Hiển thị họ tên đầy đủ
            const fullNameElement = document.getElementById('fullNameDisplay');
            if (fullNameElement) {
                fullNameElement.textContent = userData.fullName;
            }

            // Hiển thị ảnh
            const avatarElement = document.getElementById('avatarImage');
            if (avatarElement) {
                avatarElement.src = userData.avatarUrl;
            }
        });
    } else {
        console.log("Không có userId trong localStorage");
    }
});