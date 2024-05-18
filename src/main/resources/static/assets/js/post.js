import {fireBase} from "./config.js";

// Initialize Firebase
const database = fireBase.database();
const skill = database.ref('skill');
const action = database.ref('action_ascape');
const question = database.ref('questions');
const token = database.ref('tokens');

// Lấy dữ liệu từ "action_ascaspe"
action.once('value', (snapshot) => {
    const maction = snapshot.val();
    Object.keys(maction).forEach((key) => {
        const actionItem = maction[key];
        const option = document.createElement('option');
        option.value = actionItem.name;
        option.text = actionItem.source;
        document.getElementById('related-questions').add(option);
    });
});

// Lấy dữ liệu từ "skill"
skill.once('value', (snapshot) => {
    const mskill = snapshot.val();
    Object.keys(mskill).forEach((key) => {
        const skillItem = mskill[key];
        const option = document.createElement('option');
        option.value = skillItem.name;
        option.text = skillItem.source;
        document.getElementById('related-questions').add(option);
    });
});

// Lấy dữ liệu từ "question"
question.once('value', (snapshot) => {
    const mquestion = snapshot.val();
    Object.keys(mquestion).forEach((key) => {
        const option = document.createElement('option');
        option.text = key;
        document.getElementById('related-questions1').add(option);
    });
});

// Lưu token
let listToken = [];
token.on('value', (snapshot) => {
    const mtokens = snapshot.val();
    const uniqueTokens = new Set();

    for (const userId in mtokens) {
        const tokens = mtokens[userId];
        Object.keys(tokens).forEach((key) => {
            uniqueTokens.add(key);
        });
    }
    listToken = Array.from(uniqueTokens);
    console.log('token : ', listToken);
});

// Lấy thời gian hiện tại
function getCurrentTime() {
    const now = new Date();
    const day = String(now.getDate()).padStart(2, '0');
    const month = String(now.getMonth() + 1).padStart(2, '0');
    const year = now.getFullYear();
    return `${day}.${month}.${year}`;
}

// Xử lý sự kiện khi chọn option
const selectElement = document.getElementById('related-questions');
selectElement.addEventListener('change', (event) => {
    let selectedOption = event.target.options[event.target.selectedIndex];
    let selectedName = selectedOption.value;
    let selectedText = selectedOption.text;

    document.getElementById('question-body').value = selectedName;

    console.log(`Selected value: ${selectedName}`);
    console.log(`Selected text: ${selectedText}`);
});



// Lấy dữ liệu từ biểu mẫu
function getFormData(form) {
    const formData = new FormData(form);
    const selectElement = document.getElementById('related-questions');
    const selectedOption = selectElement.options[selectElement.selectedIndex];
    return {
        type: formData.get('type'),
        title: formData.get('title'),
        body: formData.get('body'),
        source: selectedOption.text, // Get the text of the selected option
    };
}

// Gửi thông báo đến API
async function sendNotification(notificationData) {
    const apiUrl = '/firebase/send-notification-admin-v1';
    const headers = { 'Content-Type': 'application/json' };
    const body = JSON.stringify(notificationData);

    try {
        const response = await fetch(apiUrl, { method: 'POST', headers, body });
        if (!response.ok) {
            throw new Error(`API error: ${response.status}`);
        }
        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error(`Error sending notification: ${error}`);
        // Hiển thị thông báo lỗi thân thiện với người dùng
        alert(`Error sending notification. Please try again later.`);
    }
}

// Xử lý sự kiện gửi biểu mẫu
const form = document.querySelector('.form');
form.addEventListener('submit', async (event) => {
    event.preventDefault();
    const formData = getFormData(form);
    const notificationData = {
        data: formData,
        time: getCurrentTime(),
        token: listToken,
    };
    console.log(notificationData)
    await sendNotification(notificationData);
});




// Lấy dữ liệu từ biểu mẫu (form bên phải)
function getFormDataRight(form) {
    const formData = new FormData(form);
    const selectElement = document.getElementById('related-questions1');
    const selectedOption = selectElement.options[selectElement.selectedIndex];
    return {
        type: formData.get('type'),
        title: formData.get('title'),
        body: formData.get('body'),
        list_question: selectedOption.text, // Get the text of the selected option
    };
}

// Xử lý sự kiện gửi biểu mẫu (form bên phải)
const formRight = document.querySelectorAll('.form')[1]; // Lấy form thứ 2 (form bên phải)
formRight.addEventListener('submit', async (event) => {
    event.preventDefault();
    const formData = getFormDataRight(formRight);
    const notificationData = {
        data: formData,
        time: getCurrentTime(),
        token: listToken,
    };
    console.log(notificationData);
    await sendNotificationV2(notificationData);
});

// Gửi thông báo đến API v2
async function sendNotificationV2(notificationData) {
    const apiUrl = '/firebase/send-notification-admin-v2';
    const headers = { 'Content-Type': 'application/json' };
    const body = JSON.stringify(notificationData);

    try {
        const response = await fetch(apiUrl, { method: 'POST', headers, body });
        if (!response.ok) {
            throw new Error(`API error: ${response.status}`);
        }
        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error(`Error sending notification: ${error}`);
        alert(`Error sending notification. Please try again later.`);
    }
}
