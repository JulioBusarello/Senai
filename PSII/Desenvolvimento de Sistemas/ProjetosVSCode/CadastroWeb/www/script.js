document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('userForm');
    const userTableBody = document.querySelector('#userTable tbody');
    const resetTableButton = document.getElementById('resetTableButton');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;
        const address = document.getElementById('address').value;
        const city = document.getElementById('city').value;
        const state = document.getElementById('state').value;
        const message = document.getElementById('message').value;

        const table = document.getElementById('userTable').getElementsByTagName('tbody')[0];
        const newRow = table.insertRow();
    
        [name, email, phone, address, city, state, message].forEach((value, index) => newRow.insertCell(index).innerText = value);

        form.reset();
    });

    resetTableButton.addEventListener('click', function() {
        userTableBody.innerHTML = '';
    });
});