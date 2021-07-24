import { Container, Row, Col, Jumbotron, CarouselItem} from "react-bootstrap";
import './App.css';
import NavigationBar from './components/NavigationBar';
import CarouselComponent from './components/CarouselComponent';

function App() {
  
  return (
    <>
    <div className="App">
      <NavigationBar />
      <CarouselComponent />
      <p>Una imagen de prueba</p>
    </div>
  </>
  );
}

export default App;
