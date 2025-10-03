const display = document.getElementById("display");
const buttons = document.querySelectorAll("button");
let present = "";
let previous = "";
let operator = "";

buttons.forEach(button => {
    button.addEventListener("click", () => {
        if (button.textContent === "C") {
            display.value = " ";
        } else if (button.textContent === "=") {
            previous = operation(present, previous, operator);
            display.value = previous;
        } else {
            display.value += button.textContent;
            let btn = button.textContent;
            if (btn >= 0 && btn <= 9 || btn === ".") {
                present += btn;
            } else {
                if (previous === "") {
                    previous = present;
                    present = "";
                }else{
                operator = btn;
                previous = operation(present, previous, operator);
            }
            }
        }
    });
});

function operation(a, b, op) {
    a = parseFloat(a);
    b = parseFloat(b);
    if (op === "+") return a + b;
    if (op === "-") return a - b;
    if (op === "X") return a * b;
    if (op === "÷") return a / b;
}