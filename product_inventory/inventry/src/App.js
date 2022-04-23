import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom"
import ProductComponent from './components/ProductComponents';
import ListProductComponent from './components/ListProductComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateProductComponent from './components/CreateProductComponent';
import UpdateProductComponent from './components/UpdateProductComponent';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />    
            <div className="container">
              <Routes> 
                <Route path = "/" exact element = {<ListProductComponent />} />
                <Route path = "/products" element = {<ListProductComponent />} />
                <Route path = "/add-products" element = {<CreateProductComponent />} />
                <Route path = "/product/:id" element = {<UpdateProductComponent />} />
              </Routes>
            </div>
          <FooterComponent />
      </Router>  
    </div>
  );
}

export default App;
