import React, { Component } from "react";
import { Card, Form, Button, Row, Col } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSave } from "@fortawesome/free-solid-svg-icons";
import axios from "axios";
import MyToast from "./MyToast";
export default class Product extends Component {
  constructor(props) {
    super(props);
    this.state = this.initialState();
    this.productChange = this.productChange.bind(this);
    this.submitProduct = this.submitProduct.bind(this);
  }

  initialState() {
    return {
      id: "",
      name: "",
      description: "",
      price: "",
      stock: "",
      supplier: "",
    };
  }

  componentDidMount() {
    const id  = this.props.match.params.id;
    if (id) {
      this.getProductById(id);
    }
  }

  getProductById(id) {
    axios
      .get(`http://localhost:8080/api/products/${id}`)
      .then(response => {
        this.setState({
          id: response.data.id,
          name: response.data.name,
          description: response.data.description,
          price: response.data.price,
          stock: response.data.stock,
          supplier: response.data.supplier,
        });
      })
      .catch(error => {
        console.log(error);
      });
  }

  updateProduct = (e) => {
    e.preventDefault();
    const { name, description, price, stock, supplier } = this.state;
    axios
      .put(`http://localhost:8080/api/products/${this.state.id}`, {
        name,
        description,
        price,
        stock,
        supplier,
      })
      .then(response => {
        this.setState({
          id: response.data.id,
          name: response.data.name,
          description: response.data.description,
          price: response.data.price,
          stock: response.data.stock,
          supplier: response.data.supplier,
        });
        this.props.history.push("/");
      })
      .catch(error => {
        console.log(error);
      });
      this.setState(this.initialState());
  }



  submitProduct = (e) => {
    alert(
      `El producto con los siguientes datos sera enviado: \n\nNombre: ${this.state.name} \nDescripcion: ${this.state.description} \nPrecio: ${this.state.price} \nCantidad: ${this.state.stock} \nProvedor: ${this.state.supplier}`
    );
    e.preventDefault();

    const product = {
      name: this.state.name,
      description: this.state.description,
      price: this.state.price,
      stock: this.state.stock,
      supplier: this.state.supplier,
    };

    axios.post("http://localhost:8080/api/products", product).then((res) => {
      console.log(res);
      if (res.data != null){
        this.setState(this.initialState());
        alert("Producto agregado");
      }
    });
  };

  productChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };

  render() {
    const { name, description, price, stock, supplier } = this.state;

    return (
      <>
        {/*<div>
          <MyToast />
        </div>*/}
        <Card className={"border, border-dark bg-dark text-white"}>
          <Card.Header>{this.state.id ? "Editar": "Agregar"} producto</Card.Header>
          <Form onSubmit={this.state.id ? this.updateProduct : this.submitProduct} id="productFromId">
            <Card.Body>
              <Row>
                <Form.Group as={Col} className="mb-3" controlId="formGridName">
                  <Form.Label>Nombre del producto</Form.Label>
                  <Form.Control
                    name="name"
                    type="text"
                    value={name}
                    onChange={this.productChange}
                  />
                </Form.Group>
                <Form.Group
                  as={Col}
                  className="mb-3"
                  controlId="formGridSupplier"
                >
                  <Form.Label>Provedor</Form.Label>
                  <Form.Control
                    name="supplier"
                    type="text"
                    value={supplier}
                    onChange={this.productChange}
                  />
                </Form.Group>
              </Row>
              <Row>
                <Form.Group as={Col} className="mb-3" controlId="formGridPrice">
                  <Form.Label>Precio</Form.Label>
                  <Form.Control
                    name="price"
                    type="text"
                    value={price}
                    onChange={this.productChange}
                  />
                </Form.Group>
                <Form.Group as={Col} className="mb-3" controlId="formGridStock">
                  <Form.Label>Cantidad</Form.Label>
                  <Form.Control
                    name="stock"
                    type="text"
                    value={stock}
                    onChange={this.productChange}
                  />
                </Form.Group>
              </Row>
              <Form.Group className="mb-3" controlId="formGridDescription">
                <Form.Label>Descipcion del producto</Form.Label>
                <Form.Control
                  name="description"
                  type="text"
                  value={description}
                  onChange={this.productChange}
                />
              </Form.Group>
            </Card.Body>
            <Card.Footer>
              <Button variant="success" type="submit">
                <FontAwesomeIcon icon={faSave} /> {this.state.id ? "Editar": "Guardar"} 
              </Button>
            </Card.Footer>
          </Form>
        </Card>
      </>
    );
  }
}
