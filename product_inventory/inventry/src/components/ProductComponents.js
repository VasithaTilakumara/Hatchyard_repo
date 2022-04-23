import userEvent from "@testing-library/user-event";
import React from "react";
import ProductService  from "../service/ProductService";

class ProductComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            products:[]
        }
    }

    componentDidMount(){
        ProductService.getProducts().then((response) =>{
            this.setState({products:response.data})
        });
    }
    render (){
        return (
           <div>
           <h1 className="text-center">User List</h1>
           <table className="table table-striped">
               <thead>
                   <tr>
                       <td>Product Id</td>
                       <td>Quantity Instock</td>
                       <td>Quantity Purchase</td>
                       <td>Unit Price</td>
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
                            </tr>
                        )
                    }
                </tbody>
            </table>
            <button type="button">Add product</button>
           </div>
        )
    }

}

export default ProductComponent