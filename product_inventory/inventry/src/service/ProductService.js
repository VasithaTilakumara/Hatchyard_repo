import axios from 'axios'

const PRODUCT_REST_API_URL = 'http://localhost:8080/products';
const PRODUCT_ADD_REST_API_URL = 'http://localhost:8080/add-products';
//const PRODUCT_GET_ID_REST_API_URL = 'http://localhost:8080/add-products';

class ProductService{

    getProducts(){
        return axios.get(PRODUCT_REST_API_URL);
    }

    createProduct(product){
        console.log('product => ' + JSON.stringify(product));
        return axios.post(PRODUCT_ADD_REST_API_URL,product);
    }

    getProductById(productId){
        return axios.get(PRODUCT_REST_API_URL+ '/' + productId);
    }

    updateProduct(product,productId){
        return axios.put(PRODUCT_REST_API_URL + '/' + productId, product);
    }

    deleteProduct(productId){
        return axios.delete(PRODUCT_REST_API_URL + '/' + productId);
    }

    
}
export default new ProductService();