import React, { Component } from 'react';
import ProductService from '../service/ProductService';
import {withRouter} from "../service/withRouter";

class CreateProductComponent extends Component {
    constructor(props){
        super(props)
        this.state={
            id: '',
            product: '',
            quantity_instock: '',
            quantity_purchase: '',
            unit_price: ''
        }
        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeProductHandler = this.changeProductHandler.bind(this);
        this.changeQuantityInstockHandler = this.changeQuantityInstockHandler.bind(this);
        this.changeQuantityPurchaseHandler = this.changeQuantityPurchaseHandler.bind(this);
        this.changeUnitPriceHandler = this.changeUnitPriceHandler.bind(this);
        this.saveProduct = this.saveProduct.bind(this);
    }

    saveProduct = (e) => {
        e.preventDefault();
        let product = {id: this.state.id, product: this.state.product, quantity_instock: this.state.quantity_instock, quantity_purchase: this.state.quantity_purchase, unit_price: this.state.unit_price};
        // console.log('product => ' + JSON.stringify(product));

        ProductService.createProduct(product).then(res =>{
            this.props.navigate('/products')
        });
    }

    changeIdHandler = (event) => {
        this.setState({id: event.target.value});
    }

    changeProductHandler = (event) => {
        this.setState({product: event.target.value});
    }

    changeQuantityInstockHandler = (event) => {
        this.setState({quantity_instock: event.target.value});
    }

    changeQuantityPurchaseHandler = (event) => {
        this.setState({quantity_purchase: event.target.value});
    }

    changeUnitPriceHandler = (event) => {
        this.setState({unit_price: event.target.value});
    }

    cancel(){
        this.props.navigate('/products');
    }

    render() {
        return (
            <div>
                <div className='container'>
                <div className='row'>
                    <div className='card col-md-6 offset-md-3 offset-md-3'>
                        <h3 className='text-center'>Add Product</h3>
                        <div className='card-body'>
                            <form>
                                <div className='form-group'>
                                   <label>Id:</label>
                                   <input placeholder='Product Id' name='id' className='form-control'
                                    value={this.state.id} onChange={this.changeIdHandler} /> 
                                </div>
                                <div className='form-group'>
                                   <label>Product:</label>
                                   <input placeholder='Product' name='product' className='form-control'
                                    value={this.state.product} onChange={this.changeProductHandler} /> 
                                </div>
                                <div className='form-group'>
                                   <label>Quantity In-Stock:</label>
                                   <input placeholder='Quantity In-Stock' name='quantity_instock' className='form-control'
                                    value={this.state.quantity_instock} onChange={this.changeQuantityInstockHandler} /> 
                                </div>
                                <div className='form-group'>
                                   <label>Quantity Purchase:</label>
                                   <input placeholder='Quantity Purchase' name='quantity_purchase' className='form-control'
                                    value={this.state.quantity_purchase} onChange={this.changeQuantityPurchaseHandler} /> 
                                </div>
                                <div className='form-group'>
                                   <label>Unit Price:</label>
                                   <input placeholder='Unit Price' name='unit_price' className='form-control'
                                    value={this.state.unit_price} onChange={this.changeUnitPriceHandler} /> 
                                </div>

                                <button className='btn btn-success' onClick={this.saveProduct}>Save</button>
                                <button className='btn btn-danger' onClick={this.cancel.bind(this)} >Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
                </div> 
            </div>
        );
    }
}

export default withRouter(CreateProductComponent);