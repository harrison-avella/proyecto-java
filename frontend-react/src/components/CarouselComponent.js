import React from "react";
import Carousel from "react-bootstrap/Carousel";
import image from "../assets/images/dirty-bike.jpg";

class CarouselComponent extends React.Component {
  render() {
    return (
      <>
        <Carousel>
  <Carousel.Item>
    <img
      className="d-block w-100"
      src={image}
      alt="First slide"
    />
    <Carousel.Caption>
      <h3>Bienvenidos a Bikerama</h3>
      <p>Salud y diversion sobre ruedas</p>
    </Carousel.Caption>
  </Carousel.Item>
  <Carousel.Item>
  <img
      className="d-block w-100"
      src={image}
      alt="First slide"
    />

    <Carousel.Caption>
      <h3>Second slide label</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </Carousel.Caption>
  </Carousel.Item>
  <Carousel.Item>
  <img
      className="d-block w-100"
      src={image}
      alt="First slide"
    />

    <Carousel.Caption>
      <h3>Third slide label</h3>
      <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
    </Carousel.Caption>
  </Carousel.Item>
</Carousel>
      </>
    );
  }
}

export default CarouselComponent;
