import React, { useState, useEffect } from 'react';
import Button from "./../Components/Button";
import InputFields from "./../Components/InputFields";
import Popup from "./../Components/PopUp";

export default function CadastrarProduto() {
  const [descricao, setDescricao] = useState('');
  const [qtd_estoque, setEstoque] = useState('');
  const [categoriaId, setCategoria] = useState('');
  const [preco_unitario, setPreco] = useState('');
  const [sku, setSku] = useState('');
  const [popupMessage, setPopupMessage] = useState('');
  const [showPopup, setShowPopup] = useState(false);
  const [managerData, setManagerData] = useState(null);
  const [categorias, setCategorias] = useState([]);

  useEffect(() => {
    const data = sessionStorage.getItem('managerData');
    if (data) {
      const parsedData = JSON.parse(data);
      setManagerData(parsedData);
      console.log('Manager Data:', parsedData);
    }

    fetch("http://localhost:8080/categoria/get_all_categoria")
        .then(response => {
          if (!response.ok) {
            throw new Error('Erro ao buscar categorias: ' + response.status);
          }
          return response.json();
        })
        .then(data => {
          setCategorias(data);
        })
        .catch(error => {
          console.error('Error fetching categories:', error);
        });
  }, []);

  const managerId = managerData?.idManager;
  const managerType = managerData?._manager_type;

  console.log(managerId , managerType)

  const div_cadastro = {
    background: 'white',
    height: "auto",
    width: "600px",
    borderRadius: '10px',
  };

  const div_title = {
    color: 'black',
    textAlign: 'center',
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // Validate the inputs
    if (descricao.length === 0) {
      setPopupMessage("Nome do produto é obrigatório!");
      setShowPopup(true);
      return;
    }
    if (qtd_estoque.length === 0) {
      setPopupMessage("Quantidade é obrigatória!");
      setShowPopup(true);
      return;
    }
    if (categoriaId.length === 0) {
      setPopupMessage("Categoria é obrigatória!");
      setShowPopup(true);
      return;
    }
    if (preco_unitario.length === 0) {
      setPopupMessage("Preço é obrigatório!");
      setShowPopup(true);
      return;
    } else if (isNaN(parseFloat(preco_unitario)) || !isFinite(preco_unitario)) {
      setPopupMessage("Preço deve ser um número válido!");
      setShowPopup(true);
      return;
    }
    if (sku.length === 0) {
      setPopupMessage("SKU é obrigatório!");
      setShowPopup(true);
      return;
    }

    const cadastroProduto = {
      descricao,
      sku,
      qtd_estoque: parseInt(qtd_estoque, 10),
      preco_unitario: parseFloat(preco_unitario),
      managerId: managerId,
      managerType,
      categoriaId: parseInt(categoriaId, 10)
    };

    console.log('Cadastro Produto:', cadastroProduto);

    fetch("http://localhost:8080/api/produtos/criar_produto", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(cadastroProduto),
    })
        .then(response => {
          if (!response.ok) {
            throw new Error('Erro na requisição: ' + response.status);
          }
          return response.text();
        })
        .then(text => {
          if (text) {
            const data = JSON.parse(text);
            console.log(data);
            setPopupMessage("Produto cadastrado com sucesso!");
            setShowPopup(true);
          } else {
            setPopupMessage("Resposta vazia do servidor");
            setShowPopup(true);
          }
        })
        .catch(error => {
          console.error('Error:', error);
          setPopupMessage('Erro ao cadastrar produto: ' + error.message);
          setShowPopup(true);
        });
  };

  return (
      <div style={div_cadastro}>
        <div style={div_title}>
          <h1 className="text-2xl font-bold mb-6">Cadastrar novo Produto</h1>
        </div>

        <form onSubmit={handleSubmit} className="space-y-4">
          <InputFields
              id="name"
              name="name"
              title="Nome do produto:"
              value={descricao}
              onChange={(e) => setDescricao(e.target.value)}
              color_option="#A9A9A9"
              width="250px"
              height="20px"
              borderRadius="5px"
              font_color="#000"
              title_color="#000"
              marginLeft="110px"
              required
          />
          <InputFields
              id="quantity"
              name="quantity"
              title="Quantidade:"
              value={qtd_estoque}
              onChange={(e) => setEstoque(e.target.value)}
              color_option="#A9A9A9"
              width="250px"
              height="20px"
              borderRadius="5px"
              font_color="#111"
              title_color="#000"
              marginLeft="110px"
              marginTop="20px"
              required
          />
          <div style={{ marginLeft: "110px", marginTop: "20px" }}>
            <label style={{ color: "#000" }}>Categoria:</label>
            <br />
            <select
                value={categoriaId}
                onChange={(e) => setCategoria(e.target.value)}
                style={{
                  width: '270px',
                  height: '40px',
                  borderRadius: '5px',
                  backgroundColor: '#A9A9A9',
                  color: 'black',
                  marginLeft: '50px'
                }}
                required
            >
              <option value="">Selecione uma categoria</option>
              {categorias.map((categoria) => (
                  <option key={categoria.idCategoria} value={categoria.idCategoria}>
                    {categoria.descricao}
                  </option>
              ))}
            </select>
          </div>
          <InputFields
              id="price"
              name="price"
              title="Preço:"
              value={preco_unitario}
              onChange={(e) => setPreco(e.target.value)}
              color_option="#A9A9A9"
              width="250px"
              height="20px"
              borderRadius="5px"
              font_color="#000"
              title_color="#000"
              marginLeft="110px"
              marginTop="20px"
              required
          />
          <InputFields
              id="sku"
              name="SkuProduto"
              title="SKU do produto:"
              value={sku}
              onChange={(e) => setSku(e.target.value)}
              color_option="#A9A9A9"
              width="250px"
              height="20px"
              borderRadius="5px"
              font_color="#000"
              title_color="#000"
              marginLeft="110px"
              marginTop="20px"
              required
          />
          <Button
              text="Incluir Produto"
              color_option="green"
              width="200px"
              height="30px"
              borderRadius="10px"
              font_color="#fff"
              marginLeft="200px"
              marginTop="40px"
              type="submit"
          />
        </form>

        {showPopup && (
            <Popup
                message={popupMessage}
                onClose={() => setShowPopup(false)}
            />
        )}
      </div>
  );
}

