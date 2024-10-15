import React, { useState } from 'react';
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
    }else if (isNaN(parseFloat(preco_unitario)) || !isFinite(preco_unitario)) {
      setPopupMessage("Preço deve ser um número válido!");
      setShowPopup(true);
      return;}
    if (sku.length === 0) {
      setPopupMessage("SKU é obrigatório!");
      setShowPopup(true);
      return;
    }

    const managerId = 9;
    const managerType = "Grande";
    setCategoria(11);

    const cadastroProduto = { descricao, sku, qtd_estoque, preco_unitario, managerId, managerType, categoriaId };

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
          color_option="#A9A9A9"
          width="250px"
          height="20px"
          borderRadius="5px"
          font_color="#000"
          title_color="#000"
          marginLeft="110px"
          onChange={(e) => setDescricao(e.target.value)}
          required
        />
        <InputFields
          id="quantity"
          name="quantity"
          title="Quantidade:"
          color_option="#A9A9A9"
          width="250px"
          height="20px"
          borderRadius="5px"
          font_color="#111"
          title_color="#000"
          marginLeft="110px"
          marginTop="20px"
          onChange={(e) => setEstoque(e.target.value)}
          required
        />
        <InputFields
          id="category"
          name="category"
          title="Categoria:"
          color_option="#A9A9A9"
          width="250px"
          height="20px"
          borderRadius="5px"
          font_color="#000"
          title_color="#000"
          marginLeft="110px"
          marginTop="20px"
          onChange={(e) => setCategoria(e.target.value)}
          required
        />
        <InputFields
          id="price"
          name="price"
          title="Preço:"
          color_option="#A9A9A9"
          width="250px"
          height="20px"
          borderRadius="5px"
          font_color="#000"
          title_color="#000"
          marginLeft="110px"
          marginTop="20px"
          onChange={(e) => setPreco(e.target.value)}
          required
        />
        <InputFields
          id=""
          name="SkuProduto"
          title="SKU do produto:"
          color_option="#A9A9A9"
          width="250px"
          height="20px"
          borderRadius="5px"
          font_color="#000"
          title_color="#000"
          marginLeft="110px"
          marginTop="20px"
          onChange={(e) => setSku(e.target.value)}
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