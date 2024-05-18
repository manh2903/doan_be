import { fireBase } from "./config.js";

// Initialize Firebase

const database = fireBase.database();
const usersRef = database.ref('users');

// Get users reference from Firebase
let userIdToDelete; // Variable to store the user ID to delete

usersRef.on('value', (snapshot) => {
    const users = snapshot.val();
    console.log(users)

    const userTable = document.getElementById('userTable');
    userTable.innerHTML = ''; // Clear old data

    // Iterate through each user and create a table row
    Object.keys(users).forEach((key) => {
        const user = users[key];
        const row = document.createElement('tr');
        row.innerHTML = `
      <td>${key}</td>
      <td><img src="${user.avatarUrl}" width="50" height="50"></td>
      <td>${user.email}</td>
      <td>${user.fullName}</td>
      <td><i class="fa-solid fa-trash-can delete-btn" data-user-id="${key}"></i></td>
    `;
        userTable.appendChild(row);
    });

    // Add event listener to delete buttons
    const deleteBtns = document.querySelectorAll('.delete-btn');
    deleteBtns.forEach((btn) => {
        btn.addEventListener('click', (event) => {
            userIdToDelete = event.target.dataset.userId;
            $('#confirmDeleteModal').modal('show');
        });
    });
});

// Handle delete user confirmation
const deleteUserButton = document.getElementById('confirmDeleteBtn');
deleteUserButton.addEventListener('click', async () => {
    try {
        if (!userIdToDelete) {
            console.error('No user ID to delete');
            return;
        }

        // Remove user from Firebase Realtime Database
        const userRef = usersRef.child(userIdToDelete);
        await userRef.remove();

        const response = await fetch(`/api/users/${userIdToDelete}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (response.ok) {
            console.log('User deleted successfully');
            // Find the row element containing the delete button with the userIdToDelete
        //     const deleteButton = document.querySelector(`.delete-btn[data-user-id="${userIdToDelete}"]`);
        //     if (deleteButton) {
        //         const row = deleteButton.closest('tr');
        //         if (row) {
        //             row.remove();
        //         } else {
        //             console.error('Error: Row element not found');
        //         }
        //     } else {
        //         console.error('Error: Delete button not found');
        //     }
        // } else {
        //     const errorData = await response.json();
        //     console.error('Error deleting user:', errorData.message);
        }

        // Hide the confirmation modal
        $('#confirmDeleteModal').modal('hide');
    } catch (error) {
        console.error('Error deleting user:', error);
        // You can also display an error message to the user here
    } finally {
        userIdToDelete = null; // Reset the variable
    }
});