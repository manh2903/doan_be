import { fireBase } from "./config.js";

// Initialize Firebase
const database = fireBase.database();
const notiRef = database.ref('notifications_send');
const usersRef = database.ref('users');


function getUserName(userId) {
    return new Promise((resolve, reject) => {
        usersRef.child(userId).once('value', (snapshot) => {
            const userData = snapshot.val();
            if (userData) {
                resolve(userData.fullName); // Adjust this according to your user data structure
            } else {
                resolve(null);
            }
        });
    });
}

notiRef.on('value', async (snapshot) => {
    const notifications = snapshot.val();

    // Clear previous table data
    const tableBody = document.getElementById('notiTable');
    tableBody.innerHTML = '';

    for (const userId in notifications) {

        const userNotifications = notifications[userId];

        for (const notificationId in userNotifications) {
            const notification = userNotifications[notificationId];
            const userName = await getUserName(userId);
            // Append data to table
            const newRow = document.createElement('tr');
            newRow.innerHTML = `
                <td>${userId}</td>
                <td>${userName}</td>
                <td>${notification.data.body}</td>
                <td>${notification.time}</td>
            `;
            tableBody.appendChild(newRow);
        }
    }
});
