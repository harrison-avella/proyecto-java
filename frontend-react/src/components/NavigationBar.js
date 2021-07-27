import React, { Component } from "react";
import { Nav, Navbar, NavDropdown, Container } from "react-bootstrap";
import logo from "../assets/images/logo.ico";
import { Link } from "react-router-dom";

export default class NavigationBar extends Component {
  render() {
    return (
      <>
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
          <Container>
            <Link className="navbar-brand" to={"carousel"}>
              <img src={logo} width="40" height="40" /> Bikerama
            </Link>
            <Navbar.Toggle aria-controls="responsive-navbar-nav" />
            <Navbar.Collapse id="responsive-navbar-nav">
              <Nav className="me-auto">
                <Link className="nav-link" to={""}>
                  Usuarios
                </Link>
                <Link className="nav-link" to={"addProduct"}>
                  Agregar Producto
                </Link>
                <Link className="nav-link" to={"productList"}>
                  Productos
                </Link>
              </Nav>
              <Nav>
                <Nav.Link href="#deets">Carrito</Nav.Link>
                <NavDropdown title="Usuario" id="collasible-nav-dropdown">
                  <NavDropdown.Item href="#action/3.1">Perfil</NavDropdown.Item>
                  <NavDropdown.Item href="#action/3.2">
                    Editar
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="#action/3.3">
                    Cerrar sesion
                  </NavDropdown.Item>
                </NavDropdown>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
      </>
    );
  }
}

