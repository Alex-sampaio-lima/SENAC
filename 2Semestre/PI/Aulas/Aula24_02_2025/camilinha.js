let idade1 = 45;
let idade2 = 10;
let idade3 = 90;
let resultado = 0;

if (idade1 >= idade2 && idade1 <= idade3 || idade1 >= idade3 && idade1 <= idade2) {
    resultado = idade1;
} else if (idade2 >= idade1 && idade2 <= idade3 || idade2 >= idade1 && idade2 <= idade3) {
    resultado = idade2;
} else {
    resultado = idade3;
}

console.log(resultado);





