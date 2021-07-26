import React, { Component } from "react";
import { Card, Form, Button, Row, Col } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSave } from "@fortawesome/free-solid-svg-icons";
export default class Product extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      description: "",
      price: "",
      stock: "",
      supplier: "",
    };
    this.productChange = this.productChange.bind(this);
    this.submitProduct = this.submitProduct.bind(this);
  }

  submitProduct(e) {
    alert(
      `Se agrego el producto con: \n\nNombre: ${this.state.name} \nDescripcion: ${this.state.description} \nPrecio: ${this.state.price} \nCantidad: ${this.state.stock} \nProvedor: ${this.state.supplier}`
    );
    e.preventDefault();
  }

  productChange(e) {
    this.setState({
      [e.target.name]: e.target.value,
    });
  }

  render() {
    return (
      <>
        <Card className={"border, border-dark bg-dark text-white"}>
          <Card.Header>Agregar producto</Card.Header>
          <Form onSubmit={this.submitProduct} id="productFromId">
            <Card.Body>
              <Row>
                <Form.Group as={Col} className="mb-3" controlId="formGridName">
                  <Form.Label>Nombre del producto</Form.Label>
                  <Form.Control
                    name="name"
                    type="text"
                    value={this.state.name}
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
                    value={this.state.supplier}
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
                    value={this.state.price}
                    onChange={this.productChange}
                  />
                </Form.Group>
                <Form.Group as={Col} className="mb-3" controlId="formGridStock">
                  <Form.Label>Cantidad</Form.Label>
                  <Form.Control
                    name="stock"
                    type="text"
                    value={this.state.stock}
                    onChange={this.productChange}
                  />
                </Form.Group>
              </Row>
              <Form.Group className="mb-3" controlId="formGridDescription">
                <Form.Label>Descipcion del producto</Form.Label>
                <Form.Control
                  name="description"
                  type="text"
                  value={this.state.description}
                  onChange={this.productChange}
                />
              </Form.Group>
            </Card.Body>
            <Card.Footer>
              <Button variant="success" type="submit">
                <FontAwesomeIcon icon={faSave} /> Guardar
              </Button>
            </Card.Footer>
          </Form>
        </Card>
      </>
    );
  }
}
