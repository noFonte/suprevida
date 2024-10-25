const { default: axios } = require("axios");
const MyFn = require("./Helpers.js")
const url = "http://localhost:8080";

const instance = axios.create({
    validateStatus: () => true,
});


test('criar um novo usuário', async () => {

    inputUser = {
        "login": MyFn.uuid(),
        "password": MyFn.uuid()
    }
    outputUser = await instance.post(url + "/register", inputUser)
    expect(outputUser.status).toBe(201)
});



test('criar um novo usuário se o login não existir', async () => {

    inputUser = {
        "login": MyFn.uuid(),
        "password": MyFn.uuid()
    }
    outputUser = await instance.post(url + "/register", inputUser)
    expect(outputUser.status).toBe(201)

    outputUser2 = await instance.post(url + "/register", inputUser, { validateStatus: false })
    expect(outputUser2.status).toBe(400)


});



test('Listar Todos Usuarios Cadastrados Na Base', async () => {
    outputUsers = await instance.get(url + "/users")
    expect(outputUsers.data.users.length).toBeGreaterThan(0);
});


test('Busca um Usuario Cadastrado Na Base', async () => {
    inputUser = {
        "login": MyFn.uuid(),
        "password": MyFn.uuid()
    }
    outputUser = await instance.post(url + "/register", inputUser)
    expect(outputUser.status).toBe(201)
    outputUser = await instance.post(url + "/user",inputUser)
    expect(outputUser.data.user.id).toBeGreaterThan(0);
});





test('criar um novo Produto', async () => {

    inputProduct = {
        "name": MyFn.uuid(),
        "description": MyFn.uuid(),
        "price": MyFn.gerarPreco(2.50,999.9)
    }

    outputProduct = await instance.post(url + "/product", inputProduct)
    expect(outputProduct.status).toBe(201)
});




test('criar um novo Produto se não tiver.', async () => {

    inputProduct = {
        "name": MyFn.uuid(),
        "description": MyFn.uuid(),
        "price": MyFn.gerarPreco(2.50,999.9)
    }

    outputProduct = await instance.post(url + "/product", inputProduct)
    expect(outputProduct.status).toBe(201)

    outputProduct2 = await instance.post(url + "/product", inputProduct, { validateStatus: false })
    expect(outputProduct2.status).toBe(400)
});



test('criar um novo Produto se não tiver. e Busca na Base o produto Cadastrado', async () => {

    inputProduct = {
        "name": MyFn.uuid(),
        "description": MyFn.uuid(),
        "price": MyFn.gerarPreco(2.50,999.9)
    }
    outputProduct = await instance.post(url + "/product", inputProduct)
    expect(outputProduct.status).toBe(201)
    expect(outputProduct.data.product.id).toBeDefined()
    outputProduct2 = await instance.get(url+"/product/"+outputProduct.data.product.id)
    expect(outputProduct.data.product).toBeDefined()
    expect(outputProduct.data.product.id).toBeGreaterThan(0);

});

test('criar um novo Produto se não tiver. e Busca na Base todos os produtos Cadastrados', async () => {
    inputProduct = {
        "name": MyFn.uuid(),
        "description": MyFn.uuid(),
        "price": MyFn.gerarPreco(2.50,999.9)
    }
    outputProduct = await instance.post(url + "/product", inputProduct)
    expect(outputProduct.status).toBe(201)
    outputProduct = await instance.get(url + "/products")
    expect(outputProduct.data.products).toBeDefined()
    expect(outputProduct.data.products.length).toBeGreaterThan(0);
});



test('criar um novo Produto se não tiver. e Busca na Base o produto Cadastrado Altera o Valor e o Preço e Nome' , async () => {

    inputProduct = {
        "name": MyFn.uuid(),
        "description": MyFn.uuid(),
        "price": MyFn.gerarPreco(2.50,999.9)
    }
    outputProduct = await instance.post(url + "/product", inputProduct)
    expect(outputProduct.status).toBe(201)
    expect(outputProduct.data.product.id).toBeDefined()
    outputProduct2 = await instance.get(url+"/product/"+outputProduct.data.product.id)
    expect(outputProduct.data.product).toBeDefined()
    expect(outputProduct.data.product.id).toBeGreaterThan(0);

    inputProductUpdate = {
        "name": MyFn.uuid(),
        "description": MyFn.uuid(),
        "price": MyFn.gerarPreco(2.50,999.9)
    }

    outputProduct3 = await instance.put(url+"/product/"+outputProduct.data.product.id,inputProductUpdate)
    expect(outputProduct3.data.product).toBeDefined()
    expect(inputProduct).not.toEqual(outputProduct3.data.product)
    expect(inputProduct.name).not.toEqual(outputProduct3.data.product.name)
    expect(inputProduct.description).not.toEqual(outputProduct3.data.product.description)
    expect(inputProduct.price).not.toEqual(outputProduct3.data.product.price)
    expect(outputProduct.data.product.id).toBe(outputProduct3.data.product.id)

    

});



test('criar um novo Produto se não tiver. e Busca na Base o produto Cadastrado, e deleta', async () => {
    inputProduct = {
        "name": MyFn.uuid(),
        "description": MyFn.uuid(),
        "price": MyFn.gerarPreco(2.50,999.9)
    }
    outputProduct = await instance.post(url + "/product", inputProduct)
    expect(outputProduct.status).toBe(201)
    expect(outputProduct.data.product.id).toBeDefined()
    outputProduct2 = await instance.get(url+"/product/"+outputProduct.data.product.id)
    expect(outputProduct.data.product).toBeDefined()
    expect(outputProduct.data.product.id).toBeGreaterThan(0);

    outputProduct3 = await instance.delete(url+"/product/"+outputProduct.data.product.id)
    expect(outputProduct3.status).toBe(200)
});