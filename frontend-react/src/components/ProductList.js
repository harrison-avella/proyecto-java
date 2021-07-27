import { faBicycle, faEdit, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import axios from "axios";
import React, { Component } from "react";
import { Button, ButtonGroup, Card, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
export default class ProductList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
    };
  }

  componentDidMount() {
    this.findAllProducts();
  }

  findAllProducts() {
    axios
      .get("http://localhost:8080/api/products")
      .then((response) => {
        console.log(response.data);
        this.setState({ products: response.data });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  deleteProduct = (id) => {
    alert(`Vas a borrar el producto con id:\n${id}`);
    axios
      .delete(`http://localhost:8080/api/products/${id}`)
      .then((response) => {
        if (response.data != null) {
          alert("Se borro exitosamente");
          this.setState({
            products: this.state.products.filter(
              (product) => product.id !== id
            ),
          });
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };
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
                  <th>Acciones</th>
                </tr>
              </thead>
              <tbody>
                {this.state.products.length > 0 ? (
                  this.state.products.map((product, index) => (
                    <tr key={index}>
                      <td>{product.id}</td>
                      <td>{product.name}</td>
                      <td>{product.description}</td>
                      <td>{product.price}</td>
                      <td>{product.stock}</td>
                      <td>{product.supplier}</td>
                      <td>
                        <ButtonGroup>
                          <Link to={`editProduct/${product.id}`} className="btn btn-sm btn-outline-primary">
                            <FontAwesomeIcon icon={faEdit} /> Editar
                          </Link>
                          
                          {"_"}
                          <Button
                            size="sm"
                            variant="outline-danger"
                            onClick={this.deleteProduct.bind(this, product.id)}
                          >
                            <FontAwesomeIcon icon={faTrash} /> Borrar
                          </Button>
                        </ButtonGroup>
                      </td>
                    </tr>
                  ))
                ) : (
                  <tr>
                    <td colSpan="6">No hay productos</td>
                  </tr>
                )}
              </tbody>
            </Table>
          </Card.Body>
        </Card>
      </>
    );
  }
}
