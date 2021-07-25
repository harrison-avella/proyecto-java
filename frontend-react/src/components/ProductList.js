import React, { Component } from "react";
import { Card, Table } from "react-bootstrap";

export default class ProductList extends Component {
  render() {
    return (
      <>
        <Card className={"border, border-dark bg-dark text-white"}>
          <Card.Header>Lista de productos</Card.Header>
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
                <tr>
                  <td>1</td>
                  <td>Marco MTB Rin 29</td>
                  <td>Esta hecho en aluminio</td>
                  <td>400</td>
                  <td>10</td>
                  <td>Venzo</td>
                </tr>
              </tbody>
            </Table>
          </Card.Body>
        </Card>
      </>
    );
  }
}
