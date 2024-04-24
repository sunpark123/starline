function gologin()
{
    const box = document.querySelector(".msg");

    box.animate(
        // keyframes
        [
            { transform: "translateX(0)", opacity: 0.5 },
            { transform: "translateX(-300px)", opacity: 0 },
        ],
        // options
        {
            duration: 500,
            easing: "linear",
            fill: "forwards",
        }
    );
    const login = document.querySelector(".login_form");
    login.style.display = "block";
    login.animate(
        // keyframes
        [
            { transform: "translateX(+300px)", opacity: 0 },
            { transform: "translateX(0)", opacity: 1 },
        ],
        // options
        {
            duration: 500,
            easing: "linear",
            fill: "forwards",
        }
    );
}

function back()
{
    const box = document.querySelector(".msg");

    box.animate(
        // keyframes
        [
            { transform: "translateX(-300px)", opacity: 0 },
            { transform: "translateX(0)", opacity: 1 },
        ],
        // options
        {
            duration: 500,
            easing: "linear",
            fill: "forwards",
        }
    );
    const login = document.querySelector(".login_form");
    login.style.display = "none";
    login.animate(
        // keyframes
        [
            { transform: "translateX(0)", opacity: 1 },
            { transform: "translateX(+300px)", opacity: 0 },
        ],
        // options
        {
            duration: 500,
            easing: "linear",
            fill: "forwards",
        }
    );
    const logins = document.querySelector(".register_form");
    logins.style.display = "none";
    logins.animate(
        // keyframes
        [
            { transform: "translateX(0)", opacity: 1 },
            { transform: "translateX(+300px)", opacity: 0 },
        ],
        // options
        {
            duration: 500,
            easing: "linear",
            fill: "forwards",
        }
    );
}

function goregister()
{
    const box = document.querySelector(".login_form");

    box.animate(
        // keyframes
        [
            { transform: "translateX(0)", opacity: 0.5 },
            { transform: "translateX(-300px)", opacity: 0 },
        ],
        // options
        {
            duration: 500,
            easing: "linear",
            fill: "forwards",
        }
    );
    const login = document.querySelector(".register_form");
    login.style.display = "block";
    login.animate(
        // keyframes
        [
            { transform: "translateX(+300px)", opacity: 0 },
            { transform: "translateX(0)", opacity: 1 },
        ],
        // options
        {
            duration: 500,
            easing: "linear",
            fill: "forwards",
        }
    );
}