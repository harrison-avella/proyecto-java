import { Container, Row, Col, Jumbotron, CarouselItem } from "react-bootstrap";
import "./App.css";
import NavigationBar from "./components/NavigationBar";
import CarouselComponent from "./components/CarouselComponent";
import Footer from "./components/Footer";
import Product from "./components/Product";
import ProductList from "./components/ProductList";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <>
      <Router>
        <div className="App">
          <NavigationBar />
          <Switch>
            <Route path="/carousel" component={CarouselComponent} />
            <Route path="/addProduct/" component={Product} />
            <Route path="/productList" component={ProductList} />
          </Switch>
          <Footer />
        </div>
      </Router>
    </>
  );
}

export default App;
