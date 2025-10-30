import axios from 'axios';
 
const PRODUCT_URL='http://localhost:9898/inventory'

export const addProduct = (product) => {
  return axios.post(PRODUCT_URL + '/addProduct', product);
};


export const getProductById = (id) => {
    return axios.get(PRODUCT_URL + '/product/' + id);
}

export const removeProduct = (id) => {
    return axios.delete(PRODUCT_URL + '/deleteProduct/' + id);
}

export const showAllProducts = () => {
    return axios.get(PRODUCT_URL + '/allProducts');
}

export const stockEdit = (product, quantity, flag) => {
    return axios.put(PRODUCT_URL + '/editStock/' + quantity + '/' + flag, product);
}

export const generateId = () => {
    return axios.get(PRODUCT_URL + '/generateId');
}

export const updateProductPrice = (product) => {
    return axios.put(PRODUCT_URL + '/updateProductPrice', product);
}

// import axios from 'axios';
 
// const PRODUCT_URL='http://localhost:9898/inventory'

// export const addProduct = (product) => {
//   return axios.post(PRODUCT_URL + '/addProduct', product);
// };


// export const getProductById = (id) => {
//     return axios.get(PRODUCT_URL + '/' + id);
// }

// export const removeProduct = (id) => {
//     return axios.delete(PRODUCT_URL + '/deleteProduct' + id);
// }

// export const showAllProducts = () => {
//     return axios.get(PRODUCT_URL + '/allProducts');
// }

// export const findReorderLevelByProductId = (id) => {
//     return axios.get(PRODUCT_URL + '/reorderLevel/' + id);
// }

// export const updateProduct = (product) => {
//     return axios.put(PRODUCT_URL + '/updateProduct' + product);
// }

// export const stockEdit = (id, quantity, flag) => {
//     return axios.put(PRODUCT_URL + '/editStock/' + id + '?quantity=' + quantity + '&flag=' + flag);
// }

// export const stockChecking = (id) => {
//     return axios.get(PRODUCT_URL + '/checkStock/' + id);
// }

// import axios from 'axios';

// const PRODUCT_URL='http://localhost:9898/inventory/product';
// const ID_URL='http://localhost:9898/inventory/id-gen';
 
// export const addProduct = (product) => {
//     return axios.post(PRODUCT_URL,product);
// }
// export const productIdGenerate = () => {
//     return axios.get(ID_URL);
// }
// export const getProductById = (id) => {
//     return axios.get(PRODUCT_URL+ '/' + id);
// }
// export const getAllProducts = () => {
//     return axios.get(PRODUCT_URL);
// }
// export const deleteProduct = (id) => {
//     return axios.delete(PRODUCT_URL+ '/' + id);
// }
// export const stockUpdate = (product,qty,flag) => {
//     return axios.put(PRODUCT_URL+'/'+qty+'/'+flag, product);
// }
// export const priceUpdate = (product) => {
//     return axios.put(PRODUCT_URL, product);
// }
 