import { faBicycle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import axios from "axios";
import React, { Component } from "react";
import { Card, Table } from "react-bootstrap";

export default class ProductList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8080/api/products")
      .then((response) => {console.log(response.data)
       this.setState({ products: response.data });
      }).catch((error) => {console.log(error)});
  }

  render() {
    return (
      <>
        <Card className={"border, border-dark bg-dark text-white"}>
          <Card.Header>
            <FontAwesomeIcon icon={faBicycle} /> Lista de productos
          </Card.Header>
          <Card.Body>
            <Table striped bordered hover variant="dark">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Nombre</th>
                  <th>Descripcion</th>
                  <th>Precio</th>
                  <th>Cantidad</th>
                  <th>Provedor</th>
                </tr>
              </thead>
              <tbody>
                {this.state.products.length > 0 ? this.state.products.map((product, index) => (
                  <tr key={index}>
                    <td>{product.id}</td>
                    <td>{product.name}</td>
                    <td>{product.description}</td>
                    <td>{product.price}</td>
                    <td>{product.stock}</td>
                    <td>{product.supplier}</td>
                  </tr>
                )) : <tr><td colSpan="6">No hay productos</td></tr>}
              </tbody>
            </Table>
          </Card.Body>
        </Card>
      </>
    );
  }
}
