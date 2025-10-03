const display = document.getElementById("display");
const buttons = document.querySelectorAll("button");
let present = "";
let number = [];
let operator = [];
let expression = "";
buttons.forEach(button => {
    button.addEventListener("click", () => {
        let btn = button.textContent;
        if (btn === "C") {
            present = "";
            number = [];
            operator = [];
            expression="";
            display.value = "";
        } else if (btn === "=") {
            number.push(parseFloat(present));
            const result = operation(number, operator);
            display.value = result;
            present = result.toString();
            number = [];
            operator = [];
            expression = result.toString();
        } else if (btn >= 0 && btn <= 9 || btn === ".") {
             if (btn === "." && present.includes(".")) return;
            present += btn;
            expression += btn;
            display.value = expression;
        } else {
            number.push(parseFloat(present));
            operator.push(btn);
            present = "";
            expression += btn;
            display.value = expression;

        }
    });
});

function operation(num, op) {
    for (let i = 0; i < op.length; i++) {
        if (op[i] === "x" || op[i] === "÷") {
            const result = operator[i] === "x" ? num[i] * num[i + 1] : num[i] / num[i + 1];
            num.splice(i, 2, result);
            op.splice(i, 1);
            i--;
        }
    }
    let result = num[0];
    for (let i = 0; i < op.length; i++) {
        if (op[i] === "+") {
            result += num[i + 1];
        } else if (op[i] === "-") {
            result -= num[i + 1];
        }
    }
    return result;

}