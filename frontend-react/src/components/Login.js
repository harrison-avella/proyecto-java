import { faEnvelope, faLock, faSignInAlt } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React, { Component } from "react";
import { Button, Card, Col, Form, Row } from "react-bootstrap";

export default class Login extends Component {
  constructor(props) {
    super(props);
    this.state = this.initialState;
  }

  initialState = {
    email: "",
    password: "",
  };

  credentialChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  render() {
    const { email, password } = this.state;
    return (
      <>
        <Row className="justify-content-md-center">
          <Col xs={5}>
            <Card className={"border border-dark bg-dark text-white"}>
              <Card.Header icon={faSignInAlt}>Ingresar</Card.Header>
              <Card.Body>
                <Form>
                  <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label><FontAwesomeIcon icon={faEnvelope} /> Correo electronico</Form.Label>
                    <Form.Control
                      required
                      autoComplete="off"
                      type="text"
                      name="email"
                      value={email}
                      placeholder="Ingresa tu correo"
                      onChange={this.credentialChange}
                    />
                  </Form.Group>
                  <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label><FontAwesomeIcon icon={faLock} /> Contraseña</Form.Label>
                    <Form.Control required
                        autoComplete="off"
                        type="password"
                        name="email"
                        value={password}
                        placeholder="Ingresa tu contraseña" />
                  </Form.Group>
                  <Button
                    type="button"
                    variant="success"
                    disabled={
                      this.state.email.length === 0 &&
                      this.state.password.length === 0
                    }
                  >
                    <FontAwesomeIcon icon={faSignInAlt} /> Ingregar
                  </Button>
                </Form>
              
                {/*
                <Form.Row>
                  <Form.Group as={Col}>
                    <InputGroup>
                      <InputGroup.Prepend>
                        <InputGroup.Text>
                          <FontAwesomeIcon icon={faEnvelope} />
                        </InputGroup.Text>
                      </InputGroup.Prepend>
                      <FormControl
                        required
                        autoComplete="off"
                        type="password"
                        name="email"
                        value={password}
                        className="bg-dark text-white"
                        placeholder="Ingresa tu contraseña"
                      />
                    </InputGroup>
                  </Form.Group>
                </Form.Row>
                */}
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </>
    );
  }
}
