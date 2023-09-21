import { Selector } from 'testcafe';

fixture `SDLMS Login Test`
    .page `https://your-sdlms-url.com/login`; // Replace with your actual login page URL

test('Login with valid credentials', async t => {
    const usernameInput = Selector('#username'); // Replace with the actual selector for the username input field
    const passwordInput = Selector('#password'); // Replace with the actual selector for the password input field
    const loginButton = Selector('#login-button'); // Replace with the actual selector for the login button

    // Fill in the username and password fields
    await t
        .typeText(usernameInput, 'your-username') // Replace with a valid username
        .typeText(passwordInput, 'your-password') // Replace with a valid password
        .click(loginButton);

    // Check if the login was successful by asserting the presence of a dashboard element
    const dashboardElement = Selector('.dashboard'); // Replace with the actual selector for a dashboard element
    await t.expect(dashboardElement.exists).ok();
});

test('Login with invalid credentials', async t => {
    const usernameInput = Selector('#username'); // Replace with the actual selector for the username input field
    const passwordInput = Selector('#password'); // Replace with the actual selector for the password input field
    const loginButton = Selector('#login-button'); // Replace with the actual selector for the login button

    // Fill in the username and password fields with invalid credentials
    await t
        .typeText(usernameInput, 'invalid-username')
        .typeText(passwordInput, 'invalid-password')
        .click(loginButton);

    // Check if there's an error message displayed
    const errorMessage = Selector('.error-message'); // Replace with the actual selector for the error message element
    await t.expect(errorMessage.exists).ok();
});