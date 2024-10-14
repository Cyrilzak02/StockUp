import React, { useState } from 'react';
import Button from "./../Components/Button";
import InputFields from "./../Components/InputFields";


export default function CadastrarProduto() {
  const [descricao, setDescricao] = useState('');
  const [qtd_estoque, setEstoque] = useState('');
  const [categoriaId, setCategoria] = useState('');
  const [preco_unitario, setPreco] = useState('');
  const [sku, setSku] = useState('');

  const div_cadastro = {
    background: 'white',
    height: "auto", // Para que a altura seja ajustada ao conteúdo
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
      alert("Nome do produto é obrigatório!");
      return;
    }
    if (qtd_estoque.length === 0) {
      alert("Quantidade é obrigatória!");
      return;
    }
    if (categoriaId.length === 0) {
      alert("Categoria é obrigatória!");
      return;
    }
    if (preco_unitario.length === 0) {
      alert("Preço é obrigatório!");
      return;
    }
    if (sku.length === 0) {
      alert("Data de validade é obrigatória!");
      return;
    }

    const managerId = 9;
    const managerType = "Grande";
    setCategoria(11)

    // {
    //   "descricao": "coco",
    //   "sku": "prd001",
    //   "qtd_estoque": 10,
    //   "preco_unitario": 19.99,
    //   "managerId": 9,
    //   "managerType": "Grande",
    //   "categoriaId": 11
    // }

    
    const cadastroProduto = {descricao, sku, qtd_estoque, preco_unitario, managerId, managerType, categoriaId};
    console.log(JSON.stringify(cadastroProduto))
    fetch("http://localhost:8080/api/produtos", {
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
      return response.text(); // Trocar para text() ao invés de json() para capturar a resposta como string
    })
    .then(text => {
      // Verificar se a resposta não está vazia antes de tentar o JSON
      if (text) {
        const data = JSON.parse(text); // Converter para JSON se não estiver vazio
        console.log(data);
      } else {
        console.log("Resposta vazia do servidor");
      }
    })
    .catch(error => console.error('Error:', error));}

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
    </div>
  );
}