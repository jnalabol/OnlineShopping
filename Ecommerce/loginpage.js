const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;

    if ((username === "user@gmail.com" && password === "user")||(username === "jyo@gmail.com" && password === "jyo")){
        alert("You have successfully logged in.");
        location.href = "home.html";
       
    } else {
        loginErrorMsg.style.opacity = 1;
    }
})