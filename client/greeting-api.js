const API_URL = 'http://white-belt-alb-802870550.us-east-1.elb.amazonaws.com/api/greeting';

// Fetch and display the list of greetings when the page loads
window.onload = function () {
    fetchGreetings();
    const greetingInput = document.getElementById('greeting-input');
    const charCount = document.getElementById('char-count');

    greetingInput.addEventListener('input', function () {
        const currentLength = greetingInput.value.length;
        charCount.textContent = `${currentLength} / 140`;
    });
}

// Fetch greetings from the API and add them to the page
function fetchGreetings() {
    fetch(API_URL)
        .then(response => response.json())
        .then(greetings => {
            const greetingList = document.getElementById('greetings');
            // Clear the list before adding new greetings
            greetingList.innerHTML = '';
            greetings.forEach(greeting => {
                const listItem = document.createElement('li');
                listItem.textContent = greeting.message;
                greetingList.appendChild(listItem);
            });
        });
}

// Add an event listener to the form to handle creating new greetings
document.getElementById('greeting-form').addEventListener('submit', event => {
    event.preventDefault();
    const greetingInput = document.getElementById('greeting-input');
    const greetingMessage = greetingInput.value;
    if (greetingMessage.length > 0 && greetingMessage.length <= 140) {
        createGreeting(greetingMessage);
        // Clear the input field after creating a new greeting
        greetingInput.value = '';
    }
});

// Create a new greeting by sending a POST request to the API
function createGreeting(message) {
    fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                message
            })
        })
        .then(response => response.json())
        .then(() => {
            // Fetch the updated list of greetings after creating a new one
            fetchGreetings();
        });
}