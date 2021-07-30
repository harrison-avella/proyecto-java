import { Container, Row, Col, Jumbotron, CarouselItem } from "react-bootstrap";
import "./App.css";
import NavigationBar from "./components/NavigationBar";
import MyCarousel from "./components/MyCarousel";
import Footer from "./components/Footer";
import Product from "./components/Product";
import ProductList from "./components/ProductList";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from "./components/Login";
import Register from "./components/Register";


function App() {
  return (
    <>
      <Router>
        <div className="App">
          <NavigationBar />
          <Switch>
            <Route path="/carousel" component={MyCarousel} />
            <Route path="/addProduct/" component={Product} />
            <Route path="/editProduct/:id" component={Product} />
            <Route path="/productList" component={ProductList} />
            <Route path="/login" component={Login} />
            <Route path="/register" component={Register} />
          </Switch>
          <Footer />
        </div>
      </Router>
    </>
  );
}

export default App;
