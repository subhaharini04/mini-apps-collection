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
            expression = "";
            display.value = "";
        } else if (btn === "DEL") {
            expression = expression.slice(0, -1);
            display.value = expression;
            present = present.slice(0, -1);
        }
        else if (btn === "=") {
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
        } else if (btn === "%") {
            present = (parseFloat(present) / 100).toString();
            expression = present;
            display.value = expression;
        }
        else if (btn === "+/-") {
           if (present === "") return;
            
            // Toggle the sign of the current number
            if (present.startsWith("-")) {
                present = present.substring(1);
            } else {
                present = "-" + present;
            }
            let lastOpIndex = Math.max(
                expression.lastIndexOf("+"),
                expression.lastIndexOf("-"),
                expression.lastIndexOf("x"),
                expression.lastIndexOf("÷")
            );
            
            if (lastOpIndex === -1) {
                // No operator found, this is the first number
                expression = present;
            } else {
                // Replace the last number in expression
                expression = expression.substring(0, lastOpIndex + 1) + present;
            }
            
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