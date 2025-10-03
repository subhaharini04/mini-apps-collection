const display = document.getElementById("display");
const buttons = document.querySelectorAll("button");
let present = "";
let number = [];
let operator = [];

buttons.forEach(button => {
    button.addEventListener("click", () => {
        let btn = button.textContent;
        if (btn === "C") {
            present = "";
            number = [];
            operator = [];
            display.value = "";
        } else if (btn === "=") {
            number.push(parseFloat(present));
            const result = operation(number, operator);
            display.value = result;
            present = result.toString();
            number = [];
            operator = [];
        } else if (btn >= 0 && btn <= 9 || btn === ".") {
            present += btn;
            display.value = present;
        } else {
            number.push(parseFloat(present));
            operator.push(btn);
            present = "";
            display.value+=btn;

        }
    });
});

function operation(num,op) {
    for(let i=0;i<op.length;i++){
        if(op[i]==="X"||op[i]==="÷"){
            const result=operator[i]==="x" ? num[i]*num[i+1]:num[i]/num[i+1];
            num.splice(i,2,result);
            op.splice(i,1);
            i--;
        }
    }
    let result=num[0];
    for(let i=0;i<op.length;i++){
        if(op[i]==="+"){
            result+=num[i+1];
        }else if(op[i]==="-"){
            result-=num[i+1];
        }
    }
        return result;

}