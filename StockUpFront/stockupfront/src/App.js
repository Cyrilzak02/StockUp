import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Pages/Login.js'
import CadastrarProduto from './Pages/CadastrarProduto.js';
import CadastroVendas from "./Pages/cadastroVendas";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Router>
          <Routes>
            <Route path="/" element={<Login />} /> 
            <Route path="/cadastrar-produto" element={<CadastrarProduto />} />
            <Route path="/cadastrar-vendas" element={<CadastroVendas />} />
          </Routes>
        </Router>
      </header>
    </div>
  );
}

export default App;