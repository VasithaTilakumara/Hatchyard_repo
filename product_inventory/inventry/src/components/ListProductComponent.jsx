import React, { Component } from 'react';
import ProductService  from "../service/ProductService";
import { useNavigate } from 'react-router-dom';
import {withRouter} from "../service/withRouter";
class ListProductComponent extends React.Component {
    constructor(props){
        super(props)
        this.state={
            products:[]
        }
        this.addProduct = this.addProduct.bind(this);
        this.editProduct = this.editProduct.bind(this);
        this.deleteProduct = this.deleteProduct.bind(this);
    }

    deleteProduct(id){
        // this.props.navigate('/product/' + id);
        ProductService.deleteProduct(id).then( res =>{
            this.setState({products: this.state.products.filter(product => product.id !== id)});
        });
    }

    editProduct(id){
        this.props.navigate('/product/' + id);
    }

    componentDidMount(){
        ProductService.getProducts().then((response) =>{
            this.setState({products:response.data})
        });
    }

    addProduct(){
        console.log(this.props.navigate);
        this.props.navigate('/add-products');
    }


    render() {
        const mystyle = {
            width: "130px"
          };
        return (
            <div>               
                <h2 className="text-center">Inventry</h2>
                <div className='row'>
                    <button style = {{width: "130px"}} className='btn btn-primary' onClick={this.addProduct}>Add Product</button>
                </div>
                <div className='row'>
                    <table className='table table-stroped table-bordered'>
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Product</td>
                                <td>Quantity Instock</td>
                                <td>Quantity Purchase</td>
                                <td>Unit Price</td>
                                <td>Actions</td>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.products.map(
                                    products =>
                                    <tr key = {products.id}>
                                        <td>{products.id}</td>
                                        <td>{products.product}</td>
                                        <td>{products.quantity_instock}</td>
                                        <td>{products.quantity_purchase}</td>
                                        <td>{products.unit_price}</td>
                                        <td>
                                            <button onClick={() => this.editProduct(products.id)} className = "btn btn-info">Update</button>
                                            <button style = {{marginLeft: "10px"}} onClick={() => this.deleteProduct(products.id)} className = "btn btn-danger">Delete</button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default withRouter(ListProductComponent);