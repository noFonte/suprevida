const { v4: uuidv4 } = require('uuid');

function uuid() {
    return uuidv4();
}
function gerarPreco(min, max) {
    // Gera um número aleatório entre o mínimo e o máximo
    let preco = (Math.random() * (max - min) + min).toFixed(2); // duas casas decimais
    return parseFloat(preco); // retorna o número como um float
}



module.exports = { uuid ,gerarPreco };
